package com.nova.blog.controllers;

import com.nova.blog.domain.Post;
import com.nova.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private PostService postService;

    @GetMapping("/blog")
    public String blogMain(Model model){

        Iterable<Post> posts = postService.findPost();
        model.addAttribute("posts", posts);

        return "blog-main";
    }

}
