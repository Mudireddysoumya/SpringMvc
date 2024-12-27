package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String productName;
	private String brand;
	private String madeIn;
    private double price;
	private int quantity;
	private double discountrate;
	private double offerprice;
	private double finalprice;
	private double stockvalue;
	private double taxprice;
	private double discountprice;
}