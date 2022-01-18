package petikar.factory_of_houses.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import petikar.factory_of_houses.domain.Part;
import petikar.factory_of_houses.domain.Part.Type;

import java.util.HashMap;
import java.util.Map;

@Component
public class PartByIdConverter implements Converter<String, Part> {

    private Map<String, Part> partMap = new HashMap<>();

    public PartByIdConverter() {
        partMap.put("01", new Part("01", "Brick", Type.WALL));
        partMap.put("02", new Part("02", "Aerocrete", Type.WALL));
        partMap.put("03", new Part("03", "Wood", Type.WALL));
        partMap.put("04", new Part("04", "Metal tile", Type.ROOF));
        partMap.put("05", new Part("05", "Flexible roof tiles", Type.ROOF));
        partMap.put("06", new Part("06", "Strip", Type.FOUNDATION));
        partMap.put("07", new Part("07", "Pile", Type.FOUNDATION));
        partMap.put("08", new Part("08", "One", Type.FLOOR));
        partMap.put("09", new Part("09", "Two", Type.FLOOR));
        partMap.put("10", new Part("10", "Panoramic glazing", Type.WINDOW));
        partMap.put("11", new Part("11", "Energy-efficient glazing", Type.WINDOW));
        partMap.put("12", new Part("12", "Second light", Type.WINDOW));
        partMap.put("13", new Part("13", "Without balcony", Type.BALCONY));
        partMap.put("14", new Part("14", "Glazed", Type.BALCONY));
        partMap.put("15", new Part("15", "Unglazed", Type.BALCONY));
    }


    @Override
    public Part convert(String id) {
        return partMap.get(id);
    }
}
