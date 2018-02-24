package live.daniel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MultimediaContentDeliverySystemApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MultimediaContentDeliverySystemApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MultimediaContentDeliverySystemApplication.class, args);
	}
}
