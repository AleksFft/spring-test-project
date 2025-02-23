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
public interface AbstractDtoMapper<M, D> {

    /**
     * Map Domain model -> DTO.
     *
     * @param domainModel Domain model
     * @return DTO
     */
    D toDto(M domainModel);

    /**
     * Map list of Domain models -> list of DTOs.
     *
     * @param source source of Domain model
     * @return List of DTOs
     */
    default List<D> toDto(Collection<M> source) {
        if (source == null) {
            return new ArrayList<>();
        }
        List<D> target = new ArrayList<D>(source.size());

        for (M domain : source) {
            target.add(toDto(domain));
        }
        return target;
    }

}
