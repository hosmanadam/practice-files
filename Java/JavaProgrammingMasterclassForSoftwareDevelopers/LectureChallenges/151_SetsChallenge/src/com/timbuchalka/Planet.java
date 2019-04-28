package com.timbuchalka;

public final class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "Planet");
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite instanceof Moon)
            return super.addSatellite(satellite);
        return false;
    }

}
