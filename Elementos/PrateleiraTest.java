package Elementos;
import Veiculos.*;
import Embalagens.*;
import Produtos.*;
import Armazem.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A classe de teste para a classe Elementos.Prateleira.
 */
public class PrateleiraTest {

    private Prateleira prateleira;
    private Armazém armazem;

    /**
     * Testa o método addEmbalagem.
     */
    @Test
    public void testeAddEmbalagem() {
        Prateleira prateleira = new Prateleira(1, 1);

        // Criação de embalagens para teste
        Embalagem caixaCartaoPequena = new CaixaCartao(1, false);
        Embalagem caixaCartaoGrande = new CaixaCartao(2, true);
        Embalagem caixa = new Caixa(3);
        Embalagem saco = new Saco(4);

        // Adiciona embalagens à prateleira
        prateleira.addEmbalagem(caixaCartaoPequena);
        prateleira.addEmbalagem(caixaCartaoGrande);
        prateleira.addEmbalagem(caixa);
        prateleira.addEmbalagem(saco);

        // Verifica se as embalagens foram adicionadas corretamente


    }

    /**
     * Testa o método removeEmbalagem.
     */
    @Test
    public void testeRemoveEmbalagem() {
        Prateleira prateleira = new Prateleira(1, 1);

        // Criação de embalagens para teste
        Embalagem caixaCartaoPequena = new CaixaCartao(1, false);
        Embalagem caixaCartaoGrande = new CaixaCartao(2, true);
        Embalagem caixa = new Caixa(3);
        Embalagem saco = new Saco(4);

        // Adiciona embalagens à prateleira
        prateleira.addEmbalagem(caixaCartaoPequena);
        prateleira.addEmbalagem(caixaCartaoGrande);
        prateleira.addEmbalagem(caixa);
        prateleira.addEmbalagem(saco);

        // Remove uma embalagem
        prateleira.removeEmbalagem(caixaCartaoPequena);
        prateleira.removeEmbalagem(caixaCartaoGrande);
        prateleira.removeEmbalagem(caixa);
        prateleira.removeEmbalagem(saco);
    }
    
     @Test
    public void testDescarregarVeiculo() {
        Prateleira prateleira = new Prateleira(5, 5);
        Armazém armazem = new Armazém(10, 10);
        Produto produto1= new Produto("kk", 1, 2, TipoProduto.BRINQUEDO_GRANDE);
        Produto produto2= new Produto("ll", 1, 2, TipoProduto.LIVRO);
        Produto produto3= new Produto("oo", 2, 3, TipoProduto.ACESSORIO);
        
        // Configurar o estado inicial da prateleira e dos veículos
        AGC agc = new AGC(1, armazem);
        Caixa caixa = new Caixa(1);
        Saco saco = new Saco(2);
        caixa.addProduto(produto2);
        saco.addProduto(produto3);
        agc.addPackage(caixa);
        agc.addPackage(saco);
        
        ULC ulc = new ULC(2, armazem);
        CaixaCartao caixaCartao= new CaixaCartao(2, true);
        caixaCartao.armazenarProduto(produto1);
        Palete palete = new Palete(1);
        palete.addCaixaCartao(caixaCartao);
        ulc.addPalete(palete);
        
        CarrinhoTransporte carrinho = new CarrinhoTransporte(1, armazem);
        carrinho.addPackage(caixa);
        carrinho.addPackage(saco);
        
        VeiculoRebocador veiculoRebocador = new VeiculoRebocador(1, armazem);
        veiculoRebocador.rebocarCarrinho(carrinho);
        
        prateleira.addVeiculo(agc);
        prateleira.addVeiculo(ulc);
        prateleira.addVeiculo(veiculoRebocador);
        
        // Executar o método descarregarVeiculo
        prateleira.descarregarVeiculo(agc);
        prateleira.descarregarVeiculo(ulc);
        prateleira.descarregarVeiculo(veiculoRebocador);
        
        // Verificar os resultados esperados ou realizar asserções
        assertEquals(4, prateleira.getCounterEmbalagens()); // Verificar se a embalagem do AGC foi adicionada corretamente
        assertEquals(1, prateleira.getCounterPaletes()); // Verificar se a palete da ULC foi adicionada corretamente
    }
}

