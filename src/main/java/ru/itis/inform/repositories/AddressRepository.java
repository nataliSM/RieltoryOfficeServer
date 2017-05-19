package ru.itis.inform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.inform.models.Address;

/**
 * Created by Natalia on 05.03.17.
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {


}
