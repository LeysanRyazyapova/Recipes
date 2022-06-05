package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipesService {

    private final RecipeRepositories recipeRepositories;

    @Autowired
    public RecipesService(RecipeRepositories recipeRepositories) {
        this.recipeRepositories = recipeRepositories;
    }

    public Optional<Recipe> findRecipeById(Long id) {
        return recipeRepositories.findById(id);
    }

    public Recipe save(Recipe toSave) {
        return recipeRepositories.save(toSave);
    }

    public boolean delete(Long id) {
        if(this.findRecipeById(id).isPresent()) {
            recipeRepositories.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
