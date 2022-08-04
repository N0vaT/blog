package com.nova.blog.service;

import com.nova.blog.controllers.BlogController;
import com.nova.blog.dao.PostRepository;
import com.nova.blog.domain.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private PostRepository postRepository;

    @Test
    void findPost() {
        List<Post> posts = postRepository.findAll();
        posts.forEach(p->LOGGER.info(p.getPostTitle()));
    }
}