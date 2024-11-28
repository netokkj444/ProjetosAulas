package Aulas.Excecoes.TratamentodeUmProblema01.Entites;

import Aulas.Excecoes.TratamentodeUmProblema01.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private int id;

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut, String name, int id) throws DomainException {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.name = name;
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if ((checkIn.before(now)) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for updates must be future");
        }
        this.checkOut = checkOut;
        this.checkIn = checkIn;
    }

    @Override
    public String toString() {
        return "\nName: " +
                name +
                " \nroom number: " +
                roomNumber +
                "\ncheck-in: " +
                sdf.format(checkIn) +
                "\ncheck-out: " +
                sdf.format(checkOut) +
                " \nnights: " + duration() +
                "\nid: " + getId();
    }
}