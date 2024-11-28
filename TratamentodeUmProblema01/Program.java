package Aulas.Excecoes.TratamentodeUmProblema01;

import Aulas.Excecoes.TratamentodeUmProblema01.Entites.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean test = true;
        int numberRoom = 0;
        Random random = new Random();
        Date checkOut;
        Date checkIn;
        int id =  random.nextInt(0,1000);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("What's your name? ");
        String name  = sc.next();
        System.out.print("Room number: ");
        numberRoom = sc.nextInt();
        do {
            try {
                test = true;
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());

                Reservation reservation = new Reservation(numberRoom, checkIn, checkOut, name,id);
                System.out.println("Reservation " + reservation);
            } catch (ParseException e) {
                System.out.println("Invalid date");
                test = false;
            } catch (DomainException e) {
                System.out.println(e.getMessage());
                test = false;
            }
        } while (test != true);

        do {
            try {
                test = true;
                System.out.println();
                System.out.println("Enter data uptade the reservasion: ");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());
                Reservation reservation = new Reservation(numberRoom, checkIn, checkOut,name,id);
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation " + reservation);
            } catch (ParseException e) {
                System.out.println("Invalid date format");
                test = false;
            } catch (DomainException e) {
                System.out.println("Error in reservation: " + e.getMessage());
                test = false;
            } catch (RuntimeException e){
                System.out.println("Unexpected error");
            }
        } while (test != true);
        sc.close();
    }
}

