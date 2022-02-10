package petikar.factory_of_houses.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import petikar.factory_of_houses.domain.Part;
import petikar.factory_of_houses.domain.udt.PartUDT;
import petikar.factory_of_houses.repository.PartRepository;

import java.util.Optional;

@Component
public class StringToPartConverter implements Converter<String, PartUDT> {

    private final PartRepository repository;

    public StringToPartConverter(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    public PartUDT convert(String id) {
        Optional<Part> ingredient = repository.findById(id);
        if (ingredient.isEmpty()) {
            return null;
        }

        return ingredient.map(i -> {
            return new PartUDT(i.getName(), i.getType());
        }).get();
    }
}
