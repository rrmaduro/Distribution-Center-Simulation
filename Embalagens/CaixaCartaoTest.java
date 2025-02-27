package Embalagens;
import Produtos.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe CaixaCartao.
 */
public class CaixaCartaoTest {
    /**
     * Testa o método podeArmazenarProduto.
     */
    @Test
    public void testPodeArmazenarProduto() {
        // Criação das caixas e produtos
        CaixaCartao caixaGrande = new CaixaCartao(1, true);
        CaixaCartao caixaPequena = new CaixaCartao(2, false);
        Produto produto1 = new Produto("Carrinho de controlo remoto", 3, 3.0, TipoProduto.BRINQUEDO_GRANDE);
        Produto produto2 = new Produto("Ursinho de peluche", 4, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produtoNull = null;

        // Verifica se as caixas foram criadas
        assertNotNull(caixaGrande.getCaixaCartaoGrande());
        assertNotNull(caixaPequena.getCaixaCartaoPequena());

        // Verifica o comportamento do método podeArmazenarProduto para diferentes casos
        assertFalse(caixaGrande.podeArmazenarProduto(produtoNull)); // Produto null não pode ser armazenado
        assertFalse(caixaPequena.podeArmazenarProduto(produtoNull)); // Produto null não pode ser armazenado
        assertFalse(caixaGrande.podeArmazenarProduto(produto2)); // Produto pequeno não pode ser armazenado em caixa grande
        assertTrue(caixaPequena.podeArmazenarProduto(produto2)); // Produto pequeno pode ser armazenado em caixa pequena
        assertTrue(caixaGrande.podeArmazenarProduto(produto1)); // Produto grande pode ser armazenado em caixa grande
        assertFalse(caixaPequena.podeArmazenarProduto(produto1)); // Produto grande não pode ser armazenado em caixa pequena
    }

    /**
     * Testa o método armazenarProduto.
     */
    @Test
    public void testArmazenarProduto() {
        // Criação das caixas e produtos
        CaixaCartao caixaGrande = new CaixaCartao(1, true);
        CaixaCartao caixaPequena = new CaixaCartao(2, false);
        Produto produto1 = new Produto("Carrinho de controlo remoto", 3, 3.0, TipoProduto.BRINQUEDO_GRANDE);
        Produto produto2 = new Produto("Ursinho de peluche", 4, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto3 = new Produto("Pato de borracha", 5, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto4 = new Produto("Boneco", 6, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto5 = new Produto("Carrinho", 7, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto6 = new Produto("Bola", 8, 2.5, TipoProduto.BRINQUEDO_PEQUENO);

        // Adiciona os produtos às caixas
        caixaPequena.armazenarProduto(produto2);
        caixaPequena.armazenarProduto(produto3);
        caixaPequena.armazenarProduto(produto4);
        caixaPequena.armazenarProduto(produto5);
        caixaPequena.armazenarProduto(produto6);

        caixaGrande.armazenarProduto(produto1);

        // Verifica se o tamanho da caixa pequena é igual a 5
        assertEquals(5, caixaPequena.getCaixaCartaoPequena().size());
        // Verifica se a caixa grande não está vazia
        assertFalse(caixaGrande.getCaixaCartaoGrande().isEmpty());
    }

    /**
     * Testa o método removerProduto.
     */
    @Test
    public void testRemoverProduto() {
        // Criação das caixas e produtos
        CaixaCartao caixaGrande = new CaixaCartao(1, true);
        CaixaCartao caixaPequena = new CaixaCartao(2, false);
        Produto produto1 = new Produto("Carrinho de controlo remoto", 3, 3.0, TipoProduto.BRINQUEDO_GRANDE);
        Produto produto2 = new Produto("Ursinho de peluche", 4, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto3 = new Produto("Pato de borracha", 5, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto4 = new Produto("Boneco", 6, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto5 = new Produto("Carrinho", 7, 2.5, TipoProduto.BRINQUEDO_PEQUENO);
        Produto produto6 = new Produto("Bola", 8, 2.5, TipoProduto.BRINQUEDO_PEQUENO);

        // Adiciona os produtos às caixas
        caixaPequena.armazenarProduto(produto2);
        caixaPequena.armazenarProduto(produto3);
        caixaPequena.armazenarProduto(produto4);
        caixaPequena.armazenarProduto(produto5);
        caixaPequena.armazenarProduto(produto6);

        // Remove os produtos das caixas
        caixaPequena.removerProduto(produto2);
        caixaPequena.removerProduto(produto3);
        caixaPequena.removerProduto(produto4);
        caixaPequena.removerProduto(produto5);
        caixaPequena.removerProduto(produto6);

        // Verifica se os produtos removidos não estão mais presentes nas caixas
        assertFalse(caixaPequena.getCaixaCartaoPequena().contains(produto2));
        assertFalse(caixaPequena.getCaixaCartaoPequena().contains(produto3));
        assertFalse(caixaPequena.getCaixaCartaoPequena().contains(produto4));
        assertFalse(caixaPequena.getCaixaCartaoPequena().contains(produto5));
        assertFalse(caixaPequena.getCaixaCartaoPequena().contains(produto6));

        caixaGrande.armazenarProduto(produto1);

        // Remove o produto da caixa grande
        caixaGrande.removerProduto(produto1);

        // Verifica se a caixa grande está vazia após a remoção do produto
        assertTrue(caixaGrande.getCaixaCartaoGrande().isEmpty());
    }
}
