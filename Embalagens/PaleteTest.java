package Embalagens;
import Produtos.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste para a classe Palete.
 */
public class PaleteTest {
    /**
     * Testa o método addCaixaCartao.
     */
    @Test
    public void testAddCaixaCartao() {
        // Cria uma palete com capacidade 3
        Palete palete = new Palete(3);
        // Cria uma caixa de cartão que armazena produtos grandes
        CaixaCartao caixa1 = new CaixaCartao(1, true);
        // Cria uma caixa de cartão que armazena produtos pequenos
        CaixaCartao caixa2 = new CaixaCartao(2, false);

        // Adiciona a caixa 1 à palete
        palete.addCaixaCartao(caixa1);
        // Adiciona a caixa 2 à palete
        palete.addCaixaCartao(caixa2);
    }

    /**
     * Testa o método removeCaixaCartao.
     */
    @Test
    public void TestRemoveCaixaCartao() {
        // Cria uma palete com capacidade 3
        Palete palete = new Palete(3);
        // Cria uma caixa de cartão que armazena produtos grandes
        CaixaCartao caixa1 = new CaixaCartao(1, true);
        // Cria uma caixa de cartão que armazena produtos pequenos
        CaixaCartao caixa2 = new CaixaCartao(2, false);

        // Adiciona a caixa 1 à palete
        palete.addCaixaCartao(caixa1);
        // Remove a caixa 1 da palete
        palete.removeCaixaCartao(caixa1);
        // Verifica se a lista de caixas de cartão da palete está vazia
        assertTrue(palete.getPalete().isEmpty()); // Verifica que a caixa foi removida da palete

        // Adiciona a caixa 2 à palete
        palete.addCaixaCartao(caixa2);
        // Remove a caixa 2 da palete
        palete.removeCaixaCartao(caixa2);
        // Verifica se a lista de caixas de cartão da palete está vazia
        assertTrue(palete.getPalete().isEmpty()); // Verifica que a caixa foi removida da palete
    }
}
