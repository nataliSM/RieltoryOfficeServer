package ru.itis.inform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.inform.models.Feature;

/**
 * Created by Natalia on 09.03.17.
 */
public interface FeaturesRepository extends JpaRepository<Feature, Integer> {
}
