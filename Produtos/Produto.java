package Produtos;

/**
The Produto class represents a product stored in the system.
 */
public class Produto {
    private String nome;
    private int id;
    private double peso;
    private TipoProduto tipo;

    /**
    Constructor for the Produto class.
    @param nome nome of the product
    @param id identifier of the product
    @param peso weight of the product
    @param tipo type of the product
     */
    public Produto(String nome, int id, double peso, TipoProduto tipo) {
        this.nome = nome;
        this.id = id;
        this.peso = peso;
        this.tipo = tipo;
    }

    // Getters e Setters

    /**
    Gets the name of the product.
    @return the name of the product
     */
    public String getNome() {
        return nome;
    }

    /**
    Sets the name of the product.
    @param nome the name of the product
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    Gets the identifier of the product.
    @return the identifier of the product
     */
    public int getId() {
        return id;
    }

    /**
    Sets the identifier of the product.
    @param id the identifier of the product
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
    Gets the weight of the product.
    @return the weight of the product
     */
    public double getPeso() {
        return peso;
    }

    /**
    Sets the weight of the product.
    @param peso the weight of the product
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
    Gets the type of the product.
    @return the type of the product
     */
    public TipoProduto getTipo() {
        return tipo;
    }

    /**
    Sets the type of the product.
    @param tipo the type of the product
     */
    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    /**
    Returns a String representation of the Produto object.
    @return a String representing the Produto object
     */
    @Override
    public String toString() {
        return "Produto{" +
        "\n  nome='" + nome + '\'' +
        "\n  id=" + id +
        "\n  peso=" + peso +
        "\n  tipo=" + tipo +
        "\n}";
    }
}
