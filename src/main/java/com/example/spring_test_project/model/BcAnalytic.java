/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
@ToString
@Getter
@Setter
@Entity(name = "bc_analytic")
@Accessors(chain = true)
public class BcAnalytic {

    @Id
    @SequenceGenerator(
            name = "bc_analytic_seq",
            sequenceName = "bc_analytic_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bc_analytic_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "counter")
    private int counter;

//    @JsonManagedReference
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "bc_analytic_import_details",
//            joinColumns = @JoinColumn(name = "bc_analytic_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "import_details_id", referencedColumnName = "id")
//    )
//    private List<ImportDetails> importDetails = new ArrayList<>();

}
