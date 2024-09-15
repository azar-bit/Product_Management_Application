package org.rest.api.service;

import org.rest.api.dto.ProductRepository;
import org.rest.api.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    private ProductRepository productRepository;

    private ProductServiceImp(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        Product product = productRepository.findById(id).orElse(new Product());
        return product;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(Long id) {

        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Product deleted successfully";
        }
        return "product not found";
    }

    @Override
    public Product editProductById(Product product, Long id) {
        if(productRepository.existsById(id)){
            Optional<Product> byId = productRepository.findById(id);
    if(byId.isPresent()){
        Product productFromDb = byId.get();
        productFromDb.setProductName(product.getProductName());
        productFromDb.setPrice(product.getPrice());
        productFromDb.setDescription(product.getDescription());
        productFromDb.setStatus(product.getStatus());
        return productRepository.save(productFromDb);
    }
        }
        return new Product();
    }
}
