package petikar.factory_of_houses;

import petikar.factory_of_houses.domain.Part;
import petikar.factory_of_houses.domain.Part.Type;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import petikar.factory_of_houses.repository.PartRepository;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("homePage");
    }

    @Bean
    public CommandLineRunner dataLoader(PartRepository repo) {
        return args -> {
            repo.save(new Part("01", "Brick", Type.WALL));
            repo.save(new Part("02", "Aerocrete", Type.WALL));
            repo.save(new Part("03", "Wood", Type.WALL));
            repo.save(new Part("04", "Metal tile", Type.ROOF));
            repo.save(new Part("05", "Flexible roof tiles", Type.ROOF));
            repo.save(new Part("06", "Strip", Type.FOUNDATION));
            repo.save(new Part("07", "Pile", Type.FOUNDATION));
            repo.save(new Part("08", "One", Type.FLOOR));
            repo.save(new Part("09", "Two", Type.FLOOR));
            repo.save(new Part("10", "Panoramic glazing", Type.WINDOW));
            repo.save(new Part("11", "Energy-efficient glazing", Type.WINDOW));
            repo.save(new Part("12", "Second light", Type.WINDOW));
            repo.save(new Part("13", "Without balcony", Type.BALCONY));
            repo.save(new Part("14", "Glazed", Type.BALCONY));
            repo.save(new Part("15", "Unglazed", Type.BALCONY));
        };
    }
}
