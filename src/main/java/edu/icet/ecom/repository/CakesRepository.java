package edu.icet.ecom.repository;

import edu.icet.ecom.entity.CakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakesRepository extends JpaRepository<CakeEntity, Long> {
    CakeEntity findByName(String name);
}
