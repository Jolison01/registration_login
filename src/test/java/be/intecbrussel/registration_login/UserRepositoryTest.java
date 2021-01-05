package be.intecbrussel.registration_login;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {


    @Autowired
    private UserRepository repo;



    private TestEntityManager entityManager1;



    @Test
    public void testCreateUser() {

        User user1 = new User();
        user1.setEmail("mynameisdavid@gmail.com");
        user1.setPassword("david2020");
        user1.setFirstName("david");
        user1.setLastName("Antonio");

        User savedUser = repo.save(user1);

        User existUser = entityManager1.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user1.getEmail());
    }
    @Test
    public void testFindUserByEmail(){
      String  email =  "david@codejava.com";
     User user =  repo.findByEmail(email);

     assertThat(user).isNotNull();

    }
}
