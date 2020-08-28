package com.myposts.controllers;

import com.myposts.services.posts.Post;
import com.myposts.services.posts.PostsService;
import com.myposts.services.users.exceptions.InvalidApiParameterException;

import com.myposts.services.users.exceptions.UserNotFoundException;
import com.myposts.services.users.exceptions.WrongPasswordException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @PostMapping("/save")
    public ResponseEntity<String> savePost(@RequestBody Post post,@RequestParam("username") String username, @RequestParam("password") String password) throws UserNotFoundException, WrongPasswordException {
        return postsService.savePost(post,username,password)?
                ResponseEntity.ok("Post Saved") :  ResponseEntity.ok("not a valid user");
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search through public posts by specified string")
    @ApiResponses(value = @ApiResponse(code = 422, message = "Search string is either null/empty/only whitespaces"))
    public List<Post> searchPublicPosts(@RequestParam("searchString") String searchString,@RequestParam("username") String username, @RequestParam("password") String password) throws InvalidApiParameterException, UserNotFoundException, WrongPasswordException {
        if (searchString == null || searchString.trim().isEmpty()) {
            throw new InvalidApiParameterException("Search string mustn't be null/empty/only whitespaces");
        }
        return postsService.searchPublicPostsBySearchString(searchString,username,password);
    }
}


