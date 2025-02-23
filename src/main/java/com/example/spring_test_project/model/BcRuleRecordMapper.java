/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Aleksandr_Berestov
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BcRuleRecordMapper extends AbstractMapper<BcRuleRecord, BcRuleRecordDto> {

}
