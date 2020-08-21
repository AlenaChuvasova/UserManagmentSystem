package by.chuvasova.ums.controller;

import by.chuvasova.ums.model.UserAccount;
import by.chuvasova.ums.repository.UserAccountRepository;
import by.chuvasova.ums.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserAccountController {

    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    UserAccountService userAccountService;

    @GetMapping("/users")
    public String getListOfUserAccounts(Model model) {
        model.addAttribute("users", userAccountRepository.findAll());
        return "users";
    }

    @GetMapping("/user/{id}")
    public String showUserDetailsById(@PathVariable("id") long id, Model model) {
        UserAccount userAccount = userAccountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", userAccount);
        return "user";
    }

    @GetMapping("/users/{id}/edit")
    public String showUserEditPage(@PathVariable("id") long id, Model model) {
        UserAccount userAccount = userAccountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("userAccount", userAccount);
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam(name = "username") String username,
                           @Valid UserAccount userAccount, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "valid-error";
        } else {
            userAccountService.updateAccount(userAccount);
            model.addAttribute("username", username);
            return "success-update";
        }
    }

    @GetMapping("/users/new")
    public String addNewUserPage() {
        return "newuser";
    }

    @ModelAttribute("userAccount")
    public UserAccount getUserObject() {
        return new UserAccount();
    }

    @PostMapping("/users/new")
    public String addNewUser(@RequestParam(name = "username") String username,
                             @Valid UserAccount userAccount, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "newuser";
        } else {
            userAccountService.signUp(userAccount);
            model.addAttribute("username", username);
            return "success";
        }
    }
}
