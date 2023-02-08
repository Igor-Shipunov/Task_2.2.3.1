package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.model.User;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.createNewUser(user);
        return "redirect:/user/main";
    }
    @GetMapping(value = "/main")
    public String mainPage(Model model) {
        model.addAttribute("allUsers",userService.getAllUsers());
        return "main";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

    @PatchMapping(value = "/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/user/main";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:/user/main";
    }
}
