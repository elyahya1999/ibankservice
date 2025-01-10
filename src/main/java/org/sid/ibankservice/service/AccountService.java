package org.sid.ibankservice.service;

import org.sid.ibankservice.dto.BankAccountRequestDTO;
import org.sid.ibankservice.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

}
