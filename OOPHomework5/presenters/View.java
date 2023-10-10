package OOPHomework5.presenters;

import OOPHomework5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     *  * @param tableNo номер столика
     */
    void showReservationTableResult(int reservationId, int tableNo);

    /**
     * Отобразить результат перебронирования столика
     * @param reservationId номер брони
     * @param oldTableNo номер прошлого столика
     * @param newTableNo номер нового столика
     */
    void showReservationTableResultAgain(int reservationId, int oldTableNo, int newTableNo);

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * Установить наблюдателя для представления
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Действие клиента (смена забронированного столика)
     * @param oldReservation номер старой брони
     * @param orderDate дата бронирования
     * @param oldTableNo номер прошлого столика
     * @param newTableNo номер нового столика
     * @param name Имя
     */
    void changeReservationTable(int oldReservation, Date orderDate, int oldTableNo, int newTableNo, String name);

}
