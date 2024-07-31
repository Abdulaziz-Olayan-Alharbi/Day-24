package com.example.day_22_exercise.Controller;

import com.example.day_22_exercise.Api.ApiResponse;
import com.example.day_22_exercise.Model.Article;
import com.example.day_22_exercise.Service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleController {

    final ArticleService articleService = new ArticleService();


    @GetMapping("/get")
    public ResponseEntity get(){
        ArrayList<Article> articles = articleService.getArticles();
        return ResponseEntity.status(200).body(articles);
    }

    @PostMapping("/add")
    public ResponseEntity addArticle(@Valid @RequestBody Article article, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        articleService.addArticle(article);
        return ResponseEntity.status(200).body(new ApiResponse("Article added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateArticle(@Valid @RequestBody Article article ,@PathVariable int id ,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (articleService.updateArticle(id, article)){
            return ResponseEntity.status(200).body(new ApiResponse("Article updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteArticle(@PathVariable int id){
        if (articleService.deleteArticle(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Article deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));
    }

    @PutMapping("/publish/{id}/{date}")
    public ResponseEntity publish(@PathVariable int id , @PathVariable LocalDate date){
        if (articleService.publish(id,date)){
            return ResponseEntity.status(200).body(new ApiResponse("Article published"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));
    }

    @GetMapping("/publishedget")
    public ResponseEntity getAllPublished(){
        ArrayList<Article> published = articleService.getAllPublished();
        return ResponseEntity.status(200).body(published);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity getCategory(@PathVariable String category){
        ArrayList<Article> categoryArticles = articleService.getByCategory(category);
        return ResponseEntity.status(200).body(categoryArticles);
    }
}
















