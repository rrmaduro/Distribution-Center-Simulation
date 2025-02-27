package Embalagens;
import Produtos.*;
import Elementos.*;

import java.util.ArrayList;

/**
 * The Palete class represents a pallet of cardboard boxes.
 * Each pallet has a list of cardboard boxes, a total weight,
 * a box counter, and a packaging type.
 */
public class Palete extends Embalagem {
    private ArrayList<CaixaCartao> caixasCartao;
    private double pesoPalete;
    private int counterCaixasCartao;
    private final TipoEmbalagem tipoEmbalagem;
    private Posicao destinoPalete;
    private Posicao posicaoAtual;

    /**
     * Constructor for the Palete class.
     * Initializes the list of cardboard boxes as empty,
     * sets an initial weight of 20.0, initializes the box counter as 0,
     * and sets the packaging type as PALETE.
     *
     * @param codigo the code of the pallet
     */
    public Palete(int codigo) {
        super(codigo);
        caixasCartao = new ArrayList<>();
        pesoPalete = 0.0;
        counterCaixasCartao = 0;
        tipoEmbalagem = TipoEmbalagem.PALETE;
    }

    /**
     * Adds a cardboard box to the pallet.
     * The box is added to the pallet's list of cardboard boxes,
     * the box counter is incremented, and the total weight of the pallet
     * is updated by adding the weight of the box.
     *
     * @param caixa the cardboard box to be added to the pallet
     */
    public void addCaixaCartao(CaixaCartao caixa) {
        caixasCartao.add(caixa);
        counterCaixasCartao++;
        pesoPalete += caixa.getPesoCaixaCartao();
    }

    /**
     * Removes a cardboard box from the pallet.
     * The box is removed from the pallet's list of cardboard boxes,
     * the box counter is decremented, and the total weight of the pallet
     * is updated by subtracting the weight of the box.
     *
     * @param caixa the cardboard box to be removed from the pallet
     */
    public void removeCaixaCartao(CaixaCartao caixa) {
        caixasCartao.remove(caixa);
        counterCaixasCartao--;
        pesoPalete -= caixa.getPesoCaixaCartao();
    }

    /**
     * Gets the list of cardboard boxes on the pallet.
     *
     * @return the list of cardboard boxes on the pallet
     */
    public ArrayList<CaixaCartao> getPalete() {
        return caixasCartao;
    }

    /**
     * Gets the number of boxes on the pallet.
     *
     * @return the number of boxes on the pallet
     */
    public int getNumeroCaixasCartao() {
        return counterCaixasCartao;
    }

    @Override
    public Posicao getDestinoEmbalagem() {
        return destinoPalete;
    }

    @Override
    public void setDestinoEmbalagem(Posicao destinoPalete) {
        this.destinoPalete = destinoPalete;
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
     * Gets the packaging type of the pallet.
     *
     * @return the packaging type of the pallet
     */
    public TipoEmbalagem getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    /**
     * Gets the total weight of the pallet.
     *
     * @return the total weight of the pallet
     */
    public double getPesoPalete() {
        return pesoPalete;
    }

    /**
     * Returns a string representation of the pallet.
     *
     * @return a string representing the pallet
     */
    @Override
    public String toString() {
        return "Palete [\n" +
        "Código: " + getCodigo() + ",\n" +
        "Número de caixas de cartão: " + counterCaixasCartao + ",\n" +
        "Peso total da palete: " + pesoPalete + " kg" + ",\n" +
        "Destino da palete: " + destinoPalete + ",\n" +
        "Posição atual da palete: " + posicaoAtual + "\n" +
        "]";
    }

}
