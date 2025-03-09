package com.stayhere.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stayhere.app.model.ProductDto;
import com.stayhere.app.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static final Logger logger = LogManager.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepo;

    public ProductDto addProduct(ProductDto product) {
        if (product.getProductName().isEmpty() || product.getCategory().isEmpty()
                || product.getSearchkeyword().isEmpty() || product.getPrice() <= 0) {
            logger.warn("All fields are mandatory");
            throw new IllegalArgumentException("All fields are mandatory");
        }
        logger.info("Adding new product: {}", product.getProductName());
        return productRepo.save(product);
    }

    public ProductDto getProduct(long productId) {
        logger.info("Fetching product with ID: {}", productId);
        return productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

    public List<ProductDto> getAllProducts() {
        logger.info("Fetching all products");
        return productRepo.findAll();
    }

    public ProductDto updateProduct(long productId, ProductDto updatedProduct) {
        logger.info("Updating product with ID: {}", productId);
        return productRepo.findById(productId).map(existingProduct -> {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setSearchkeyword(updatedProduct.getSearchkeyword());
            existingProduct.setPrice(updatedProduct.getPrice());
            return productRepo.save(existingProduct);
        }).orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

    public void deleteProduct(long productId) {
        logger.info("Deleting product with ID: {}", productId);
        if (!productRepo.existsById(productId)) {
            throw new RuntimeException("Product not found with ID: " + productId);
        }
        productRepo.deleteById(productId);
    }

	
}
