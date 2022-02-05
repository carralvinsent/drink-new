package store.drink.drink.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.drink.drink.Model.Bottle;
import store.drink.drink.Repository.BottleRepository;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/AddBottle")
public class AddBottleController {

    private final BottleRepository bottleRepository;

    @Autowired
    public AddBottleController(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    @PostMapping
    public String addDrinksToCart(@Valid Bottle bottle, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("AddBottle", this.bottleRepository.findAll());
            return "AddBottle";
        }
        this.bottleRepository.save(bottle);
        return "redirect:/Home";
    }

    @GetMapping
    public String getItem(Model model) {
        model.addAttribute("AddBottle", this.bottleRepository.findAll());
        model.addAttribute("bottle", new Bottle());
        return "/AddBottle";

    }

}
