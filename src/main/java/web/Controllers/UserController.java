package web.Controllers;

import web.Service.UserService;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.PersistenceContext;

@Controller
//@RequestMapping(value = "/user")
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
    public String create(@ModelAttribute("newUser") User user) {
        userService.create(user);
        return "redirect:/new";
    }
    @GetMapping(value = "/test")
    public String test() {
        //model.addAttribute("user", new User());
        return "test";
    }
}
