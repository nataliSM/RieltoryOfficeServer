package ru.itis.inform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.inform.models.Trader;

/**
 * Created by Natalia on 09.04.17.
 */
public interface TraderRepository extends JpaRepository<Trader, Integer> {
}
