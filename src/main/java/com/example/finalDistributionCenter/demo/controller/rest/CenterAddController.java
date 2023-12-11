package com.example.finalDistributionCenter.demo.controller.rest;

import com.example.finalDistributionCenter.demo.model.DistributionCenter;
import com.example.finalDistributionCenter.demo.model.Item;
import com.example.finalDistributionCenter.demo.model.dto.CreateCenter;
import com.example.finalDistributionCenter.demo.repository.DistributionCenterRepository;
import com.example.finalDistributionCenter.demo.repository.DistributionCenterRepositoryPaginated;
import com.example.finalDistributionCenter.demo.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/add", produces = "application/json")
public class CenterAddController {

    private final DistributionCenterRepositoryPaginated centerRepositoryPaginated;
    private final DistributionCenterRepository centerRepository;

    private final ItemRepository itemRepository;

    public CenterAddController(DistributionCenterRepositoryPaginated centerRepositoryPaginated,
                               DistributionCenterRepository centerRepository, ItemRepository itemRepository) {
        this.centerRepositoryPaginated = centerRepositoryPaginated;
        this.centerRepository = centerRepository;
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public DistributionCenter createCenter(@Valid @RequestBody CreateCenter center) {
        return centerRepository.save(center.toDistributionCenter());
    }

    @PostMapping("/{id}/items")
    public Item addItemToCenter(@PathVariable Long id, @Valid @RequestBody Item item) {
        var selectedCenter = centerRepository.findById(id);
        item.setDistributionCenter(selectedCenter.get());
        var savedItem = itemRepository.save(item);
        return savedItem;
    }

}
