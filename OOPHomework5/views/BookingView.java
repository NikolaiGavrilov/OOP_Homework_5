package OOPHomework5.views;

import OOPHomework5.models.Table;
import OOPHomework5.presenters.View;
import OOPHomework5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationId, int tableNo) {
        if (reservationId > 0){
            System.out.printf("Столик №%d успешно забронирован. Номер вашей брони: #%d\n", tableNo, reservationId);
        }
        else {
            System.out.println("Не удалось забронировать столик. Попробуйте повторить операцию позже.");
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name){
        observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * Действие клиента (пользователь решил поменять столик)
     * Отменить резерв столика, забронировать другой столик
     * @param oldReservation старый номер брони
     * @param reservationDate дата бронирования
     * @param oldTableNo номер прошлого столика
     * @param newTableNo номер нового столика
     * @param name имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int oldTableNo, int newTableNo, String name){
        System.out.println("Вы поменяли столик на другой. Бронь за предыдущий столик аннулирована.");
        observer.onReservationTableAgain(reservationDate, oldTableNo, newTableNo, name);
    }

}
