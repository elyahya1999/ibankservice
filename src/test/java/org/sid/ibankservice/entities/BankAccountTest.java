package org.sid.ibankservice.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sid.ibankservice.enums.AccountType;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = BankAccount.builder()
                .id("12345")
                .dateCreation(new Date())
                .balance(1000.0)
                .devise("USD")
                .accountType(AccountType.SAVINGS)
                .build();
    }

    @Test
    void testGetId() {
        assertEquals("12345", bankAccount.getId());
    }

    @Test
    void testGetDateCreation() {
        assertNotNull(bankAccount.getDateCreation());
    }

    @Test
    void testGetBalance() {
        assertEquals(1000.0, bankAccount.getBalance());
    }

    @Test
    void testGetDevise() {
        assertEquals("USD", bankAccount.getDevise());
    }

    @Test
    void testGetAccountType() {
        assertEquals(AccountType.SAVINGS, bankAccount.getAccountType());
    }

    @Test
    void testSetId() {
        bankAccount.setId("54321");
        assertEquals("54321", bankAccount.getId());
    }

    @Test
    void testSetDateCreation() {
        Date newDate = new Date();
        bankAccount.setDateCreation(newDate);
        assertEquals(newDate, bankAccount.getDateCreation());
    }

    @Test
    void testSetBalance() {
        bankAccount.setBalance(2000.0);
        assertEquals(2000.0, bankAccount.getBalance());
    }

    @Test
    void testSetDevise() {
        bankAccount.setDevise("EUR");
        assertEquals("EUR", bankAccount.getDevise());
    }

    @Test
    void testSetAccountType() {
        bankAccount.setAccountType(AccountType.CURRENT);
        assertEquals(AccountType.CURRENT, bankAccount.getAccountType());
    }

    @Test
    void testEquals() {
        BankAccount sameAccount = BankAccount.builder()
                .id("12345")
                .dateCreation(bankAccount.getDateCreation())
                .balance(1000.0)
                .devise("USD")
                .accountType(AccountType.SAVINGS)
                .build();

        assertEquals(bankAccount, sameAccount);
    }

    @Test
    void testHashCode() {
        BankAccount sameAccount = BankAccount.builder()
                .id("12345")
                .dateCreation(bankAccount.getDateCreation())
                .balance(1000.0)
                .devise("USD")
                .accountType(AccountType.SAVINGS)
                .build();

        assertEquals(bankAccount.hashCode(), sameAccount.hashCode());
    }

    @Test
    void testToString() {
        String expected = "BankAccount(id=12345, dateCreation=" + bankAccount.getDateCreation() +
                ", balance=1000.0, devise=USD, accountType=SAVINGS)";
        assertEquals(expected, bankAccount.toString());
    }

    @Test
    void testBuilder() {
        BankAccount newAccount = BankAccount.builder()
                .id("67890")
                .dateCreation(new Date())
                .balance(5000.0)
                .devise("GBP")
                .accountType(AccountType.SAVINGS)
                .build();

        assertNotNull(newAccount);
        assertEquals("67890", newAccount.getId());
        assertEquals(5000.0, newAccount.getBalance());
        assertEquals("GBP", newAccount.getDevise());
        assertEquals(AccountType.SAVINGS, newAccount.getAccountType());
    }
}
