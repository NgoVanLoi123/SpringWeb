package com.example.SpringWeb.controller;

import com.example.SpringWeb.model.response.ProductResponse;
import com.example.SpringWeb.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Controller
@RequestMapping("/admin") // base path
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getProduct(Model model) {
        List<ProductResponse> products = productService.getProducts();
        model.addAttribute("dsProduct", products);
        return "product";
    }
    @PostMapping
    public ResponseEntity<?> createProduct(
            @RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile file
    ) {
        productService.createProduct(file,name,price,description);
        return ResponseEntity.ok(null);
    }
}