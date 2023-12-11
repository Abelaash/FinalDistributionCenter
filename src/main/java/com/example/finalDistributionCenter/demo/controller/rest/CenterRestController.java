package com.example.finalDistributionCenter.demo.controller.rest;

import com.example.finalDistributionCenter.demo.model.DistributionCenter;
import com.example.finalDistributionCenter.demo.model.Item;
import com.example.finalDistributionCenter.demo.repository.DistributionCenterRepository;
import com.example.finalDistributionCenter.demo.repository.DistributionCenterRepositoryPaginated;
import com.example.finalDistributionCenter.demo.repository.ItemRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/center", produces = "application/json")
public class CenterRestController {

    private final DistributionCenterRepositoryPaginated centerRepositoryPaginated;
    private final DistributionCenterRepository centerRepository;

    private final ItemRepository itemRepository;

    public CenterRestController(DistributionCenterRepositoryPaginated centerRepositoryPaginated,
                                DistributionCenterRepository centerRepository, ItemRepository itemRepository) {
        this.centerRepositoryPaginated = centerRepositoryPaginated;
        this.centerRepository = centerRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public Iterable<DistributionCenter> allCenters(@RequestParam("page") Optional<Integer> page,
                                                   @RequestParam("size") Optional<Integer> size) {
        if (!page.isPresent() || !size.isPresent()) {
            return centerRepository.findAll();
        } else {
            return centerRepositoryPaginated.findAll(PageRequest.of(page.get(), size.get()));
        }
    }

    @GetMapping("/{id}")
    public DistributionCenter getCenter(@PathVariable Long id) {
        var selectedCenter = centerRepository.findById(id);
        return selectedCenter.get();
    }

    @GetMapping("/{id}/items")
    public List<Item> getCenterItems(@PathVariable Long id) {
        var selectedCenter = centerRepository.findById(id);
        var items = selectedCenter.get().getItems();
        return items;
    }

}
