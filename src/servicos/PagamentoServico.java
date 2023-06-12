
package servicos;


public class PagamentoServico implements PagamentoOnlineServico {

    
    @Override
    public double pagamentoGratis(double quantia) {
        return quantia * 0.02;
    }

    @Override
    public double interesse(double quantia, int meses) {
        return quantia * 0.01 * meses;
        
    }
    
    
    
    
}
