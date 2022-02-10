package petikar.factory_of_houses.domain;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import petikar.factory_of_houses.domain.udt.HouseUDT;
import petikar.factory_of_houses.domain.udt.HouseUDTUtils;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class HouseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = Uuids.timeBased();

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

    @Column("houses")
    private List<HouseUDT> houses = new ArrayList<>();

    public void addHouse(House house) {
        this.houses.add(HouseUDTUtils.toHouseUDT(house));
    }

}
