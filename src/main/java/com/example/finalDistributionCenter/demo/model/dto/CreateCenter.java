package com.example.finalDistributionCenter.demo.model.dto;

import com.example.finalDistributionCenter.demo.model.DistributionCenter;
import com.example.finalDistributionCenter.demo.model.Item;
import lombok.Data;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateCenter {
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "distributionCenter", cascade = CascadeType.ALL)
    private List<Item> items;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;

    public DistributionCenter toDistributionCenter() {
        return DistributionCenter.builder()
                .name(this.getName())
                .items(this.getItems())
                .latitude(this.getLatitude())
                .longitude(this.getLongitude())
                .build();
    }
}
