package com.berkay22demirel.kuponrobotu.utils;

import java.util.List;

public class CollectionUtil {

    public static <T> boolean isNotEmpty(List<T> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Object[] array) {
        if (array != null && array.length > 0) {
            return true;
        }
        return false;
    }
}
