package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private UserService userService;



    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(ModelMap model) {
        List<String> msg = new ArrayList<>();
        msg.add(new String("spring-mvc > 5.3.14"));
        msg.add(new String("thymeleaf-spring5 > 3.0.14.RELEASE"));
        msg.add(new String("hibernate-core 5.6.3.Final"));

        model.addAttribute("msg", msg);
        return "index";
    }


    @GetMapping("/users")
    public String getUsersList(ModelMap model) {
        model.addAttribute("userList", userService.getUsersList());
        return "users";
    }



    @GetMapping("/users/create")
    public String addNewUser(@ModelAttribute("userAdd") User user) {
        return "create";

    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute("userAdd") @Valid User addUser,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "create";

        userService.addNewUser(addUser);


        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String upDate(@RequestParam(value = "id", defaultValue = "1") Long id, ModelMap model) {
        model.addAttribute("userUpdate", userService.getUserByID(id));
        return "edit";

    }

    @PostMapping("/users/edit")
    public String updateUser(@ModelAttribute("userUpdate") User user) {
        userService.updateUser(user.getId(), user);

        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteUser(id);

        return "redirect:/users";
    }

    @GetMapping("/users/user")
    public String getUser(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("userSolo", userService.getUserByID(id));

        return "user";
    }








}
