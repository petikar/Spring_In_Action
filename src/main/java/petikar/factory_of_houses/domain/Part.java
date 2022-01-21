package petikar.factory_of_houses.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
public class Part {
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WALL, ROOF, FOUNDATION, FLOOR, WINDOW, BALCONY
    }
}