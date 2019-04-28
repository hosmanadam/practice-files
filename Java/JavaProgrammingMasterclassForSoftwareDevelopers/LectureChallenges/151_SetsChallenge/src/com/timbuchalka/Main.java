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
 * an asteroid also called "BetaMinor", for example.  ✓
 *
 * Hint: This is much easier to implement for the Set than it is for the Map,
 * because the Map will need a key that uses both fields.
 *
 * There is a restriction that the only satellites that planets can have must
 * be moons. Even if you don't implement a STAR type, though, your program
 * should not prevent one being added in the future (and a STAR's satellites
 * can be almost every kind of HeavenlyBody).  ✓
 *
 * Test cases:
 * 1. The planets and moons that we added in the previous video should appear in
 * the solarSystem collection and in the sets of moons for the appropriate planets.  ✓
 *
 * 2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.  ✓
 *
 * 3. Attempting to add a duplicate to a Set must result in no change to the set (so
 * the original value is not replaced by the new one).  ✓
 *
 * 4. Attempting to add a duplicate to a Map results in the original being replaced
 * by the new object.  ✓
 *
 * 5. Two bodies with the same name but different designations can be added to the same set.  ✓
 *
 * 6. Two bodies with the same name but different designations can be added to the same map,
 * and can be retrieved from the map.  ✓
 */
public class Main {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();

    private static Set<Star> stars = new HashSet<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Set<Moon> moons = new HashSet<>();

    private static HeavenlyBody.BodyType STAR = HeavenlyBody.BodyType.STAR;
    private static HeavenlyBody.BodyType PLANET = HeavenlyBody.BodyType.PLANET;
    private static HeavenlyBody.BodyType MOON = HeavenlyBody.BodyType.MOON;

    public static void main(String[] args) {
        createSolarSystem();
        printSolarSystem();
        testSolarSystem();
    }

    private static void createSolarSystem() {
        createPlanet("Mercury", 88);

        createPlanet("Venus", 225);

        createPlanet("Earth", 365)
                .addSatellite(createMoon("Moon", 27), true);

        createPlanet("Mars", 687)
                .addSatellite(createMoon("Deimos", 1.3), true)
                .addSatellite(createMoon("Phobos", 0.3), true);

        createPlanet("Jupiter", 4332)
                .addSatellite(createMoon("Io", 1.8), true)
                .addSatellite(createMoon("Europa", 3.5), true)
                .addSatellite(createMoon("Ganymede", 7.1), true)
                .addSatellite(createMoon("Callisto", 16.7), true);

        createPlanet("Saturn", 10759);

        createPlanet("Uranus", 30660);

        createPlanet("Neptune", 165);

        createPlanet("Pluto", 248);

        Star sun = createStar("Sun", 225_000_000 * 365);

        for (HeavenlyBody planet : planets) {
            sun.addSatellite(planet);
            for (HeavenlyBody moon : planet.getSatellites()) {
                sun.addSatellite(moon);
            }
        }
    }

    private static Star createStar(String name, double orbitalPeriod) {
        Star star = new Star(name, orbitalPeriod);
        solarSystem.put(star.getKey(), star);
        stars.add(star);
        return star;
    }

    private static Planet createPlanet(String name, double orbitalPeriod) {
        Planet planet = new Planet(name, orbitalPeriod);
        solarSystem.put(planet.getKey(), planet);
        planets.add(planet);
        return planet;
    }

    private static Moon createMoon(String name, double orbitalPeriod) {
        Moon moon = new Moon(name, orbitalPeriod);
        solarSystem.put(moon.getKey(), moon);
        moons.add(moon);
        return moon;
    }

    private static void printSolarSystem() {
        printStars();
        printSatellitesOf("Sun", STAR);
        printPlanets();
        printSatellitesOf("Earth", PLANET);
        printSatellitesOf("Mars", PLANET);
        printSatellitesOf("Jupiter", PLANET);
        printMoons();
        printOrbitalPeriods();
    }

    private static void printStars() {
        System.out.println("Stars");
        for (HeavenlyBody star : stars) {
            System.out.println("\t" + star.getName());
        }
    }

