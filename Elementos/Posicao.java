package Elementos;

/**
 * The `Posicao` class represents a position in a two-dimensional space.
 * It implements the `Elemento` interface.
 */
public class Posicao implements Elemento {
    private final int linha;
    private final int coluna;
    private final int comprimento;
    private final int largura;
    private TipoElemento tipoElemento;

    /**
     * Constructor for the `Posicao` class.
     * Defines the row and column of the position, ensuring they are not negative.
     * Sets the length and width as 2.
     *
     * @param row    The row of the position.
     * @param column The column of the position.
     */
    public Posicao(int linha, int coluna) {
        if (linha < 0 && coluna < 0) {
            this.linha = 0;
            this.coluna = 0;
        } else {
            this.linha = linha;
            this.coluna = coluna;
        }
        this.comprimento = 2;
        this.largura = 2;
    }

    /**
     * Calculates the distance between the current position and another given position.
     *
     * @param position The position to which the distance is calculated.
     * @return The distance between the positions.
     */
    protected double distanceTo(Posicao position) {
        int x1 = this.getComprimento();
        int y1 = this.getLargura();
        int x2 = position.getComprimento();
        int y2 = position.getLargura();

        int deltaX = x2 - x1;
        int deltaY = y2 - y1;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Gets the row of the position.
     *
     * @return The row of the position.
     */
    public int getLinha() {
        return linha;
    }

    /**
     * Gets the column of the position.
     *
     * @return The column of the position.
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * Gets the length of the position.
     *
     * @return The length of the position.
     */
    public int getComprimento() {
        return comprimento;
    }

    /**
     * Gets the width of the position.
     *
     * @return The width of the position.
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Gets the element type of the position.
     *
     * @return The element type of the position.
     */
    @Override
    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Posicao other = (Posicao) obj;
        return linha == other.getLinha() && coluna == other.getColuna();
    }
}
