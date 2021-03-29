package by.kukshinov.application.controller;


import by.kukshinov.application.entity.Ingredient;
import by.kukshinov.application.entity.Taco;
import by.kukshinov.application.service.IngredientsService;
import by.kukshinov.application.service.TacoService;
import by.kukshinov.application.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/design")
public class TacoController {
    private static final String TACO_DESIGN = "design";
    private static final String DESIGN_PAGE = "design";
    private static final String ERROR_PAGE = "redirect:/error";
    private static final String CURRENT_ORDER = "redirect:/orders/current";

    private static final Logger LOGGER = LogManager.getLogger(TacoController.class);

    private final IngredientsService ingredientsService;
    private final TacoService tacoService;

    @Autowired
    public TacoController(IngredientsService ingredientsService, TacoService tacoService) {
        this.ingredientsService = ingredientsService;
        this.tacoService = tacoService;
    }

    @GetMapping()
    public String showDesignForm(Model model) {
        Map<String, List<Ingredient>> ingredientsNamesIngredients = ingredientsService.getIngredientsNamesIngredients();
        model.addAllAttributes(ingredientsNamesIngredients);
        model.addAttribute(TACO_DESIGN, new Taco());
        return DESIGN_PAGE;
    }

    @PostMapping
    public String saveTaco(@Valid Taco taco, Errors errors) {
        if (errors.hasErrors()) {
            return DESIGN_PAGE;
        }
        try {
            tacoService.saveTaco(taco);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
        return CURRENT_ORDER;
    }


}
