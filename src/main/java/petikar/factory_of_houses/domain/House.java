package petikar.factory_of_houses.domain;

import lombok.Data;

import java.util.List;

@Data
public class House {

    private String name;

    private List<Part> parts;

}
