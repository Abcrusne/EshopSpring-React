
package it.akademija;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import it.akademija.model.Product;

@Configuration
@ImportResource({ "classpath*:application-context.xml" })
public class AppConfig {

	@Bean
	public Product getProduct1() {
		return new Product("Stalas", "labai geras", ".jpg", new BigDecimal(360), 3);
	}

	@Bean
	public Product getProduct2() {
		return new Product("kede", "aprasymas daikto", ".jpg", new BigDecimal(10), 30);
	}

	@Bean
	public Product getProduct3() {
		return new Product("stiklas", "aprasau", ".jpg", new BigDecimal(100), 15);
	}

}