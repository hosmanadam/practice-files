package com.timbuchalka;

import java.util.Objects;

public final class Key implements Comparable<Key> {

    private final String name;
    private final BodyType bodyType;

    public Key(String name, BodyType bodyType) {
        this.name = name;
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Key otherKey = (Key) obj;
        return name.equals(otherKey.name) && bodyType.equals(otherKey.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bodyType);
    }

    @Override
    public int compareTo(Key otherKey) {
        if (this == otherKey)
            return 0;
        int nameComparison = name.compareTo(otherKey.getName());
        if (nameComparison == 0)
            return bodyType.compareTo(otherKey.getBodyType());
        return nameComparison;
    }
}
