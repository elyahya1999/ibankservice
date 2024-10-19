package org.sid.ibankservice.web;

import org.sid.ibankservice.dto.BankAccountRequestDTO;
import org.sid.ibankservice.dto.BankAccountResponseDTO;
import org.sid.ibankservice.entities.BankAccount;
import org.sid.ibankservice.repositories.BankAccountRepository;
import org.sid.ibankservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")

public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable  String id) {
        return bankAccountRepository.findById(id).
                orElseThrow(() -> new RuntimeException(String.format("Account with id %s not found", id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }
    //si on ajoute les ifs dont la methode put fait put et patch
    @PutMapping ("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id,@RequestBody BankAccount bankAccount) {
        BankAccount account=bankAccountRepository.findById(id).
                orElseThrow(() -> new RuntimeException(String.format("Account with id %s not found", id)));
        if(bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if(bankAccount.getAccountType()!=null)account.setAccountType(bankAccount.getAccountType());
        if(bankAccount.getDateCreation()!=null)account.setDateCreation(bankAccount.getDateCreation());
        if(bankAccount.getDevise()!=null)account.setDevise(bankAccount.getDevise());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
         bankAccountRepository.deleteById(id);
    }
}
