public class Main {
    public static void main(String[] args) throws InterruptedException {
        // creates a vector of station and track segments
        // which continually prints to console
        RailRoute railRoute = new RailRoute();
        railRoute.start();

        // Creates five new train threads.
        Thread myThreads[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            myThreads[i] = new Train("fast", railRoute, i + 1 + "");
            myThreads[i].start();
            Thread.sleep(1000);
        }
    }
}