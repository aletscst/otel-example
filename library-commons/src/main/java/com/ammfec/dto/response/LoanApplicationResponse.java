package com.ammfec.dto.response;

import com.ammfec.dto.general.LoanApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoanApplicationResponse extends BasicResponse {
    private LoanApplication loanApplication;
}
