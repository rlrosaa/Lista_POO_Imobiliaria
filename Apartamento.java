public class Apartamento extends Imovel {

    final static double PERCENTUAL_CALC_APTO = 0.004;
    final static double TAXA_DESCONTO_APTO = 0.05;
    private double condominio;
    private double valorTotalAPagar;

    /**
     * Cria um novo apartamento como obejto. 
     * Caso o valor de venda inserirdo seja invalido, será considerado um valor de R$200.000,00.
     * Caso o ano de Construção inserido seja invalido (menor que 1800), será considerado o ano de 1800.
     * Caso o valor de condominio inserido seja invalido, a taxa será considerada 0.
     * @param endereco
     * @param anoConstrucao
     * @param valorVenda
     * @param acrescimoBeneficio
     * @param condominio
     */
    public Apartamento(String endereco, int anoConstrucao, double valorVenda, double acrescimoBeneficio , double condominio){
        super(endereco,anoConstrucao,valorVenda,acrescimoBeneficio,PERCENTUAL_CALC_APTO,TAXA_DESCONTO_APTO);
        inicializar(condominio);
    }      
    
    
    private void inicializar(double condominio) {
        if(condominio<0){
            condominio = 0 ;
        }
        atualizaCondominio(condominio);
        valorServico();
    }


    /**
     * Atualizar o valor do condominio do apartamento.
     * Apenas valores maiores ou iguais a zero são validos. Caso seja inserido um valor invalido, não haverá atualização.
     * @param condominio
     */
     public void atualizaCondominio(double condominio){
        if(condominio>=0){
            this.condominio = condominio;
        }
    }

    /**
     * Retona o valor todo pago no Imovel, incluindo as taxas de serviço.
     * @return
     */
    public double getValorTotalAPagar(){
        return this.valorTotalAPagar;
    }
    
    @Override
    /**
     * Atualizar o valor total a pagar e retorna o valor referente aos serviços de condominio.
     * @return
     */
    protected double valorServico() {
        double valorServico = this.condominio;
        this.valorTotalAPagar = getValorAluguel() + valorServico;
        return valorServico;
    }
    
}
