package com.stayhere.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stayhere.app.model.ProductDto;
import com.stayhere.app.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/easybuy/api/product")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<EntityModel<ProductDto>> addProduct(@RequestBody ProductDto productDto) {
        logger.info("Adding a new product: {}", productDto.getProductName());
        ProductDto product = productService.addProduct(productDto);
        EntityModel<ProductDto> productResource = EntityModel.of(product,
                linkTo(methodOn(ProductController.class).getProduct(product.getProductid())).withSelfRel(),
                linkTo(methodOn(ProductController.class).updateProduct(product.getProductid(), new ProductDto())).withRel("update"),
                linkTo(methodOn(ProductController.class).deleteProduct(product.getProductid())).withRel("delete"),
                linkTo(methodOn(ProductController.class).getAllProducts()).withRel("all-products"));
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProductDto>> getProduct(@PathVariable("id") long l) {
        logger.info("Fetching product with ID: {}", l);
        ProductDto product = productService.getProduct(l);
        EntityModel<ProductDto> productResource = EntityModel.of(product,
                linkTo(methodOn(ProductController.class).getProduct(l)).withSelfRel(),
                linkTo(methodOn(ProductController.class).updateProduct(l, new ProductDto())).withRel("update"),
                linkTo(methodOn(ProductController.class).deleteProduct(l)).withRel("delete"),
                linkTo(methodOn(ProductController.class).getAllProducts()).withRel("all-products"));
        return new ResponseEntity<>(productResource, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ProductDto>>> getAllProducts() {
        logger.info("Fetching all products");
        List<ProductDto> products = productService.getAllProducts();
        List<EntityModel<ProductDto>> productResources = products.stream()
                .map(product -> EntityModel.of(product,
                        linkTo(methodOn(ProductController.class).getProduct(product.getProductid())).withSelfRel(),
                        linkTo(methodOn(ProductController.class).updateProduct(product.getProductid(), new ProductDto())).withRel("update"),
                        linkTo(methodOn(ProductController.class).deleteProduct(product.getProductid())).withRel("delete")))
                .collect(Collectors.toList());
        CollectionModel<EntityModel<ProductDto>> collectionModel = CollectionModel.of(productResources,
                linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ProductDto>> updateProduct(@PathVariable("id") long productId, @RequestBody ProductDto productDto) {
        logger.info("Updating product with ID: {}", productId);
        ProductDto updatedProduct = productService.updateProduct(productId, productDto);
        EntityModel<ProductDto> productResource = EntityModel.of(updatedProduct,
                linkTo(methodOn(ProductController.class).getProduct(productId)).withSelfRel(),
                linkTo(methodOn(ProductController.class).deleteProduct(productId)).withRel("delete"),
                linkTo(methodOn(ProductController.class).getAllProducts()).withRel("all-products"));
        return new ResponseEntity<>(productResource, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        logger.info("Deleting product with ID: {}", id);
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.NO_CONTENT);
    }
}
