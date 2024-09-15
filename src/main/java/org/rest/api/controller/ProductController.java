package org.rest.api.controller;

import org.rest.api.model.Product;
import org.rest.api.service.ProductServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private ProductServiceImp productServiceImp;
    private ProductController(ProductServiceImp productServiceIm) {
        this.productServiceImp = productServiceIm;
    }

    @PostMapping("/save")
   public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productServiceImp.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Product>>  getAllProducts() {
        return new ResponseEntity<>(productServiceImp.getProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productServiceImp.findProductById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Product> updateProduct( @PathVariable("id") Long id,@RequestBody Product product) {
        return new ResponseEntity<>(productServiceImp.editProductById(product,id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteProduct( @PathVariable("id") Long id) {
        return new ResponseEntity<String>(productServiceImp.deleteProduct(id), HttpStatus.OK);
    }


}
