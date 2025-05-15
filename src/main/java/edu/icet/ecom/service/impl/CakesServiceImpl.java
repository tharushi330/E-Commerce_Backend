package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Cakes;
import edu.icet.ecom.entity.CakeEntity;
import edu.icet.ecom.repository.CakesRepository;
import edu.icet.ecom.service.CakesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CakesServiceImpl implements CakesService {
    private final CakesRepository repository;
    private final ModelMapper mapper;

    @Override
    public Optional<Cakes> add(Cakes cakes) {
        CakeEntity entity = mapper.map(cakes, CakeEntity.class);
        CakeEntity savedEntity = repository.save(entity);
        Cakes savedCakes = mapper.map(savedEntity, Cakes.class);
        return Optional.of(savedCakes);

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Cakes cakes) {
        CakeEntity existingEntity = repository.findById(cakes.getCakeId())
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        CakeEntity updatedEntity = mapper.map(cakes, CakeEntity.class);
        updatedEntity.setCakeId(existingEntity.getCakeId());
        repository.save(updatedEntity);
    }

    @Override
    public List<Cakes> searchByName(String name) {
        List<CakeEntity> entity = (List<CakeEntity>) repository.findByName(name);
        List<Cakes> list = new ArrayList<>();
        entity.forEach(entityies -> list.add(mapper.map(entityies,Cakes.class)));
        return list;
    }

    @Override
    public List<Cakes> getAll() {
        List<CakeEntity> entity = repository.findAll();
        List<Cakes> arrayList = new ArrayList<>();
        entity.forEach(e -> arrayList.add(mapper.map(e, Cakes.class)));
        return arrayList;
    }
}
