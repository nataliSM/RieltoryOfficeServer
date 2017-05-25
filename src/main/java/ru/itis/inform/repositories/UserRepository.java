package ru.itis.inform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.inform.models.Offer;
import ru.itis.inform.models.Trader;
import ru.itis.inform.models.User;

import java.util.List;

/**
 * Created by Natalia on 13.05.17.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select user from User user where  " +
            "user.username= :username")
    User findByUsername(@Param("username") String username);


}
