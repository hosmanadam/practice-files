public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        int originalNumber = number;
        int reverseCollector = 0;
        do {
            reverseCollector *= 10;
            reverseCollector += number % 10;
            number /= 10;
        } while (number > 0);
        return (reverseCollector == originalNumber);
    }

}
