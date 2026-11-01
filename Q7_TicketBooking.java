class TicketBooking {

    int availableSeats = 2;

    synchronized void bookSeat(String user, int seats) {

        if (availableSeats >= seats) {

            availableSeats -= seats;

            System.out.println(user +
                " booked " + seats + " seat(s) successfully");

        } else {

            System.out.println(user +
                " booking failed. Not enough seats");
        }
    }
}

class User1 extends Thread {

    TicketBooking booking;

    User1(TicketBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.bookSeat("User1", 1);
    }
}

class User2 extends Thread {

    TicketBooking booking;

    User2(TicketBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.bookSeat("User2", 2);
    }
}

public class Q7_TicketBooking {

    public static void main(String[] args)
            throws InterruptedException {

        TicketBooking booking = new TicketBooking();

        User1 u1 = new User1(booking);
        User2 u2 = new User2(booking);

        u1.start();
        u1.join();

        u2.start();
        u2.join();
    }
}