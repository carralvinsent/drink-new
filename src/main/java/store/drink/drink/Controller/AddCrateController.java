package store.drink.drink.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.drink.drink.Model.Crate;
import store.drink.drink.Repository.CrateRepository;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/AddCrate")
public class AddCrateController {

    private final CrateRepository crateRepository;

    @Autowired
    public AddCrateController(CrateRepository crateRepository) {
        this.crateRepository = crateRepository;
    }

    @PostMapping
    public String addDrinksToCart(@Valid Crate crate, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("AddCrate", this.crateRepository.findAll());
            return "AddCrate";
        }
        this.crateRepository.save(crate);
        return "redirect:/Home";
    }

    @GetMapping
    public String getItem(Model model) {
        model.addAttribute("AddCrate",this.crateRepository.findAll());
        model.addAttribute("crate",new Crate());
        return "/AddCrate";

    }

}
