package edu.icet.ecom.repository;

import edu.icet.ecom.entity.FlowerEntity;
import edu.icet.ecom.entity.GiftPackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftPackRepository extends JpaRepository<GiftPackEntity, Long> {
    GiftPackEntity findByName(String name);
}
