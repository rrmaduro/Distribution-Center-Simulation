package Armazem;

import Veiculos.*;
import Elementos.*;

import static org.junit.jupiter.api.Assertions.*;

class ArmazémTest {
    public static void main(String[] args) {
        Posicao posicao = new Posicao(5, 5);
        Posicao oposicao = new Posicao(2, 2);
        Posicao newPosicao = new Posicao(4, 3);
        Posicao posicaoLocalRecolha = new Posicao(9, 3);
        Posicao posicaoLocalEntrega = new Posicao(0, 3);
        LocalEntrega localEntrega = new LocalEntrega(0, 3);
        LocalRecolha localRecolha = new LocalRecolha(9, 3);
        Armazém armazém = new Armazém(10, 10);
        AGC agc = new AGC(23, armazém);
        ULC ulc = new ULC(14, armazém);
        CarrinhoTransporte carrinhoTransporte = new CarrinhoTransporte(56, armazém);
        VeiculoRebocador veiculoRebocador = new VeiculoRebocador(67, armazém);
        Prateleira prateleira1 = new Prateleira(5, 5);
        Prateleira prateleira2 = new Prateleira(5, 6);
        Prateleira prateleira3 = new Prateleira(5, 7);
        Prateleira prateleira4 = new Prateleira(7, 5);
        Prateleira prateleira5 = new Prateleira(7, 6);
        assertTrue(armazém.getVeiculos().contains(agc));
        assertTrue(armazém.getVeiculos().contains(ulc));
        assertTrue(armazém.getVeiculos().contains(carrinhoTransporte));
        assertTrue(armazém.getVeiculos().contains(veiculoRebocador));
        armazém.addPrateleira(prateleira1);
        armazém.addPrateleira(prateleira2);
        armazém.addPrateleira(prateleira3);
        armazém.addPrateleira(prateleira4);
        armazém.addPrateleira(prateleira5);
        armazém.visualizeArmazem();

        armazém.moveVeiculo(agc, posicaoLocalRecolha);
        armazém.visualizeArmazem();
        armazém.moveVeiculoWithDirecao(agc, Direcao.UP);
        armazém.visualizeArmazem();
        armazém.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazém.visualizeArmazem();
        armazém.moveVeiculoWithDirecao(agc, Direcao.LEFT);
        armazém.visualizeArmazem();



    }
}
