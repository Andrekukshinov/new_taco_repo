package by.kukshinov.application.service.impl;

import by.kukshinov.application.entity.Ingredient;
import by.kukshinov.application.entity.enums.Type;
import by.kukshinov.application.service.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class IngredientsServiceImpl implements IngredientsService {
    @Override
    public List<Ingredient> getAll() {
        return List.of(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
    }

    @Override
    public Map<String, List<Ingredient>> getIngredientsNamesIngredients() {
        List<Ingredient> all = getAll();
        Type[] ingredientTypes = Type.values();
        return Arrays
                .stream(ingredientTypes)
                .collect(Collectors.toMap((Enum::toString), type -> filterByType(all, type)));

    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
