package Embalagens;
import Produtos.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe Caixa.
 */
public class CaixaTest {
    /**
     * Testa o método podeArmazenarProduto.
     */
    @Test
    public void testPodeArmazenarProduto() {
        // Cria um saco para testes
        Caixa caixa = new Caixa(1);

        // Cria uma roupa para testar se pode ser armazenado na caixa
        Produto roupa = new Produto("Saia", 1 , 2.0 , TipoProduto.ROUPA);

        // Verifica se a caixa pode armazenar a roupa (deve retornar false)
        assertFalse(caixa.podeArmazenarProduto(roupa));

        // Cria um eletrónico grande para testar se pode ser armazenado na caixa
        Produto eletronicoGrande = new Produto("Televisor 50 polegadas", 2 , 4.0 , TipoProduto.ELETRONICO_GRANDE);

        // Verifica se a caixa pode armazenar o eletrónico grande (deve retornar false)
        assertFalse(caixa.podeArmazenarProduto(eletronicoGrande));

        // Cria um brinquedo pequeno para testar se pode ser armazenado na caixa
        Produto brinquedoPequeno = new Produto("Carrinho", 3 , 3.0 , TipoProduto.BRINQUEDO_PEQUENO);

        // Verifica se a caixa pode armazenar o brinquedo pequeno (deve retornar true)
        assertTrue(caixa.podeArmazenarProduto(brinquedoPequeno));
    }

    /**
     * Testa o método addProduto.
     */
    @Test
    public void testAdicionaProduto() {
        // Cria um produto para teste
        Produto produto = new Produto("Harry Potter", 3, 2.0, TipoProduto.LIVRO);
        // Cria uma caixa com capacidade 1
        Caixa caixa = new Caixa(1);

        // Adiciona o produto na caixa
        caixa.addProduto(produto);

        // Verifica se o peso da caixa é 2.0
        assertEquals(2.0, caixa.getPesoCaixa());
    }

    /**
     * Testa o método removeProduto.
     */
    @Test
    public void testRemoveProduto() {
        // Cria um produto para teste
        Produto produto = new Produto("Carrinho de controle remoto", 3, 3.0, TipoProduto.BRINQUEDO_GRANDE);
        // Cria uma caixa
        Caixa caixa = new Caixa(1);

        // Adiciona o produto na caixa
        caixa.addProduto(produto);
        // Remove o produto da caixa
        caixa.removeProduto(produto);

        // Verifica se o peso da caixa é 0.0
        assertEquals(0.0, caixa.getPesoCaixa());
        // Verifica se a caixa está vazia
        assertTrue(caixa.getCaixa().isEmpty());
    }

    /**
     * Testa o método getCapacidade.
     */
    @Test
    public void testGetCapacidade() {
        // Cria uma caixa com capacidade 1
        Caixa caixa = new Caixa(1);

        // Verifica se a capacidade da caixa é 1.0
        assertEquals(1.0, caixa.getCapacidade());
    }
}
