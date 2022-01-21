package petikar.factory_of_houses.repository;

import org.springframework.data.repository.CrudRepository;
import petikar.factory_of_houses.domain.Part;

public interface PartRepository extends CrudRepository<Part, String> {

}
