package edu.icet.ecom.service;

import edu.icet.ecom.dto.Toys;

import java.util.List;
import java.util.Optional;

public interface ToysService {
    Optional<Toys> add(Toys toys);

    void delete(Long toyId);

    void update(Toys toys);

    List<Toys> searchByName(String name);

    List<Toys> getAll();
}
