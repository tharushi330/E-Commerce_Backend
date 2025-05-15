package edu.icet.ecom.service;

import edu.icet.ecom.dto.Flowers;

import java.util.List;
import java.util.Optional;

public interface FlowersService {
    Optional<Flowers> add(Flowers flowers);

    void delete(Long flowerId);

    void update(Flowers flowers);

    List<Flowers> searchByName(String name);

    List<Flowers> getAll();
}
