package Simulacao;

import Armazem.*;
import Veiculos.*;
import Produtos.*;
import Embalagens.*;
import Elementos.*;


/**
 * The Simulation class represents a simulation of a warehouse system.
 * It initializes the warehouse, vehicles, and products, and performs
 * a series of steps to simulate the movement and processing of items
 * within the warehouse.
 */
public class Simulation {
    private static Armazém armazem;
    private static AGC agc;
    private static ULC ulc;
    private static VeiculoRebocador veiculoRebocador;
    private static CarrinhoTransporte carrinhoTransporte;
    private Posicao posicao19_2, posicao19_4, posicao19_6, posicao10_5, posicao6_13, posicao17_8;
    private Saco saco1, saco2, saco3, saco4, saco5, saco6, saco7;
    private Caixa caixa1;
    private CaixaCartao caixaCartao1, caixaCartao2, caixaCartao3, caixaCartao4, caixaCartao5;
    private Palete palete1;


    /**
     * Performs step 2 of the simulation: creating products and adding them
     * to the appropriate storage locations in the warehouse.
     */
    public void step1() {
        ReadCSV.readAndProcessCSV();
        armazem = ReadCSV.getArmazem(); // Assign the armazem object to the instance variable
        armazem.visualizeArmazem();

        agc = ReadCSV.getAGC();
        ulc = ReadCSV.getULC();
        veiculoRebocador = ReadCSV.getVeiculoRebocador();
        carrinhoTransporte = ReadCSV.getCarrinhoTransporte();

        // create products
        Produto produto1 = new Produto("Carrinho Hot Wheels", 1, 0.7, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto2 = new Produto("Boneca Barbie", 2, 0.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto3 = new Produto("Sony PlayStation 5", 3, 4.5, TipoProduto.ELETRONICO_GRANDE);
        Produto produto4 = new Produto("Apple iPhone 12", 4, 0.5, TipoProduto.ELETRONICO_PEQUENO);
        Produto produto5 = new Produto("Samsung Smart TV 4K", 5, 15.0, TipoProduto.ELETRONICO_GRANDE);
        Produto produto6 = new Produto("Livro Dom Quixote", 6, 1.2, TipoProduto.LIVRO);
        Produto produto7 = new Produto("Calça Levi's 501", 7, 1.2, TipoProduto.ROUPA);
        Produto produto8 = new Produto("Canon EOS Rebel T7i", 8, 1.0, TipoProduto.ELETRONICO_PEQUENO);
        Produto produto9 = new Produto("Amazon Echo Dot", 9, 0.3, TipoProduto.ELETRONICO_PEQUENO);
        Produto produto10 = new Produto("Apple AirPods Pro", 10, 0.2, TipoProduto.ELETRONICO_PEQUENO);
        Produto produto11 = new Produto("LEGO Star Wars Millennium Falcon", 11, 3.0, TipoProduto.BRINQUEDO_GRANDE);
        Produto produto12 = new Produto("Casa dos Sonhos da Barbie", 12, 2.5, TipoProduto.BRINQUEDO_GRANDE);
        Produto produto13 = new Produto("Relógio de Pulso Casio", 13, 0.3, TipoProduto.ACESSORIO);
        Produto produto14 = new Produto("Casaco North Face", 14, 1.8, TipoProduto.ROUPA);
        Produto produto15 = new Produto("Óculos de Sol Ray-Ban", 15, 0.2, TipoProduto.ACESSORIO);
        Produto produto16 = new Produto("Mochila Nike", 16, 0.6, TipoProduto.ACESSORIO);


        // add products to the respective Local de Recolha
        armazem.getLocalRecolha(19, 2).addProduto(produto1);
        armazem.getLocalRecolha(19, 2).addProduto(produto2);
        armazem.getLocalRecolha(19, 2).addProduto(produto7);
        armazem.getLocalRecolha(19, 2).addProduto(produto13);
        armazem.getLocalRecolha(19, 2).addProduto(produto14);
        armazem.getLocalRecolha(19, 2).addProduto(produto15);
        armazem.getLocalRecolha(19, 2).addProduto(produto16);

        armazem.getLocalRecolha(19, 4).addProduto(produto6);

        armazem.getLocalRecolha(19, 6).addProduto(produto4);
        armazem.getLocalRecolha(19, 6).addProduto(produto8);
        armazem.getLocalRecolha(19, 6).addProduto(produto9);
        armazem.getLocalRecolha(19, 6).addProduto(produto10);

        armazem.getLocalRecolha(19, 6).addProduto(produto3);
        armazem.getLocalRecolha(19, 6).addProduto(produto11);
        armazem.getLocalRecolha(19, 6).addProduto(produto12);
        armazem.getLocalRecolha(19, 6).addProduto(produto5);

        // create the respective positions of Local de Recolha
        posicao19_2 = new Posicao(19, 2);
        posicao19_4 = new Posicao(19, 4);
        posicao19_6 = new Posicao(19, 6);

        // create the respective positions of the Prateleiras used in the simulation
        posicao10_5 = new Posicao(10, 5); //AGC
        posicao6_13 = new Posicao(6, 13); //VR e CR
        posicao17_8 = new Posicao(17, 8); //ULC


        // create the Embalagens
        saco1 = new Saco(1);
        saco2 = new Saco(2);
        saco3 = new Saco(3);
        saco4 = new Saco(4);
        saco5 = new Saco(5);
        saco6 = new Saco(6);
        saco7 = new Saco(7);

        caixa1 = new Caixa(1);

        caixaCartao1 = new CaixaCartao(1, false);
        caixaCartao2 = new CaixaCartao(2, true);
        caixaCartao3 = new CaixaCartao(3, true);
        caixaCartao4 = new CaixaCartao(4, true);
        caixaCartao5 = new CaixaCartao(4, true);

        palete1 = new Palete(1);

        // add the Embalagens to the respective Local de Recolha
        armazem.getLocalRecolha(19, 2).addEmbalagem(saco1);
        armazem.getLocalRecolha(19, 2).addEmbalagem(saco2);
        armazem.getLocalRecolha(19, 2).addEmbalagem(saco3);
        armazem.getLocalRecolha(19, 2).addEmbalagem(saco4);
        armazem.getLocalRecolha(19, 2).addEmbalagem(saco5);
        armazem.getLocalRecolha(19, 2).addEmbalagem(saco6);
        armazem.getLocalRecolha(19, 2).addEmbalagem(saco7);

        armazem.getLocalRecolha(19, 4).addEmbalagem(caixa1);

        armazem.getLocalRecolha(19, 6).addEmbalagem(caixaCartao2);
        armazem.getLocalRecolha(19, 6).addEmbalagem(caixaCartao3);
        armazem.getLocalRecolha(19, 6).addEmbalagem(caixaCartao4);
        armazem.getLocalRecolha(19, 6).addEmbalagem(caixaCartao5);

        armazem.getLocalRecolha(19, 6).addPalete(palete1);


        // prints
        System.out.println("Local de Recolha (19,2): ");
        System.out.println();
        System.out.println("Produtos:");
        System.out.println(armazem.getLocalRecolha(19, 2).getProdutos());
        System.out.println();
        System.out.println("Embalagens:");
        System.out.println(armazem.getLocalRecolha(19, 2).getEmbalagens());
        System.out.println();
        System.out.println();

        System.out.println("Local de Recolha (19,4): ");
        System.out.println();
        System.out.println("Produtos:");
        System.out.println(armazem.getLocalRecolha(19, 4).getProdutos());
        System.out.println();
        System.out.println("Embalagens:");
        System.out.println(armazem.getLocalRecolha(19, 4).getEmbalagens());
        System.out.println();
        System.out.println();

        System.out.println("Local de Recolha (19,6): ");
        System.out.println();
        System.out.println("Produtos:");
        System.out.println(armazem.getLocalRecolha(19, 6).getProdutos());
        System.out.println();
        System.out.println("Embalagens:");
        System.out.println(armazem.getLocalRecolha(19, 6).getEmbalagens());
        System.out.println();
        System.out.println("Paletes:");
        System.out.println(armazem.getLocalRecolha(19, 6).getPaletes());


        // packing the products

        armazem.getLocalRecolha(19, 2).embalarProdutos();
        System.out.println();
        System.out.println();
        System.out.println("Os produtos do Local de Recolha (19,2) foram embalados com sucesso.");
        System.out.println();
        System.out.println("Embalagens:");
        System.out.println(armazem.getLocalRecolha(19, 2).getEmbalagens());


        armazem.getLocalRecolha(19, 4).embalarProdutos();
        System.out.println();
        System.out.println();
        System.out.println("Os produtos do Local de Recolha (19,4) foram embalados com sucesso.");
        System.out.println();
        System.out.println("Embalagens:");
        System.out.println(armazem.getLocalRecolha(19, 4).getEmbalagens());


        armazem.getLocalRecolha(19, 6).embalarProdutos();
        System.out.println();
        System.out.println();
        System.out.println("Os produtos do Local de Recolha (19,6) foram embalados com sucesso.\n");
        System.out.println();
        System.out.println("Embalagens:");
        System.out.println(armazem.getLocalRecolha(19, 6).getEmbalagens());
        System.out.println();
        System.out.println("Paletes:");
        System.out.println(armazem.getLocalRecolha(19, 6).getPaletes());
        System.out.println();
        System.out.println();

    }

    public void step2() {

        System.out.println("INICIO DA MOVIMENTACAO");
        armazem.visualizeArmazem();

        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step3() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step4() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step5() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step6() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step7() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step8() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step9() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step10() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step11() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step12() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step13() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step14() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step15() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step16() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step17() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step18() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step19() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.visualizeArmazem();
    }

    public void step20() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step21() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();
    }

    public void step22() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();
    }

