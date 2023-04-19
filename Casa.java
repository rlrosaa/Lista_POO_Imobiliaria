public class Casa extends Imovel {

    final static double PERCENTUAL_CALC_CASA = 0.005;
    final static double TAXA_DESCONTO_CASA = 0.1;
    private double seguroIncendio;
    private double valorTotalAPagar;

    /**
     * Cria um novo apartamento como obejto. 
     * Caso o valor de venda inserirdo seja invalido, será considerado um valor de R$200.000,00.
     * Caso o ano de Construção inserido seja invalido (menor que 1800), será considerado o ano de 1800.
     * Caso o valor de taxa de incencio inserido seja invalido, a taxa será considerada 0.
     * @param endereco
     * @param anoConstrucao
     * @param valorVenda
     * @param acrescimoBeneficio
     * @param condominio
     */
    public Casa(String endereco, int anoConstrucao, double valorVenda, double acrescimoBeneficio , double seguroIncendio){
        super(endereco,anoConstrucao,valorVenda,acrescimoBeneficio,PERCENTUAL_CALC_CASA,TAXA_DESCONTO_CASA);
        inicializar(seguroIncendio);
    }      
    
    
    private void inicializar(double seguroIncendio) {
        if(seguroIncendio<0){
            seguroIncendio = 0 ;
        }
        atualizaSeguroIncendio(seguroIncendio);
        valorServico();
    }


    /**
     * Atualizar o valor do Seguro Incendio da  Casa.
     * Apenas valores maiores ou iguais a zero são validos. Caso seja inserido um valor invalido, não haverá atualização.
     * @param condominio
     */
     public void atualizaSeguroIncendio(double seguroIncendio){
        if(seguroIncendio>=0){
            this.seguroIncendio = seguroIncendio;
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
        double valorServico = this.seguroIncendio / 12;
        this.valorTotalAPagar = getValorAluguel() + valorServico;
        return valorServico;
    }
    
}
