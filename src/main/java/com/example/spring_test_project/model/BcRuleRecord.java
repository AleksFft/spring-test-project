/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
@Entity(name = "bc_rule_import_record_tmp")
public class BcRuleRecord {

    @Id
    @SequenceGenerator(
            name = "bc_rule_import_record_seq",
            sequenceName = "bc_rule_import_record_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bc_rule_import_record_seq")
    private Long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RecordStatus status;

    @Column(name = "import_session_id")
    private String importSessionId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "budget_id")
    private Long budgetId;

    @Column(name = "side")
    @Enumerated(EnumType.STRING)
    private SideType side;

    @Column(name = "bank_bic")
    private String bankBic;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_inn")
    private String clientInn;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "erp_id")
    private String erpId;

    @Column(name = "rule_number")
    private Long ruleNumber;

    @Column(name = "bc_code")
    private String bcCode;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "bank_bic_contractor")
    private String bankBicContractor;

    @Column(name = "account_contractor")
    private String accountContractor;

    @Column(name = "name_contractor")
    private String nameContractor;

    @Column(name = "inn_contractor")
    private String innContractor;

    @Column(name = "payment_details")
    private String paymentDetails;

    @Column(name = "ext_budget_code")
    private String extBudgetCode;

    @Column(name = "oper_type_code")
    private String operTypeCode;

    @Column(name = "payment_internal")
    private String paymentInternal;

    @Column(name = "rule_author")
    @Enumerated(EnumType.STRING)
    private RuleAuthor ruleAuthor;

    @Column(name = "rule_priority")
    private Long rulePriority;

    @Column(name = "document_execution_state")
    private String documentExecutionState;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "import_record_error_data_tmp", joinColumns = @JoinColumn(name = "record_id"))
    private List<ImportRecordErrorInfo> errorData = new ArrayList<>();

    @Column(name = "rc_id")
    private Long rcId;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "rc_account_id")
    private Long rcAccountId;

    @Column(name = "rc_name")
    private String rcName;

    @Column(name = "is_selected")
    private Boolean isSelected;

    @Column(name = "curr_code")
    private String currCode;

}
