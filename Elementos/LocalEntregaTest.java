package Elementos;
import Veiculos.*;
import Embalagens.*;
import Armazem.*;

import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;

import static org.junit.Assert.*;

public class LocalEntregaTest {
    private LocalEntrega localEntrega;
    private Armazém armazem;
    private AGC agc;
    private ULC ulc;

    @Before
    public void setUp() {
        localEntrega = new LocalEntrega(1, 1);
        armazem = new Armazém(10, 10);
        agc = new AGC(1, armazem);
        ulc = new ULC(2, armazem);
    }

    @Test
    public void testAddVeiculo() {
        localEntrega.addVeiculo(agc);
        assertTrue(localEntrega.hasVeiculo());
        assertEquals(agc, localEntrega.getVeiculo().get(0));
    }

    @Test
    public void testRemoveVeiculo() {
        localEntrega.addVeiculo(agc);
        assertTrue(localEntrega.hasVeiculo());
        localEntrega.removeVeiculo(agc);
        assertFalse(localEntrega.hasVeiculo());
        assertEquals(0, localEntrega.getVeiculo().size());
    }

    @Test
    public void testDescarregarVeiculo() {
        localEntrega.addVeiculo(agc);
        Caixa caixa = new Caixa(1);
        agc.addPackage(caixa);
        localEntrega.descarregarVeiculo(agc);
        assertEquals(1, localEntrega.getProdutosEmbalados().size());
        assertTrue(localEntrega.getProdutosEmbalados().contains(caixa));
    }

    @Test
    public void testAddEmbalagem() {
        Caixa caixa = new Caixa(1);
        localEntrega.addEmbalagem(caixa);
        assertEquals(1, localEntrega.getProdutosEmbalados().size());
        assertTrue(localEntrega.getProdutosEmbalados().contains(caixa));
    }

    @Test
    public void testRemoveEmbalagem() {
        Caixa caixa = new Caixa(1);
        localEntrega.addEmbalagem(caixa);
        localEntrega.removeEmbalagem(caixa);
        assertEquals(0, localEntrega.getProdutosEmbalados().size());
        assertFalse(localEntrega.getProdutosEmbalados().contains(caixa));
    }

    @Test
    public void testGetTipoElemento() {
        assertEquals(TipoElemento.LOCAL_ENTREGA, localEntrega.getTipoElemento());
    }

    @Test
    public void testHashCode() {
        LocalEntrega other = new LocalEntrega(1, 1);
        assertEquals(other.hashCode(), localEntrega.hashCode());
    }

    @Test
    public void testEquals() {
        LocalEntrega other = new LocalEntrega(1, 1);
        assertTrue(localEntrega.equals(other));
    }
}