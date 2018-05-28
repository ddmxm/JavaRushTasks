package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Solution))
            return false;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Solution n = (Solution) o;
        boolean fCheck = first == n.first || (first != null && first.equals(n.first));
        boolean lCheck = last == n.last || (last != null && last.equals(n.last));
        return fCheck && lCheck;
    }

    @Override
    public int hashCode() {
        int fHash = 0;
        int sHash = 0;
        if (first != null)
            fHash = first.hashCode();
        if (last != null)
            sHash = last.hashCode();
        return fHash + sHash;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
