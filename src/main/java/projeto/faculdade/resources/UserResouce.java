package projeto.faculdade.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.faculdade.entities.User;
import projeto.faculdade.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/user")
public class UserResouce {
	private final UserService userService;

	public UserResouce(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping("/insert")
	public ResponseEntity<User> insert(@RequestBody User obj) {
		User user = userService.insert(obj);
		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User obj) {
		User user = userService.update(obj);
		return ResponseEntity.ok().body(user);
	}
}
