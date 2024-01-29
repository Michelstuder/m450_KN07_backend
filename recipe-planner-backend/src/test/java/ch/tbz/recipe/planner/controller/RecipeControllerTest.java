package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.service.RecipeService;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.mockito.Mockito.doReturn;

@Epic("Recipe Planner")
@Feature("Recipe Operations")
class RecipeControllerTest {

    @InjectMocks
    private RecipeController controller;

    @Mock
    private RecipeService recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Story("Get all recipes")
    void getRecipes() {
        Assertions.assertEquals(HttpStatusCode.valueOf(200), controller.getRecipes().getStatusCode());
    }

    @Test
    @Story("Get a recipe by id")
    void getRecipe() {
        Recipe testRecipe = new Recipe();
        UUID randomUUID = UUID.randomUUID();
        testRecipe.setId(randomUUID);

        doReturn(testRecipe).when(recipeService).getRecipeById(testRecipe.getId());

        Assertions.assertEquals(randomUUID, recipeService.getRecipeById(testRecipe.getId()).getId());
    }

    @Test
    @Story("Add a recipe")
    void addRecipe() {
        Recipe testRecipe = new Recipe();

        doReturn(testRecipe).when(recipeService).addRecipe(testRecipe);

        ResponseEntity<Recipe> createdRecipe = controller.addRecipe(testRecipe);

        Assertions.assertEquals(HttpStatusCode.valueOf(200), createdRecipe.getStatusCode());
        Assertions.assertEquals(testRecipe, createdRecipe.getBody());
    }
}