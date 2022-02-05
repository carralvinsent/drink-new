package store.drink.drink.Repository;

import org.springframework.data.repository.CrudRepository;
import store.drink.drink.Model.User;

public interface UserRepository  extends CrudRepository<User,Long> {

    User findByUsername(String username);

}
