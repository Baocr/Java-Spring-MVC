package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
// Annotation này đánh dấu lớp là một Controller trong Spring, giúp Spring quản lý các yêu cầu HTTP đến lớp này

public class UserController 
// Đây là lớp dùng để xử lý các yêu cầu HTTP liên quan đến người dùng
{

    private UserService userService; 
    // // Đây là một biến thành viên của lớp, 
    // dùng để lưu trữ đối tượng UserService, 
    // giúp xử lý logic nghiệp vụ liên quan đến người dùng

    public UserController(UserService userService) // Constructor của lớp,
    {
        this.userService = userService; // Gán đối tượng UserService vào biến thành viên
    }

    @RequestMapping("/") // Annotation này đánh dấu method này sẽ xử lý các yêu cầu HTTP đến đường dẫn gốc ("/")
    // Method này sẽ trả về tên của trang HTML sẽ được hiển thị khi người dùng truy cập vào đường dẫn gốc
    public String getHomePage(Model model) // Method này dùng để xử lý yêu cầu HTTP đến đường dẫn gốc
    {
        String test = this.userService.handleHello();
        model.addAttribute("eric", test);
        return "hello"; // Trả về tên của trang HTML sẽ được hiển thị,
    }

    @RequestMapping("/admin/user") // Annotation này đánh dấu method này sẽ xử lý các yêu cầu HTTP đến đường dẫn "/user"
    public String userPage(Model model) // Method này dùng để xử lý yêu cầu HTTP đến đường dẫn gốc
    {
        model.addAttribute("newUser", new User());
        return "/admin/user/create";
    }


    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoibaoUser) {
        System.out.println("Run here"+ hoibaoUser);
        return "hello";
    }
}
    
