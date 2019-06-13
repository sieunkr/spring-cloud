package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("blog")
    public ResponseNaverBlog findBlogByQuery(){
        return blogService.findBlogByQuery("스프링부트");
    }

    @Deprecated
    @GetMapping("legacy-blog")
    public ResponseNaverBlog legacyFindBlogByQuery(){
        return blogService.legacyFindBlogByQuery("스프링부트");
    }

}
