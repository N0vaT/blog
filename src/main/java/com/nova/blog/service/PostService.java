package com.nova.blog.service;

import com.nova.blog.dao.PostRepository;
import com.nova.blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public List<Post> findPost(){
        return postRepository.findAll();
    }
}