    public void step23() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();
    }

    public void step24() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();
    }

    public void step25() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();
    }

    public void step26() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.getLocalRecolha(19, 4).carregarVeiculo(carrinhoTransporte);
        armazem.visualizeArmazem();
    }

    public void step27() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step28() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step29() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step30() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);

        armazem.visualizeArmazem();
    }

    public void step31() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step32() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step33() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step34() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.getLocalRecolha(19, 6).carregarVeiculo(ulc);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step35() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step36() {
        armazem.getLocalRecolha(19, 2).carregarVeiculo(agc);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step37() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step38() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step39() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step40() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.getPrateleira(posicao17_8).descarregarVeiculo(ulc);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step41() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step42() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step43() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step44() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step45() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step46() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }

    public void step47() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step48() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step49() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();


    }

    public void step50() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step51() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step52() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step53() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step54() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.getPrateleira(posicao6_13).descarregarVeiculo(carrinhoTransporte);
        armazem.visualizeArmazem();

    }


    public void step55() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step56() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();

    }


    public void step57() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.visualizeArmazem();

    }


    public void step58() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step59() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step60() {
        armazem.getPrateleira(posicao10_5).descarregarVeiculo(agc);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step61() {
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }


    public void step62() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }


    public void step63() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }


    public void step64() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }


    public void step65() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }

    public void step66() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }


    public void step67() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }


    public void step68() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);  // chega à posição inicial
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();

    }


    public void step69() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();

    }


    public void step70() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();

    }


    public void step71() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();

    }


    public void step72() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();

    }


    public void step73() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.visualizeArmazem();

    }


    public void step74() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.visualizeArmazem();

    }


    public void step75() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step76() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);

        armazem.visualizeArmazem();

    }


    public void step77() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }


    public void step78() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step79() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step80() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step81() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step82() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step83() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step84() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step85() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();

    }

    public void step86() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step87() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step88() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step89() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step90() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step91() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.getPrateleira(posicao6_13).carregarVeiculo(carrinhoTransporte);
        armazem.visualizeArmazem();
    }

    public void step92() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.visualizeArmazem();
    }

    public void step93() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN);
        armazem.visualizeArmazem();
    }


    public void step94() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step95() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step96() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.getPrateleira(posicao17_8).carregarVeiculo(ulc);
        armazem.visualizeArmazem();
    }

    public void step97() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step98() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step99() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step100() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step101() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step102() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step103() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step104() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step105() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step106() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step107() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step108() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step109() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step110() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step111() {
        armazem.getPrateleira(posicao10_5).carregarVeiculo(agc);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.getLocalEntrega(0, 3).descarregarVeiculo(carrinhoTransporte);
        armazem.visualizeArmazem();
    }

    public void step112() {
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step113() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(veiculoRebocador, Direcao.DOWN); // vr/ct terminam aqui
        armazem.visualizeArmazem();
    }

    public void step114() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step115() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step116() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step117() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.RIGHT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step118() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step119() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step120() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step121() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step122() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step123() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step124() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.UP);
        armazem.visualizeArmazem();
    }

    public void step125() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.visualizeArmazem();
        armazem.getLocalEntrega(0, 1).descarregarVeiculo(ulc);
    }

    public void step126() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step127() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.moveVeiculoWithDirecao(ulc, Direcao.DOWN); // ulc termina aqui
        armazem.visualizeArmazem();
    }

    public void step128() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step129() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step130() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.visualizeArmazem();
    }

    public void step131() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }

    public void step132() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazem.visualizeArmazem();

    }

    public void step133() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazem.visualizeArmazem();

    }

    public void step134() {
        armazem.getLocalEntrega(0, 2).descarregarVeiculo(agc);
        armazem.visualizeArmazem();

    }

    public void step135() {
        armazem.visualizeArmazem();

    }

    public void step136() {
        armazem.moveVeiculoWithDirecao(agc, Direcao.DOWN);// agc termina aqui
        armazem.visualizeArmazem();

    }

}
