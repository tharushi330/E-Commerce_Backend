package edu.icet.ecom.repository;

import edu.icet.ecom.entity.ToyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToysRepository extends JpaRepository<ToyEntity, Long> {
    ToyEntity findByName(String name);
}
