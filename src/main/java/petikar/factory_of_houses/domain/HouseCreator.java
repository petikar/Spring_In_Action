package petikar.factory_of_houses.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.util.ArrayList;
import java.util.List;

@Data
public class HouseCreator {

    @NotBlank (message="Customer name is required")
    private String customerName;
    @Pattern(regexp="^8-9(\\d){2}-(\\d){3}-(\\d){2}-(\\d){2}$", message="Must be formatted 8-9**-***-**-**")
    private String customerPhone;

    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber; //4242424242424242
    
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<House> houses = new ArrayList<>();

    public void addHouse(House house) {
        this.houses.add(house);
    }
}
