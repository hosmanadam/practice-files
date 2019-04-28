package com.timbuchalka;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by dev on 12/01/2016.
 */
public abstract class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType bodyType;
    private final Key key;

    public static final Key createKey(String name, BodyType bodyType) {
        return new Key(name, bodyType);
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
        this.key = new Key(name, bodyType);
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public HeavenlyBody addSatellite(HeavenlyBody satellite, boolean chainable) {
        if (addSatellite(satellite))
            return this;
        return null;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj)
            return true;
        if ((obj == null) || (obj.getClass() != this.getClass()))
            return false;
        return key.equals(((HeavenlyBody) obj).getKey());
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return bodyType + " '" + name + "' (orbital period: " + orbitalPeriod + ")";
    }

    public static final class Key implements Comparable<Key> {

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

    public enum BodyType {
        STAR,
        PLANET,
        MOON,
    }

}
