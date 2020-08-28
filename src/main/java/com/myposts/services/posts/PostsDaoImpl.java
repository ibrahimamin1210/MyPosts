package com.myposts.services.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostsDaoImpl implements PostsDao {

    @Autowired
    private EntityManager em;

    @Override
    public List<Post> findPublicPostsBySearchString(String searchString) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);

        String keywords = "%" + Arrays.stream(searchString.split(" "))
                .map(keyword -> keyword.toUpperCase())
                .collect(Collectors.joining("%")) + "%";

        Root<Post> post = cq.from(Post.class);
        Predicate contentPredicate = cb.like(cb.upper(post.get("content")), keywords);
        Predicate statusPredicate = cb.equal(post.get("isPrivate"), false);
        cq.where(statusPredicate, contentPredicate);

        TypedQuery<Post> query = em.createQuery(cq);
        return query.getResultList();
    }
}
