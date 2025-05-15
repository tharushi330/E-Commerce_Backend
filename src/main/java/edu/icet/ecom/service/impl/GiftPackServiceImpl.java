package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.GiftPack;
import edu.icet.ecom.entity.GiftPackEntity;
import edu.icet.ecom.repository.GiftPackRepository;
import edu.icet.ecom.service.GiftPackService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GiftPackServiceImpl implements GiftPackService {
    private final GiftPackRepository repository;
    private final ModelMapper mapper;

    @Override
    public Optional<GiftPack> add(GiftPack giftPack) {
        GiftPackEntity entity = mapper.map(giftPack, GiftPackEntity.class);
        GiftPackEntity savedEntity = repository.save(entity);
        GiftPack savedGiftPack = mapper.map(savedEntity, GiftPack.class);
        return Optional.of(savedGiftPack);
    }

    @Override
    public void delete(Long giftPackId) {
        repository.deleteById(giftPackId);
    }

    @Override
    public void update(GiftPack giftPack) {
        GiftPackEntity existingEntity = repository.findById(giftPack.getGiftPackId())
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        GiftPackEntity updatedEntity = mapper.map(giftPack, GiftPackEntity.class);
        updatedEntity.setGiftPackId(existingEntity.getGiftPackId());
        repository.save(updatedEntity);
    }

    @Override
    public List<GiftPack> searchByName(String name) {
        List<GiftPackEntity> entity = (List<GiftPackEntity>) repository.findByName(name);
        List<GiftPack> list = new ArrayList<>();
        entity.forEach(entityies -> list.add(mapper.map(entityies,GiftPack.class)));
        return list;
    }

    @Override
    public List<GiftPack> getAll() {
        List<GiftPackEntity> entity = repository.findAll();
        List<GiftPack> arrayList = new ArrayList<>();
        entity.forEach(e -> arrayList.add(mapper.map(e, GiftPack.class)));
        return arrayList;
    }
}
