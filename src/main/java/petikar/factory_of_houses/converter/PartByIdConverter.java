package petikar.factory_of_houses.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import petikar.factory_of_houses.domain.Part;
import petikar.factory_of_houses.repository.PartRepository;

@Component
public class PartByIdConverter implements Converter<String, Part> {

    private final PartRepository repository;

    public PartByIdConverter(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Part convert(String id) {
        return repository.findById(id).orElse(null);
    }
}
