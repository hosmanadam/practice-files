package com.timbuchalka;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Modify the previous HeavenlyBody example so that the HeavenlyBody
 * class also has a "bodyType" field. This field will store the
 * type of HeavenlyBody (such as STAR, PLANET, MOON, etc).  ✓
 *
 * You can include as many types as you want, but must support at
 * least PLANET and MOON.
 *
 * For each of the types that you support, subclass the HeavenlyBody class
 * so that your program can create objects of the appropriate type.  ✓
 *
 * Although astronomers may shudder at this, our solar systems will
 * allow two bodies to have the same name as long as they are not the
 * same type of body: so you could have a star called "BetaMinor" and
 * an asteroid also called "BetaMinor", for example.  // TODO
 *
 * Hint: This is much easier to implement for the Set than it is for the Map,
 * because the Map will need a key that uses both fields.
 *
 * There is a restriction that the only satellites that planets can have must
 * be moons. Even if you don't implement a STAR type, though, your program
 * should not prevent one being added in the future (and a STAR's satellites
 * can be almost every kind of HeavenlyBody).  // TODO
 *
 * Test cases:
 * 1. The planets and moons that we added in the previous video should appear in
 * the solarSystem collection and in the sets of moons for the appropriate planets.  // TODO
 *
 * 2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.  // TODO
 *
 * 3. Attempting to add a duplicate to a Set must result in no change to the set (so
 * the original value is not replaced by the new one).  // TODO
 *
 * 4. Attempting to add a duplicate to a Map results in the original being replaced
 * by the new object.  // TODO
 *
 * 5. Two bodies with the same name but different designations can be added to the same set.  // TODO
 *
 * 6. Two bodies with the same name but different designations can be added to the same map,
 * and can be retrieved from the map.  // TODO
 */
public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> moons = new HashSet<>();

    public static void main(String[] args) {
        createSolarSystem();
        printSolarSystem();
//        testSolarSystem();
    }

    private static void createSolarSystem() {

        HeavenlyBody tempPlanet;
        HeavenlyBody tempMoon;


        tempPlanet = new Planet("Mercury", 88);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Venus", 225);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Earth", 365);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addMoon(tempMoon);


        tempPlanet = new Planet("Mars", 687);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addMoon(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addMoon(tempMoon);


        tempPlanet = new Planet("Jupiter", 4332);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addMoon(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addMoon(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addMoon(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addMoon(tempMoon);


        tempPlanet = new Planet("Saturn", 10759);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Uranus", 30660);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Neptune", 165);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Pluto", 248);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);


        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

    }

    private static void printSolarSystem() {
        printPlanets();
        printSatellitesOf("Earth");
        printSatellitesOf("Mars");
        printSatellitesOf("Jupiter");
        printMoons();
        printOrbitalPeriods();
    }

    private static void printSatellitesOf(String name) {
        HeavenlyBody body = solarSystem.get(name);
        System.out.println("Satellites of " + body.getName());
        for (HeavenlyBody satellite: body.getSatellites()) {
            System.out.println("\t" + satellite.getName());
        }
    }

    private static void printPlanets() {
        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }
    }

    private static void printOrbitalPeriods() {
        System.out.println("Orbital period in Earth days");
        for(HeavenlyBody planet : planets) {
            String paddedName = String.format("%-9s", planet.getName() + ":");
            System.out.println("\t" + paddedName + (int) planet.getOrbitalPeriod());
        }
    }

    private static void printMoons() {
        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }
    }

    private static void testSolarSystem() {
        HeavenlyBody pluto = new Planet("Pluto", 842);
        planets.add(pluto);
        printOrbitalPeriods();
    }

}
