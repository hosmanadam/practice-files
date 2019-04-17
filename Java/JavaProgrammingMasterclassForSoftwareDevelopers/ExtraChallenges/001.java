public class SpeedConverter {

    public static long toMilesPerHour(double kilometeresPerHour) {
        if (kilometeresPerHour < 0) {
            return -1;
        } else {
            return Math.round(kilometeresPerHour / 1.609);
        }
    }
    
    public static void printConversion(double kilometeresPerHour) {
        long milesPerHour = toMilesPerHour(kilometeresPerHour);
        if (milesPerHour == -1) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometeresPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }
    
}
