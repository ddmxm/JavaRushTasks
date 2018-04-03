package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/*
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        /*Map modifierValues = new HashMap<Integer, String>();
        modifierValues.put(1024, "ABSTRACT");
        modifierValues.put(16, "FINAL");
        modifierValues.put(512, "INTERFACE");
        modifierValues.put(256, "NATIVE");
        modifierValues.put(2, "PRIVATE");
        modifierValues.put(4, "PROTECTED");
        modifierValues.put(1, "PUBLIC");
        modifierValues.put(8, "STATIC");
        modifierValues.put(2048, "STRICT");
        modifierValues.put(32, "SYNCHRONIZED");
        modifierValues.put(128, "TRANSIENT");
        modifierValues.put(64, "VOLATILE");*/
        int bitAnd = allModifiers & specificModifier;
        return bitAnd == specificModifier ? true : false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
