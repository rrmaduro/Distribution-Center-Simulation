package Veiculos;
import Embalagens.*;
import Armazem.*;

import java.util.ArrayList;

/**
The CarrinhoTransporte class represents a transport vehicle called cart.
It can store boxes, cardboard boxes, and bags, respecting a maximum load capacity.
 */
public class CarrinhoTransporte extends Veiculo {

    private final double capacidadeMaxima  = 200.0;
    private double cargaAtual;
    private int counterCaixasCartao;
    private int counterCaixas;
    private int counterSacos;
    private ArrayList<Embalagem> embalagems;
    private Armazém armazem;

    /**
    Creates an instance of the CarrinhoTransporte class with the specified code and adds it to the warehouse.
    @param codigo The code of the transport cart.
    @param warehouse The warehouse to which the transport cart belongs.
     */
    public CarrinhoTransporte(int codigo, Armazém armazem) {
        super(codigo);
        counterCaixasCartao = 0;
        this.embalagems = new ArrayList<>();
        this.armazem = armazem;
        armazem.addVeiculo(this);
    }

    /**
    Gets the maximum load capacity of the transport cart.
    @return The maximum load capacity of the transport cart.
     */
    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
    Gets the current load of the transport cart.
    @return The current load of the transport cart.
     */

    public double getCargaAtual() {
        return cargaAtual;
    }

    /**
    Checks if the transport cart is empty.
    @return true if the transport cart is empty, false otherwise.
     */
    public boolean isEmpty() {
        return getCounterCarga() == 0;
    }

    /**
    Gets the load counter of the transport cart.
    @return The load counter of the transport cart.
     */
    public int getCounterCarga() {
        return counterCaixas + counterSacos + counterCaixasCartao;
    }

    /**
    Adds a package to the transport cart, if possible.
    @param package The package to be added.
     */
    public void addPackage(Embalagem embalagem) {
        if (embalagem instanceof CaixaCartao) {
            if (((CaixaCartao) embalagem).getCaixaCartaoPequena() != null) {
                if (((CaixaCartao) embalagem).getPesoCaixaCartao() + cargaAtual < capacidadeMaxima) {
                    embalagems.add(embalagem);
                    counterCaixasCartao++;
                    this.cargaAtual = cargaAtual + ((CaixaCartao) embalagem).getPesoCaixaCartao();
                }
            }
        } else if (embalagem instanceof Caixa) {
            if (((Caixa) embalagem).getCaixa() != null) {
                if (((Caixa) embalagem).getPesoCaixa() + cargaAtual < capacidadeMaxima) {
                    embalagems.add(embalagem);
                    counterCaixas++;
                    this.cargaAtual = cargaAtual + ((Caixa) embalagem).getPesoCaixa();
                }
            }
        } else if (embalagem instanceof Saco) {
            if (((Saco) embalagem).getSaco() != null) {
                if (((Saco) embalagem).getPesoSaco() + cargaAtual < capacidadeMaxima) {
                    embalagems.add(embalagem);
                    counterSacos++;
                    this.cargaAtual = cargaAtual + ((Saco) embalagem).getPesoSaco();
                }
            }
        } else {
            System.out.println("Não é possível adicionar a embalagem.");
        }
    }

    /**
    Removes a package from the transport cart, if present.
    @param package The package to be removed.
     */
    public void removePackage(Embalagem embalagem) {
        if (embalagem instanceof CaixaCartao) {
            if (embalagems.contains(embalagem)) {
                embalagems.remove(embalagem);
                counterCaixasCartao--;
                this.cargaAtual = cargaAtual - ((CaixaCartao) embalagem).getPesoCaixaCartao();
            }
        } else if (embalagem instanceof Caixa) {
            if (embalagems.contains(embalagem)) {
                embalagems.remove(embalagem);
                counterCaixas--;
                this.cargaAtual = cargaAtual - ((Caixa) embalagem).getPesoCaixa();
            }
        } else if (embalagem instanceof Saco) {
            if (embalagems.contains(embalagem)) {
                embalagems.remove(embalagem);
                counterSacos--;
                this.cargaAtual = cargaAtual - ((Saco) embalagem).getPesoSaco();
            }
        } else {
            System.out.println("Não é possível remover a embalagem.");
        }
    }

    /**
    Gets the list of packages in the transport cart.
    @return The list of packages in the transport cart.
     */
    public ArrayList<Embalagem> getEmbalagems() {
        return embalagems;
    }

    /**
    Returns a list containing all the packages in the transport cart.
    The packages are removed from the cart.
    @return A list with all the packages in the transport cart.
     */
    public ArrayList<Embalagem> retrieveAllPackages() {
        ArrayList<Embalagem> allPackages = new ArrayList<>(embalagems);
        embalagems.clear();
        return allPackages;
    }
}
