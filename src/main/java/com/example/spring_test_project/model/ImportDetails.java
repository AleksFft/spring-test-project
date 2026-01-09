/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aleksandr_Berestov
 */
@Data
@Accessors(chain = true)
@Entity(name = "import_details")
public class ImportDetails {

    @Id
    @SequenceGenerator(
            name = "import_details_seq",
            sequenceName = "import_details_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "import_details_seq")
    private Long id;

    @Column(name = "session_id")
    private String sessionId;

//    @JsonBackReference
//    @ManyToMany(mappedBy = "importDetails")
//    Set<BcAnalytic> bcAnalytics = new HashSet<>();

}
