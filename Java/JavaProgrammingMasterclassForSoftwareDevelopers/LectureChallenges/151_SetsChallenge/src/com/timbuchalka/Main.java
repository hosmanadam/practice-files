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
 * 2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.  // TODO
 *
 * 3. Attempting to add a duplicate to a Set must result in no change to the set (so
 * the original value is not replaced by the new one).  ✓
 *
 * 4. Attempting to add a duplicate to a Map results in the original being replaced
 * by the new object.  // TODO
 *
 * 5. Two bodies with the same name but different designations can be added to the same set.  ✓
 *
 * 6. Two bodies with the same name but different designations can be added to the same map,
 * and can be retrieved from the map.  // TODO: create composite key class
 */
public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<Star> stars = new HashSet<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Set<Moon> moons = new HashSet<>();

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
        solarSystem.put(name, star);
        stars.add(star);
        return star;
    }

    private static Planet createPlanet(String name, double orbitalPeriod) {
        Planet planet = new Planet(name, orbitalPeriod);
        solarSystem.put(name, planet);
        planets.add(planet);
        return planet;
    }

    private static Moon createMoon(String name, double orbitalPeriod) {
        Moon moon = new Moon(name, orbitalPeriod);
        solarSystem.put(name, moon);
        moons.add(moon);
        return moon;
    }

    private static void printSolarSystem() {
        printStars();
        printSatellitesOf("Sun");
        printPlanets();
        printSatellitesOf("Earth");
        printSatellitesOf("Mars");
        printSatellitesOf("Jupiter");
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

    private static void printSatellitesOf(String name) {
        HeavenlyBody body = solarSystem.get(name);
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
    }

    private static void testPlanetDoesNotAcceptNonMoonSatellite() {
        HeavenlyBody earth = solarSystem.get("Earth");
        HeavenlyBody sun = solarSystem.get("Sun");
        boolean result = earth.addSatellite(sun);

        System.out.println(
                "    Planet does not accept non-moon satellite: " +
                        (!result ? "PASSED ✓" : "FAILED ✗")
        );
        assert !result;
    }

    private static void testSetDoesNotOverwriteValueWithDuplicate() {
        double originalOrbitalPeriod = solarSystem.get("Pluto").getOrbitalPeriod();
        Planet pluto2 = new Planet("Pluto", 842);
        planets.add(pluto2);
        double newOrbitalPeriod = solarSystem.get("Pluto").getOrbitalPeriod();

        System.out.println(
                "    Set doesn't overwrite vaue with duplicate: " +
                        (originalOrbitalPeriod == newOrbitalPeriod ? "PASSED ✓" : "FAILED ✗")
        );
        assert originalOrbitalPeriod == newOrbitalPeriod;
    }

    private static void testSetDoesNotAcceptHeavenlyBodyOfSameNameAndSubclass() {
        int initialSize = planets.size();
        planets.add(new Planet("Pluto", 842));

        System.out.println(
                "    Set doesn't accept HeavenlyBody of same name and subclass: " +
                        (initialSize == planets.size()
                                ? "PASSED ✓"
                                : "FAILED ✗")
        );
        assert initialSize == planets.size();
    }

    private static void testSetAcceptsHeavenlyBodyOfSameNameAndDifferentSubclass() {
        Set<HeavenlyBody> testSet = new HashSet<>();
        Moon betaMinorMoon = new Moon("BetaMinor", 333);
        testSet.add(betaMinorMoon);
        Star betaMinorStar = new Star("BetaMinor", 999_999_999);
        testSet.add(betaMinorStar);

        System.out.println(
                "    Set accepts HeavenlyBody of same name and different subclass: " +
                        (testSet.size() == 2 ? "PASSED ✓" : "FAILED ✗")
        );
        assert testSet.size() == 2;
    }

//    // TODO
//    private static void testMapOverwritesValueWithDuplicate() {
//        System.out.println(
//                "    : " +
//                        (1 == 2 ? "PASSED ✓" : "FAILED ✗")
//        );
//        assert 1 == 2;
//    }

//    // TODO
//    private static void testCanRetrieveHeavenlyBodiesOfSameNameAndDifferentSubclassFromMap() {
//        System.out.println(
//                "    : " +
//                        (1 == 2 ? "PASSED ✓" : "FAILED ✗")
//        );
//        assert 1 == 2;
//    }

//    // TODO
//    private static void testEqualsIsSymmetric() {
//        System.out.println(
//                "    : " +
//                        (1 == 2 ? "PASSED ✓" : "FAILED ✗")
//        );
//        assert 1 == 2;
//    }

}
