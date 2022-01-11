package com.sadatmalik.fusionnews.services;

import com.sadatmalik.fusionnews.model.Article;
import com.sadatmalik.fusionnews.model.NytResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Article> getMostPopular() {
        NytResponse response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        List<Article> results = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            for (Article article : response.getResults()) {
                if (article.getMedia() != null && !article.getMedia().isEmpty()) {
                    String imageUrl = article.getMedia().get(0).getMediaMetadata().get(1).getUrl();
                    article.setImageUrl(imageUrl);
                    results.add(article);
                }
            }
        }
        return results;
    }
}