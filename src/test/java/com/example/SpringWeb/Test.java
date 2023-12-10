package com.example.SpringWeb;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Test {

    @NotBlank(message = "Tên sinh viên bắt buộc nhập")
    private String name;
    private String address;
    private String phone;
    private String className;
    private MultipartFile image;

}
