package projeto.faculdade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import projeto.faculdade.entities.User;
import projeto.faculdade.repositories.UserRepository;
import projeto.faculdade.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = this.userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new ResourceNotFoundException("O usuário não existe!");
	}

	public User insert(User obj) {
		return this.userRepository.save(obj);
	}

	public void delete(Long id) {
		User user = this.findById(id);
		this.userRepository.delete(user);
	}

	public User update(User obj) {
		this.findById(obj.getId());
		return this.userRepository.save(obj);
	}
}
