package com.example.shopping_service.Repository;

import com.example.shopping_service.Module.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository  extends CrudRepository<Shop, Long> {
}
