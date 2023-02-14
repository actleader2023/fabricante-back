package com.lmt.fabricanteback.product.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	@Override
	Page<Product> findAll(Pageable pageable);

	@Query(value = "{ 'quantity': { '$gte': 10 }}")
	List<Product> findAllByOrderByFilter(Sort sort);

}
