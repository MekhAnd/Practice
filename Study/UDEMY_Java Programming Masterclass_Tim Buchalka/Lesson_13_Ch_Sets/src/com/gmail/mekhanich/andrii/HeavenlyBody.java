package com.gmail.mekhanich.andrii;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private String bodyType;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, String bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;

    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        if (this.getClass().getSimpleName().equalsIgnoreCase("planet") ||
                this.getClass().getSimpleName().equalsIgnoreCase("sun")) {
            return this.satellites.add(moon);
        } else {
            return false;
        }
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            System.out.println("The same obj");
            return true;
        }

        if (obj == null || obj.getClass().getSimpleName() != this.getClass().getSimpleName()) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        System.out.println(this.name.equals(objName));
        return this.name.equals(objName);
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57;
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + name + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                '}';
    }

    class Planet extends HeavenlyBody {
        public Planet(String name, double oribitalPeriod, String bodyType) {
            super(name, oribitalPeriod, bodyType);
        }


    }

    class Satellite extends HeavenlyBody {
        public Satellite(String name, double oribitalPeriod, String bodyType) {
            super(name, oribitalPeriod, bodyType);
        }
    }

    class Asteroid extends HeavenlyBody {
         public Asteroid(String name, double oribitalPeriod, String bodyType) {
            super(name, oribitalPeriod, bodyType);
        }

        public Asteroid getAsteroig() {
            return this;
        }
    }

    class Comet extends HeavenlyBody {
         public Comet(String name, double oribitalPeriod, String bodyType) {
            super(name, oribitalPeriod, bodyType);
        }
    }

}
