package com.example.SpringWeb.service;

import com.example.SpringWeb.entity.Product;
import com.example.SpringWeb.model.response.ProductResponse;
import com.example.SpringWeb.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .image(product.getImage())
                        .build()
                )
                .collect(Collectors.toList());

    }
    public void createProduct(MultipartFile file, String name, int price, String description) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        String fileImage="";
        try {
            fileImage= Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = Product.builder()
                .name(name)
                .price(price)
                .description(description)
                .image(fileImage)
                .build();
        productRepository.save(product);
    }

}
