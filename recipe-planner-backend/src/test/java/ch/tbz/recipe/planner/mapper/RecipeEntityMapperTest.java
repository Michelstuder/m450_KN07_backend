package ch.tbz.recipe.planner.mapper;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RecipeEntityMapperTest {

    private final RecipeEntityMapper mapper = new RecipeEntityMapperImpl();

    @Test
    void entityToDomain() {
        RecipeEntity recipeEntity = new RecipeEntity();
        UUID uuid = UUID.randomUUID();
        recipeEntity.setId(uuid);
        recipeEntity.setName("Test Recipe");

        Recipe recipe = mapper.entityToDomain(recipeEntity);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(recipe.getId()).isEqualTo(recipeEntity.getId());
        softly.assertThat(recipe.getName()).isEqualTo(recipeEntity.getName());
        softly.assertAll();
    }

    @Test
    void domainToEntity() {
        Recipe recipe = new Recipe();
        UUID uuid = UUID.randomUUID();
        recipe.setId(uuid);
        recipe.setName("Test Recipe");

        RecipeEntity recipeEntity = mapper.domainToEntity(recipe);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(recipeEntity.getId()).isEqualTo(recipe.getId());
        softly.assertThat(recipeEntity.getName()).isEqualTo(recipe.getName());
        softly.assertAll();
    }
}