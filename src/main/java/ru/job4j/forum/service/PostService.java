package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAllPosts();
    }

    public Post findByIdPost(int id) {
       return postRepository.findById(id);
    }

    public void saveOrUpdate(Post post) {
        if (findByIdPost(post.getId()) == null) {
            postRepository.add(post);
        } else {
            postRepository.updatePost(post.getId(), post);
        }
    }
}