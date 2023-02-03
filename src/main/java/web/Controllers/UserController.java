package web.Controllers;

import web.Service.UserService;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    /*@PostMapping()
    public String create(@ModelAttribute("newUser") User user) {
        userService.create(user);
        return "redirect:/user";
    }*/
    @GetMapping(value = "/test")
    public String test() {
        //model.addAttribute("user", new User());
        return "test";
    }
}
