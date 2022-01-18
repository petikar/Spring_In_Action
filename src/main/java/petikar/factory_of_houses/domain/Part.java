package petikar.factory_of_houses.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Part {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WALL, ROOF, FOUNDATION, FLOOR, WINDOW, BALCONY
    }
}