package Utility;

public class BrowserUtility {
    public static void wait(int sec) {

        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}