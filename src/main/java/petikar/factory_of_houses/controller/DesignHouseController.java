package petikar.factory_of_houses.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import petikar.factory_of_houses.domain.House;
import petikar.factory_of_houses.domain.Part;
import petikar.factory_of_houses.domain.Part.Type;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
@RequestMapping("/design")
@SessionAttributes("HouseOrder")
public class DesignHouseController {

    @GetMapping
    public String showDesignForm(Model model) { // Model - отправляет данные м/у view и controller, addAttribute - кладём в эту модель то, что нам надо

        model.addAttribute("design", new House());
        return "design";
    }

    @ModelAttribute
    public void addPartsToModel(Model model) {
        List<Part> parts = Arrays.asList(
                new Part("01", "Brick", Type.WALL),
                new Part("02", "Aerocrete", Type.WALL),
                new Part("03", "Wood", Type.WALL),
                new Part("04", "Metal tile", Type.ROOF),
                new Part("05", "Flexible roof tiles", Type.ROOF),
                new Part("06", "Strip", Type.FOUNDATION),
                new Part("07", "Pile", Type.FOUNDATION),
                new Part("08", "One", Type.FLOOR),
                new Part("09", "Two", Type.FLOOR),
                new Part("10", "Panoramic glazing", Type.WINDOW),
                new Part("11", "Energy-efficient glazing", Type.WINDOW),
                new Part("12", "Second light", Type.WINDOW),
                new Part("13", "Without balcony", Type.BALCONY),
                new Part("14", "Glazed", Type.BALCONY),
                new Part("15", "Unglazed", Type.BALCONY)
        );

        Type[] types = Part.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(parts, type));
        }
    }

    @PostMapping
    public String processHouse(@Valid @ModelAttribute("design") House house, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "design";
        }

        //save the house
        log.info("Processing house: " + house);

        return "redirect:/orders/current";
    }


    private Iterable<Part> filterByType(List<Part> parts, Type type) {
        return parts.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
