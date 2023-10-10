package OOPHomework5.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    void onReservationTableAgain(Date reservationDate, int oldReservation, int oldTableNo, int newTableNo, String name);

}
