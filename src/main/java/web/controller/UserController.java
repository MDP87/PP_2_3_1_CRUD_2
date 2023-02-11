package web.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.repository.UserRepository;
import web.model.User;

@Controller
@RequestMapping("/")
public class UserController {
  private UserRepository userRepository;
  public UserController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @GetMapping(value = "/")
  public String printWelcome(ModelMap model) {
    List<String> messages = new ArrayList<>();
    messages.add("Hello!");
    model.addAttribute("messages", messages);
    return "index";
  }
  @GetMapping("/users")
  public String showAllUsers(Model model) {
    List<User> list = userRepository.getListUsers();
    model.addAttribute("users", list);
    return "users";
  }
  @GetMapping("/add")
  public String addToIndexUser(Model model) {
    model.addAttribute("user", new User());
    return "add";
  }
  @PostMapping("/addNewUser")
  public String addNewUser(@ModelAttribute User user) {
    userRepository.add(user);
    return "redirect:/users";
  }
  @GetMapping("/update/{id}")
  public String editUser(@PathVariable("id") long id, Model model) {
    model.addAttribute("user", userRepository.getUserById(id));
    return "update";
  }
  @PatchMapping("/user/{id}")
  public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id ) {
    userRepository.updateUser(user, id);
    return "redirect:/users";
  }
  @DeleteMapping("/delete/{id}")
  public String deleteUser(@PathVariable("id") long id) {
    userRepository.deleteUserById(id);
    return "redirect:/users";
  }

}
