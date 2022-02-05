package store.drink.drink.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import store.drink.drink.Model.User;
import store.drink.drink.Repository.UserRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(value={"/Login","/"})
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getOrderItems(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("user", new User());
        return "Login";
    }

    @PostMapping
    public String deleteOrderItemsAndCreateNewOrder(@Valid User user, Errors errors, Model model, BindingResult result) {
        if (errors.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
        }
        else{
            User existing = userRepository.findByUsername(user.getUsername());
            if (existing == null) {
                result.rejectValue("username",null,"Invalid Username. Try again.");
            }
            else {
                if(existing.getPassword().equals(user.getPassword())){
                    return "redirect:/Home";
                }
                result.rejectValue("username",null,"Invalid Password. Try again.");
            }
        }
        return "Login";
    }

}
