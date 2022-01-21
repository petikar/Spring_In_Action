package petikar.factory_of_houses.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Table
public class House {

    @Id
    private Integer id;

    private Date createdAt = new Date();

    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 6, message="You must choose each part")
    private List<Part> parts;

}
