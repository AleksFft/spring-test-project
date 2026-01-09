/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2025 VTB Group. All rights reserved.
 */

package com.example.spring_test_project;

/**
 * @author Aleksandr_Berestov
 */
public class TestRunner {
    public static void main(String[] args) throws Exception {
        Main.main(new String[]{
                "-c", "JmmReorderingDekkerTest",
                "-t", "2", // количество потоков
                "-iter", "1000000" // количество итераций
        });
    }
}
