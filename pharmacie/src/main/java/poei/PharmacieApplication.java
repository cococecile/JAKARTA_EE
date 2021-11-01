package poei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:hibernate.cfg.xml"} )
public class PharmacieApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacieApplication.class, args);
	}

}
