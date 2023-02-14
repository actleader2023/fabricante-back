package com.lmt.fabricanteback.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmt.fabricanteback.utils.audit.AuditDocument;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Document
public class Product extends AuditDocument {

	@Id
	@JsonProperty
	private String id;

	@JsonProperty(required = true)
	private String name;

	@JsonProperty(required = true)
	private Double price;

//	@Id
//	@JsonProperty
//	private String id;
//
//	@JsonProperty(required = true)
//	private String name;
//
//	@JsonProperty(required = true)
//	private Integer quantity;
//
//	@DBRef
//	@JsonProperty(required = true)
//	private Sector sector;

}
