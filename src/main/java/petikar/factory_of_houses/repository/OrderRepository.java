package petikar.factory_of_houses.repository;

import org.springframework.data.repository.CrudRepository;
import petikar.factory_of_houses.domain.HouseOrder;

public interface OrderRepository extends CrudRepository<HouseOrder, String> {
}
