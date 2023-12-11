package com.example.finalDistributionCenter.demo.controller.rest;

import com.example.finalDistributionCenter.demo.model.DistributionCenter;
import com.example.finalDistributionCenter.demo.model.Item;
import com.example.finalDistributionCenter.demo.model.dto.CreateCenter;
import com.example.finalDistributionCenter.demo.model.dto.UpdateItem;
import com.example.finalDistributionCenter.demo.repository.DistributionCenterRepository;
import com.example.finalDistributionCenter.demo.repository.DistributionCenterRepositoryPaginated;
import com.example.finalDistributionCenter.demo.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/update", produces = "application/json")
public class CenterUpdateController {

    private final DistributionCenterRepositoryPaginated centerRepositoryPaginated;
    private final DistributionCenterRepository centerRepository;

    private final ItemRepository itemRepository;

    public CenterUpdateController(DistributionCenterRepositoryPaginated centerRepositoryPaginated,
                                  DistributionCenterRepository centerRepository, ItemRepository itemRepository) {
        this.centerRepositoryPaginated = centerRepositoryPaginated;
        this.centerRepository = centerRepository;
        this.itemRepository = itemRepository;
    }

    @PutMapping("/{id}")
    public DistributionCenter updateCenter(@PathVariable("id") Long id,
                                           @Valid @RequestBody CreateCenter center) {
        var centerToUpdate = centerRepository.findById(id).orElseThrow();
        centerToUpdate.setName(center.getName());
        centerToUpdate.setItems(center.getItems());
        centerToUpdate.setLatitude(center.getLatitude());
        centerToUpdate.setLongitude(center.getLongitude());
        return centerRepository.save(centerToUpdate);
    }

    @PutMapping("/items/{itemId}/quantities={quantity}")
    public Item updateCenterItem(@PathVariable Long itemId, @PathVariable int quantity, @Valid @RequestBody UpdateItem item) {
        var itemToUpdate = itemRepository.findById(itemId).orElseThrow();
        itemToUpdate.setName(itemToUpdate.getName());
        itemToUpdate.setQuantity(itemToUpdate.getQuantity()- quantity);
        itemToUpdate.setPrice(itemToUpdate.getPrice());
        itemToUpdate.setBrandFrom(itemToUpdate.getBrandFrom());
        itemToUpdate.setCreateYear(itemToUpdate.getCreateYear());
        itemToUpdate.setDistributionCenter(itemToUpdate.getDistributionCenter());
        return itemRepository.save(itemToUpdate);
    }
}