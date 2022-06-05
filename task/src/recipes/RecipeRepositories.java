package recipes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepositories extends CrudRepository<Recipe, Long> {
}
