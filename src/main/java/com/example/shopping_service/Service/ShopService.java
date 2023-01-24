package com.example.shopping_service.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.shopping_service.DTO.ShopDTO;
import com.example.shopping_service.Module.Shop;
import com.example.shopping_service.Repository.ShopRepository;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        List<Shop> shops = (List<Shop>) shopRepository.findAll();
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository.findAllByUserId(userIdentifier);
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateShop(shopDTO.getDateShop());
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(long ProductId) {
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if (shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO) {
        shopDTO.setTotal(shopDTO.getItemDTOS()
                .stream()
                .map(x -> x.getPrice())
                .reduce((float) 0, Float::sum));

        Shop shop = Shop.convert(shopDTO);
        shop.setDateShop(new Date());
        shop = shopRepository.save(shop);
        return ShopDTO.convert(shop);
    }
}