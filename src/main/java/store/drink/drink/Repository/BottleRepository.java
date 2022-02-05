package store.drink.drink.Repository;

import org.springframework.data.repository.CrudRepository;
import store.drink.drink.Model.Bottle;

public interface BottleRepository extends CrudRepository<Bottle, Long> {
}
