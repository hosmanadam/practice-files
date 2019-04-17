public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (((temperature > 24) && (temperature < 36))
               || ((summer == true) && (temperature > 24) && (temperature < 46))) {
            return true;
        }
        return false;
    }
}
