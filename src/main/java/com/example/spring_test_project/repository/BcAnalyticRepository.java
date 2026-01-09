/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.repository;

import com.example.spring_test_project.model.BcAnalytic;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksandr_Berestov
 */
public interface BcAnalyticRepository extends JpaRepository<BcAnalytic, Long> {

    BcAnalytic findFirstByName(String name);

}
