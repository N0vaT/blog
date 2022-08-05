package com.nova.blog.service;

import com.nova.blog.dao.PostRepository;
import com.nova.blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Transactional(readOnly = true)
    public List<Post> findById(long postId){
        Optional<Post> post = postRepository.findById(postId);
        List<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        return res;
    }

    @Transactional
    public void savePost(Post post){
        postRepository.saveAndFlush(post);
    }

    @Transactional(readOnly = true)
    public boolean existsById(long id) {
        return postRepository.existsById(id);
    }
}
