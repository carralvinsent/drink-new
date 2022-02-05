package store.drink.drink.Repository;

import org.springframework.data.repository.CrudRepository;
import store.drink.drink.Model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
