package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private final AtomicInteger position = new AtomicInteger(0);

    private Map<Integer, User> users = new HashMap<>();

    public void add(User user) {
        user.setId(position.incrementAndGet());
        users.put(position.get(), user);
    }

    public User findById(int id) {
       return users.get(id);
    }

    public List<User> findAllUsers() {
        return List.copyOf(users.values());
    }


    public User findByName(String name) {
        for (User user : users.values()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
