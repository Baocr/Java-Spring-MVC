package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
// Annotation này đánh dấu lớp là một Controller trong Spring, giúp Spring quản lý các yêu cầu HTTP đến lớp này

public class UserController 
// Đây là lớp dùng để xử lý các yêu cầu HTTP liên quan đến người dùng
{

    private final UserService userService; 
    // Đây là một biến thành viên của lớp, dùng để lưu trữ đối tượng UserRepository,
    // giúp xử lý các thao tác liên quan đến dữ liệu người dùng
    public UserController(UserService userService) // Constructor của lớp,
    {
        this.userService = userService; // Gán đối tượng UserService vào biến thành viên
    }

    @RequestMapping("/") // Annotation này đánh dấu method này sẽ xử lý các yêu cầu HTTP đến đường dẫn gốc ("/")
    // Method này sẽ trả về tên của trang HTML sẽ được hiển thị khi người dùng truy cập vào đường dẫn gốc
    public String getHomePage(Model model) // Method này dùng để xử lý yêu cầu HTTP đến đường dẫn gốc
    {
        List<User> arrUsers = this.userService.getAllUsersByEmail("1@gmail.com"); // Gọi phương thức getAllUsers từ UserService để lấy danh sách người dùng
        System.out.println(arrUsers);
        model.addAttribute("eric", "test");
        return "hello"; // Trả về tên của trang HTML sẽ được hiển thị,
    }

    @RequestMapping("/admin/user") 
    public String getUserPage(Model model) // Method này dùng để xử lý yêu cầu HTTP đến đường dẫn "/user"
    {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users1", users);
        return "/admin/user/table-user"; // Trả về tên của trang HTML sẽ được hiển thị
    }

    @RequestMapping("/admin/user/{id}") 
    public String getUserDetailPage(Model model, @PathVariable long id) // Method này dùng để xử lý yêu cầu HTTP đến đường dẫn "/user"
    {
        System.out.println("id: " + id);
        model.addAttribute("id", id);
        return "/admin/user/show"; // Trả về tên của trang HTML sẽ được hiển thị
    }



    @RequestMapping("/admin/user/create") // Annotation này đánh dấu method này sẽ xử lý các yêu cầu HTTP đến đường dẫn "/user"
    public String getCreateUserPage(Model model) // Method này dùng để xử lý yêu cầu HTTP đến đường dẫn gốc
    {
        model.addAttribute("newUser", new User());
        return "/admin/user/create";
    }


    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoibaoUser) {
        
        this.userService.handleSaveUser(hoibaoUser);
        return "redirect:/admin/user"; // Trả về tên của trang HTML sẽ được hiển thị
    }
}
    
