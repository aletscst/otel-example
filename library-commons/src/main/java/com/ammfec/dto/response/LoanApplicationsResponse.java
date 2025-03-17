package com.ammfec.dto.response;

import com.ammfec.dto.general.LoanApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoanApplicationsResponse extends BasicResponse {
    private List<LoanApplication> loanApplications;
}
