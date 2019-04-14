package info.startupbuilder.backendstarterpack.infrastructure;

import info.startupbuilder.backendstarterpack.Account;
import info.startupbuilder.backendstarterpack.Entry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static info.startupbuilder.backendstarterpack.Entry.Type.DEBIT;
import static org.junit.Assert.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
public class EntryRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EntryRepository repository;

    @Test
    public void repositoryShouldSaveAndRetrieve() {

        String accountName = "Test";

        Account account = new Account();
        account.setName(accountName);
        accountRepository.save(account);

        Entry entry = new Entry();
        entry.setAccount(account);
        entry.setAmount(BigDecimal.TEN);
        entry.setType(DEBIT);

        repository.save(entry);

        Entry retrieved = repository.findAll().get(0);

        assertNotNull(retrieved);
        assertNotNull(retrieved.getId());
    }
}
