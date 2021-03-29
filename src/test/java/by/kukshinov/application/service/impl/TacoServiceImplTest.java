package by.kukshinov.application.service.impl;


import by.kukshinov.application.entity.Ingredient;
import by.kukshinov.application.entity.enums.Type;
import by.kukshinov.application.service.IngredientsService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class TacoServiceImplTest {
    private static final List<Ingredient> WRAP_INGRS = List.of(
            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Type.WRAP)
    );
    private static final List<Ingredient> PROTEIN_INGRS = List.of(
            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Type.PROTEIN)
    );
    private static final List<Ingredient> VEGGIES_INGRS = List.of(
            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Type.VEGGIES)
    );

    private static final List<Ingredient> CHEESE_INGRS = List.of(
            new Ingredient("CHED", "Cheddar", Type.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", Type.CHEESE)
    );

    private static final List<Ingredient> SAUCE_INGRS = List.of(
            new Ingredient("SLSA", "Salsa", Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
    );


    private static final Map<String, List<Ingredient>> EXPECTED =
            Map.of(
                    Type.WRAP.toString(), WRAP_INGRS,
                    Type.PROTEIN.toString(), PROTEIN_INGRS,
                    Type.VEGGIES.toString(), VEGGIES_INGRS,
                    Type.CHEESE.toString(), CHEESE_INGRS,
                    Type.SAUCE.toString(), SAUCE_INGRS
            );

    @Test
    public void testGetIngredientsNamesIngredientsShouldReturnMapOfIngredients() {
        IngredientsService service = new IngredientsServiceImpl();

        Map<String, List<Ingredient>> actual = service.getIngredientsNamesIngredients();

        Assert.assertEquals(EXPECTED, actual);
    }
}
