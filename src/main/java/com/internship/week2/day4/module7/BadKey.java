package com.internship.week2.day4.module7;

public class BadKey {
    private final int id;

    public BadKey(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return 1; // Intentionally bad
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BadKey)) return false;
        BadKey other = (BadKey) obj;
        return this.id == other.id;
    }
}
