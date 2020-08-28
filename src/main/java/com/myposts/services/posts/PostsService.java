package com.myposts.services.posts;

import com.myposts.services.users.User;
import com.myposts.services.users.UsersService;
import com.myposts.services.users.exceptions.UserNotFoundException;
import com.myposts.services.users.exceptions.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService {

    @Autowired
    private UsersService userService;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private PostsDao postsDao;

    public boolean savePost(Post post, String userName, String password) throws UserNotFoundException, WrongPasswordException {
        User user = userService.validateUserAuthority(userName, password);
        if (user != null) {
            Post newPost = new Post(post.getContent(), post.isPrivate(), user);
            postsRepository.save(newPost);
            return true;
        } else return false;
    }

    public List<Post> searchPublicPostsBySearchString(String searchString, String userName, String password) throws UserNotFoundException, WrongPasswordException {
        User user = userService.validateUserAuthority(userName, password);
        if (user != null) {
            return postsDao.findPublicPostsBySearchString(searchString);
        } else return null;
    }
}
