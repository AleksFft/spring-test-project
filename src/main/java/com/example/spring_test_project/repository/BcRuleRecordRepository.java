/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.repository;

import com.example.spring_test_project.model.BcRuleRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
public interface BcRuleRecordRepository extends JpaRepository<BcRuleRecord, Long> {

}
