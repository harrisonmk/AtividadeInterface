
package projeto;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import modelo.Contrato;
import modelo.Prestacao;
import servicos.ContratoServico;
import servicos.PagamentoServico;


public class Main {


    public static void main(String[] args) {
        
       Scanner scan = new Scanner(System.in);
       DecimalFormat deci = new DecimalFormat("0.00");
       DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       
       System.out.println("Entre com os dados do contrato:");
       System.out.print("Numero: ");
       int numero = scan.nextInt();
       System.out.print("Data (dd/MM/yyyy): ");
       LocalDate data = LocalDate.parse(scan.next(), fmt);  // converte o tipo lido para Data e formata
       System.out.print("Valor do contrato: "); 
       double valorTotal = scan.nextDouble();
       
       Contrato contrato = new Contrato(numero,data,valorTotal);
       
       System.out.print("Entre com o numero de parcelas: ");
       int n = scan.nextInt();
       
       
       ContratoServico contratoServico = new ContratoServico(new PagamentoServico());
       
       
       contratoServico.processoContrato(contrato, n);
       
       System.out.println("Parcelas:");
       for(Prestacao prestacao : contrato.getPrestacoes()){
           System.out.println(prestacao);
       }
        
        
       scan.close();
    }
    
}
