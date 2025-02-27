package Veiculos;

import Armazem.*;
import Elementos.Direcao;
import Elementos.Posicao;
import Sensores.CameraSensor;
import Sensores.LidarSensor;
import Sensores.UltrasonicSensor;

import java.util.ArrayList;

/**
 * The VeiculoRebocador class represents a tow truck vehicle.
 * <p>
 * It can tow a single transport cart.
 */
public class VeiculoRebocador extends Veiculo {
    private final int capacidadeDeReboque = 1;
    private final ArrayList<CarrinhoTransporte> veiculoRebocado;
    private Armazém armazem;
    private Posicao posicao;
    private Direcao direcao;
    private LidarSensor lidarSensor;
    private UltrasonicSensor ultrasonicSensor;
    private CameraSensor cameraSensor;

    /**
     * Constructor for the VeiculoRebocador class.
     *
     * @param codigo    the code of the tow truck vehicle
     * @param warehouse the warehouse to which the vehicle is associated
     */
    public VeiculoRebocador(int codigo, Armazém armazem) {
        super(codigo);
        this.veiculoRebocado = new ArrayList<>(capacidadeDeReboque);
        this.armazem = armazem;
        armazem.addVeiculo(this);
        posicao = armazem.getPosicao(this);
        direcao = Direcao.NULL;
        lidarSensor = new LidarSensor(this);
        ultrasonicSensor = new UltrasonicSensor(this);
        cameraSensor = new CameraSensor(this, lidarSensor, ultrasonicSensor);
    }

    /**
     * Gets the list of transport carts towed by the tow truck vehicle.
     *
     * @return the list of towed transport carts
     */
    public ArrayList<CarrinhoTransporte> getVeiculoRebocado() {
        return veiculoRebocado;
    }

    /**
     * Gets the towing capacity of the tow truck vehicle.
     *
     * @return the towing capacity
     */
    public int getCapacidadeDeReboque() {
        return capacidadeDeReboque;
    }

    /**
     * Tows a transport cart with the tow truck vehicle.
     *
     * @param transportCart the transport cart to be towed
     */
    public void rebocarCarrinho(CarrinhoTransporte carrinhoTransporte) {
        if (carrinhoTransporte != null) {
            veiculoRebocado.add(carrinhoTransporte);
            System.out.println("O carrinho irá ser rebocado. Carga = " + carrinhoTransporte.getCounterCarga());
        } else {
            System.out.println("Impossível rebocar o carrinho.");
        }
    }

    /**
     * Releases a transport cart that was being towed by the tow truck vehicle.
     *
     * @param transportCart the transport cart to be released
     */
    public void libertarCarrinho(CarrinhoTransporte carrinhoTransporte) {
        if (carrinhoTransporte != null) {
            if (veiculoRebocado.isEmpty()) {
                System.out.println("Não está sendo rebocado nenhum veículo.");
            } else {
                veiculoRebocado.remove(carrinhoTransporte);
                System.out.println("Carrinho removido com sucesso.");
            }
        }
    }

    @Override
    public Posicao getPosicao() {
        posicao = armazem.getPosicao(this);
        return posicao;
    }

    @Override
    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    @Override
    public Direcao getDirecao() {
        return direcao;
    }

    @Override
    public Armazém getArmazem() {
        return armazem;
    }

    @Override
    public LidarSensor getLidarSensor() {
        return lidarSensor;
    }

    @Override
    public UltrasonicSensor getUltrasonicSensor() {
        return ultrasonicSensor;
    }

    @Override
    public CameraSensor getCameraSensor() {
        return cameraSensor;
    }


    /**
     * Returns a String representation of the VeiculoRebocador object.
     *
     * @return a String representing the VeiculoRebocador object
     */
    @Override
    public String toString() {
        return "VeiculoRebocador{" +
                "\n  capacidadeDeReboque=" + capacidadeDeReboque +
                "\n  veiculoRebocado=" + veiculoRebocado +
                "\n  armazem=" + armazem +
                "\n}";
    }
}
