package Elementos;
import Produtos.*;
import Armazem.*;
import Embalagens.*;
import Veiculos.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocalRecolhaTest {
    private TipoProduto tipoProduto;
    private Armazém armazem;

    @Test
    public void testAddProduto() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        Produto produto1 = new Produto("Saia", 1, 2.0, TipoProduto.ROUPA);
        Produto produto2 = new Produto("Peluche", 1, 4.0, TipoProduto.BRINQUEDO_PEQUENO);

        localRecolha.addProduto(produto1);
        localRecolha.addProduto(produto2);

        assertTrue(localRecolha.getProdutos().contains(produto1));
        assertTrue(localRecolha.getProdutos().contains(produto2));
    }

    @Test
    public void testRemoveProduto() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        Produto produto1 = new Produto("Saia", 1, 2.0, TipoProduto.ROUPA);
        Produto produto2 = new Produto("Peluche", 1, 4.0, TipoProduto.BRINQUEDO_PEQUENO);

        localRecolha.addProduto(produto1);
        localRecolha.addProduto(produto2);

        assertTrue(localRecolha.getProdutos().contains(produto1));
        assertTrue(localRecolha.getProdutos().contains(produto2));

        localRecolha.removeProduto(produto1);
        localRecolha.removeProduto(produto2);

        assertFalse(localRecolha.getProdutos().contains(produto1));
        assertFalse(localRecolha.getProdutos().contains(produto2));

    }

    @Test
    public void testAddEmbalagem() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        Caixa caixa1 = new Caixa(1);
        Caixa caixa2 = new Caixa(2);

        localRecolha.addEmbalagem(caixa1);
        localRecolha.addEmbalagem(caixa2);

        assertTrue(localRecolha.getEmbalagens().contains(caixa1));
        assertTrue(localRecolha.getEmbalagens().contains(caixa2));

    }

    @Test
    public void testRemoveEmbalagem() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        Caixa caixa1 = new Caixa(1);
        Caixa caixa2 = new Caixa(2);

        localRecolha.addEmbalagem(caixa1);
        localRecolha.addEmbalagem(caixa2);

        assertTrue(localRecolha.getEmbalagens().contains(caixa1));
        assertTrue(localRecolha.getEmbalagens().contains(caixa2));

        localRecolha.removeEmbalagem(caixa1);

        assertFalse(localRecolha.getEmbalagens().contains(caixa1));
        assertTrue(localRecolha.getEmbalagens().contains(caixa2));
    }

    @Test
    public void testAddPalete() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        Palete palete1 = new Palete(1);
        Palete palete2 = new Palete(2);

        localRecolha.addPalete(palete1);
        localRecolha.addPalete(palete2);

        assertTrue(localRecolha.getPaletes().contains(palete1));
        assertTrue(localRecolha.getPaletes().contains(palete2));
    }

    @Test
    public void testRemovePalete() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        Palete palete1 = new Palete(1);
        Palete palete2 = new Palete(2);

        localRecolha.addPalete(palete1);
        localRecolha.addPalete(palete2);

        assertTrue(localRecolha.getPaletes().contains(palete1));
        assertTrue(localRecolha.getPaletes().contains(palete2));

        localRecolha.removePalete(palete1);

        assertFalse(localRecolha.getPaletes().contains(palete1));
        assertTrue(localRecolha.getPaletes().contains(palete2));
    }

    @Test
    public void testAddVeiculo() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        armazem = new Armazém(10, 10);
        AGC veiculo1 = new AGC(1, armazem);


        localRecolha.addVeiculo(veiculo1);

        assertTrue(localRecolha.getVeiculos().contains(veiculo1));

    }

    @Test
    public void testRemoveVeiculo() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        armazem = new Armazém(10, 10);
        AGC veiculo1 = new AGC(1, armazem);

        localRecolha.addVeiculo(veiculo1);


        assertTrue(localRecolha.getVeiculos().contains(veiculo1));


        localRecolha.removeVeiculo(veiculo1);

        assertFalse(localRecolha.getVeiculos().contains(veiculo1));
    }

    @Test
    public void testEmbalarProdutos() {
        LocalRecolha localRecolha = new LocalRecolha(0, 0);
        Produto produto1 = new Produto("Boneca", 1, 2.0, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto3= new Produto("Livro", 3, 1,TipoProduto.LIVRO);
        Saco saco= new Saco(1);
        Caixa caixa= new Caixa(3);

        localRecolha.addProduto(produto1);
        localRecolha.addProduto(produto3);

        localRecolha.addEmbalagem(saco);
        localRecolha.addEmbalagem(caixa);

        localRecolha.embalarProdutos();

        assertTrue(localRecolha.getEmbalagens().contains(saco));
        assertTrue(saco.getSaco().contains(produto1));

        assertTrue(localRecolha.getEmbalagens().contains(caixa));
        assertTrue(caixa.getCaixa().contains(produto3));
    }
}
