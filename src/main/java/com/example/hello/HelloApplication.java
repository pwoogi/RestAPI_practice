package com.example.hello;

import com.example.hello.ioc.ApplicationContextProvider;
import com.example.hello.ioc.Base64Enconder;
import com.example.hello.ioc.Encoder;
import com.example.hello.ioc.UrlEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);

//		ApplicationContext context = ApplicationContextProvider.getContext();
//
//		//Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//		//UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
//
//		Encoder encoder = context.getBean("base64Encode", Encoder.class);
//		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
//		String result = encoder.encode(url);
//		System.out.println(result);

		System.out.println(Base64.getEncoder().encodeToString("chris@gamil.com".getBytes()));
	}

}

@Configuration
class AppConfig{

	@Bean("base64Encode")
	public Encoder encoder(Base64Enconder base64Enconder){
		return new Encoder(base64Enconder);
	}
	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder){
		return new Encoder(urlEncoder);
	}
}
