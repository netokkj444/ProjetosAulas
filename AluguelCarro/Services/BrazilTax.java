package Aulas.Interfaces.AluguelCarro.Services;

public class BrazilTax {
    public double taxServices(double amount){
        if (amount <= 100){
            return amount * 0.2;
        } else {
            return amount * 0.15;
        }
    }
}
