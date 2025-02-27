package Veiculos;
import Embalagens.*;
import Armazem.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Classe de teste para a classe AGC.
 */
public class AGCTest {
    private AGC agc;

    @Before
    public void setUp() {
        Armazém armazém = new Armazém(10, 10);
        agc = new AGC(1, armazém);
    }

    /**
     * Testa o método addPackage da classe AGC.
     */
    @Test
    public void testAddPackage() {
        agc.addPackage(new CaixaCartao(1, false));
        agc.addPackage(new Caixa(1));
        agc.addPackage(new Saco(1));

        assertEquals(3, agc.getCargaTotal());
    }

    /**
     * Testa o método removePackage da classe AGC.
     */
    @Test
    public void testRemovePackage() {
        CaixaCartao caixaCartao = new CaixaCartao(1, false);
        Caixa caixa = new Caixa(1);
        Saco saco = new Saco(1);

        agc.addPackage(caixaCartao);
        agc.addPackage(caixa);
        agc.addPackage(saco);

        agc.removePackage(caixa);

        assertEquals(2, agc.getCargaTotal());
    }

    /**
     * Testa o método getCargaTotal da classe AGC.
     */
    @Test
    public void testGetCargaTotal() {
        CaixaCartao caixaCartao = new CaixaCartao(1, false);
        Caixa caixa = new Caixa(1);
        Saco saco = new Saco(1);

        agc.addPackage(caixaCartao);
        agc.addPackage(caixa);
        agc.addPackage(saco);

        assertEquals(3, agc.getCargaTotal());

        agc.removePackage(caixa);

        assertEquals(2, agc.getCargaTotal());
    }

    /**
     * Testa o método getMaxPeso da classe AGC.
     */
    @Test
    public void testGetMaxPeso() {
        double maxPeso = agc.getMaxPeso();

        double expectedMaxPeso = 100.0;
        double actualMaxPeso = agc.getMaxPeso();
        assertEquals(expectedMaxPeso, actualMaxPeso, 0.001);
    }

    /**
     * Testa o método addPackage para uma CaixaCartao na classe AGC.
     */
    @Test
    public void testAddPackageCaixaCartao() {
        agc.addPackage(new CaixaCartao(1, false));

        int expectedCargaTotal = 1;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
    }

    /**
     * Testa o método addPackage para uma Caixa na classe AGC.
     */
    @Test
    public void testAddPackageCaixa() {
        agc.addPackage(new Caixa(1));

        int expectedCargaTotal = 1;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
    }

    /**
     * Testa o método addPackage para um Saco na classe AGC.
     */
    @Test
    public void testAddPackageSaco() {
        agc.addPackage(new Saco(2));

        int expectedCargaTotal = 1;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
    }

    /**
     * Testa o método addPackage para uma embalagem inválida na classe AGC.
     */
    @Test
    public void testAddPackageInvalid() {
        int expectedCargaTotal = 0;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
    }

    /**
     * Testa o método removePackage para uma CaixaCartao na classe AGC.
     */
    @Test
    public void testRemovePackageCaixaCartao() {
        CaixaCartao caixaCartao = new CaixaCartao(1, false);
        agc.addPackage(caixaCartao);
        agc.removePackage(caixaCartao);

        int expectedCargaTotal = 0;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
    }

    /**
     * Testa o método removePackage para uma Caixa na classe AGC.
     */
    @Test
    public void testRemovePackageCaixa() {
        Caixa caixa = new Caixa(1);
        agc.addPackage(caixa);
        agc.removePackage(caixa);

        int expectedCargaTotal = 0;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
    }

    /**
     * Testa o método removePackage para um Saco na classe AGC.
     */
    @Test
    public void testRemovePackageSaco() {
        Saco saco = new Saco(2);
        agc.addPackage(saco);
        agc.removePackage(saco);

        int expectedCargaTotal = 0;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
    }

    /**
     * Testa o método removePackage para uma embalagem inválida na classe AGC.
     */
    @Test
    public void testRemovePackageInvalid() {
        int expectedCargaTotal = 0;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
    }

    /**
     * Testa o método retrieveAllPackages da classe AGC.
     */
    @Test
    public void testRetrieveAllPackages() {
        CaixaCartao caixaCartao = new CaixaCartao(1, false);
        Caixa caixa = new Caixa(2);
        Saco saco = new Saco(1);
        agc.addPackage(caixaCartao);
        agc.addPackage(caixa);
        agc.addPackage(saco);

        ArrayList<Embalagem> retrievedPackages = agc.retrieveAllPackages();

        int expectedCargaTotal = 0;
        int actualCargaTotal = agc.getCargaTotal();
        assertEquals(expectedCargaTotal, actualCargaTotal);
        assertEquals(3, retrievedPackages.size());
    }
}