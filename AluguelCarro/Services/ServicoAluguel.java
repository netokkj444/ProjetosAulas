package Aulas.Interfaces.AluguelCarro.Services;

import Aulas.Interfaces.AluguelCarro.Entites.AluguelCarro;
import Aulas.Interfaces.AluguelCarro.Entites.Fatura;

public class ServicoAluguel {
    private Double priceperHour;
    private Double priceperDay;
    private BrazilTax brazilTax;

    public ServicoAluguel(Double priceperHour, Double priceperDay, BrazilTax brazilTax) {
        this.priceperHour = priceperHour;
        this.priceperDay = priceperDay;
        this.brazilTax = brazilTax;
    }

    public void processInvoice(AluguelCarro aluguelCarro){
        aluguelCarro.setFatura(new Fatura(priceperHour,priceperDay));
    }
}
