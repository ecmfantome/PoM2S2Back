package dev.unchk.platformm2po.internal.shared;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static String generateRegistrationNumber() {
        long number = ThreadLocalRandom.current().nextLong(0, 1_000_000_000_000L);
        return String.format("UNCK_%012d", number);
    }
}
