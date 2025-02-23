/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package three;

import java.util.concurrent.CountDownLatch;

/**
 * @author Aleksandr_Berestov
 */
public class Main {

    private static int i1;
    private static int i2;

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(100);

        for (int i = 0; i < 100_000; i++) {

            latch.countDown();
            i1++;
            i2++;
        }

    }

}