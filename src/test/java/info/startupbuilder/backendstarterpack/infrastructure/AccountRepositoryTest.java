package info.startupbuilder.backendstarterpack.infrastructure;

import info.startupbuilder.backendstarterpack.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class AccountRepositoryTest {

    @Autowired
    AccountRepository repository;

    @Test
    public void repositoryShouldBeWiredCorrectly() {
        assertNotNull(repository);
    }

    @Test
    public void repositoryShouldGenerateId() {
        String name = "Test";

        var account = new Account();
        account.setName(name);
        repository.save(account);

        var retrieved = repository.findFirstByName(name);

        assertTrue(retrieved.isPresent());
        assertNotNull(retrieved.get().getId());
    }
}
