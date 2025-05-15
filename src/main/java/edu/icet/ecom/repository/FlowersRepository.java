package edu.icet.ecom.repository;

import edu.icet.ecom.entity.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowersRepository extends JpaRepository<FlowerEntity, Long> {
    FlowerEntity findByName(String name);
}
