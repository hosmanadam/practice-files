package com.timbuchalka;

public final class Star extends HeavenlyBody {

    public Star(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.STAR);
    }

}
