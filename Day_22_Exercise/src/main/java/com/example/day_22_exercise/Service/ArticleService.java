package com.example.day_22_exercise.Service;


import com.example.day_22_exercise.Model.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class ArticleService {

    ArrayList<Article> articles = new ArrayList<>();

    public void addArticle(Article article) {
        articles.add(article);
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public boolean updateArticle(int id ,Article article) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.set(i, article);
                return true;
            }
        }
        return false;
    }

    public boolean deleteArticle(int id) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean publish(int id , LocalDate date) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.get(i).setPublished(true);
                articles.get(i).setPublishDate(date);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Article> getAllPublished() {
        ArrayList<Article> publishedArticles = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).isPublished()) {
                publishedArticles.add(articles.get(i));
            }
        }
        return publishedArticles;
    }

    public ArrayList<Article> getByCategory(String category) {
        ArrayList<Article> categoryArticles = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getCategory().equals(category)) {
                categoryArticles.add(articles.get(i));
            }
        }
        return categoryArticles;
    }
}
