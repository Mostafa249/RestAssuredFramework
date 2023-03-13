package com.backend.utils;

public class TestUtils {
    public static String generateUniqueName(String name) {
        return name + System.currentTimeMillis();
    }
}
