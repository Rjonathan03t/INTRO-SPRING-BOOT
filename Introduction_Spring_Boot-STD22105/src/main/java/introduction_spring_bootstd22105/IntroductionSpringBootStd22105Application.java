package introduction_spring_bootstd22105;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
		"controller",
		"introduction_spring_bootstd22105",
		"model",
		"repository",
		"Service"
})
public class IntroductionSpringBootStd22105Application {
	public static void main(String[] args) {
		SpringApplication.run(IntroductionSpringBootStd22105Application.class, args);
	}
}
