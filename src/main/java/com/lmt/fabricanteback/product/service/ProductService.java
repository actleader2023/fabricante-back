package com.lmt.fabricanteback.product.service;

import com.lmt.fabricanteback.product.model.Product;
import com.lmt.fabricanteback.product.model.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ProductService {

	private final ProductRepository repository;

	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public Product save(Product product) {
		if (product.getName().isEmpty() && product.getPrice() == 0) {
			throw new IllegalArgumentException("[X]-> Produto está null ou vazio!");
		}

		Product createdProduct = repository.save(product);
		log.info("[V]-> Produto criado com sucesso! NOME[{}], PREÇO[{}]",
				createdProduct.getName(), createdProduct.getPrice());

		return createdProduct;
	}

	@Transactional
	public List<Product> listAll() {
		List<Product> products = repository.findAll();
		if (products.isEmpty()) {
			log.info("[X]-> Lista de produtos está vazia!");
		}

		log.info("[V]-> Listagem feita com sucesso! | TOTAL DE PRODUTOS[{}]", products.size());
		return products;
	}

	public Product getByProductId(String id) {
		return repository.findById(id).orElse(new Product());
	}

	@Transactional
	public Product update(Product product) {
		if (product.toString().isEmpty()) {
			throw new IllegalArgumentException("[X]-> Produto está null ou vazio!");
		}

		Product productUpdate = repository.findById(product.getId())
				.orElseThrow(() -> new RuntimeException("[X]-> O Produto [" + product.getName() + "] não foi encontrado!"));

		if (!product.getName().isEmpty() && !productUpdate.getName().equals(product.getName())) {
			log.info("[NOME: {} -> {}]", productUpdate.getName(), product.getName());
			productUpdate.setName(product.getName());
		}

		if (product.getPrice() != null && !Objects.equals(productUpdate.getPrice(), product.getPrice())) {
			log.info("[QUANTIDADE: {} -> {}]", productUpdate.getPrice(), product.getPrice());
			productUpdate.setPrice(product.getPrice());
		}

		productUpdate = repository.save(productUpdate);
		log.info("[V]-> Produto atualizado com sucesso! ID[{}], NOME[{}] ", productUpdate.getId(), productUpdate.getName());

		return productUpdate;
	}

	public void delete(String id) {
		if (id.isEmpty()) {
			throw new IllegalArgumentException("[X]-> Produto está null ou vazio!");
		}

		repository.deleteById(id);
	}

}
