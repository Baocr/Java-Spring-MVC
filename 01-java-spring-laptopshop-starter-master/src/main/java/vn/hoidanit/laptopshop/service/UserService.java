package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;

@Service // Annotation này đánh dấu lớp là một Service trong Spring, giúp Spring quản lý bean của lớp này

public class UserService // Đây là lớp dùng để xử lý logic nghiệp vụ liên quan đến người dùng
{
    public String handleHello() // Method này dùng để trả về một chuỗi đơn giản, có thể là thông điệp chào mừng hoặc thông tin khác
    {
        return "Hello from UserService!"; // Trả về chuỗi "Hello from UserService!"
    }
}
