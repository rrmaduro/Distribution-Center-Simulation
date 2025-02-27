package Produtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A classe de teste para a classe Produto.
 */
public class ProdutoTest {

    @Test
    public void testGetsAndSets() {
        Produto produto = new Produto("Produto Teste", 123, 1.5, TipoProduto.ACESSORIO);

        // Teste de gets
        assertEquals("Produto Teste", produto.getNome());
        assertEquals(123, produto.getId());
        assertEquals(1.5, produto.getPeso(), 0.001);
        assertEquals(TipoProduto.ACESSORIO, produto.getTipo());

        // Teste de sets
        produto.setNome("Produto Teste Atualizado");
        produto.setId(456);
        produto.setPeso(2.0);
        produto.setTipo(TipoProduto.BRINQUEDO_GRANDE);

        assertEquals("Produto Teste Atualizado", produto.getNome());
        assertEquals(456, produto.getId());
        assertEquals(2.0, produto.getPeso(), 0.001);
        assertEquals(TipoProduto.BRINQUEDO_GRANDE, produto.getTipo());
    }
}
