package Veiculos;
import Embalagens.*;
import Armazem.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A classe de teste para a classe CarrinhoTransporte.
 */
class CarrinhoTransporteTest {
    /**
     * Testa o método getCapacidadeMaxima.
     */
    @Test
    public void testGetCapacidadeMaxima() {
        // Cria um armazém com capacidade de 10x10
        Armazém armazém = new Armazém(10, 10);
        // Cria um carrinho de transporte com capacidade 1 e o armazém
        CarrinhoTransporte carrinho = new CarrinhoTransporte(1, armazém);

        // Verifica se a capacidade máxima do carrinho é 200.0
        assertEquals(200.0, carrinho.getCapacidadeMaxima());
    }

    /**
     * Testa o método getCargaAtual.
     */
    @Test
    public void testGetCargaAtual() {
        // Cria um armazém com capacidade de 10x10
        Armazém armazém = new Armazém(10, 10);
        // Cria um carrinho de transporte com capacidade 1 e o armazém
        CarrinhoTransporte carrinho = new CarrinhoTransporte(1, armazém);

        // Verifica se a carga atual do carrinho é 0.0
        assertEquals(0.0, carrinho.getCargaAtual());
    }

    /**
     * Testa o método isEmpty.
     */
    @Test
    public void testIsEmpty() {
        // Cria um armazém com capacidade de 10x10
        Armazém armazém = new Armazém(10, 10);
        // Cria um carrinho de transporte com capacidade 1 e o armazém
        CarrinhoTransporte carrinho = new CarrinhoTransporte(1, armazém);

        // Verifica se o carrinho está vazio (deve retornar true)
        assertTrue(carrinho.isEmpty());

        // Cria uma caixa
        Caixa caixa = new Caixa(2);
        // Adiciona a caixa ao carrinho
        carrinho.addPackage(caixa);

        // Verifica se o carrinho está vazio (deve retornar false)
        assertFalse(carrinho.isEmpty());
    }

    /**
     * Testa o método getCounterCarga.
     */
    @Test
    public void testGetCounterCarga() {
        // Cria um armazém com capacidade de 10x10
        Armazém armazém = new Armazém(10, 10);
        // Cria um carrinho de transporte com capacidade 1 e o armazém
        CarrinhoTransporte carrinho = new CarrinhoTransporte(1, armazém);

        // Verifica se o contador de carga do carrinho é 0
        assertEquals(0, carrinho.getCounterCarga());

        // Adiciona uma caixa ao carrinho
        carrinho.addPackage(new Caixa(2));

        // Verifica se o contador de carga do carrinho é 1
        assertEquals(1, carrinho.getCounterCarga());
    }

    /**
     * Testa o método addPackage.
     */
    @Test
    public void testAddPackage() {
        // Cria um armazém com capacidade de 10x10
        Armazém armazém = new Armazém(10, 10);
        // Cria um carrinho de transporte com capacidade 1 e o armazém
        CarrinhoTransporte carrinho = new CarrinhoTransporte(1, armazém);

        // Cria uma caixa e um saco
        Caixa caixa1 = new Caixa(2);
        Saco saco = new Saco(3);

        // Adiciona a caixa e o saco ao carrinho
        carrinho.addPackage(caixa1);
        carrinho.addPackage(saco);

        // Verifica se o contador de carga do carrinho é 2
        assertEquals(2, carrinho.getCounterCarga());

        // Cria uma nova caixa
        Caixa caixa2 = new Caixa(4);
        // Adiciona a nova caixa ao carrinho
        carrinho.addPackage(caixa2);

        // Verifica se o contador de carga do carrinho é 3
        assertEquals(3, carrinho.getCounterCarga());
    }

    /**
     * Testa o método removePackage.
     */
    @Test
    public void testRemovePackage() {
        // Cria um armazém com capacidade de 10x10
        Armazém armazém = new Armazém(10, 10);
        // Cria um carrinho de transporte com capacidade 1 e o armazém
        CarrinhoTransporte carrinho = new CarrinhoTransporte(1, armazém);

        // Cria uma caixa e um saco
        Caixa caixa1 = new Caixa(2);
        Saco saco = new Saco(3);

        // Adiciona a caixa e o saco ao carrinho
        carrinho.addPackage(caixa1);
        carrinho.addPackage(saco);

        // Verifica se o contador de carga do carrinho é 2
        assertEquals(2, carrinho.getCounterCarga());

        // Remove a caixa do carrinho
        carrinho.removePackage(caixa1);

        // Verifica se o contador de carga do carrinho é 1
        assertEquals(1, carrinho.getCounterCarga());
    }
}
