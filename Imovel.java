
public abstract class Imovel {

    double valorVenda, percentualCalcAluguel, descontoAluguel, acrescimoBeneficio;
    double valorAluguel, taxasServico, ValorAluguelImobiliaria,valorTotalImovel;
    final static double DESCONTO_MAX = 0.3 , COMISSAO_IMOBILIARIA = 0.12;
    String endereco;
    int anoConstrucao;

 
    protected abstract double valorServico();

    public Imovel(String endereco, int anoConstrucao, double valorVenda, double acrescimoBeneficio , double taxasServico,
    double percentualCalcAluguel , double descontoAluguel){

    }

    private void atualizaAlugueis(){
        calculaAluguel();
        calculaAluguelImobiliaria();
        calculaValorTotalImovel();
    }

    private void calculaAluguel(){
        this.valorAluguel = (valorVenda * percentualCalcAluguel) + acrescimoBeneficio;
    }

    private void calculaAluguelImobiliaria(){
        this.ValorAluguelImobiliaria = this.valorAluguel * COMISSAO_IMOBILIARIA;
    }

    private void calculaValorTotalImovel(){
        this.ValorAluguelImobiliaria = this.valorAluguel + taxasServico;
    }

    /**
     * Inserir valor do aluguel relacionado a beneficios do imovel. Apenas valores maior que zero são validos.
     * Caso um valor invalido for inserido, o valor referente ao beneficio não será atualizado.
     * @param valorBeneficio
     */
    public void atualizarAcrescimoBeneficio (double valorBeneficio){
        if (valorBeneficio>0){
            this.acrescimoBeneficio = valorBeneficio;
            atualizaAlugueis();
        }
    }

    // Metodos SET
    /**
     * Atualizar o valor de venda do imovel.
     * Apenas valores maiores que zero são validos. Caso seja inserido um valor invalido, não haverá atualização.
     * @param valorVenda
     */
    public void setValorVenda(double valorVenda){
        if (valorVenda>0){
            this.valorVenda = valorVenda;
            atualizaAlugueis();
        }
    }
    /** 
     * Atualizar Endereço do imovel.
     *Caso seja inserido um valor invalido, não haverá atualização.
     * @param endereco
     */
    public void setEndereco(String endereco){
        if(!endereco.isEmpty()){
            this.endereco = endereco;
        }
    }
    
    /**
     * Atualizar Ano de Construção do imovel.
     * Apenas valores maior que 1800 são validos. Caso seja inserido um valor invalido, não haverá atualização.
     * @param anoConstrucao
     */
    public void setAnoConstrucao(int anoConstrucao){
        if (anoConstrucao>1800){
            this.anoConstrucao = anoConstrucao;
        }
    }

    // Metodos GET
    /**
     * Retornona o valor do aluguel refente ao Imovel.
     * @return
     */
    public double getValorAluguel(){
        return this.valorAluguel;
    }

    /**
     * Retorna o valor do percentual do aluguel que é a comissão da imobiliaria.
     * @return
     */
    public double getValorAluguelImobiliaria(){
        return this.getValorAluguel();
    }

    /**
     * Retona o valor todo pago no Imovel, incluindo as taxas de serviço.
     * @return
     */
    public double getValorTotalImovel(){
        return this.valorTotalImovel;
    }

}


