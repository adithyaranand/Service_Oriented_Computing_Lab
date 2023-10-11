import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WeatherServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherServiceApplication.class, args);
    }
}

@RestController
class WeatherController {
    @GetMapping("/weather/{location}")
    public String getWeather(@PathVariable String location) {
        // Implement logic to retrieve weather data for the specified location
        // For this example, we'll return a simple message.
        return "The weather in " + location + " is sunny.";
    }
}
