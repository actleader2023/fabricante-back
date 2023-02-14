package com.lmt.fabricanteback.product.controller;

import com.lmt.fabricanteback.product.business.ProductBusiness;
import com.lmt.fabricanteback.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = {"/product", "/products"})
public class ProductController {

	private final ProductBusiness business;
	private final ProductService service;

	@Autowired
	public ProductController(ProductBusiness business,
							 ProductService service) {
		this.business = business;
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody @Validated ProductDTO productDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ProductMapper.fromEntityToDto(business.createProduct(productDTO))
		);
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> listAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(
				service.listAll().stream()
						.map(ProductMapper::fromEntityToDto)
						.collect(Collectors.toList())
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				ProductMapper.fromEntityToDto(service.getByProductId(id))
		);
	}

	@PutMapping
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody @Validated ProductDTO productDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(
				ProductMapper.fromEntityToDto(service.update(ProductMapper.fromDtoToEntity(productDTO)))
		);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable String id) {
		service.delete(id);
	}

}
