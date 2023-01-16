package com.example.shopping_service.Repository;

import com.example.shopping_service.Module.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
