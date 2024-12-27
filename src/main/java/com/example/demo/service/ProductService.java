package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.model.ProductModel;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductEntity> products=productRepository.findAll();
		return products;
	}
	public ProductEntity searchById(Long id) {
		// TODO Auto-generated method stub
		Optional<ProductEntity>optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else {
			return null;
		}
	}
    public void deleteProductById(Long id) {
		
		// TODO Auto-generated method stub
    	productRepository.deleteById(id);
		
	}
   
    //get product get by id
    public ProductModel getProductById(Long id) {
        return productRepository.findById(id)
                .map(productEntity -> mapToProductModel(productEntity))
                .orElseThrow(() -> new RuntimeException("Product not found for ID: " + id));
    }

    public void updateProduct(Long id, ProductModel productModel) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found for ID: " + id));

        // Update fields
        productEntity.setProductName(productModel.getProductName());
        productEntity.setBrand(productModel.getBrand());
        productEntity.setMadeIn(productModel.getMadeIn());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setDiscountrate(productModel.getDiscountrate());

        productRepository.save(productEntity);
    }

    public void saveProductDetails(ProductModel productModel) {
        ProductEntity productEntity = new ProductEntity();

        double stockValue = productModel.getPrice() * productModel.getQuantity();
        double discountPrice = productModel.getPrice() * productModel.getDiscountrate() / 100;
        double offerPrice = productModel.getPrice() - discountPrice;
        double taxPrice = productModel.getPrice() * 0.18;
        double finalPrice = offerPrice + taxPrice;

        productEntity.setProductName(productModel.getProductName());
        productEntity.setBrand(productModel.getBrand());
        productEntity.setMadeIn(productModel.getMadeIn());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setDiscountrate(productModel.getDiscountrate());
        productEntity.setStockvalue(stockValue);
        productEntity.setDiscountprice(discountPrice);
        productEntity.setOfferprice(offerPrice);
        productEntity.setTaxprice(taxPrice);
        productEntity.setFinalprice(finalPrice);

        productRepository.save(productEntity);
    }

    // Utility method for mapping
    private ProductModel mapToProductModel(ProductEntity productEntity) {
        ProductModel productModel = new ProductModel();
        productModel.setProductName(productEntity.getProductName());
        productModel.setBrand(productEntity.getBrand());
        productModel.setMadeIn(productEntity.getMadeIn());
        productModel.setQuantity(productEntity.getQuantity());
        productModel.setPrice(productEntity.getPrice());
        productModel.setDiscountrate(productEntity.getDiscountrate());
        return productModel;
    }

		
}