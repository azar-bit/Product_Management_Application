package org.rest.api.service;

import org.rest.api.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product findProductById(Long id);
    List<Product> getProducts();
    String deleteProduct(Long id);
    Product editProductById(Product product,Long id);

}
