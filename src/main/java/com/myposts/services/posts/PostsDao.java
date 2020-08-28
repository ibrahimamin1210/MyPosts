package com.myposts.services.posts;

import java.util.List;

public interface PostsDao {
    List<Post> findPublicPostsBySearchString(String searchString);
}
