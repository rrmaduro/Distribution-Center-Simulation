package Embalagens;
import Produtos.*;
import Elementos.*;

import java.util.ArrayList;

/**
 * Class representing a box as packaging.
 * A box has the capacity to store a single product.
 */
public class Caixa extends Embalagem {
    private final int capacidade = 1;
    private ArrayList<Produto> caixa;
    private double pesoCaixa;
    private TipoEmbalagem tipoEmbalagem;
    private Posicao destinoEmbalagem;
    private Posicao posicaoAtual;


    /**
     * Constructor for the Caixa class.
     *
     * @param codigo The code of the box.
     */
    public Caixa(int codigo) {
        super(codigo);
        pesoCaixa = 0.0;
        tipoEmbalagem = TipoEmbalagem.CAIXA;
        caixa = new ArrayList<>(capacidade);
    }

    /**
     * Checks if the box can store the specified product.
     *
     * @param produto The product to be checked.
     * @return true if the box can store the product, false otherwise.
     */
    public boolean podeArmazenarProduto(Produto produto) {
        boolean podeArmazenarProduto = true;

        if (!caixa.isEmpty() || produto.getTipo() == TipoProduto.ROUPA || produto.getTipo() == TipoProduto.BRINQUEDO_GRANDE || produto.getTipo() == TipoProduto.ELETRONICO_GRANDE) {
            podeArmazenarProduto = false;
            System.out.println("Esse produto não pode ser adicionado à caixa.");
        }

        return podeArmazenarProduto;
    }


    /**
     * Adds a product to the box, if it can be stored.
     *
     * @param produto The product to be added.
     */
    public void addProduto(Produto produto) {
        if (podeArmazenarProduto(produto)) {
            caixa.add(produto);
            pesoCaixa += produto.getPeso();
        }
    }

    /**
     * Removes a product from the box.
     *
     * @param produto The product to be removed.
     */
    public void removeProduto(Produto produto) {
        caixa.remove(produto);
        pesoCaixa = 0.0;
    }

    /**
     * Gets the total weight of the box, considering the weight of the stored products.
     *
     * @return The total weight of the box.
     */
    public double getPesoCaixa() {
        return pesoCaixa;
    }

    /**
     * Gets the list of products stored in the box.
     *
     * @return The list of products in the box.
     */
    public ArrayList<Produto> getCaixa() {
        return caixa;
    }

    /**
     * Returns the destination of the packaging.
     *
     * @return The destination of the packaging.
     */
    @Override
    public Posicao getDestinoEmbalagem() {
        return destinoEmbalagem;
    }

    /**
     * Sets the destination of the packaging.
     *
     * @param destinoEmbalagem The destination of the packaging.
     */
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
     * Obtém a capacidade da caixa.
     *
     * @return A capacidade da caixa (1 unidade).
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Obtém o tipo de embalagem da caixa.
     *
     * @return O tipo de embalagem da caixa.
     */
    public TipoEmbalagem getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    /**
     * Retorna uma representação em string da caixa.
     *
     * @return uma string representando a caixa
     */
    @Override
    public String toString() {
        return "Caixa [\n" +
                "Código: " + getCodigo() + ",\n" +
                "Peso total da caixa: " + pesoCaixa + " kg" + ",\n" +
                "Tipo de embalagem: " + tipoEmbalagem + ",\n" +
                "Destino da caixa: " + destinoEmbalagem + ",\n" +
                "Posição atual da caixa: " + posicaoAtual + "\n" +
                "]";
    }

}
