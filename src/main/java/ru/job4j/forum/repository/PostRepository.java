package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostRepository {

    private final AtomicInteger position = new AtomicInteger(0);

    private Map<Integer, Post> posts = new HashMap<>();

    public PostRepository() {
        add(Post.of("Продаю машину ладу 01.",
                "Продажа машины, Lada 98. Пробег 4800 км",
                LocalDateTime.now()));
    }

    public void add(Post post) {
        post.setId(position.incrementAndGet());
        post.setCreated(LocalDateTime.now());
        posts.put(position.get(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public List<Post> findAllPosts() {
        return List.copyOf(posts.values());
    }

    public void updatePost(int id, Post post) {
        post.setCreated(LocalDateTime.now());
        posts.put(id, post);
    }

    public Post findByName(String name) {
        for (Post user : posts.values()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}


