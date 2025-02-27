package Elementos;

import Veiculos.*;
import Embalagens.*;
import Produtos.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Iterator;

/**
 * The LocalRecolha class represents a collection position in the warehouse.
 * <p>
 * It can contain vehicles, packed packages, and palletized products.
 */
public class LocalRecolha extends Posicao {
    private static final int capacidade = 1;
    private ArrayList<Veiculo> veiculos;
    private HashSet<Embalagem> produtosEmbalados;
    private HashSet<Embalagem> embalagens;
    private HashSet<Produto> produtos;
    private HashSet<Palete> paletes;
    private int linha, coluna;
    private int counterVeiculos;
    private int counterEmbalagens;
    private int counterProdutosEmbalados;
    private int counterProdutosEmPalete;
    private TipoElemento tipoElemento;

    /**
     * Creates an instance of the LocalRecolha class with the specified coordinates.
     *
     * @param linha  The row coordinate of the collection position.
     * @param coluna The column coordinate of the collection position.
     */
    public LocalRecolha(int linha, int coluna) {
        super(linha, coluna);
        this.linha = linha;
        this.coluna = coluna;
        counterProdutosEmbalados = 0;
        counterProdutosEmPalete = 0;
        counterVeiculos = 0;
        tipoElemento = TipoElemento.LOCAL_RECOLHA;
        veiculos = new ArrayList<>(capacidade);
        produtosEmbalados = new HashSet<>();
        paletes = new HashSet<>();
        embalagens = new HashSet<>();
        produtos = new HashSet<>();
    }

    /**
     * Gets the type of element for the collection position.
     *
     * @return The type of element for the collection position.
     */
    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    /**
     * Gets the palletized products present in the collection position.
     *
     * @return The palletized products present in the collection position.
     */
    public HashSet<Palete> getPaletes() {
        return paletes;
    }

    /**
     * Gets the packed packages present in the collection position.
     *
     * @return The packed packages present in the collection position.
     */
    public HashSet<Embalagem> getProdutosEmbalados() {
        return produtosEmbalados;
    }

    /**
     * Adds a product to the collection position.
     *
     * @param produto The product to be added.
     */
    public void addProduto(Produto produto) {
        if (produto != null) {
            produtos.add(produto);
        } else {
            System.out.println("Unable to add product.");
        }
    }

    /**
     * Gets the products present in the collection position.
     *
     * @return A set of products present in the collection position.
     */
    public HashSet<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Removes a product from the collection position, if present.
     *
     * @param produto The product to be removed.
     */
    public void removeProduto(Produto produto) {
        if (produto != null) {
            produtos.remove(produto);
        } else {
            System.out.println("Unable to remove product.");
        }
    }

    /**
     * Adds a packed package to the collection position.
     *
     * @param embalagem The packed package to be added.
     */
    public void addEmbalagem(Embalagem embalagem) {
        if (embalagem != null) {
            if (embalagem instanceof Caixa) {
                embalagens.add(embalagem);
                counterEmbalagens++;
            } else if (embalagem instanceof CaixaCartao) {
                embalagens.add(embalagem);
                counterEmbalagens++;
            } else if (embalagem instanceof Saco) {
                embalagens.add(embalagem);
                counterEmbalagens++;
            }
        } else {
            System.out.println("Impossível adicionar embalagem.");
        }
    }

    /**
     * Removes a packaging item from the collection point.
     *
     * @param embalagem The packaging item to be removed.
     */
    public void removeEmbalagem(Embalagem embalagem) {
        if (embalagem != null) {
            if (embalagem instanceof Caixa) {
                embalagens.remove(embalagem);
                counterEmbalagens--;
            } else if (embalagem instanceof CaixaCartao) {
                embalagens.remove(embalagem);
                counterEmbalagens--;
            } else if (embalagem instanceof Saco) {
                embalagens.remove(embalagem);
                counterEmbalagens--;
            }
        } else {
            System.out.println("Impossível adicionar embalagem.");
        }
    }

    /**
     * Retrieves the packaging items present at the collection point.
     *
     * @return A set of packaging items present at the collection point.
     */
    public HashSet<Embalagem> getEmbalagens() {
        return embalagens;
    }

    /**
     * Adds a pallet to the collection point.
     *
     * @param palete The pallet to be added.
     */
    public void addPalete(Palete palete) {
        if (palete != null) {
            paletes.add(palete);
            counterProdutosEmPalete++;
        } else {
            System.out.println("Impossível adicionar palete.");
        }
    }

    /**
     * Removes a pallet from the collection point.
     *
     * @param palete The pallet to be removed.
     */
    public void removePalete(Palete palete) {
        if (palete != null) {
            paletes.remove(palete);
            counterProdutosEmPalete--;
        } else {
            System.out.println("Impossível remover palete.");
        }
    }

