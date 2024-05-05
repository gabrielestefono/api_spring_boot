package projeto.faculdade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FaculdadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaculdadeApplication.class, args);
	}
}

@RestController
@RequestMapping(value = "/")
class ResourceNenhum {
	@GetMapping("")
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok().body("Teste");
	}
}