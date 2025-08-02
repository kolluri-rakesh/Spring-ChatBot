package com.example.bot.service;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class SearchService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String searchDuckDuckGo(String query) {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String url = "https://api.duckduckgo.com/?q=" + encodedQuery + "&format=json&no_html=1&skip_disambig=1";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");
            headers.set("User-Agent", "Mozilla/5.0");

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            JSONObject json = new JSONObject(response.getBody());
            String abstractText = json.optString("AbstractText");
            String answer = json.optString("Answer");

            if (!abstractText.isEmpty()) {
                return abstractText;
            } else if (!answer.isEmpty()) {
                return answer;
            } else {
                return "No direct answer found from DuckDuckGo. Try using Wikipedia or News.";
            }

        } catch (Exception e) {
            return "Error fetching data from DuckDuckGo: " + e.getMessage();
        }
    }

    public String searchWikipedia(String query) {
        try {
            String encodedQuery = URLEncoder.encode(query.replace(" ", "_"), StandardCharsets.UTF_8);
            String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + encodedQuery;

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                return "No Wikipedia summary found for: " + query;
            }

            JSONObject json = new JSONObject(response.getBody());
            return json.optString("extract", "No summary available.");

        } catch (Exception e) {
            return "Error fetching from Wikipedia: " + e.getMessage();
        }
    }

    public String searchNews(String query) {
        try {
            String apiKey = "2b89fa45949846778d73983e8c60a2b5"; // Replace with your actual API key
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String url = "https://newsapi.org/v2/everything?q=" + encodedQuery + "&apiKey=" + apiKey;

            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "Mozilla/5.0");

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            JSONObject json = new JSONObject(response.getBody());
            if (json.has("articles") && json.getJSONArray("articles").length() > 0) {
                JSONObject firstArticle = json.getJSONArray("articles").getJSONObject(0);
                return "📰 " + firstArticle.optString("title") + "\n" + firstArticle.optString("url");
            } else {
                return "No news articles found for: " + query;
            }

        } catch (Exception e) {
            return "Error fetching from NewsAPI: " + e.getMessage();
        }
    }
}
