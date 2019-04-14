package info.startupbuilder.backendstarterpack;

import info.startupbuilder.backendstarterpack.infrastructure.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendStarterPackApplicationTests {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void contextLoads() {
		assertNotNull(accountRepository);
	}

}
