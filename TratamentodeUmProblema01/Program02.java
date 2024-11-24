package Aulas.Excecoes.TratamentodeUmProblema01;

import Aulas.Excecoes.TratamentodeUmProblema01.Entites.Reservation;
import Aulas.Excecoes.TratamentodeUmProblema01.Entites.Reservation02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program02 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        boolean test = true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Room number: ");
        int n = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checKin2 = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut2 = sdf.parse(sc.next());

        if (!checkOut2.after(checKin2)) {
            System.out.println("Error in reservation: check-out date must be after check-in date.");
            test = false;
        } else {
            Reservation02 reservation02 = new Reservation02(n,checKin2,checkOut2);
            System.out.println("Reservation " + reservation02);
            System.out.println();

            System.out.println("Enter data uptade the reservasion: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut= sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: check-out date must be after check-in date.");
            } else {
                reservation02.up
            }

            sc.close();
        }
    }
}
