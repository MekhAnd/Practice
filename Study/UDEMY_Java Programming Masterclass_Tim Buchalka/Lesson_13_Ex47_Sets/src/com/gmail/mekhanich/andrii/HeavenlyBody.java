package com.gmail.mekhanich.andrii;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bodyType);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        if (this.getKey().getBodyType() == BodyTypes.MOON) {
            return false;
        } else return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public final boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if(obj instanceof  HeavenlyBody){
//            HeavenlyBody compareObj = (HeavenlyBody) obj;
//            return this.key.equals(compareObj.getKey());
//        }
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass().getSimpleName() != this.getClass().getSimpleName()) {
            return false;
        }

        Key objKey = ((HeavenlyBody) obj).getKey();
        return this.key.equals(objKey);

    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.getName() + ": " + this.key.getBodyType() + ", " + orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (!name.equals(key.name)) return false;
            return bodyType == key.bodyType;
        }

        @Override
        public int hashCode() {
            return name.hashCode() + bodyType.hashCode() + 57;
        }

        @Override
        public String toString() {
            return name + ": " + bodyType;
        }
    }
}
