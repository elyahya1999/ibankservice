package org.sid.ibankservice.service;

import org.sid.ibankservice.dto.BankAccountRequestDTO;
import org.sid.ibankservice.dto.BankAccountResponseDTO;
import org.sid.ibankservice.entities.BankAccount;
import org.sid.ibankservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final BankAccountRepository bankAccountRepository;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .dateCreation(new Date())
                .balance(bankAccountDTO.getBalance())
                .devise(bankAccountDTO.getDevise())
                .accountType(bankAccountDTO.getAccountType())
                .build();

        BankAccount savedbqsaccount = bankAccountRepository.save(bankAccount);

        return BankAccountResponseDTO.builder()
                .id(savedbqsaccount.getId())
                .dateCreation(savedbqsaccount.getDateCreation())
                .balance(savedbqsaccount.getBalance())
                .devise(savedbqsaccount.getDevise())
                .accountType(savedbqsaccount.getAccountType())
                .build();
    }
}
