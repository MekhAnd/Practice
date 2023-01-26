package com.gmail.mekhanich.andrii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    private static void addBodyToSolarSystem (HeavenlyBody body){
        solarSystem.put(body.getName()+":"+body.getClass().getSimpleName(), body);
    }

    public static void main(String[] args) {

        HeavenlyBody sun = new HeavenlyBody("Sun", 0, "Star");

        HeavenlyBody.Planet temp = sun.new Planet("Mercury", 88, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

        temp = sun.new Planet("Venus", 225, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

        temp = sun.new Planet("Earth", 365, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

        HeavenlyBody.Satellite tempMoon = sun.new Satellite("Moon", 27, "satellite");
        addBodyToSolarSystem(tempMoon);
        temp.addMoon(tempMoon);

        temp = sun.new Planet("Mars", 687, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

        tempMoon = sun.new Satellite("Deimos", 1.3, "satellite");
        addBodyToSolarSystem(tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = sun.new Satellite("Phobos", 0.3, "satellite");
        addBodyToSolarSystem(tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = sun.new Planet("Jupiter", 4332, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

        tempMoon = sun.new Satellite("Io", 1.8, "satellite");
        addBodyToSolarSystem (tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = sun.new Satellite("Europa", 3.5, "satellite");
        addBodyToSolarSystem (tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = sun.new Satellite("Ganymede", 7.1, "satellite");
        addBodyToSolarSystem (tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = sun.new Satellite("Callisto", 16.7, "satellite");
        addBodyToSolarSystem (tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = sun.new Planet("Saturn", 10759, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

        temp = sun.new Planet("Uranus", 30660, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

        temp = sun.new Planet("Neptune", 165, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

        temp = sun.new Planet("Pluto", 842, "planet");
        addBodyToSolarSystem(temp);
        planets.add(temp);

//        System.out.println("Planets");;
//        for (HeavenlyBody planet:planets){
//            System.out.println("\t" + planet.getName());
//        }

//        HeavenlyBody body = solarSystem.get("Jupiter");
//        System.out.println("Moons of " + body.getName());;
//        for (HeavenlyBody moon: body.getSatellites()){
//            System.out.println("\t" + moon.getName());
//        }
//
//        Set <HeavenlyBody> moons = new HashSet<>();
//        for (HeavenlyBody planet :planets){
//            moons.addAll(planet.getSatellites());
//        }
//        System.out.println("All moons");
//        for (HeavenlyBody moon: moons){
//            System.out.println("\t" + moon.getName());
//        }


//        Second Pluto -> will be added to this Set because compare objects (before override equals + hashCode)
        HeavenlyBody.Planet pluto = sun.new Planet("Pluto", 842, "planet");
        planets.add(pluto);
        System.out.println("!!!!!");
        System.out.println("Planets");;
        for (HeavenlyBody planet:planets){
            System.out.println("\t" + planet.getName() + "\t" + planet.getOrbitalPeriod());
        }
////        Third Pluto -> will not be added to this Set the objects are same (before override equals + hashCode)
        HeavenlyBody pluto01 = new HeavenlyBody("Pluto", 248, "planet");
        planets.add(pluto);
        System.out.println("!!!!!");
        System.out.println("Planets");;
        for (HeavenlyBody planet:planets){
            System.out.println("\t" + planet.getName() + "\t" + planet.getOrbitalPeriod());
        }



        HeavenlyBody.Asteroid pluto02 = sun.new Asteroid("Pluto", 248, "asteroid");
        planets.add(pluto02);
        addBodyToSolarSystem(pluto02);
//        solarSystem.put(temp.getName()+" "+temp.getClass().getSimpleName(), temp);
        System.out.println("!!!!!");
        System.out.println("Planets");;

        System.out.println(pluto02.getClass() + "\n" + pluto02.getClass().getSimpleName());

        for (HeavenlyBody planet:planets){
            System.out.println("\t" + planet.getName() + "\t" + planet.getOrbitalPeriod() + "\t" + planet.getClass().getSimpleName());
        }

        System.out.println(pluto02.getClass());

        HeavenlyBody.Planet p001 = sun.new Planet("test", 1, "planet");
        HeavenlyBody.Planet p002 = sun.new Planet("test", 1, "planet");

        for(String heavenBody:solarSystem.keySet()){
            System.out.println(heavenBody + "\t" + solarSystem.get(heavenBody));
        }

        System.out.println(p001.equals(p002));
        System.out.println(p002.equals(p001));
    }
}