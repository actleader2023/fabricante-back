package com.lmt.fabricanteback.product.business;

import com.lmt.fabricanteback.product.controller.ProductDTO;
import com.lmt.fabricanteback.product.controller.ProductMapper;
import com.lmt.fabricanteback.product.model.Product;
import com.lmt.fabricanteback.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBusiness {

	private final ProductService productService;

	@Autowired
	public ProductBusiness(ProductService productService) {
		this.productService = productService;
	}

	public Product createProduct(ProductDTO productDTO) {
		Product product = ProductMapper.fromDtoToEntitySave(productDTO);
//		product.setSector(sectorService.findByName(productDTO.getSectorName()));

		return productService.save(product);
	}

}
