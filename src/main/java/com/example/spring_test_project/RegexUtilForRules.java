/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project;

import java.util.regex.Pattern;

/**
 * @author Aleksandr_Berestov
 */
public class RegexUtilForRules {

    public static Boolean isMatch(String ruleString, String analyticString) {
        String replacedAnalytic = analyticString
                .replaceAll("\n", "")
                .replaceAll("\r", "");
        return Pattern.compile(ruleString
                        .replace("_", ".")
                        .replace("%", ".*"))
                .matcher(replacedAnalytic)
                .matches();
    }

}
