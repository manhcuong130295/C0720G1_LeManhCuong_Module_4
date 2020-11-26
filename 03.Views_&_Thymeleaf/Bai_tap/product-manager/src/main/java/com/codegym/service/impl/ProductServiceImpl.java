package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "SP-001", "iphone", 1200, "apple", 10));
        productMap.put(2, new Product(2, "SP-002", "nokia", 1200, "nokia", 10));
        productMap.put(3, new Product(3, "SP-003", "samsung galaxy", 1200, "samsung", 10));
        productMap.put(4, new Product(4, "SP-004", "sony", 1200, "apple", 10));
        productMap.put(5, new Product(5, "SP-005", "exiter", 10200, "yamaha", 10));
        productMap.put(6, new Product(6, "SP-006", "airblade", 11200, "apple", 10));
        productMap.put(7, new Product(7, "SP-007", "apple watch", 1200, "apple", 10));
        productMap.put(8, new Product(8, "SP-008", "ipad", 1200, "apple", 10));
        productMap.put(9, new Product(9, "SP-009", "lg optimus", 1200, "lg", 10));
        productMap.put(10, new Product(10, "SP-0010", "tivi lg 4k", 1200, "lg", 10));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
