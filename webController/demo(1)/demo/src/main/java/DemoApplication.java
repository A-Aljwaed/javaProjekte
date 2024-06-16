import meinKontroller.SagService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext apx=SpringApplication.run(DemoApplication.class);
		SagService ss= apx.getBean(SagService.class);
		System.out.println(ss.hey());






	}

}
