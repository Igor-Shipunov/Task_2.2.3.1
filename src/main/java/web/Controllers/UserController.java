package web.Controllers;

import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.persistence.PersistenceContext;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    //@Autowired
    /*@PersistenceContext
    UserService userService;*/

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/user/main";
    }
    @GetMapping(value = "/main")
    public String main(Model model) {
        model.addAttribute("allUsers",userService.readAll());
        return "main";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.readById(id));
        return "/edit";
    }

    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/main";
    }

    /*@GetMapping(value = "/{id}/delete")
    public String getForDelete(Model model, @PathVariable("id") int id) {
        model.addAttribute("DeletedUser", userService.readById(id));
        return "/";
    }*/

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.delete(userService.readById(id));
        return "redirect:/user/main";
    }
}
