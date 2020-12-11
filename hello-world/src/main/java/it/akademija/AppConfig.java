
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
		return new Product(1l, "Stalas", "labai geras", ".jpg", new BigDecimal(360), 3);
	}

	@Bean
	public Product getProduc2() {
		return new Product(2l, "kede", "aprasymas daikto", ".jpg", new BigDecimal(10), 30);
	}

	@Bean
	public Product getProduc3() {
		return new Product(3l, "stiklas", "aprasau", ".jpg", new BigDecimal(100), 15);
	}

}