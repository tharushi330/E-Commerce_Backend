package edu.icet.ecom.service;

import edu.icet.ecom.dto.Cakes;

import java.util.List;
import java.util.Optional;

public interface CakesService {
    Optional<Cakes> add(Cakes cakes);

    void delete(Long id);

    void update(Cakes cakes);

    List<Cakes> searchByName(String name);

    List<Cakes> getAll();
}
