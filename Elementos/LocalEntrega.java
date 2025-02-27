package Elementos;
import Veiculos.*;
import Embalagens.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/**
 * The `LocalEntrega` class represents a delivery position in the warehouse.
 * It can contain vehicles, packed packages, and products on pallets.
 */
public class LocalEntrega extends Posicao {
    private static final int capacity = 1;
    private ArrayList<Veiculo> veiculos;
    private HashSet<Embalagem> produtosEmbalados;
    private HashSet<Palete> produtosEmPaletes;

    private int linha, coluna;
    private int counterVeiculos;
    private int counterProdutosEmbalados;
    private int counterProdutosEmPalete;
    private Embalagem elementToRemove;
    private TipoElemento tipoElemento;

    /**
     * Creates an instance of the `LocalEntrega` class with the specified coordinates.
     *
     * @param linha  The row coordinate of the delivery position.
     * @param coluna The column coordinate of the delivery position.
     */
    public LocalEntrega(int linha, int coluna) {
        super(linha, coluna);
        counterProdutosEmbalados = 0;
        counterProdutosEmPalete = 0;
        counterVeiculos = 0;
        tipoElemento = TipoElemento.LOCAL_ENTREGA;
        veiculos = new ArrayList<>(capacity);
        this.produtosEmbalados = new HashSet<>();
        this.produtosEmPaletes = new HashSet<>();
    }

    /**
     * Gets the element type of the delivery position.
     *
     * @return The element type of the delivery position.
     */
    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    /**
     * Gets the palletized products present at the delivery position.
     *
     * @return The palletized products present at the delivery position.
     */
    public HashSet<Palete> getProdutosEmPaletes() {
        return produtosEmPaletes;
    }

    /**
     * Gets the packed packages present at the delivery position.
     *
     * @return The packed packages present at the delivery position.
     */
    public HashSet<Embalagem> getProdutosEmbalados() {
        return produtosEmbalados;
    }

    /**
     * Adds a vehicle to the delivery position, if possible.
     *
     * @param veiculo The vehicle to be added.
     */
    public void addVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            if (counterVeiculos < capacity) {
                if (veiculo instanceof AGC) {
                    veiculos.add(veiculo);
                    counterVeiculos++;
                    System.out.println("The AGC has been moved to this position.");
                }
                if (veiculo instanceof ULC) {
                    veiculos.add(veiculo);
                    counterVeiculos++;
                    System.out.println("The ULC has been moved to this position.");
                }
                if (veiculo instanceof VeiculoRebocador) {
                    veiculos.add(veiculo);
                    counterVeiculos++;
                    System.out.println("The Tug Vehicle has been moved to this position.");
                }
            } else {
                System.out.println("Unable to add vehicle.");
            }
        } else {
            System.out.println("Unable to add vehicle.");
        }
    }

    /**
     * Removes a vehicle from the delivery position, if present.
     *
     * @param veiculo The vehicle to be removed.
     */
    public void removeVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            if (veiculos.contains(veiculo)) {
                if (veiculo instanceof AGC) {
                    veiculos.remove(veiculo);
                    counterVeiculos--;
                    System.out.println("The AGC has been moved to this position.");
                }
                if (veiculo instanceof ULC) {
                    veiculos.remove(veiculo);
                    counterVeiculos--;
                    System.out.println("The ULC has been moved to this position.");
                }
                if (veiculo instanceof VeiculoRebocador) {
                    veiculos.remove(veiculo);
                    counterVeiculos--;
                    System.out.println("The Tug Vehicle has been moved to this position.");
                }
            } else {
                System.out.println("Unable to remove vehicle.");
            }
        } else {
            System.out.println("Unable to remove vehicle.");
        }
    }

    /**
     * Unloads a vehicle at the delivery position, if present.
     *
     * @param veiculo The vehicle to be unloaded.
     */
    public void descarregarVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            if (veiculos.contains(veiculo)) {
                if (veiculo instanceof AGC) {
                    ArrayList<Embalagem> embalagens = ((AGC) veiculo).retrieveAllPackages();
                    produtosEmbalados.addAll(embalagens);
                    counterProdutosEmbalados++;
                    System.out.println("Unloading completed.");
                }
                if (veiculo instanceof ULC) {
                    ArrayList<Palete> paletes = ((ULC) veiculo).retrieveAllPaletes();
                    produtosEmPaletes.addAll(paletes);
                    counterProdutosEmPalete++;
                    System.out.println("Unloading completed.");
                }
                if (veiculo instanceof VeiculoRebocador veiculoRebocador) {
                    if (!veiculoRebocador.getVeiculoRebocado().isEmpty()) {
                        for (Veiculo veiculoTransportado : veiculoRebocador.getVeiculoRebocado()) {
                            if (veiculoTransportado instanceof CarrinhoTransporte carrinhoTransporte) {
                                for (Embalagem embalagem : carrinhoTransporte.getEmbalagems()) {
                                    addEmbalagem(embalagem);

                                }
                                carrinhoTransporte.getEmbalagems().clear();
                                System.out.println("Unloading of Transport Cart completed.");
                            }
                        }
                    }
                }
            }
        }
    }

    public void addEmbalagem(Embalagem embalagem) {
        if (embalagem != null) {
            produtosEmbalados.add(embalagem);
        }
    }

    public void removeEmbalagem(Embalagem embalagem) {
        if (embalagem != null && produtosEmbalados.contains(embalagem)) {
            produtosEmbalados.remove(embalagem);
        }
    }

    /**
     * Gets the list of vehicles present at the delivery position.
     *
     * @return The list of vehicles present at the delivery position.
     */
    public ArrayList<Veiculo> getVeiculo() {
        return veiculos;
    }

    /**
     * Checks if the delivery position has vehicles.
     *
     * @return true if the delivery position has vehicles, false otherwise.
     */
    public boolean hasVeiculo() {
        return counterVeiculos > 0;
    }

    /**
     * Calculates the hash code value for the current instance.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(linha, coluna, veiculos, produtosEmbalados, produtosEmPaletes);
    }

    /**
     * Checks if the current instance is equal to the specified object.
     *
     * @param obj The object to compare with the current instance.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocalEntrega other = (LocalEntrega) obj;
        return linha == other.linha &&
                coluna == other.coluna &&
                Objects.equals(veiculos, other.veiculos) &&
                Objects.equals(produtosEmbalados, other.produtosEmbalados) &&
                Objects.equals(produtosEmPaletes, other.produtosEmPaletes);
    }

}
