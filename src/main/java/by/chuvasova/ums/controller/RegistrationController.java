package by.chuvasova.ums.controller;

import by.chuvasova.ums.model.UserAccount;
import by.chuvasova.ums.service.UserAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserAccountService userAccountService;

    public RegistrationController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/menu")
    public String menuPage() {
        return "menu";
    }

    @ModelAttribute("userAccount")
    public UserAccount getUserObject() {
        return new UserAccount();
    }

    @PostMapping("/register")
    public String addNewUser(@RequestParam(name = "username") String username,
                             @Valid UserAccount userAccount, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "register";
        } else {
            userAccountService.signUp(userAccount);
            model.addAttribute("username", username);
            return "success";
        }
    }
}
