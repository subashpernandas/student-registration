package com.tech.subash.volatil;

/*        Feature                      | `volatile int` | `AtomicInteger` | `synchronized` |
        | ---------------------------- | -------------- | --------------- | -------------- |
        | Visibility                   | ✅ Yes          | ✅ Yes           | ✅ Yes      |
        | Atomicity (e.g. `++`)        | ❌ No           | ✅ Yes           | ✅ Yes      |
        | Performance (low contention) | ✅ Fast         | ✅ Fast          | ⚠️ Slower   |
        | Use for counters?            | ❌ No           | ✅ Yes           | ✅ Yes      |

*/

public class VolatileDemo {

    // It could be either volatile or Atmoic
    // private static Cricketer cricketer = new Cricketer(new AtomicBoolean(false));
    private static  volatile Cricketer cricketer = new Cricketer(false);

    public static void main(String[] args) throws InterruptedException {

        Thread batter = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            cricketer.setBatterReady(true);
            /*AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            cricketer.setBatterReady(atomicBoolean);*/
            System.out.println("Batter Flag  Set " + cricketer.isBatterReady());
        });

        Thread bowler = new Thread(() -> {
            while (!cricketer.isBatterReady()) {
                //System.out.println("Reader thread detected flag "+ flag);
            }
            System.out.println("Bowler Flag Set " + cricketer.isBatterReady());
        });

        System.out.println("Initial Flag Set " + cricketer.isBatterReady());

        batter.start();
        bowler.start();


        batter.join();
        bowler.join();
    }
}

