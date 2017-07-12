package edunote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import edunote.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"edunote"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	@Bean
	public HttpMessageConverters customConverters(){
		ByteArrayHttpMessageConverter array = new ByteArrayHttpMessageConverter();
		return new HttpMessageConverters(array);
	}
}
