package Aulas.Interfaces.AluguelCarro;

import Aulas.Interfaces.AluguelCarro.Entites.AluguelCarro;
import Aulas.Interfaces.AluguelCarro.Entites.Veiculo;
import Aulas.Interfaces.AluguelCarro.Services.BrazilTax;
import Aulas.Interfaces.AluguelCarro.Services.ServicoAluguel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime inicio;
        LocalDateTime fim;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
        inicio = LocalDateTime.parse(sc.nextLine(),fmt);
        System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
        fim = LocalDateTime.parse(sc.nextLine(),fmt);
        AluguelCarro aluguelCarro = new AluguelCarro(inicio,fim,new Veiculo(modelo));

        System.out.print("Entre com o preço por hora: ");
        double precoHR = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double precoDIA = sc.nextDouble();

        ServicoAluguel servicoAluguel = new ServicoAluguel(precoDIA,precoHR,new BrazilTax());
        servicoAluguel.processInvoice(aluguelCarro);
        System.out.println("FATURA:");
        System.out.print("Pagamento básico: " + String.format("%.2f%n",aluguelCarro.getFatura().getPagamentoBasico()));
        System.out.print("Imposto: " + String.format("%.2f%n",aluguelCarro.getFatura().getTaxa()));
        System.out.print("Total: " + String.format("%.2f%n",aluguelCarro.getFatura().getPagamentoTotal()));

        sc.close();
    }
}
