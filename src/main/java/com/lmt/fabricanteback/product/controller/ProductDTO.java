package com.lmt.fabricanteback.product.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private String id;
	private String name;
	private Double price;

//	private String id;
//
//	@NotNull(message = "Nome do produto não pode estar nulo!")
//	@NotBlank(message = "Nome do produto não pode estar em branco!")
//	private String name;
//
//	@NotNull(message = "Quantidade do produto não pode estar nulo!")
//	private Integer quantity;
//
//	@NotNull(message = "Nome do setor não pode estar nulo!")
//	@NotBlank(message = "Nome do setor não pode estar em branco!")
//	private String sectorName;
}
