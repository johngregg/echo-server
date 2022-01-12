package org.johngregg.echo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@SpringBootApplication
@Configuration
public class EchoServerApplication {

	@Value("${url}")
	private String url;

	@Bean
	public DAO dao() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(url).build();
		return retrofit.create(DAO.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EchoServerApplication.class, args);
	}

}
