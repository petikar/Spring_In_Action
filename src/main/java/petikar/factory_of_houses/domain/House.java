package petikar.factory_of_houses.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date createdAt = new Date();

    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @ManyToMany
    @NotNull
    @Size(min = 6, max = 6, message="You must choose each part once")
    private List<Part> parts;

}
