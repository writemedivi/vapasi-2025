import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TicketBookingSimulator {
    static final Logger LOGGER = Logger.getLogger(TicketBookingSimulator.class.getName());

    public static void main(String[] args) {
        int requestCount = getRequestCount();

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            for (int request = 1; request <= requestCount; request++) {
                executor.submit(new BookingRequest(request));
            }

        } catch (RuntimeException e) {
            LOGGER.severe(e.getMessage());
            throw new RuntimeException(e);
        }

        LOGGER.info("All requests finished processing" + requestCount);
    }

    private static int getRequestCount() {
        int requestCount ;
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.print("Enter booking request count : ");
            requestCount = userInput.nextInt();
            LOGGER.info("Total number of request received to book ticket : " + requestCount);
            return requestCount;

        }

    }
}
