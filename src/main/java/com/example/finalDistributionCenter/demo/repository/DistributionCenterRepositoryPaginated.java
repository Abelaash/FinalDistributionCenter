package com.example.finalDistributionCenter.demo.repository;

import com.example.finalDistributionCenter.demo.model.DistributionCenter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionCenterRepositoryPaginated extends PagingAndSortingRepository<DistributionCenter, Long> {
}
