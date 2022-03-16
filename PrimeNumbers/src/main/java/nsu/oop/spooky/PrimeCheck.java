package nsu.oop.spooky;

public class PrimeCheck {
    public static boolean isNotPrime(Integer n) {
        if (n == 1 || n == 2) {
            return false;
        }
        if ((n % 2) == 0) {
            return true;
        }
        for (int i = 3; ((long) i * i) <= n; i += 2) {
            if (n % i == 0) return true;
        }
        return false;
    }
}
