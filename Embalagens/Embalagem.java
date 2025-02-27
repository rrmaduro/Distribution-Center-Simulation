package Embalagens;
import Produtos.*;
import Elementos.*;

import java.io.Serializable;

/**
 * A classe Embalagem representa uma embalagem genérica.
 * Embalagem é uma classe abstrata e serve como base para a definição de tipos específicos de embalagens.
 */
public abstract class Embalagem implements Serializable {
    private final int codigo;
    private Posicao destinoEmbalagem;
    private Posicao posicaoAtual;

    /**
     * Construtor da classe Embalagem.
     *
     * @param codigo o código da embalagem
     */
    public Embalagem(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o código da embalagem.
     *
     * @return o código da embalagem
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Obtém o tipo da embalagem.
     *
     * @return o tipo da embalagem (método abstrato a ser implementado pelas subclasses)
     */
    public abstract TipoEmbalagem getTipoEmbalagem();
    
    public void setDestinoEmbalagem(Posicao destino){
        destinoEmbalagem=destino;
    }

    public Posicao getDestinoEmbalagem() {
        return destinoEmbalagem;
    }
    
    public Posicao getPosicaoAtual(){
        return getPosicaoAtual();
    }

    public void setPosicaoAtual(Posicao posicaoAtual){
        this.posicaoAtual=posicaoAtual;
    }
}
