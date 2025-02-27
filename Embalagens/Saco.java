package Embalagens;
import Produtos.*;
import Elementos.*;

import java.util.ArrayList;

/**
 * The Saco class represents a bag packaging.
 * It can store a single product.
 */
public class Saco extends Embalagem {
    private final int capacidade = 1;
    private Produto produto;
    private double pesoSaco;
    private ArrayList<Produto> saco;
    private TipoEmbalagem tipoEmbalagem;
    private Posicao destinoEmbalagem;
    private Posicao posicaoAtual;

    /**
     * Constructor for the Saco class.
     *
     * @param codigo the code of the bag
     */
    public Saco(int codigo) {
        super(codigo);
        saco = new ArrayList<>(capacidade);
        pesoSaco = 0.0;
        tipoEmbalagem = TipoEmbalagem.SACO;
    }

    /**
     * Checks if it is possible to store a product in the bag.
     *
     * @param produto the product to be checked
     * @return true if it is possible to store the product, false otherwise
     */
    public boolean podeArmazenarProduto(Produto produto) {
        boolean podeArmazenarProduto = true;
        if (!saco.isEmpty()) {
            podeArmazenarProduto = false;
        } else {
            if (produto.getTipo() == TipoProduto.LIVRO || produto.getTipo() == TipoProduto.ELETRONICO_GRANDE || produto.getTipo() == TipoProduto.BRINQUEDO_GRANDE) {
                podeArmazenarProduto = false;
                System.out.println("This product cannot be added to the bag");
            }
        }
        return podeArmazenarProduto;
    }

    /**
     * Adds a product to the bag if it is possible to store it.
     *
     * @param produto the product to be added
     */
    public void addProduto(Produto produto) {
        if (podeArmazenarProduto(produto)) {
            saco.add(produto);
            pesoSaco += produto.getPeso();
        }
    }

    /**
     * Removes a product from the bag.
     *
     * @param produto the product to be removed
     */
    public void removeProduto(Produto produto) {
        saco.remove(produto);
        pesoSaco = 0.0;
    }

    /**
     * Gets the total weight of the bag.
     *
     * @return the total weight of the bag
     */
    public double getPesoSaco() {
        return pesoSaco;
    }

    /**
     * Gets the list of products in the bag.
     *
     * @return the list of products in the bag
     */
    public ArrayList<Produto> getSaco() {
        return saco;
    }

    @Override
    public Posicao getDestinoEmbalagem() {
        return destinoEmbalagem;
    }

    @Override
    public void setDestinoEmbalagem(Posicao destinoEmbalagem) {
        this.destinoEmbalagem = destinoEmbalagem;
    }

    @Override
    public Posicao getPosicaoAtual() {
        return posicaoAtual;
    }

    @Override
    public void setPosicaoAtual(Posicao posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    /**
     * Gets the capacity of the bag.
     *
     * @return the capacity of the bag
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Gets the type of packaging of the bag.
     *
     * @return the type of packaging of the bag
     */
    public TipoEmbalagem getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    /**
     * Returns a string representation of the Saco object.
     *
     * @return a string representing the Saco object
     */
    @Override
    public String toString() {
        return "Saco{" +
                "\n  capacidade=" + capacidade +
                "\n  produto=" + produto +
                "\n  pesoSaco=" + pesoSaco +
                "\n  saco=" + saco +
                "\n  tipoEmbalagem=" + tipoEmbalagem +
                "\n}";
    }
}