    /**
     * Adds a vehicle to the collection point, if possible.
     *
     * @param veiculo The vehicle to be added.
     */
    public void addVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            if (counterVeiculos < capacidade) {
                if (veiculo instanceof AGC) {
                    veiculos.add(veiculo);
                    counterVeiculos++;
                    System.out.println("O AGC foi movido para esta posição.");
                } else if (veiculo instanceof ULC) {
                    veiculos.add(veiculo);
                    counterVeiculos++;
                    System.out.println("O ULC foi movido para esta posição.");
                } else if (veiculo instanceof VeiculoRebocador) {
                    veiculos.add(veiculo);
                    counterVeiculos++;
                    System.out.println("O Veículo Rebocador foi movido para esta posição.");
                }
            } else {
                System.out.println("Impossível adicionar veículo. Capacidade máxima atingida.");
            }
        } else {
            System.out.println("Impossível adicionar veículo. Veículo inválido.");
        }
    }

    /**
     * Packs products into available packaging items and adds cardboard boxes to a pallet.
     */
    public void embalarProdutos() {
        ArrayList<CaixaCartao> caixasCartaoARetirar = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto != null) {
                for (Embalagem embalagem : embalagens) {
                    if (embalagem instanceof Saco saco) {
                        if (saco.podeArmazenarProduto(produto)) {
                            saco.addProduto(produto);
                            produtosEmbalados.add(saco);
                        }

                    } else if (embalagem instanceof Caixa caixa) {
                        if (caixa.podeArmazenarProduto(produto)) {
                            caixa.addProduto(produto);
                            produtosEmbalados.add(caixa);
                        }

                    } else if (embalagem instanceof CaixaCartao caixaCartao) {
                        if (caixaCartao.podeArmazenarProduto(produto)) {
                            caixaCartao.armazenarProduto(produto);
                            caixasCartaoARetirar.add(caixaCartao);
                        }

                    }
                }
            }
        }
        for (CaixaCartao caixaCartao : caixasCartaoARetirar) {
            for (Palete palete : paletes) {
                palete.addCaixaCartao(caixaCartao);
            }
        }

        caixasCartaoARetirar.clear();
    }

    /**
     * Removes a vehicle from the collection point, if present.
     *
     * @param veiculo The vehicle to be removed.
     */
    public void removeVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            if (veiculos.contains(veiculo)) {
                if (veiculo instanceof AGC) {
                    veiculos.remove(veiculo);
                    counterVeiculos--;
                    System.out.println("O AGC foi movido para esta posição.");
                    return; // Exit the method after removing the vehicle
                }
                if (veiculo instanceof ULC) {
                    veiculos.remove(veiculo);
                    counterVeiculos--;
                    System.out.println("O ULC foi movido para esta posição.");
                    return; // Exit the method after removing the vehicle
                }
                if (veiculo instanceof VeiculoRebocador) {
                    veiculos.remove(veiculo);
                    counterVeiculos--;
                    System.out.println("O Veículo Rebocador foi movido para esta posição.");
                    return; // Exit the method after removing the vehicle
                }
            }
            System.out.println("Impossível remover veículo.");
        } else {
            System.out.println("Impossível remover veículo.");
        }
    }


    /**
     * Loads a vehicle with packaging items or pallets present at the collection point.
     *
     * @param veiculo The vehicle to be loaded.
     */
    public void carregarVeiculo(Veiculo veiculo) {
        if (veiculo != null && veiculos.contains(veiculo)) {
            if (veiculo instanceof AGC) {
                AGC agc = (AGC) veiculo;
                Iterator<Embalagem> iterator = produtosEmbalados.iterator();
                while (iterator.hasNext() && agc.getCargaTotal() < agc.getMaxPeso()) {
                    Embalagem embalagem = iterator.next();
                    agc.addPackage(embalagem);
                    iterator.remove();
                    counterProdutosEmbalados--;
                }
            } else if (veiculo instanceof CarrinhoTransporte) {
                CarrinhoTransporte carrinho = (CarrinhoTransporte) veiculo;
                Iterator<Embalagem> iterator = produtosEmbalados.iterator();
                while (iterator.hasNext() && carrinho.getCapacidadeMaxima() < carrinho.getCargaAtual()) {
                    Embalagem embalagem = iterator.next();
                    carrinho.addPackage(embalagem);
                    iterator.remove();
                    counterProdutosEmbalados--;
                }
            } else if (veiculo instanceof ULC) {
                ULC ulc = (ULC) veiculo;
                Iterator<Palete> iterator = paletes.iterator();
                while (iterator.hasNext() && ulc.getCounter() < ulc.getQuantidadeMercadoria()) {
                    Palete palete = iterator.next();
                    ulc.addPalete(palete);
                    iterator.remove();
                    counterProdutosEmPalete--;
                }
            }
            System.out.println("Carga concluída.");
        } else {
            System.out.println("Veículo inválido.");
        }
    }



    /**
     * Retrieves the vehicles present at the collection point.
     *
     * @return The vehicles present at the collection point.
     */
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * Checks if the collection point has vehicles.
     *
     * @return true if the collection point has vehicles, false otherwise.
     */
    public boolean hasVeiculo() {
        return counterVeiculos > 0;
    }

    /**
     * Returns the hash code for the collection point.
     *
     * @return The calculated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(linha, coluna, veiculos, produtosEmbalados, paletes);
    }

    /**
     * Checks if the collection point is equal to another object.
     *
     * @param obj The object to be compared.
     * @return true if the collection point is equal to the provided object, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocalRecolha other = (LocalRecolha) obj;
        return linha == other.getLinha() && coluna == other.getColuna() && Objects.equals(veiculos, other.veiculos) && Objects.equals(produtosEmbalados, other.produtosEmbalados) && Objects.equals(paletes, other.paletes);
    }

}
