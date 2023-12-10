package com.example.SpringWeb.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductCreationRequest {

    @NotBlank(message = "Tên bắt buộc nhập")
    private String name;
    private int price;
    private String description;
    private MultipartFile image;

}

