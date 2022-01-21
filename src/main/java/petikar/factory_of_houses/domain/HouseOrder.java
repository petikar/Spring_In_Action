package petikar.factory_of_houses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table ("house_order")
public class HouseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Customer name is required")
    @Column("customer_name")
    private String customerName;

    @Pattern(regexp = "^8-9(\\d){2}-(\\d){3}-(\\d){2}-(\\d){2}$", message = "Must be formatted 8-9**-***-**-**")
    @Column("customer_phone")
    private String customerPhone;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber; //4242424242424242

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<House> houses = new ArrayList<>();

    public void addHouse(House house) {
        this.houses.add(house);
    }
}
