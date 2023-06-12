
package modelo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Prestacao {
    
    private static DecimalFormat deci = new DecimalFormat("0.00");
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate date;
    private Double quantia;
    
    

    public Prestacao(LocalDate date, Double quantia) {
        this.date = date;
        this.quantia = quantia;
    }

    public Prestacao() {
    }

    
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getQuantia() {
        return quantia;
    }

    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }

    @Override
    public String toString() {
        return date.format(fmt) + " - "+ deci.format(quantia);
    }
    
    
    
    
    
    
}
