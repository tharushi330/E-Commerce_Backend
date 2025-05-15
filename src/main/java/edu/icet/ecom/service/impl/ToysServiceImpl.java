package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Toys;
import edu.icet.ecom.entity.ToyEntity;
import edu.icet.ecom.repository.ToysRepository;
import edu.icet.ecom.service.ToysService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToysServiceImpl implements ToysService {
    private final ToysRepository repository;
    private final ModelMapper mapper;

    @Override
    public Optional<Toys> add(Toys toys) {
        ToyEntity entity = mapper.map(toys, ToyEntity.class);
        ToyEntity savedEntity = repository.save(entity);
        Toys savedToys = mapper.map(savedEntity, Toys.class);
        return Optional.of(savedToys);
    }

    @Override
    public void delete(Long toyId) {
        repository.deleteById(toyId);
    }

    @Override
    public void update(Toys toys) {
        ToyEntity existingEntity = repository.findById(toys.getToyId())
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        ToyEntity updatedEntity = mapper.map(toys, ToyEntity.class);
        updatedEntity.setToyId(existingEntity.getToyId());
        repository.save(updatedEntity);
    }

    @Override
    public List<Toys> searchByName(String name) {
        List<ToyEntity> entity = (List<ToyEntity>) repository.findByName(name);
        List<Toys> list = new ArrayList<>();
        entity.forEach(entityies -> list.add(mapper.map(entityies,Toys.class)));
        return list;
    }

    @Override
    public List<Toys> getAll() {
        List<ToyEntity> entity = repository.findAll();
        List<Toys> arrayList = new ArrayList<>();
        entity.forEach(e -> arrayList.add(mapper.map(e, Toys.class)));
        return arrayList;
    }
}
