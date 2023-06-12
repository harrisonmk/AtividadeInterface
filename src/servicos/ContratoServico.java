package servicos;

import java.time.LocalDate;
import modelo.Contrato;
import modelo.Prestacao;

public class ContratoServico {

    private PagamentoOnlineServico pagamentoOnlineServico;

    public ContratoServico(PagamentoOnlineServico pagamentoOnlineServico) {
        this.pagamentoOnlineServico = pagamentoOnlineServico;
    }

    public void processoContrato(Contrato contrato, int meses) {

        double basicQuota = contrato.getValorTotal() / meses;
        
        for (int i = 1; i <= meses; i++) {
            LocalDate dueDate = contrato.getData().plusMonths(i);//adiciona meses
            
            double interesse = pagamentoOnlineServico.interesse(basicQuota, i);
            double taxa = pagamentoOnlineServico.pagamentoGratis(basicQuota + interesse);
            double quota = basicQuota + interesse + taxa;
            
            contrato.getPrestacoes().add(new Prestacao(dueDate,quota));
            

        }

    }

}
