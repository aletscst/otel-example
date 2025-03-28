package com.ammfec.service;

import com.ammfec.db.model.LoanApplicationModel;
import com.ammfec.db.repository.LoanApplicationRepository;
import com.ammfec.dto.general.Book;
import com.ammfec.dto.general.LoanApplication;
import com.ammfec.dto.general.User;
import com.ammfec.dto.request.LoanApplicationRequest;
import com.ammfec.dto.response.*;
import com.ammfec.exception.NotFoundException;
import com.ammfec.web_client.BookClient;
import com.ammfec.web_client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class LoanApplicationServiceImp implements LoanApplicationService {
    @Autowired
    private LoanApplicationRepository repository;

    @Autowired
    private UserClient userClient;

    @Autowired
    private BookClient bookClient;

    @Override
    public LoanApplicationsResponse getLoanApplications() {
        Iterable<LoanApplicationModel> loanApplicationsModel = repository.findAll();

        LoanApplicationsResponse loanApplicationsResponse = new LoanApplicationsResponse();

        List<LoanApplication> loanApplications = new ArrayList<>();
        for (LoanApplicationModel loanApplicationModel : loanApplicationsModel) {
            LoanApplication loanApplication = new LoanApplication();
            loanApplication.setId(loanApplicationModel.getId());

            loanApplication.setUser(getUser(loanApplicationModel.getIdUser()));

            loanApplication.setBook(getBook(loanApplicationModel.getIdBook()));

            loanApplication.setStatus(loanApplicationModel.getStatus());
            loanApplication.setCreationDate(loanApplicationModel.getCreatedAt());
            loanApplication.setUpdateDate(loanApplicationModel.getUpdatedAt());

            loanApplications.add(loanApplication);
        }

        loanApplicationsResponse.setLoanApplications(loanApplications);

        return loanApplicationsResponse;
    }

    @Override
    public LoanApplicationResponse getLoanApplication(Integer id) {
        LoanApplicationModel loanApplicationModel = repository.findById(id).orElseThrow(() ->{
            log.error("LoanApplication not found");
            log.error("LoanApplication not found with id {}", id);
            return new NotFoundException("LoanApplication not found");
        });

        LoanApplicationResponse loanApplicationResponse = new LoanApplicationResponse();
        loanApplicationResponse.setId(loanApplicationModel.getId());

        LoanApplication loanApplication = new LoanApplication();

        loanApplication.setUser(getUser(loanApplicationModel.getIdUser()));

        loanApplication.setBook(getBook(loanApplicationModel.getIdBook()));

        loanApplication.setStatus(loanApplicationModel.getStatus());
        loanApplication.setCreationDate(loanApplicationModel.getCreatedAt());
        loanApplication.setUpdateDate(loanApplicationModel.getUpdatedAt());

        loanApplicationResponse.setLoanApplication(loanApplication);

        return loanApplicationResponse;
    }

    @Override
    public LoanApplicationResponse createLoanApplication(LoanApplicationRequest loanApplicationRequest) {
        return null;
    }

    @Override
    public LoanApplicationResponse updateLoanApplication(Integer id, LoanApplicationRequest loanApplicationRequest) {
        return null;
    }

    private User getUser(Integer id) {
        ResponseEntity<UserResponse> response = userClient.getUser(id);

        if(response.getStatusCode().is2xxSuccessful()) {
            return Objects.requireNonNull(response.getBody()).getUser();
        }
        log.error("User not found");
        log.error("User not found with id {}, response {}", id, response);
        throw new RuntimeException("User not found");
    }

    private Book getBook(Integer id) {
        ResponseEntity<BookResponse> response = bookClient.getBook(id);

        if(response.getStatusCode().is2xxSuccessful()) {
            return Objects.requireNonNull(response.getBody()).getBook();
        }
        log.error("Book not found");
        log.error("Book not found with id {}, response {}", id, response);
        throw new RuntimeException("Book not found");
    }
}
