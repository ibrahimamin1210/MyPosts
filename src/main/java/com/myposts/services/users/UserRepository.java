package com.myposts.services.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = "SELECT * FROM system_users  WHERE user_name = ?1",
            nativeQuery = true)
    User findByuserName(String userName);
}
