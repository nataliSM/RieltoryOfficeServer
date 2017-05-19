package ru.itis.inform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.inform.models.Trader;
import ru.itis.inform.models.User;

/**
 * Created by Natalia on 13.05.17.
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
