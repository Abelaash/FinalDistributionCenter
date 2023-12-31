package com.example.finalDistributionCenter.demo;

import com.example.finalDistributionCenter.demo.model.DistributionCenter;
import com.example.finalDistributionCenter.demo.model.Item;
import com.example.finalDistributionCenter.demo.repository.DistributionCenterRepository;
import com.example.finalDistributionCenter.demo.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class FinalDistributionCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalDistributionCenterApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository itemRepository, DistributionCenterRepository centerRepository) {
		return args -> {
			var distributionCenter1 = centerRepository
					.save(DistributionCenter.builder().name("location 1").latitude(43.711615).longitude(-79.401982).build());
			itemRepository
					.save(Item.builder().name("Small Nomad Bag")
							.yearOfCreation(2024)
							.brand(Item.Brand.DIOR)
							.price(new BigDecimal(4700))
							.quantity(10).distributionCenter(distributionCenter1).build());
			itemRepository
					.save(Item.builder()
							.name("B30 Sneaker")
							.yearOfCreation(2023)
							.brand(Item.Brand.DIOR)
							.price(new BigDecimal(1350))
							.quantity(5).distributionCenter(distributionCenter1).build());
			itemRepository
					.save(Item.builder()
							.name("Sweater")
							.yearOfCreation(2022)
							.brand(Item.Brand.DIOR)
							.price(new BigDecimal(4000)).distributionCenter(distributionCenter1).quantity(8).build());
		};
	}

	@Bean
	CommandLineRunner dataLoader2(ItemRepository itemRepository, DistributionCenterRepository centerRepository) {
		return args -> {
			var distributionCenter2 = centerRepository
					.save(DistributionCenter.builder().name("location 2").latitude(43.762160).longitude(-79.284125).build());
			itemRepository
					.save(Item.builder()
							.name("Box Logo Hoodie")
							.yearOfCreation(2022)
							.brand(Item.Brand.SUPREME)
							.price(new BigDecimal(1100)).quantity(20).distributionCenter(distributionCenter2).build());
			itemRepository
					.save(Item.builder()
							.name("Box Logo Backpack")
							.yearOfCreation(2022)
							.brand(Item.Brand.SUPREME)
							.price(new BigDecimal(2100)).quantity(15).distributionCenter(distributionCenter2).build());
			itemRepository
					.save(Item.builder()
							.name("Tourist varsity \"Black\" jacket")
							.yearOfCreation(2022)
							.brand(Item.Brand.SUPREME)
							.price(new BigDecimal(1350)).quantity(10).distributionCenter(distributionCenter2).build());
			itemRepository
					.save(Item.builder()
							.name("Sweater")
							.yearOfCreation(2022)
							.brand(Item.Brand.DIOR)
							.price(new BigDecimal(4000)).distributionCenter(distributionCenter2).quantity(2).build());
		};
	}

	@Bean
	CommandLineRunner dataLoader3(ItemRepository itemRepository, DistributionCenterRepository centerRepository) {
		return args -> {
			var distributionCenter3 = centerRepository
					.save(DistributionCenter.builder().name("location 3").latitude(43.631470).longitude(-79.527526).build());
			itemRepository
					.save(Item.builder()
							.name("Air Jordan 1 Retro High Off-White Chicago")
							.yearOfCreation(2022)
							.brand(Item.Brand.OFFWHITE)
							.price(new BigDecimal(7000)).quantity(13).distributionCenter(distributionCenter3).build());
			itemRepository
					.save(Item.builder()
							.name("Script Logo Opp Over Skate Hoodie")
							.yearOfCreation(2022)
							.brand(Item.Brand.OFFWHITE)
							.price(new BigDecimal(1550)).quantity(2).distributionCenter(distributionCenter3).build());
			itemRepository
					.save(Item.builder()
							.name("Nike Air Force 1 Low Off-White")
							.yearOfCreation(2024)
							.brand(Item.Brand.OFFWHITE)
							.price(new BigDecimal(2250)).quantity(5).distributionCenter(distributionCenter3).build());
		};
	}

	@Bean
	CommandLineRunner dataLoader4(ItemRepository itemRepository, DistributionCenterRepository centerRepository) {
		return args -> {
			var distributionCenter4 = centerRepository
					.save(DistributionCenter.builder().name("location 4").latitude(43.774829).longitude(-79.186823).build());
			itemRepository
					.save(Item.builder()
							.name("Jacket")
							.yearOfCreation(2023)
							.brand(Item.Brand.STONEISLAND)
							.price(new BigDecimal(1100)).quantity(6).distributionCenter(distributionCenter4).build());
			itemRepository
					.save(Item.builder()
							.name("Sweater")
							.yearOfCreation(2025)
							.brand(Item.Brand.STONEISLAND)
							.price(new BigDecimal(1550)).quantity(20).distributionCenter(distributionCenter4).build());
			itemRepository
					.save(Item.builder()
							.name("T-SHIRTS")
							.yearOfCreation(2023)
							.brand(Item.Brand.STONEISLAND)
							.price(new BigDecimal(1150)).quantity(25).distributionCenter(distributionCenter4).build());
		};
	}
}
