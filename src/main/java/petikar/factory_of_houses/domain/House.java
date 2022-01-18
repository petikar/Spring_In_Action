package petikar.factory_of_houses.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class House {

    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 6, message="You must choose each part")
    private List<Part> parts;

}
