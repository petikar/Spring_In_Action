package petikar.factory_of_houses.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HouseCreator {

    private String customerName;
    private String customerPhone;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<House> houses = new ArrayList<>();

    public void addHouse(House house) {
        this.houses.add(house);
    }
}
