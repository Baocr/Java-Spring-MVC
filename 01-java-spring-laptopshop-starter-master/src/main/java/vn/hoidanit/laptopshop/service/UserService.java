package vn.hoidanit.laptopshop.service;


import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service // Annotation này đánh dấu lớp là một Service trong Spring, giúp Spring quản lý bean của lớp này

public class UserService // Đây là lớp dùng để xử lý logic nghiệp vụ liên quan đến người dùng
{
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) // Constructor của lớp, nhận vào một đối tượng UserRepository
    {
        this.userRepository = userRepository; // Gán đối tượng UserRepository vào biến thành viên
    }

    public String handleHello() // Method này dùng để trả về một chuỗi đơn giản, có thể là thông điệp chào mừng hoặc thông tin khác
    {
        return "Hello from UserService!"; // Trả về chuỗi "Hello from UserService!"
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
