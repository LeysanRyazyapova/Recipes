package recipes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepositories extends CrudRepository<Recipe, Long> {
    List<Recipe> findByCategoryLikeIgnoreCaseOrderByDateDesc(String category);
    List<Recipe> findByNameContainingIgnoreCaseOrderByDateDesc(String name);
}
