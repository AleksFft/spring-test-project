/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
public interface AbstractDomainMapper<M, D> {

    /**
     * Map DTO -> Domain model.
     *
     * @param dto DTO
     * @return Domain model
     */
    M toDomainModel(D dto);

    /**
     * Map list of DTOs -> list of Domain models.
     *
     * @param source List of DTO
     * @return List of domain models
     */
    default List<M> toDomainModel(Collection<D> source) {
        if (source == null) {
            return new ArrayList<>();
        }
        List<M> target = new ArrayList<M>(source.size());
        for (D dto : source) {
            target.add(toDomainModel(dto));
        }
        return target;
    }

}
