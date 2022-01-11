package com.sadatmalik.fusionnews.services;

import com.sadatmalik.fusionnews.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    private ArticleService service;

    @Test
    void getMostPopular() {
        List<Article> articles = service.getMostPopular();
        assertThat(articles).isNotNull();
        assertThat(articles.size()).isGreaterThan(0);

        System.out.println(articles);

        // check media URL is not null
        for (Article article : articles) {
            assertThat(article.getImageUrl()).isNotNull();
        }

    }
}