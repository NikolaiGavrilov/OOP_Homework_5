package OOPHomework5.models;

import OOPHomework5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;
    private Collection<Reservation> reservations;

    /**
     * Получение списка всех столиков
     */
    @Override
    public Collection<Table> loadTables() {

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }


    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param name Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table: loadTables()) {
            if (table.getNo() == tableNo){
                table.setNewBookingStatus();
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw  new RuntimeException("Некорректный номер столика.");
    }

    /**
     * Смена забронированного столика на столик с другим номером
     * @param oldReservation
     * @param reservationDate
     * @param oldTableNo номер прошлого столика
     * @param newTableNo номер нового столика
     * @param name
     * @return
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int oldTableNo, int newTableNo, String name){
        for (Table tableOld: loadTables()) {
            if (tableOld.getNo() == oldTableNo){ 
                    tableOld.setNewBookingStatus();
            }
        }
        for (Table table: loadTables()) {
            if (table.getNo() == newTableNo){
                table.setNewBookingStatus();
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }

        throw  new RuntimeException("Некорректный номер столика.");
    }
}

