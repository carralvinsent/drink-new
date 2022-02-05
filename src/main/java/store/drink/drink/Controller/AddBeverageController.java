package store.drink.drink.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.drink.drink.Model.Bottle;
import store.drink.drink.Model.Crate;
import store.drink.drink.Repository.BottleRepository;
import store.drink.drink.Repository.CrateRepository;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/AddBeverage")
public class AddBeverageController {

    private final BottleRepository bottleRepository;
    private final CrateRepository crateRepository;

    @Autowired
    public AddBeverageController(BottleRepository bottleRepository, CrateRepository crateRepository) {
        this.bottleRepository = bottleRepository;
        this.crateRepository = crateRepository;
    }

    @PostMapping
    public String addDrinksToCart(@Valid Bottle bottle, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("AddBeverage", this.bottleRepository.findAll());
            return "AddBeverage";
        }
        this.bottleRepository.save(bottle);
        return "redirect:/Home";
    }

    @GetMapping
    public String getItem(Model model) {
        model.addAttribute("AddBeverage", this.bottleRepository.findAll());
        model.addAttribute("AddBeverage",this.crateRepository.findAll());
        model.addAttribute("bottle", new Bottle());
        model.addAttribute("crate",new Crate());
        return "/AddBeverage";

    }

}
