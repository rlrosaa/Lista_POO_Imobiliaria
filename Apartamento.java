public class Apartamento extends Imovel {

    final static double PERCENTUAL_CALC_APTO = 0.004;
    final static double TAXA_DESCONTO_APTO = 0.05;
    double condominio=0;

    
    public Apartamento(String endereco, int anoConstrucao, double valorVenda, double acrescimoBeneficio , double condominio){
        
        super(endereco, anoConstrucao,valorVenda,acrescimoBeneficio,0,PERCENTUAL_CALC_APTO,TAXA_DESCONTO_APTO);

    }      
    
    
    /**
     * Atualizar o valor do condominio do apartamento.
     * Apenas valores maiores que zero são validos. Caso seja inserido um valor invalido, não haverá atualização.
     * @param condominio
     */
     public void atualizaCondominio(double condominio){
        if(condominio>0){
            this.condominio = condominio;
        }
    }

    @Override
    protected double valorServico() {
        return condominio;
    }
    
}
