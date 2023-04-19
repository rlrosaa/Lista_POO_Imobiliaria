public class appTeste {

    public static void main(String[] args) {
        
        Imobiliaria ceuLar = new Imobiliaria();
        Proprietario rafs = new Proprietario();
        Imovel casa1 = new Casa("Rua 1", 1990, 300000, 500, 1400);
        Imovel ape1 = new Apartamento("Rua 2", 2017, 250000, 150, 43);

        System.out.println(casa1.getValorAluguel());
        System.out.println(casa1.getValorAluguelImobiliaria());
        System.out.println(ape1.getValorAluguel());
        System.out.println(ape1.getValorAluguelImobiliaria());

        System.out.println(ceuLar.getGanhoTotal());
        System.out.println(rafs.getSomaAluguelTotal());

        ceuLar.addImovel(casa1);
        rafs.addImovel(casa1);

        System.out.println(ceuLar.getGanhoTotal());
        System.out.println(rafs.getSomaAluguelTotal());
        System.out.println(rafs.getSomaAluguelLiquido());
        System.out.println();

        ceuLar.addImovel(ape1);
        rafs.addImovel(ape1);

        System.out.println(ceuLar.getGanhoTotal());
        System.out.println(rafs.getSomaAluguelTotal());
        System.out.println(rafs.getSomaAluguelLiquido());
        System.out.println();

        ceuLar.removeImovel(ape1);
        rafs.removeImovel(ape1);

        System.out.println(ceuLar.getGanhoTotal());
        System.out.println(rafs.getSomaAluguelTotal());
        System.out.println(rafs.getSomaAluguelLiquido());
        System.out.println();




        
    }
    
}
