package com.example.shopping_service.Repository;

import com.example.shopping_service.Module.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
    List<Shop> findAllByUserId(String userId);
    List<Shop> findAllByTotalGreaterThan(Float total);
    List<Shop> findAllByDateShop(Date date);
}

