package OOPHomework5.models;

import java.util.Date;


public class Reservation {

    private static int counter = 1000;

    private final int id;

    public int getId() {
        return id;
    }

    public int getSameId(int oldId) {
        return oldId;
    }

    private Date date;

    private String name;

    {
        id = ++counter;
    }


    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }
}
