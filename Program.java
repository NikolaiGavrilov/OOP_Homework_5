import OOPHomework5.models.TableModel;
import OOPHomework5.presenters.BookingPresenter;
import OOPHomework5.presenters.Model;
import OOPHomework5.presenters.View;
import OOPHomework5.views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Model tableModel = new TableModel();
        View bookingView = new BookingView();
        BookingPresenter presenter = new BookingPresenter(tableModel, bookingView);
        presenter.updateUIShowTables();
        bookingView.reservationTable(new Date(), 2, "Станислав");
        presenter.updateUIShowTables();
        bookingView.changeReservationTable(1001, new Date(), 2, 3, "Станислав");
        presenter.updateUIShowTables();

    }

}
