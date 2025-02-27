package Veiculos;
import Embalagens.*;
import Armazem.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A classe de teste para a classe VeiculoRebocador.
 */
class VeiculoRebocadorTest {
    @Test
    public void testGetCapacidadeMaxima() {
        Armazém armazem = new Armazém(10, 10);
        CarrinhoTransporte carrinhoTransporte = new CarrinhoTransporte(1, armazem);
        assertEquals(200.0, carrinhoTransporte.getCapacidadeMaxima());
    }

    @Test
    public void testGetCargaAtual() {
        Armazém armazem = new Armazém(10, 10);
        CarrinhoTransporte carrinhoTransporte = new CarrinhoTransporte(1, armazem);
        assertEquals(0.0, carrinhoTransporte.getCargaAtual());
    }

    @Test
    public void testIsEmpty() {
        Armazém armazem = new Armazém(10, 10);
        CarrinhoTransporte carrinhoTransporte = new CarrinhoTransporte(1, armazem);
        assertTrue(carrinhoTransporte.isEmpty());

        Caixa caixa = new Caixa(2);
        carrinhoTransporte.addPackage(caixa);
        assertFalse(carrinhoTransporte.isEmpty());
    }

    @Test
    public void testGetCounterCarga() {
        Armazém armazem = new Armazém(10, 10);
        CarrinhoTransporte carrinhoTransporte = new CarrinhoTransporte(1, armazem);
        assertEquals(0, carrinhoTransporte.getCounterCarga());

        carrinhoTransporte.addPackage(new Caixa(2));
        assertEquals(1, carrinhoTransporte.getCounterCarga());
    }

    @Test
    public void testAddPackage() {
        Armazém armazem = new Armazém(10, 10);
        CarrinhoTransporte carrinhoTransporte = new CarrinhoTransporte(1, armazem);
        Caixa caixa1 = new Caixa(2);
        Saco saco = new Saco(3);

        carrinhoTransporte.addPackage(caixa1);
        carrinhoTransporte.addPackage(saco);
        assertEquals(2, carrinhoTransporte.getCounterCarga());

        Caixa caixa2 = new Caixa(4);
        carrinhoTransporte.addPackage(caixa2);
        assertEquals(3, carrinhoTransporte.getCounterCarga());
    }

    @Test
    public void testRemovePackage() {
        Armazém armazem = new Armazém(10, 10);
        CarrinhoTransporte carrinhoTransporte = new CarrinhoTransporte(1, armazem);
        Caixa caixa1 = new Caixa(2);
        Saco saco = new Saco(3);

        carrinhoTransporte.addPackage(caixa1);
        carrinhoTransporte.addPackage(saco);
        assertEquals(2, carrinhoTransporte.getCounterCarga());

        carrinhoTransporte.removePackage(caixa1);
        assertEquals(1, carrinhoTransporte.getCounterCarga());
    }
}
