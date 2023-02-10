package web.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserServiceImp;
import web.model.User;

@Controller
//@RequestMapping("/")
public class UsersController {

  @GetMapping("/users")
  public String showAllUsers(Model model) {
//    List<User> list = new UserServiceImp().getListUsers();
    List<String> list = new ArrayList<>(Arrays.asList("11", "22", "33", "44"));
    model.addAttribute("users", list);
    return "users";
  }

  @GetMapping("/add")
  public String addUser() {
    return "add";
  }
}
