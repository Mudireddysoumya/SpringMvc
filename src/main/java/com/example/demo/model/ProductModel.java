package com.example.demo.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductModel {

	@NotBlank(message="prodcut name cannot be empty")
	private String productName;
	@Positive(message="price must be greater than zero")
	private double price;
	@Min(message="Quantity at least 1",value=1)
	private int quantity;
	@NotBlank(message="brand name cannot be empty")
	private String brand;
	@NotBlank(message="Madein field cannot be empty")
	private String madeIn;
	@DecimalMax(message="discount rate cannot exceed 100",value="100.0")
	private double discountrate;

}