package Elementos;

/**
 * The `Parede` class represents a wall in a game.
 * It inherits from the `Posicao` class and defines the element type as WALL.
 */
public class Parede extends Posicao {
    private TipoElemento tipoElemento; // Tipo de elemento (PAREDE)

    /**
     * Constructor for the `Parede` class.
     * Calls the constructor of the superclass `Posicao` with the provided row and column,
     * and sets the element type as WALL.
     *
     * @param row    The row of the wall position.
     * @param column The column of the wall position.
     */
    public Parede(int linha, int coluna) {
        super(linha, coluna);
        tipoElemento = TipoElemento.PAREDE;
    }

    /**
     * Gets the element type of the wall.
     *
     * @return The element type (WALL).
     */
    @Override
    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }
}
