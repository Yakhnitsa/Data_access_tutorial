package com.yurets_y.mapping.composite_id_mapping;

import com.yurets_y.mapping.composite_id_mapping.entity.Account;
import com.yurets_y.mapping.composite_id_mapping.entity.AccountId;
import com.yurets_y.mapping.composite_id_mapping.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class CompositeMappingIdApplication implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args){
        SpringApplication.run(CompositeMappingIdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Let the stress begin!");
        Account account  = new Account();
        account.setAccountNumber("22345");
        account.setAccountType("USER");
        account.setUserName("TestUser");
        account.setUserEmail("test@user.com");
        accountRepository.save(account);

        AccountId id = new AccountId("22345","USER");

        Account AccountFromRepo = accountRepository.getOne(id);
        Iterable<Account> accounts = accountRepository.findAll();


        Optional<Account> fromRepo = accountRepository.findById(id);


        System.out.println("Account from repo:");
        System.out.println(fromRepo.get().getUserEmail());




    }
}
