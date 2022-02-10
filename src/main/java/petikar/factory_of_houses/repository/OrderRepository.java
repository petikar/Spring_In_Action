package petikar.factory_of_houses.repository;

import org.springframework.data.repository.CrudRepository;
import petikar.factory_of_houses.domain.HouseOrder;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<HouseOrder, UUID> {

    List<HouseOrder> findHouseOrderByCustomerPhoneAndPlacedAtBetween(String phone, Date from, Date before);

}
