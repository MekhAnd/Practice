package com.gmail.mekhanich.andrii;

import java.util.HashSet;
import java.util.Set;

    public final class HeavenlyBody {
        private final String name;
        private final double orbitalPeriod;
        private final Set<HeavenlyBody> satellites;

        public HeavenlyBody(String name, double orbitalPeriod) {
            this.name = name;
            this.orbitalPeriod = orbitalPeriod;
            this.satellites = new HashSet<>();
        }

        public String getName() {
            return name;
        }

        public double getOrbitalPeriod() {
            return orbitalPeriod;
        }

        public boolean addMoon(HeavenlyBody moon) {
            return this.satellites.add(moon);
        }

        public Set<HeavenlyBody> getSatellites() {
            return new HashSet<>(this.satellites);
        }

    //    @Override
    //    public boolean equals(Object obj) {
    //        return super.equals(obj);
    //    }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                System.out.println("The same obj");
                return true;
            }

            System.out.println("obj.getClass() is " + obj.getClass());
            System.out.println("this.getClass() is " + this.getClass());

            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            String objName = ((HeavenlyBody) obj).getName();
            System.out.println(this.name.equals(objName));
            return this.name.equals(objName);
        }

        @Override
        public int hashCode() {
            System.out.println("hashCode() called ");
            return this.name.hashCode() + 57;
        }
}
