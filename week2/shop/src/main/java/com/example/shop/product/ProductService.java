package com.example.shop.product;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.net.List;
import java.util.*;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    // 상품 등록
    public Product createProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // 상품 목록 조회
    public List<Product> getAllProducts() {
        return products;
    }

    // 개별 상품 조회
    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));
    }

    // 상품 수정
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProductOpt = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
            return existingProduct;
        } else {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }
    }

    // 상품 삭제
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}