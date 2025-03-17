package com.ammfec.db.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "loan_applications")
public class LoanApplicationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_book")
    private Integer idBook;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
