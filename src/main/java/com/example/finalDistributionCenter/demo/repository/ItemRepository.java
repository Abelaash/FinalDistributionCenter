package com.example.finalDistributionCenter.demo.repository;

import com.example.finalDistributionCenter.demo.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByBrandFromEquals(Item.Brand brandFrom);

    List<Item> findByNameEquals(String name);

    List<Item> findByNameEqualsAndAndBrandFromEquals(String name, Item.Brand brandFrom);
}