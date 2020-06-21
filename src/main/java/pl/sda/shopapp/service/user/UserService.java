package pl.sda.shopapp.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.shopapp.dto.CreateUserDto;
import pl.sda.shopapp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void createUser(CreateUserDto dto) {
        var user = mapper.map(dto);
        repository.save(user);
    }
}
