package OOPHomework5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {


    private static int counter;

    private final int no;

    private boolean bookingStatus = true;

    private final Collection<Reservation> reservations = new ArrayList<>();

    public int getNo() {
        return no;
    }

    public boolean getBookingStatus() {
        return bookingStatus;
    }

    public void setNewBookingStatus() {
        if (getBookingStatus() == true) bookingStatus = false;
        else if (getBookingStatus() == false) bookingStatus = true;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    {
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d. Сейчас свободен: %b", no, bookingStatus);
    }

}
