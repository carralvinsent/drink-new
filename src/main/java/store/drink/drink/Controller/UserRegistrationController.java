package store.drink.drink.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import store.drink.drink.Model.User;
import store.drink.drink.Repository.UserRepository;

@Controller
@RequestMapping(value="/registration")
public class UserRegistrationController {

    private final UserRepository userRepository;

    @Autowired
    public UserRegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("user", new User());
        return "UserRegistration";
    }

    @PostMapping
    public String registerNewUser(@Valid User user, Errors errors, Model model, BindingResult result) {
        if (errors.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
        }
        else{
            User existing = userRepository.findByUsername(user.getUsername());
            if (existing != null) {
                result.rejectValue("username", null, "There is already an account registered with that email");
            }
            else {
                userRepository.save(user);
                return "redirect:/registration?success";
            }
        }
        return "UserRegistration";
    }

}