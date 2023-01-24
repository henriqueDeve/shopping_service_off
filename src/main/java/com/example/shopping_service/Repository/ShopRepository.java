package com.example.shopping_service.Repository;

import com.example.shopping_service.Module.Shop;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ShopRepository  extends CrudRepository<Shop, Long> {
    public List<Shop> findAllByUserIdentifier(String userIdentifier);
    public List<Shop> findAllByTotalGreaterThan(Float total);
    public List<Shop> findAllByDateGreaterThanEquals(Date date);
}

