package com.nova.blog.service;

import com.nova.blog.dao.PostRepository;
import com.nova.blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> findPost(){
        List<Post> list = postRepository.findAll();
        Collections.reverse(list);
        return list;
    }

    @Transactional
    public void savePost(Post post){
        postRepository.saveAndFlush(post);
    }
}
