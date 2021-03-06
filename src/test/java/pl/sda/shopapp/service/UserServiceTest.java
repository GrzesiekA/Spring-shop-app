package pl.sda.shopapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shopapp.dto.CreateUserDto;
import pl.sda.shopapp.entity.User;
import pl.sda.shopapp.repository.UserRepository;
import pl.sda.shopapp.service.user.UserService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void testCreateUser() {
        // given
        var dto = new CreateUserDto("user", "admin", asList("ADMIN"));

        // when
        service.createUser(dto);
        em.flush();
        em.clear();

        // then
        var user = repository.getOne("user");
        assertEquals(new User(
                "user", "$2a$10$M4dQlk68Un1J5JbJqN27sOS1Pbo0Cy5i6PNfWb4Do1vKmTl8QV/r2", true), user);
        assertEquals("ROLE_ADMIN", user.getAuthorities().get(0).getAuthority());
    }
}
