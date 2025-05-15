package edu.icet.ecom.service;

import edu.icet.ecom.dto.Flowers;
import edu.icet.ecom.dto.GiftPack;

import java.util.List;
import java.util.Optional;

public interface GiftPackService {
    Optional<GiftPack> add(GiftPack giftPack);

    void delete(Long giftPackId);

    void update(GiftPack giftPack);

    List<GiftPack> searchByName(String name);

    List<GiftPack> getAll();
}
