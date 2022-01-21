package petikar.factory_of_houses.repository;

import org.springframework.data.repository.CrudRepository;
import petikar.factory_of_houses.domain.HouseOrder;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<HouseOrder, String> {

    List<HouseOrder> findHouseOrderByCustomerPhoneAndPlacedAtBetween(String phone, Date from, Date before);

}
