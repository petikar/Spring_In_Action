package petikar.factory_of_houses.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import petikar.factory_of_houses.domain.HouseOrder;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/current")
    public String orderForm (Model model) {
        model.addAttribute("houseOrder", new HouseOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid HouseOrder house, Errors errors) {

        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order for the construction of a house submitted: " + house);
        return "redirect:/";
    }
}
