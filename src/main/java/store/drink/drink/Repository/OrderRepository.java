package store.drink.drink.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import store.drink.drink.Model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {

//    @EntityGraph(value = "Order.orderItems")
//    Iterable<Orders> findAll();
}
