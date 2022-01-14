package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> list = new ArrayList<>();
        postRepository.findAll().forEach(list::add);
        return list;
    }

    public Post findByIdPost(int id) {
       return postRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Post post) {
        post.setCreated(LocalDateTime.now());
        postRepository.save(post);
    }
}