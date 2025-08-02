package com.example.bot.controller;

import com.example.bot.service.SearchService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("query") String query,
                         @RequestParam("source") String source,
                         Model model) {

        String result;
        switch (source.toLowerCase()) {
            case "wikipedia" -> result = searchService.searchWikipedia(query);
            case "news" -> result = searchService.searchNews(query);
            default -> result = searchService.searchDuckDuckGo(query);
        }

        model.addAttribute("result", result);
        return "result";
    }
}
