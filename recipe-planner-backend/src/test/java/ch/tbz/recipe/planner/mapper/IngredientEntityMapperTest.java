package ch.tbz.recipe.planner.mapper;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Recipe Planner")
@Feature("Ingredient Mapping")
class IngredientEntityMapperTest {

    private final IngredientEntityMapper mapper = new IngredientEntityMapperImpl();

    @Test
    @Story("Mapping IngredientEntity to Ingredient")
    void entityToDomain() {
        IngredientEntity ingredientEntity = new IngredientEntity();
        UUID randomUUID = UUID.randomUUID();
        ingredientEntity.setId(randomUUID);
        ingredientEntity.setName("Test Ingredient");

        Ingredient ingredient = mapper.entityToDomain(ingredientEntity);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(ingredient.getId()).isEqualTo(ingredientEntity.getId());
        softly.assertThat(ingredient.getName()).isEqualTo(ingredientEntity.getName());
        softly.assertAll();
    }

    @Test
    @Story("Mapping Ingredient to IngredientEntity")
    void domainToEntity() {
        Ingredient ingredient = new Ingredient();
        UUID randomUUID = UUID.randomUUID();
        ingredient.setId(randomUUID);
        ingredient.setName("Test Ingredient");

        IngredientEntity ingredientEntity = mapper.domainToEntity(ingredient);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(ingredientEntity.getId()).isEqualTo(ingredient.getId());
        softly.assertThat(ingredientEntity.getName()).isEqualTo(ingredient.getName());
        softly.assertAll();
    }

    @Test
    @Story("Mapping IngredientEntities to Ingredients")
    void entitiesToDomains() {
        IngredientEntity entity1 = new IngredientEntity();
        UUID randomUUID1 = UUID.randomUUID();
        UUID randomUUID2 = UUID.randomUUID();
        entity1.setId(randomUUID1);
        entity1.setName("Ingredient 1");

        IngredientEntity entity2 = new IngredientEntity();
        entity2.setId(randomUUID2);
        entity2.setName("Ingredient 2");

        List<IngredientEntity> entities = Arrays.asList(entity1, entity2);

        List<Ingredient> ingredients = mapper.entitiesToDomains(entities);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(ingredients).hasSize(2);

        softly.assertThat(ingredients.get(0).getId()).isEqualTo(entity1.getId());
        softly.assertThat(ingredients.get(0).getName()).isEqualTo(entity1.getName());

        softly.assertThat(ingredients.get(1).getId()).isEqualTo(entity2.getId());
        softly.assertThat(ingredients.get(1).getName()).isEqualTo(entity2.getName());

        softly.assertAll();
    }

    @Test
    @Story("Mapping Ingredients to IngredientEntities")
    void domainsToEntities() {
        Ingredient ingredient1 = new Ingredient();
        UUID randomUUID1 = UUID.randomUUID();
        UUID randomUUID2 = UUID.randomUUID();
        ingredient1.setId(randomUUID1);
        ingredient1.setName("Ingredient 1");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(randomUUID2);
        ingredient2.setName("Ingredient 2");

        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);

        List<IngredientEntity> entities = mapper.domainsToEntities(ingredients);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(entities).hasSize(2);

        softly.assertThat(entities.get(0).getId()).isEqualTo(ingredient1.getId());
        softly.assertThat(entities.get(0).getName()).isEqualTo(ingredient1.getName());

        softly.assertThat(entities.get(1).getId()).isEqualTo(ingredient2.getId());
        softly.assertThat(entities.get(1).getName()).isEqualTo(ingredient2.getName());

        softly.assertAll();
    }
}