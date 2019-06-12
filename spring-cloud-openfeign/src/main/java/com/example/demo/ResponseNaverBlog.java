package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseNaverBlog implements Serializable {

    public static ResponseNaverBlog EMPTY = new ResponseNaverBlog();

    private String lastBuildDate;
    private Integer total;
    private Integer start;
    private List<naverDocument> items;

    @Data
    @NoArgsConstructor
    public static class naverDocument{
        String title;
        String link;
        String description;
        String bloggername;
        String bloggerlink;
        String postdate;
    }
}
