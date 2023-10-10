package OOPHomework5.presenters;

import OOPHomework5.models.Table;
import OOPHomework5.models.TableModel;
import OOPHomework5.views.BookingView;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Model model;
    private View view;
    private Date reservationDate;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    private Collection<Table> loadTables(){
        return model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateUIShowTables(){
        view.showTables(loadTables());
    }

    /**
     * Отобразить результат бронирования на представлении
     * @param reservationId результат бронирования
     * * @param tableNo номер столика, который был забронирован
     */
    private void updateUIShowReservationResult(int reservationId, int tableNo){
        view.showReservationTableResult(reservationId, tableNo);
    }

    /**
     * Отобразить результат перебронирования на представлении
     * @param reservationId результат бронирования
     * @param oldTableNo номер прошлого столика
     * @param newTableNo номер нового столика
     */
    private void updateUIShowReservationResultAgain(int reservationId, int oldTableNo, int newTableNo){
        view.showReservationTableResultAgain(reservationId, oldTableNo, newTableNo);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationResult(reservationNo, tableNo);
        }
        catch (RuntimeException e){
            updateUIShowReservationResult(-1, -1);
        }
    }

        /**
     * Произошло событие, пользователь нажал на кнопку смены столика
     * @param reservationDate дата резерва
     * @param oldReservation прошлая бронь
     * @param oldTableNo номер прошлого столика
     * @param newTableNo номер нового столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTableAgain(Date reservationDate, int oldReservation, int oldTableNo, int newTableNo, String name) {
        this.reservationDate = reservationDate;
        try {
            int reservationNo = model.changeReservationTable(oldReservation, reservationDate, oldTableNo, newTableNo, name)-1;
            updateUIShowReservationResultAgain(reservationNo, oldTableNo, newTableNo);
        }
        catch (RuntimeException e){
            updateUIShowReservationResult(-1, -1);
        }
    }
}
