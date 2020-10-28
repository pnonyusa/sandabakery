package co.za.sandabakery.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.RecipeEntity;

@Repository
public interface RecipeRepository extends PagingAndSortingRepository<RecipeEntity,Long> {
	RecipeEntity findByRecipeId(String recipeId);
}
