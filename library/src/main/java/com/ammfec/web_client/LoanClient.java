package com.ammfec.web_client;

import com.ammfec.dto.response.LoanApplicationResponse;
import com.ammfec.dto.response.LoanApplicationsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loan-service", url = "${library.loans.url-base}")
public interface LoanClient {

    @GetMapping("/loan-applications")
    ResponseEntity<LoanApplicationsResponse> getLoanApplications();

    @GetMapping("/loan-applications/{id}")
    ResponseEntity<LoanApplicationResponse> getLoanApplication(@PathVariable Integer id);

}
