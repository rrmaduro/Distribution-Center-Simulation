package Embalagens;
import Produtos.*;
import Elementos.*;

import java.util.ArrayList;

/**

Class representing a cardboard box as packaging.
 */
public class CaixaCartao extends Embalagem {
    private final boolean isProdutoGrande;
    private ArrayList<Produto> caixaCartaoPequena;
    private ArrayList<Produto> caixaCartaoGrande;
    private int caixaCounter;
    private double pesoCaixa;
    private final TipoEmbalagem tipoEmbalagem;
    private Posicao destinoEmbalagem;
    private Posicao posicaoAtual;

    /**

    Constructor for the CaixaCartao class.
    @param codigo The code of the cardboard box.
    @param isProdutoGrande Indicates if the box is for large or small products.
     */
    public CaixaCartao(int codigo, boolean isProdutoGrande) {
        super(codigo);
        this.isProdutoGrande = isProdutoGrande;
        if (isProdutoGrande) {
            this.caixaCartaoGrande = new ArrayList<>();
        } else {
            this.caixaCartaoPequena = new ArrayList<>();
        }
        pesoCaixa = 0.0;
        tipoEmbalagem = TipoEmbalagem.CAIXACARTAO;
    }

    /**

    Checks if the cardboard box can store the specified product.
    @param produto The product to be checked.
    @return true if the cardboard box can store the product, false otherwise.
     */
    public boolean podeArmazenarProduto(Produto produto) {
        boolean armazena = false;
        int capacidadeRestante;
        if (produto != null) {
            if (isProdutoGrande) {
                if (caixaCartaoGrande.isEmpty()) {
                    if (produto.getTipo() == TipoProduto.BRINQUEDO_GRANDE || produto.getTipo() == TipoProduto.ELETRONICO_GRANDE) {
                        armazena = true;
                        System.out.println("Can be stored in the large box.");
                        System.out.println("Remaining capacity after storing: 0");
                    }
                }
            } else {
                if (caixaCounter < 10) {
                    if (produto.getTipo() == TipoProduto.BRINQUEDO_PEQUENO || produto.getTipo() == TipoProduto.ELETRONICO_PEQUENO) {
                        armazena = true;
                        caixaCounter++;
                        capacidadeRestante = 10 - caixaCounter;
                        System.out.println("Can be stored in the small box.");
                        System.out.println("Remaining capacity after storing " + produto + ": " + capacidadeRestante);
                    }
                }
            }
        }
        return armazena;
    }

    /**

    Stores the product in the cardboard box if possible.
    @param produto The product to be stored.
     */
    public void armazenarProduto(Produto produto) {
        int capacidadeRestante;
        if (produto != null) {
            if (isProdutoGrande) {
                if (caixaCartaoGrande.isEmpty()) {
                    if (produto.getTipo() == TipoProduto.BRINQUEDO_GRANDE || produto.getTipo() == TipoProduto.ELETRONICO_GRANDE) {
                        caixaCartaoGrande.add(produto);
                        pesoCaixa += produto.getPeso();
                        System.out.println("Remaining capacity after storing " + produto + ": 0");
                    }
                }
            } else {
                if (caixaCounter < 10) {
                    if (!(produto.getTipo() == TipoProduto.BRINQUEDO_GRANDE || produto.getTipo() == TipoProduto.ELETRONICO_GRANDE)) {
                        caixaCartaoPequena.add(produto);
                        caixaCounter++;
                        pesoCaixa += produto.getPeso();
                        capacidadeRestante = 10 - caixaCounter;
                        System.out.println("Can be stored in the small box.");
                    }
                }
            }
        }
    }

    /**

    Removes the product from the cardboard box if present.
    @param produto The product to be removed.
     */
    public void removerProduto(Produto produto) {
        int capacidadeRestante;
        if (produto != null) {
            if (isProdutoGrande) {
                if (caixaCartaoGrande.contains(produto)) {
                    caixaCartaoGrande.remove(produto);
                    pesoCaixa -= produto.getPeso();
                    System.out.println(produto.getNome() + " has been removed from the cardboard box.");
                }
            } else {
                if (caixaCounter < 10) {
                    if (caixaCartaoPequena.contains(produto)) {
                        caixaCartaoPequena.remove(produto);
                        caixaCounter--;
                        pesoCaixa -= produto.getPeso();
                        capacidadeRestante = 10 - caixaCounter;
                        System.out.println(produto.getNome() + " has been removed from the cardboard box.");
                    }
                }
            }
        }
    }

    /**

    Gets the list of products stored in the small cardboard box.
    @return The list of products in the small cardboard box.
     */
    public ArrayList<Produto> getCaixaCartaoPequena() {
        return caixaCartaoPequena;
    }

    /**

    Gets the list of products stored in the large cardboard box.
    @return The list of products in the large cardboard box.
     */
    public ArrayList<Produto> getCaixaCartaoGrande() {
        return caixaCartaoGrande;
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

    Gets the type of cardboard box (large or small) and its capacity.
    @return A string describing the box type and its capacity.
     */
    public String getTipoCaixa() {
        String s;
        if (isProdutoGrande) {
            s = "The box can store 1 large product.";
        } else {
            s = "The box can store 10 small products.";
        }
        return s;
    }

    /**

    Gets the capacity of the cardboard box.
    @return The capacity of the cardboard box (1 for a large box, 10 for a small box).
     */
    public double getCapacidade() {
        if (isProdutoGrande) {
            return 1.0;
        } else {
            return 10.0;
        }
    }

    /**

    Gets the total weight of the cardboard box.
    @return The total weight of the cardboard box.
     */
    public double getPesoCaixaCartao() {
        return pesoCaixa;
    }

    /**

    Gets the type of packaging of the cardboard box.
    @return The type of packaging of the cardboard box.
     */
    public TipoEmbalagem getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public boolean isProdutoGrande() {
        return isProdutoGrande;
    }

    @Override
    public String toString() {
        String produtoType = isProdutoGrande ? "Large" : "Small";
        return "Cardboard Box" +
        "\nCode: " + getCodigo() +
        "\nType: " + produtoType +
        "\nTotal Weight: " + getPesoCaixaCartao() + " kg";
}
}