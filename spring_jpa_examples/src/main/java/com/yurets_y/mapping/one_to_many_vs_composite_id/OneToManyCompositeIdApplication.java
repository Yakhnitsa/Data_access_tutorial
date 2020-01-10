package com.yurets_y.mapping.one_to_many_vs_composite_id;

import com.yurets_y.mapping.one_to_many_vs_composite_id.entity.Account;
import com.yurets_y.mapping.one_to_many_vs_composite_id.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class OneToManyCompositeIdApplication implements CommandLineRunner {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private AccountRepo accountRepo;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyCompositeIdApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        initDatabase();

        Optional<Account> account = accountRepo.findById(new Account.AccountId("USER","115"));
        if(account.isPresent()){
            System.out.println(account);
        }

    }

    public void initDatabase(){
        Account account = new Account("USER","115");

        Message message1 = new Message("#hello","hello world");
        Message message2 = new Message("#goodbye","goodbye my love, goodbye");
        Message message3 = new Message("#postscriptum","don`t cry...");

        message1.setAccount(account);
        message2.setAccount(account);
        message3.setAccount(account);

        account.add(message1);
        account.add(message2);
        account.add(message3);

        accountRepo.save(account);
    }
}
