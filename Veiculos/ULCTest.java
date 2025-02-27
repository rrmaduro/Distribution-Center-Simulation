package Veiculos;
import Embalagens.*;
import Armazem.*;

import org.junit.jupiter.api.Test;

/**
 * A classe de teste para a classe ULC.
 */
public class ULCTest {
    @Test
    public void testAddPalete() {
        Armazém armazém = new Armazém(10, 10);
        ULC ulc = new ULC(123, armazém);
        Palete palete = new Palete(1);
        ulc.addPalete(palete);

        if (ulc.getPesoCarga() == palete.getPesoPalete()) {
            System.out.println("Palete adicionada com sucesso.");
        } else {
            System.out.println("Falha ao adicionar a palete.");
        }
    }

    @Test
    public void testRemovePalete() {
        Armazém armazém = new Armazém(10, 10);
        ULC ulc = new ULC(123, armazém);
        Palete palete = new Palete(1);
        ulc.addPalete(palete);
        ulc.removePalete(palete);

        if (ulc.getPesoCarga() == 0) {
            System.out.println("Palete removida com sucesso.");
        } else {
            System.out.println("Falha ao remover a palete.");
        }
    }

    @Test
    public void testGetPesoCarga() {
        Armazém armazém = new Armazém(10, 10);
        ULC ulc = new ULC(123, armazém);
        Palete palete = new Palete(1);
        ulc.addPalete(palete);

        if (ulc.getPesoCarga() == palete.getPesoPalete()) {
            System.out.println("Peso da carga: " + ulc.getPesoCarga());
        } else {
            System.out.println("Falha ao obter o peso da carga.");
        }
    }

    @Test
    public void testGetCodigoULC() {
        Armazém armazém = new Armazém(10, 10);
        ULC ulc = new ULC(123, armazém);

        if (ulc.getCodigoULC() == 123) {
            System.out.println("Código do ULC: " + ulc.getCodigoULC());
        } else {
            System.out.println("Falha ao obter o código do ULC.");
        }
    }

    @Test
    public void testGetQuantidadeMercadoria() {
        Armazém armazém = new Armazém(10, 10);
        ULC ulc = new ULC(123, armazém);

        if (ulc.getQuantidadeMercadoria() == 1) {
            System.out.println("Quantidade de mercadorias: " + ulc.getQuantidadeMercadoria());
        } else {
            System.out.println("Falha ao obter a quantidade de mercadorias.");
        }
    }
}
