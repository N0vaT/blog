package com.nova.blog.controllers;

import com.nova.blog.dao.PostRepository;
import com.nova.blog.domain.Post;
import com.nova.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Controller
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        model.addAttribute("posts", postService.findPost());
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text);
        postService.savePost(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long postId, Model model){
        if(!postService.existsById(postId)){
            return "redirect:/blog";
        }
        model.addAttribute("post" , postService.findById(postId));
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long postId, Model model){
        if(!postService.existsById(postId)){
            return "redirect:/blog";
        }
        model.addAttribute("post" , postService.findById(postId));
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = postRepository.findById(id).orElseThrow(RuntimeException::new);
        post.setPostTitle(title);
        post.setPostAnons(anons);
        post.setPostFullText(full_text);
        postRepository.save(post);
        return String.format("redirect:/blog/%d",id) ;
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow(RuntimeException::new);
        postRepository.delete(post);
        return "redirect:/blog" ;
    }
}
