package com.example.day_22_exercise.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Article {

    @NonNull
    private int id;
    @NotEmpty
    @Size(max = 50)
    private String title;
    @NotEmpty
    @Size(min = 4 ,max = 20)
    private String author;
    @NotEmpty
    @Size(min = 20)
    private String content;
    @NotEmpty
    @Pattern(regexp = "^(Sport|Technology|Politics)$")
    private String category;
    @NotEmpty
    private String imageUrl;
    private boolean isPublished = false;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;

}
