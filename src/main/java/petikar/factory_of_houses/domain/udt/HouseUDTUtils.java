package petikar.factory_of_houses.domain.udt;

import petikar.factory_of_houses.domain.House;
import petikar.factory_of_houses.domain.Part;

import java.util.List;
import java.util.stream.Collectors;

public class HouseUDTUtils {

    public static PartUDT toPartUDT(Part part) {
        return new PartUDT(part.getName(), part.getType());
    }

    public static HouseUDT toHouseUDT(House house) {
        return new HouseUDT(house.getName(), house.getParts());
    }

    public static List<PartUDT> toPartUDTs(List<Part> parts) {
        return parts.stream()
                .map(part -> toPartUDT(part))
                .collect(Collectors.toList());
    }
    public static List<HouseUDT> toHouseUDTs(List<House> houses) {
        return houses.stream()
                .map(house -> toHouseUDT(house))
                .collect(Collectors.toList());
    }
}
