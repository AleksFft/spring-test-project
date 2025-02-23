/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.mapper;

import com.example.spring_test_project.model.BcAnalytic;
import com.example.spring_test_project.model.BcAnalyticDto;
import com.example.spring_test_project.model.ImportDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aleksandr_Berestov
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class BcAnalyticMapper implements AbstractMapper<BcAnalytic, BcAnalyticDto>{

    public abstract BcAnalyticDto toDto(BcAnalytic entity);
}
