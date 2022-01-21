package petikar.factory_of_houses.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class HouseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Pattern(regexp = "^8-9(\\d){2}-(\\d){3}-(\\d){2}-(\\d){2}$", message = "Must be formatted 8-9**-***-**-**")
    private String customerPhone;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber; //4242424242424242

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @OneToMany (cascade = CascadeType.ALL)
    private List<House> houses = new ArrayList<>();

    public void addHouse(House house) {
        this.houses.add(house);
    }
}
