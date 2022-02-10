package petikar.factory_of_houses.domain;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@Table("parts")
public class Part implements Serializable {

    @PrimaryKey
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WALL, ROOF, FOUNDATION, FLOOR, WINDOW, BALCONY
    }
}