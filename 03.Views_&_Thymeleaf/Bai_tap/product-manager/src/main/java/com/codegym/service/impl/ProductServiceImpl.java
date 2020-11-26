package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap = new TreeMap<>();

    static {
        productMap.put(1, new Product( "SP-001", "iphone", 1200, "apple", 10));
        productMap.put(2, new Product( "SP-002", "nokia", 1200, "nokia", 10));
        productMap.put(3, new Product("SP-003", "samsung galaxy", 1200, "samsung", 10));
        productMap.put(4, new Product("SP-004", "sony", 1200, "apple", 10));
        productMap.put(5, new Product( "SP-005", "exiter", 10200, "yamaha", 10));
        productMap.put(6, new Product( "SP-006", "airblade", 11200, "apple", 10));
        productMap.put(7, new Product( "SP-007", "apple watch", 1200, "apple", 10));
        productMap.put(8, new Product( "SP-008", "ipad", 1200, "apple", 10));
        productMap.put(9, new Product( "SP-009", "lg optimus", 1200, "lg", 10));
        productMap.put(10, new Product("SP-0010", "tivi lg 4k", 1200, "lg", 10));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
//        int id= (int)(Math.random()*100);
//        product.setId(id);

        List<Product> products=new ArrayList<>(productMap.values());
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
