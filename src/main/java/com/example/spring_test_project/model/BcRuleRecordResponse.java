/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@Accessors(chain = true)
public class BcRuleRecordResponse {

    private String sessionId;
    private String clientName;
    private String inn;
    private String kpp;
    private String extId;
    private String rcName;
    private Integer rulesAmount;
    private Long selectedRulesAmount;
    private Long debitAmount;
    private Long creditAmount;
    private Long duplicateErrorAmount;
    private Long requisiteErrorAmount;
    private Long clientId;
    private BcRuleRecordTypeDto type;
    private Integer size;

}
