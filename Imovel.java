import java.util.Calendar;

public abstract class Imovel {

    private double valorVenda;
    private double percentualCalcAluguel;
    private double taxaDesconto;
    private double descontoAluguel;
    private double acrescimoBeneficio;
    private double valorAluguel;
    private double ValorAluguelImobiliaria;
    final static double DESCONTO_MAX = 0.3;
    final static double COMISSAO_IMOBILIARIA = 0.12;
    String endereco;
    int anoConstrucao;

    protected abstract double valorServico();

    public Imovel(String endereco, int anoConstrucao, double valorVenda, double acrescimoBeneficio,
    double percentualCalcAluguel , double taxaDesconto){

        inicializar(endereco,anoConstrucao,valorVenda,acrescimoBeneficio,percentualCalcAluguel,taxaDesconto);

    }

    private void inicializar(String endereco, int anoConstrucao, double valorVenda, double acrescimoBeneficio,
            double percentualCalcAluguel, double taxaDesconto) {
            
        this.endereco = endereco;
        if (anoConstrucao >1800){
            this.anoConstrucao = anoConstrucao;
        }
        else{
            this.anoConstrucao = 1800;
        }

        if(valorVenda<=0){
            valorVenda = 200000;
        }
        this.valorVenda = valorVenda;
        this.acrescimoBeneficio = acrescimoBeneficio;
        this.percentualCalcAluguel = percentualCalcAluguel;
        this.taxaDesconto = taxaDesconto;
        atualizaAlugueis();
        
    }

    private void calculaDesconto() {
        Calendar data = Calendar.getInstance();
        int anoAtual = data.get(Calendar.YEAR);

        double desconto = ((anoAtual - this.anoConstrucao) / 5) * this.taxaDesconto;

        if (desconto > DESCONTO_MAX) {
            desconto = DESCONTO_MAX;
        }

        this.descontoAluguel = desconto;
    }

    private void atualizaAlugueis() {
        calculaDesconto();
        calculaAluguel();
        calculaAluguelImobiliaria();
    }

    private void calculaAluguel() {
        this.valorAluguel = ((valorVenda * percentualCalcAluguel) * (1-descontoAluguel)) + acrescimoBeneficio;
    }

    private void calculaAluguelImobiliaria() {
        this.ValorAluguelImobiliaria = this.valorAluguel * COMISSAO_IMOBILIARIA;
    }

    /**
     * Inserir valor do aluguel relacionado a beneficios do imovel. Apenas valores
     * maior que zero são validos.
     * Caso um valor invalido for inserido, o valor referente ao beneficio não será
     * atualizado.
     * 
     * @param valorBeneficio
     */
    public void atualizarAcrescimoBeneficio(double valorBeneficio) {
        if (valorBeneficio > 0) {
            this.acrescimoBeneficio = valorBeneficio;
            atualizaAlugueis();
        }
    }

    // Metodos SET
    /**
     * Atualizar o valor de venda do imovel.
     * Apenas valores maiores que zero são validos. Caso seja inserido um valor
     * invalido, não haverá atualização.
     * 
     * @param valorVenda
     */
    public void setValorVenda(double valorVenda) {
        if (valorVenda > 0) {
            this.valorVenda = valorVenda;
            atualizaAlugueis();
        }
    }

    /**
     * Atualizar Endereço do imovel.
     * Caso seja inserido um valor invalido, não haverá atualização.
     * 
     * @param endereco
     */
    public void setEndereco(String endereco) {
        if (!endereco.isEmpty()) {
            this.endereco = endereco;
        }
    }

    /**
     * Atualizar Ano de Construção do imovel.
     * Apenas valores maior que 1800 são validos. Caso seja inserido um valor
     * invalido, não haverá atualização.
     * 
     * @param anoConstrucao
     */
    public void setAnoConstrucao(int anoConstrucao) {
        if (anoConstrucao > 1800) {
            this.anoConstrucao = anoConstrucao;
            calculaAluguel();
        }
    }

    // Metodos GET
    /**
     * Retornona o valor do aluguel refente ao Imovel.
     * 
     * @return
     */
    public double getValorAluguel() {
        return this.valorAluguel;
    }

    /**
     * Retorna o valor do percentual do aluguel que é a comissão da imobiliaria.
     * 
     * @return
     */
    public double getValorAluguelImobiliaria() {
        return this.ValorAluguelImobiliaria;
    }

}
