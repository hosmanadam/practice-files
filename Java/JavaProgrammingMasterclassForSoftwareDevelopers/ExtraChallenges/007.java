public class TeenNumberChecker {

    public static boolean hasTeen(int a, int b, int c) {
        if (isTeen(a) || isTeen(b) || isTeen(c)) {
            return true;
        }
        return false;
    }

    public static boolean isTeen(int age) {
        if (age > 12 && age < 20) {
            return true;
        }
        return false;
    }

}
