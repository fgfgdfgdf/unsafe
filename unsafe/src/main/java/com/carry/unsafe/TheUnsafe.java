package com.carry.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Objects;

public class TheUnsafe {

    private static Unsafe unsafe;

    static {
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    // ------------------------------------------util------------------------------------------------

    public static boolean isStatic(Field field) {
        return Modifier.isStatic(field.getModifiers());
    }

    public static long getFieldOffset(Field field) {
        return isStatic(field) ? unsafe.staticFieldOffset(field) : unsafe.objectFieldOffset(field);
    }

    // -----------------------------------------Memory-------------------------------------------------
    public static Integer getIntVal(Object obj, String name) {
        Objects.requireNonNull(obj);
        Objects.requireNonNull(name);
        try {
            Field declaredField = obj.getClass().getDeclaredField(name);
            boolean isStatic = isStatic(declaredField);
            long fieldOffset = getFieldOffset(declaredField);
            if (isStatic) {
                return unsafe.getInt(null, fieldOffset);
            } else {
                return unsafe.getInt(obj, fieldOffset);
            }
        } catch (NoSuchFieldException ignored) {
        }
        return null;
    }


}