    private static void printPlanets() {
        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }
    }

    private static void printMoons() {
        System.out.println("All Moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }
    }

    private static void printSatellitesOf(String name, HeavenlyBody.BodyType bodyType) {
        HeavenlyBody body = solarSystem.get(new HeavenlyBody.Key(name, bodyType));
        System.out.println("Satellites of " + body.getName());
        for (HeavenlyBody satellite : body.getSatellites()) {
            System.out.println("\t" + satellite.getName());
        }
    }

    private static void printOrbitalPeriods() {
        System.out.println("Orbital period in Earth days");
        for (HeavenlyBody planet : planets) {
            String paddedName = String.format("%-9s", planet.getName() + ":");
            System.out.println("\t" + paddedName + (int) planet.getOrbitalPeriod());
        }
    }

    private static void testSolarSystem() {
        System.out.println("TESTS");
        testPlanetDoesNotAcceptNonMoonSatellite();
        testSetDoesNotOverwriteValueWithDuplicate();
        testSetDoesNotAcceptHeavenlyBodyOfSameNameAndSubclass();
        testSetAcceptsHeavenlyBodyOfSameNameAndDifferentSubclass();
        testMapDoesNotAcceptHeavenlyBodyOfSameNameAndSubclass();
        testMapAcceptsHeavenlyBodyOfSameNameAndDifferentSubclass();
        testMapOverwritesValueWithDuplicate();
        testCanRetrieveHeavenlyBodiesOfSameNameAndDifferentSubclassFromMap();
        testEqualsIsSymmetric();
    }

    private static void testPlanetDoesNotAcceptNonMoonSatellite() {
        HeavenlyBody earth = solarSystem.get(new HeavenlyBody.Key("Earth", PLANET));
        HeavenlyBody sun = solarSystem.get(new HeavenlyBody.Key("Sun", STAR));
        boolean passed = !earth.addSatellite(sun);

        printTestResult("Planet does not accept non-moon satellite", passed);
        assert passed;
    }

    private static void testSetDoesNotOverwriteValueWithDuplicate() {
        HeavenlyBody.Key plutoKey = new HeavenlyBody.Key("Pluto", PLANET);
        double originalOrbitalPeriod = solarSystem.get(plutoKey).getOrbitalPeriod();
        Planet pluto2 = new Planet("Pluto", 842);
        planets.add(pluto2);
        double newOrbitalPeriod = solarSystem.get(plutoKey).getOrbitalPeriod();
        boolean passed = originalOrbitalPeriod == newOrbitalPeriod;

        printTestResult("Set doesn't overwrite vaue with duplicate", passed);
        assert passed;
    }

    private static void testSetDoesNotAcceptHeavenlyBodyOfSameNameAndSubclass() {
        int initialSize = planets.size();
        planets.add(new Planet("Pluto", 842));
        boolean passed = initialSize == planets.size();

        printTestResult("Set doesn't accept HeavenlyBody of same name and subclass", passed);
        assert passed;
    }

    private static void testSetAcceptsHeavenlyBodyOfSameNameAndDifferentSubclass() {
        Set<HeavenlyBody> testSet = new HashSet<>();
        Moon betaMinorMoon = new Moon("BetaMinor", 333);
        testSet.add(betaMinorMoon);
        Star betaMinorStar = new Star("BetaMinor", 999_999_999);
        testSet.add(betaMinorStar);
        boolean passed = testSet.size() == 2;

        printTestResult("Set accepts HeavenlyBody of same name and different subclass", passed);
        assert passed;
    }

    private static void testMapDoesNotAcceptHeavenlyBodyOfSameNameAndSubclass() {
        int initialSize = solarSystem.size();
        Planet duplicate = new Planet("Pluto", 248);
        solarSystem.put(duplicate.getKey(), duplicate);
        boolean passed = initialSize == solarSystem.size();

        printTestResult("Map doesn't accept HeavenlyBody of same name and subclass", passed);
        assert passed;
    }

    private static void testMapAcceptsHeavenlyBodyOfSameNameAndDifferentSubclass() {
        int initialSize = solarSystem.size();
        Moon nonDuplicate = new Moon("Pluto", 248);
        solarSystem.put(nonDuplicate.getKey(), nonDuplicate);
        boolean passed = solarSystem.size() == initialSize + 1;

        printTestResult("Map accepts HeavenlyBody of same name and different subclass", passed);
        assert passed;
    }

    private static void testMapOverwritesValueWithDuplicate() {
        int newValue = 9999999;
        Planet duplicate = new Planet("Pluto", newValue);
        solarSystem.put(duplicate.getKey(), duplicate);
        HeavenlyBody retrieved = solarSystem.get(new HeavenlyBody.Key("Pluto", PLANET));
        boolean passed = retrieved.getOrbitalPeriod() == newValue;

        printTestResult("Map overwrites value with duplicate", passed);
        assert passed;
    }

    private static void testCanRetrieveHeavenlyBodiesOfSameNameAndDifferentSubclassFromMap() {
        Planet planet = new Planet("BetaMinor", 111);
        Moon moon = new Moon("BetaMinor", 9999);
        solarSystem.put(planet.getKey(), planet);
        solarSystem.put(moon.getKey(), moon);
        HeavenlyBody retrievedPlanet = solarSystem.get(new HeavenlyBody.Key("BetaMinor", PLANET));
        HeavenlyBody retrievedMoon = solarSystem.get(new HeavenlyBody.Key("BetaMinor", MOON));
        boolean passed = retrievedPlanet.equals(planet) && retrievedMoon.equals(moon);

        printTestResult("Can retrieve heavenly bodies of same name and different subclass from map", passed);
        assert passed;
    }

    private static void testEqualsIsSymmetric() {
        Planet planet1 = new Planet("BetaMinor", 111);
        Planet planet2 = new Planet("BetaMinor", 333);
        Moon moon = new Moon("BetaMinor", 111);

        boolean result1 = planet1.equals(moon) == moon.equals(planet1);
        boolean result2 = planet1.equals(planet2) == planet2.equals(planet1);
        boolean passed = result1 && result2;

        printTestResult("heavenlyBody.equals() is symmetric", passed);
        assert passed;
    }

    private static void printTestResult(String description, boolean passed) {
        System.out.println("    " + description + ": " + (passed ? "PASSED ✓" : "FAILED ✗"));
    }

}
