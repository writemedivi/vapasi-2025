import java.util.logging.Logger;


public class BookingRequest implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(BookingRequest.class.getName());
    private final int requestNumber;

    BookingRequest(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    @Override
    public void run() {
        String threadName = String.valueOf(Thread.currentThread().getName());
        LOGGER.info("Booking received for request- " + requestNumber + " and thread " + threadName + "' is handling.");
        processPaymentRequest();
        LOGGER.info("Ticket Confirmed for request- " + requestNumber + " is completed by thread " + threadName + "' ");

    }

    void processPaymentRequest() {
        String threadName = Thread.currentThread().getName();

        try {
            LOGGER.info("Payment" + " is processing for request - " + requestNumber + " and thread " + threadName + "' is handling.");
            Thread.sleep(5000); // simulate delay
            LOGGER.info("Payment" + " process for request - " + requestNumber + " is completed by thread " + threadName + "' ");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe("Payment" + " for request : " + requestNumber + " got interrupted." + threadName);
        }
    }

}
