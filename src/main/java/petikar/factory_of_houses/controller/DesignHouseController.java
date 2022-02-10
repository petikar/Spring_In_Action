package petikar.factory_of_houses.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import petikar.factory_of_houses.domain.House;
import petikar.factory_of_houses.domain.HouseOrder;
import petikar.factory_of_houses.domain.Part;
import petikar.factory_of_houses.domain.Part.Type;
import petikar.factory_of_houses.repository.PartRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
@RequestMapping("/design")
@SessionAttributes("houseOrder")
public class DesignHouseController {

    private final PartRepository partRepository;

    public DesignHouseController(PartRepository repository) {
        this.partRepository = repository;
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @ModelAttribute
    public void addPartsToModel(Model model) {
        List<Part> parts = new ArrayList<>();
        partRepository.findAll().forEach(i -> parts.add(i));

        Type[] types = Part.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(parts, type));
        }
    }

    @ModelAttribute(name = "houseOrder")
    public HouseOrder order() {
        return new HouseOrder();
    }

    @ModelAttribute(name = "house")
    public House house() {
        return new House();
    }

    @PostMapping
    public String processHouse(@Valid @ModelAttribute("house") House house, Errors errors, HouseOrder houseOrder) {

        if (errors.hasErrors()) {
            return "design";
        }

        houseOrder.addHouse(house);

        log.info("Processing house: " + house);

        return "redirect:/orders/current";
    }


    private Iterable<Part> filterByType(List<Part> parts, Type type) {
        return parts.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
