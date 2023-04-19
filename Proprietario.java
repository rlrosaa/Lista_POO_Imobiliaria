import java.util.ArrayList;

public class Proprietario {

    private ArrayList<Imovel> imoveisProprietario;
    private double somaAluguelTotal;
    private double somaAluguelLiquido;

    public Proprietario(){
        inicializar();
    }

    public Proprietario(Imovel imovel){
        inicializar();
        addImovel(imovel);
    }

    private void inicializar() {
        this.somaAluguelLiquido = this.somaAluguelTotal = 0;
        imoveisProprietario = new ArrayList<>();
    }

    public void addImovel(Imovel imovel){
        imoveisProprietario.add(imovel);
        atualizaSomasValor(imovel.getValorAluguel(), imovel.getValorAluguel()- imovel.getValorAluguelImobiliaria());
    }

    public void removeImovel(Imovel imovel){
        imoveisProprietario.remove(imovel);
        atualizaSomasValor(0-imovel.getValorAluguel(),0 - (imovel.getValorAluguel()- imovel.getValorAluguelImobiliaria()));
    }

    private void atualizaSomasValor(double aluguel, double aluguelLiquido){
        this.somaAluguelTotal += aluguel;
        this.somaAluguelLiquido+= aluguelLiquido;
    }

    /**
     * Retorna a soma do valor total dos alugueis de todos os imoveis de um proprietario.
     * @return
     */
    public double getSomaAluguelTotal(){
        return somaAluguelTotal;
    }

    /**
     * Retorna a soma do valor que é recebido dos alugueis de todos os imoveis de um proprietario.
     * @return
     */
    public double getSomaAluguelLiquido(){
        return somaAluguelLiquido;
    }
    
}
