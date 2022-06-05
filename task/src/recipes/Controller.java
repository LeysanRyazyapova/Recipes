package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;


@RestController
public class Controller {

    Long uniqueId = 1L;
    @Autowired
    RecipesService recipesService;

    @PostMapping("/api/recipe/new")
    public Map<String, Long> postRecipe(@RequestBody @Valid Recipe receivesRecipe) {

        Recipe recipe = recipesService.save(new Recipe(receivesRecipe.getId(),
                        receivesRecipe.getName(), receivesRecipe.getDescription(),
                        receivesRecipe.getCategory(), LocalDate.now(),
                        receivesRecipe.getIngredients(), receivesRecipe.getDirections()));
        return Map.of("id", recipe.getId());
    }

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        if(recipesService.findRecipeById(id).isPresent())
            return recipesService.findRecipeById(id).get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/recipe/{id}")
    public HttpStatus remove(@PathVariable Long id) {
        if(recipesService.delete(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/recipe/{id}")
    public HttpStatus updateRecipe(@PathVariable Long id, @RequestBody @Valid Recipe receivesRecipe) {
        Optional<Recipe> recipeOptional = recipesService.findRecipeById(id);
        if(recipeOptional.isPresent()) {
            recipesService.save(receivesRecipe);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
