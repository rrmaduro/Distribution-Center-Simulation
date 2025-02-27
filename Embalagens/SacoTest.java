package Embalagens;
import Produtos.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A classe de teste para a classe Saco.
 */
public class SacoTest {

    @Test
    public void testPodeArmazenarProduto() {
        // Cria um novo saco para testes
        Saco saco = new Saco(1);

        // Cria um livro para testar se pode ser armazenado no saco
        Produto livro = new Produto("O Senhor dos Anéis", 1 , 2.0 , TipoProduto.LIVRO);

        // Verifica se o saco pode armazenar o livro (deve retornar false)
        assertFalse(saco.podeArmazenarProduto(livro));

        // Cria um eletrónico grande para testar se pode ser armazenado no saco
        Produto eletronicoGrande = new Produto("Televisor 50 polegadas", 2 , 4.0 , TipoProduto.ELETRONICO_GRANDE);

        // Verifica se o saco pode armazenar o eletrónico grande (deve retornar false)
        assertFalse(saco.podeArmazenarProduto(eletronicoGrande));

        // Cria um brinquedo pequeno para testar se pode ser armazenado no saco
        Produto brinquedoPequeno = new Produto("Carrinho", 3 , 3.0 , TipoProduto.BRINQUEDO_PEQUENO);

        // Verifica se o saco pode armazenar o brinquedo pequeno (deve retornar true)
        assertTrue(saco.podeArmazenarProduto(brinquedoPequeno));
    }

    @Test
    public void testAdicionaProduto(){

        Produto produto = new Produto("Carrinho de controlo remoto", 3, 3.0, TipoProduto.BRINQUEDO_PEQUENO);
        Saco saco = new Saco(1);

        saco.addProduto(produto);

        assertEquals(3.0, saco.getPesoSaco()); // verifica se o peso do saco é 3.0
    }

    @Test
    public void testRemoveProduto(){

        Produto produto = new Produto("Carrinho de controlo remoto", 3, 3.0, TipoProduto.BRINQUEDO_GRANDE);
        Saco saco = new Saco(1);

        saco.addProduto(produto); //adiciona o produto ao saco
        saco.removeProduto(produto); //remove o produto do saco

        assertEquals(0.0, saco.getPesoSaco()); //verifica se o peso do saco é 0.0
        assertTrue(saco.getSaco().isEmpty()); //verifica que o produto foi removido do saco
    }

    @Test
    public void testGetCapacidade() {
        // Cria um novo saco para testes
        Saco saco = new Saco(1);

        // Verifica se a capacidade do saco está correta (deve retornar 1.0)
        assertEquals(1.0, saco.getCapacidade());
    }
}
