package info.startupbuilder.backendstarterpack.presentation;

import info.startupbuilder.backendstarterpack.Account;
import info.startupbuilder.backendstarterpack.infrastructure.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("account")
public class AccountController {

    @Autowired
    AccountRepository repository;

    @PostMapping
    Account create(@RequestBody Account account) {
        return repository.save(account);
    }
}
