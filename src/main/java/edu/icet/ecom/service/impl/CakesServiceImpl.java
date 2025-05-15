package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Cakes;
import edu.icet.ecom.service.CakesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CakesServiceImpl implements CakesService {
    @Override
    public Optional<Cakes> add(Cakes cakes) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Cakes cakes) {

    }

    @Override
    public List<Cakes> searchByName(String name) {
        return List.of();
    }

    @Override
    public List<Cakes> getAll() {
        return List.of();
    }
}
