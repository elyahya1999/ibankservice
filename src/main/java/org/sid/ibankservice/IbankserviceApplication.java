package org.sid.ibankservice;

import org.sid.ibankservice.entities.BankAccount;
import org.sid.ibankservice.enums.AccountType;
import org.sid.ibankservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class IbankserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbankserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount = BankAccount.builder().
						id(UUID.randomUUID().toString()).
						dateCreation(new Date()).
						accountType(Math.random()>0.5? AccountType.CURRENT: AccountType.SAVING).
						balance(1000 + Math.random() * 9000).
						devise("DH").
						build();
				bankAccountRepository.save(bankAccount);
			}

		};

}

}
