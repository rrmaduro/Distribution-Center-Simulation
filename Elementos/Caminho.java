package Elementos;
import Veiculos.*;

import java.util.ArrayList;

/**
 * The `Caminho` class represents a position on the transportation system path.
 * It can store one vehicle at a time.
 */
public class Caminho extends Posicao {
    private static final int capacidade = 1;
    private ArrayList<Veiculo> veiculos;
    private int counter;
    private TipoElemento tipoElemento;
    private Posicao pontoDestino;

    /**
     * Creates an instance of the `Caminho` class with the specified position.
     *
     * @param row    The row of the path position.
     * @param column The column of the path position.
     */
    public Caminho(int linha, int coluna) {
        super(linha, coluna);
        veiculos = new ArrayList<Veiculo>(capacidade);
        counter = 0;
        tipoElemento = TipoElemento.CAMINHO;
        pontoDestino = null;
    }

    /**
     * Gets the element type of the position.
     *
     * @return The element type of the position.
     */
    public TipoElemento getTipoElement() {
        return tipoElemento;
    }

    /**
     * Gets the list of vehicles at the path position.
     *
     * @return The list of vehicles at the path position.
     */
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * Gets the capacity of vehicles that the path position can store.
     *
     * @return The capacity of vehicles for the path.
     */
    public static int getCapacidade() {
        return capacidade;
    }

    /**
     * Gets the counter of vehicles currently stored at the path position.
     *
     * @return The counter of vehicles at the path position.
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Sets the destination point for which the vehicle is moving.
     *
     * @param position The destination point to set.
     */
    public void setPontoDestino(Posicao posicao){
        this.pontoDestino = posicao;
    }

    /**
     * Gets the destination point to which the vehicle is moving.
     *
     * @return The current destination point.
     */
    public Posicao getPontoDestino(){
        return pontoDestino;
    }

    /**
     * Adds a vehicle to the path position, if possible.
     *
     * @param vehicle The vehicle to be added.
     */
    public void addVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            if (counter < capacidade) {
                if (veiculo instanceof AGC) {
                    veiculos.add(veiculo);
                    counter++;
                    System.out.println("O AGC foi movido para esta posição.");
                }
                if (veiculo instanceof ULC) {
                    veiculos.add(veiculo);
                    counter++;
                    System.out.println("O ULC foi movido para esta posição.");
                }
                if (veiculo instanceof VeiculoRebocador) {
                    veiculos.add(veiculo);
                    counter++;
                    System.out.println("O Veículo Rebocador foi movido para esta posição.");
                }
                if (veiculo instanceof CarrinhoTransporte) {
                    veiculos.add(veiculo);
                    counter++;
                    System.out.println("O Carrinho de Transporte foi movido para esta posição.");
                }
            } else {
                System.out.println("Impossível adicionar veículo.");
            }
        } else {
            System.out.println("Impossível adicionar veículo.");
        }
    }

    /**
     * Removes a vehicle from the path position, if present.
     *
     * @param vehicle The vehicle to be removed.
     */
    public void removeVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            if (veiculos.contains(veiculo)) {
                if (veiculo instanceof AGC) {
                    veiculos.remove(veiculo);
                    counter--;
                    System.out.println("O AGC foi removido desta posição.");
                }
                if (veiculo instanceof ULC) {
                    veiculos.remove(veiculo);
                    counter--;
                    System.out.println("O ULC foi removido desta posição.");
                }
                if (veiculo instanceof VeiculoRebocador) {
                    veiculos.remove(veiculo);
                    counter--;
                    System.out.println("O Veículo Rebocador foi removido desta posição.");
                }
                if (veiculo instanceof CarrinhoTransporte) {
                    veiculos.remove(veiculo);
                    counter--;
                    System.out.println("O Carrinho de Transporte foi removido desta posição.");
                }
            } else {
                System.out.println("Impossível remover veículo.");
            }
        } else {
            System.out.println("Impossível remover veículo.");
        }
    }

    /**
     * Checks if the path position contains an AGC.
     *
     * @return true if an AGC is present at the position, false otherwise.
     */
    public boolean hasAGC() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof AGC) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the path position contains a ULC.
     *
     * @return true if a ULC is present at the position, false otherwise.
     */
    public boolean hasULC() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof ULC) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the path position contains a Tow Vehicle.
     *
     * @return true if a Tow Vehicle is present at the position, false otherwise.
     */
    public boolean hasVeiculoRebocador() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof VeiculoRebocador) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the path position contains a Transport Cart.
     *
     * @return true if a Transport Cart is present at the position, false otherwise.
     */
    public boolean hasCarrinhoTransporte() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof CarrinhoTransporte) {
                return true;
            }
        }
        return false;
    }
}
