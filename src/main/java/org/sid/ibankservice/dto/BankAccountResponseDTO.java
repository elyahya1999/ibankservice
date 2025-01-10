package org.sid.ibankservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ibankservice.enums.AccountType;

import java.util.Date;
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date dateCreation;
    private Double balance;
    private String devise;
    private AccountType accountType;
}
