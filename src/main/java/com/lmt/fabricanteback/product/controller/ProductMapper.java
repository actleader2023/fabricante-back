package com.lmt.fabricanteback.product.controller;

import com.lmt.fabricanteback.product.model.Product;

import java.util.Objects;

public class ProductMapper {

	public static ProductDTO fromEntityToDto(Product entity) {
		if (Objects.isNull(entity))
			return new ProductDTO();

		return ProductDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.price(entity.getPrice())
				.build();
	}

	public static Product fromDtoToEntitySave(ProductDTO dto) {
		if (Objects.isNull(dto))
			return new Product();

		return Product.builder()
				.name(dto.getName())
				.price(dto.getPrice())
				.build();
	}

	public static Product fromDtoToEntity(ProductDTO dto) {
		if (Objects.isNull(dto))
			return new Product();

		return Product.builder()
				.id(dto.getId())
				.name(dto.getName())
				.price(dto.getPrice())
				.build();
	}

}
