package petikar.factory_of_houses.domain;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class PartRef {
    private final String part;
}
