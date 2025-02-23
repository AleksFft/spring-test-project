/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@Accessors(chain = true)
public class BcRuleRecordDto {
    @Schema(description = "Идентификатор записи импорта")
    private Long id;

    @Schema(description = "Статус записи")
    private RecordStatusDto status;

    @Schema(description = "Идентификатор сессии")
    private String importSessionId;

    @Schema(description = "Идентификатор группы компаний")
    private Long groupId;

    @Schema(description = "Идентификатор бюджета")
    private Long budgetId;

    @Schema(description = "1.БИК банка (филиала)")
    private String bankBic;

    @Schema(description = "2.Наименование банка")
    private String bankName;

    @Schema(description = "3.Наименование клиента по услуге КИБ.")
    private String clientName;

    @Schema(description = "4.ИНН клиента по услуге КИБ.")
    private String clientInn;

    @Schema(description = "5.Номер расчетного счета.")
    private String accountNumber;

    @Schema(description = "6.Внешний идентификатор Клиента.")
    private String erpId;

    @Schema(description = "7(6-ф2).Номер правила.")
    private Long ruleNumber;

    @Schema(description = "8(7-ф2).Код БК.")
    private String bcCode;

    @Schema(description = "9(8-ф2).Примечание.")
    private String ruleName;

    @Schema(description = "10(9-ф2).БИК банка контрагента.")
    private String bankBicContractor;

    @Schema(description = "11(10-ф2).Шаблон номера счета контрагента.")
    private String accountContractor;

    @Schema(description = "12(11-ф2).Шаблон наименования контрагента.")
    private String nameContractor;

    @Schema(description = "13(12-ф2).ИНН контрагента.")
    private String innContractor;

    @Schema(description = "14(13-ф2).Шаблон назначения платежа.")
    private String paymentDetails;

    @Schema(description = "15(14-ф2).Шаблон кода БК по др. стороне проводки.")
    private String extBudgetCode;

    @Schema(description = "16(15-ф2).Вид документа.")
    private String operTypeCode;

    @Schema(description = "17(16-ф2).Направление.")
    private SideTypeDto side;

    @Schema(description = "18(17-ф2).Признак внутреннего платежа.")
    private String paymentInternal;

    @Schema(description = "19(18-ф2).Признак стороны правила.")
    private RuleAuthorDto ruleAuthor;

    @Schema(description = "19-ф2.Приоритет.")
    private Long rulePriority;

    @Schema(description = "20-ф2. Факт исполнения.")
    private String documentExecutionState;

    @Schema(description = "Данные об ошибках.")
    private List<ImportRecordErrorInfoDto> errorData = new ArrayList<>();

    @Schema(description = "Идентификатор центра ответственности.")
    private Long rcId;

    @Schema(description = "Имя центра ответственности.")
    private String rcName;

    @Schema(description = "Идентификатор клиента.")
    private Long clientId;

    @Schema(description = "Идентификатор подразделения.")
    private Long branchId;

    @Schema(description = "Идентификатор счета (просто счета и счета получателя/отправителя).")
    private Long accountId;

    @Schema(description = "Идентификатор счета в справочнике счетов")
    private Long rcAccountId;

    @Schema(description = "Признак выбрано ли правило для импортирования")
    private Boolean isSelected;

    @Schema(description = "Буквенный код валюты")
    private String currCode;


    public void addErrorData(ImportRecordErrorInfoDto dto) {
        this.errorData.add(dto);
    }

    public boolean isNotNumberUniq(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BcRuleRecordDto recordDto = (BcRuleRecordDto) o;
        return Objects.equals(groupId, recordDto.groupId)
                && Objects.equals(ruleNumber, recordDto.ruleNumber)
                && side == recordDto.side
                && ruleAuthor == recordDto.ruleAuthor
                && Objects.equals(rcId, recordDto.rcId)
                && Objects.equals(branchId, recordDto.branchId);
    }

    public boolean isDuplicate(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BcRuleRecordDto dto = (BcRuleRecordDto) o;
        return Objects.equals(bankBic, dto.bankBic)
                && Objects.equals(clientInn, dto.clientInn)
                && Objects.equals(accountNumber, dto.accountNumber)
                && Objects.equals(erpId, dto.erpId)
                && Objects.equals(bcCode, dto.bcCode)
                && Objects.equals(bankBicContractor, dto.bankBicContractor)
                && Objects.equals(accountContractor, dto.accountContractor)
                && Objects.equals(nameContractor, dto.nameContractor)
                && Objects.equals(innContractor, dto.innContractor)
                && Objects.equals(paymentDetails, dto.paymentDetails)
                && Objects.equals(extBudgetCode, dto.extBudgetCode)
                && Objects.equals(operTypeCode, dto.operTypeCode)
                && side == dto.side
                && Objects.equals(paymentInternal, dto.paymentInternal)
                && Objects.equals(documentExecutionState, dto.documentExecutionState);
    }

}
