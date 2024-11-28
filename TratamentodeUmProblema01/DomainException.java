package Aulas.Excecoes.TratamentodeUmProblema01;

public class DomainException extends RuntimeException {
    /* diference of runtimeException by Exception is what the compiler no obliges to treat */
    public  DomainException(String msg){
        super(msg);
    }
}
