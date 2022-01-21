package petikar.factory_of_houses.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import petikar.factory_of_houses.domain.House;
import petikar.factory_of_houses.domain.Part;
import petikar.factory_of_houses.domain.Part.Type;
import petikar.factory_of_houses.repository.PartRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
@RequestMapping("/design")
@SessionAttributes("HouseOrder")
public class DesignHouseController {

    private final PartRepository repository;

    public DesignHouseController(PartRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String showDesignForm(Model model) { // Model - отправляет данные м/у view и controller, addAttribute - кладём в эту модель то, что нам надо

        model.addAttribute("design", new House());
        return "design";
    }

    @ModelAttribute
    public void addPartsToModel(Model model) {
        Iterable<Part> parts = repository.findAll();
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


    private Iterable<Part> filterByType(Iterable<Part> parts, Type type) {
        List<Part> partList = (List<Part>) parts;
        return partList.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
