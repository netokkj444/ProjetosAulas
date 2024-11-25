package Aulas.Excecoes.TratamentodeUmProblema01;

import Aulas.Excecoes.TratamentodeUmProblema01.Entites.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        boolean test = true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Room number: ");
        int numberRoom = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: check-out date must be after check-in date.");
            test = false;
        } else {
            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println("Reservation " + reservation);
            System.out.println();

            System.out.println("Enter data uptade the reservasion: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());
            Date now = new Date();

            System.out.println("fala ai");
            sc.close();
        }
    }
}
