package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Flowers;
import edu.icet.ecom.entity.FlowerEntity;
import edu.icet.ecom.repository.FlowersRepository;
import edu.icet.ecom.service.FlowersService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowersServiceImpl implements FlowersService {
    private final FlowersRepository repository;
    private final ModelMapper mapper;

    @Override
    public Optional<Flowers> add(Flowers flowers) {
        FlowerEntity entity = mapper.map(flowers, FlowerEntity.class);
        FlowerEntity savedEntity = repository.save(entity);
        Flowers savedFlowers = mapper.map(savedEntity, Flowers.class);
        return Optional.of(savedFlowers);
    }

    @Override
    public void delete(Long flowerId) {
        repository.deleteById(flowerId);
    }

    @Override
    public void update(Flowers flowers) {
        FlowerEntity existingEntity = repository.findById(flowers.getFlowerId())
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        FlowerEntity updatedEntity = mapper.map(flowers, FlowerEntity.class);
        updatedEntity.setFlowerId(existingEntity.getFlowerId());
        repository.save(updatedEntity);
    }

    @Override
    public List<Flowers> searchByName(String name) {
        List<FlowerEntity> entity = (List<FlowerEntity>) repository.findByName(name);
        List<Flowers> list = new ArrayList<>();
        entity.forEach(entityies -> list.add(mapper.map(entityies,Flowers.class)));
        return list;
    }

    @Override
    public List<Flowers> getAll() {
        List<FlowerEntity> entity = repository.findAll();
        List<Flowers> arrayList = new ArrayList<>();
        entity.forEach(e -> arrayList.add(mapper.map(e, Flowers.class)));
        return arrayList;
    }
}
