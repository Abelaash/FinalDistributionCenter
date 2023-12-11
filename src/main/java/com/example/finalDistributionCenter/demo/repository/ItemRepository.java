package com.example.finalDistributionCenter.demo.repository;

import com.example.finalDistributionCenter.demo.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByBrandEquals(Item.Brand brand);

    List<Item> findByNameEquals(String name);

    List<Item> findByNameEqualsAndAndBrandEquals(String name, Item.Brand brand);
}