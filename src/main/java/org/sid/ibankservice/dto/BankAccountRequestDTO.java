package org.sid.ibankservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ibankservice.enums.AccountType;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDTO {

    private Double balance;
    private String devise;
    private AccountType accountType;
}
