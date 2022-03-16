package nsu.oop.spooky;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class  PrimeFind {
    public static boolean consequentSearch(List<Integer> arr) {
        System.out.print("Concurrent process - ");
        long startTime = System.currentTimeMillis();
        for (Integer l : arr) {
            if (PrimeCheck.isNotPrime(l)) {
                System.out.println(System.currentTimeMillis() - startTime);
                return true;
            }
        }
        System.out.println(System.currentTimeMillis() - startTime + " ms;");
        return false;
    }

    public static boolean threadSearch(List<Integer> arr, int threadsNumber) throws InterruptedException {
        System.out.print("Threaded parallel process - " + threadsNumber + " threads - ");
        long startTime = System.currentTimeMillis();
        AtomicBoolean res = new AtomicBoolean(false);
        List<Thread> threads = new ArrayList<>(threadsNumber);
        for (int i = 0; i < threadsNumber; i++) {
            int finalI = i;
            threads.add(new Thread() {
                public void run() {
                    for (int j = finalI; arr.size() > j; j = j + threadsNumber) {
                        if (PrimeCheck.isNotPrime(arr.get(j)) || res.get()) {
                            res.set(true);
                            break;
                        }
                    }
                }
            });
            threads.get(i).start();
        }
        for (int i = 0; i < threadsNumber; i++) {
            threads.get(i).join();
        }
        System.out.println(System.currentTimeMillis() - startTime + " ms;");
        return res.get();

    }

    public static boolean parallelSearch(List<Integer> arr) {
        System.out.print("Parallel stream - ");
        long startTime = System.currentTimeMillis();
        List<Integer> notPrimeList = arr.parallelStream().filter(PrimeCheck::isNotPrime).collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - startTime + " ms;");
        return !notPrimeList.isEmpty();
    }
}