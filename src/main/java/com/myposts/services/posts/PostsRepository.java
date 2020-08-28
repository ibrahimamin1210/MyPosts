package com.myposts.services.posts;

import com.myposts.services.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser(User user);
}