import java.util.ArrayList;

public class Imobiliaria {
    ArrayList<Imovel> imoveisImobiliaria;
    double ganhoTotal;
    
    /** Cria o objeto Imobiliaria sem adicionar nenhum imovel na lista. O valor de ganho total é estabelicido como ZERO */
    public Imobiliaria (){
        inicializar();
    }

    /** Cria o objeto Imobiliaria já adicionando o imovel selecionado na lista. O valor de aluguel do imovel é somado ao ganho total da imobiliaria.
     * 
     * @param imovel
     */
    public Imobiliaria (Imovel imovel){
        inicializar();
        addImovel(imovel);
    }

    /**
     * Metódo para adicionar um novo Imovel na lista de imoveis da Imobiliaria. 
     * @param imovel
     */
    public void addImovel(Imovel imovel){
        imoveisImobiliaria.add(imovel);
        atualizarValorTotal(imovel.getValorAluguelImobiliaria());
    }

    private void inicializar(){
        imoveisImobiliaria = new ArrayList<>();
        ganhoTotal = 0;
    }

    private void atualizarValorTotal (double valorAluguel){
        this.ganhoTotal += valorAluguel;
    }
}