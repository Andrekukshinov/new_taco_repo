package by.kukshinov.application.service;


import by.kukshinov.application.entity.Ingredient;

import java.util.List;
import java.util.Map;


public interface IngredientsService {
    List<Ingredient> getAll();

    Map<String, List<Ingredient>> getIngredientsNamesIngredients();
}
