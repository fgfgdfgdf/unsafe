package com.carry.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeGet {

    private static Unsafe unsafe = null;

    public static Unsafe getUnsafe() {
        if (unsafe == null) {
            try {
                Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
                unsafeField.setAccessible(true);
                unsafe = (Unsafe) unsafeField.get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return unsafe;
    }

    public static void main(String[] args) {
        Unsafe unsafe1 = getUnsafe();
        System.out.println(Unsafe.ARRAY_BOOLEAN_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_BYTE_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_SHORT_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_CHAR_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_INT_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_LONG_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_FLOAT_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_DOUBLE_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_OBJECT_BASE_OFFSET);
        System.out.println(Unsafe.ARRAY_BOOLEAN_INDEX_SCALE);
        System.out.println(Unsafe.ARRAY_BYTE_INDEX_SCALE);
        System.out.println(Unsafe.ARRAY_SHORT_INDEX_SCALE);
        System.out.println(Unsafe.ARRAY_CHAR_INDEX_SCALE);
        System.out.println(Unsafe.ARRAY_INT_INDEX_SCALE);
        System.out.println(Unsafe.ARRAY_LONG_INDEX_SCALE);
        System.out.println(Unsafe.ARRAY_FLOAT_INDEX_SCALE);
        System.out.println(Unsafe.ARRAY_DOUBLE_INDEX_SCALE);
        System.out.println(Unsafe.ARRAY_OBJECT_INDEX_SCALE);
        System.out.println(Unsafe.ADDRESS_SIZE);

        System.out.println(Unsafe.ARRAY_BOOLEAN_BASE_OFFSET);
    }

}
