package info.startupbuilder.backendstarterpack.presentation;

import info.startupbuilder.backendstarterpack.Account;
import info.startupbuilder.backendstarterpack.infrastructure.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
@RunWith(SpringRunner.class)
public class AccountControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    AccountRepository mockRepository;

    @Test
    public void shouldReturnANewlyCreatedAccountWithId() throws Exception {
        Account account = new Account();
        account.setId(1L);
        account.setName("Test");

        when(mockRepository.save(any(Account.class))).thenReturn(account);

        mvc.perform(post("/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(content().string(containsString("Test")));
    }
}
