/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project;

import com.example.spring_test_project.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {


        System.out.println(longerPredicate(interrupt("4")));
        List<Status> statuses = Status.errorStatuses();

    }

    private static String longerPredicate(Supplier<Boolean> interruptSupplier) {

        List<String> collect = IntStream.range(1, 5)
                .mapToObj(i -> i + "")
                .toList();


        String collect1 = collect.stream()
                .filter(s -> interruptSupplier.get())
                .map(s -> s + " - stream")
                .collect(Collectors.joining("; "));

        if (collect1.isEmpty()) {
            return "interrupted";
        }

        return collect1;
    }

    private static Supplier<Boolean> interrupt(String s) {
        return () -> !s.equals("5");
    }

    private static String longerPredicate() {

        List<String> collect = IntStream.range(1, 22).mapToObj(i -> i + "").toList();

        boolean breaked = false;
        for (String s: collect) {
            if (s.equals("7")) {
                return "breaked";
            }
        }

        if (breaked) {
            return "breaked";
        }

        return "not breaked";
    }

    private static String aaa(String val) {
        return val.replace("RUR", "RUB");
    }

    private static void aaa2(List<String> val) {
        val.forEach(System.out::print);
    }

    private static BiPredicate<String, String>  aaa2() {
        BiPredicate<String, String> or = pre().or(pre());
        return or;

    }

    private static BiPredicate<String, String> pre() {
        return String::equals;
    }

    private static boolean pre(String a, String b, BiPredicate<String, String> pre) {
        return pre.test(a, b);
    }

}
