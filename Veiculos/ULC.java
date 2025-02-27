package Veiculos;
import Elementos.Direcao;
import Elementos.Posicao;
import Embalagens.*;
import Armazem.*;
import Sensores.CameraSensor;
import Sensores.LidarSensor;
import Sensores.UltrasonicSensor;

import java.util.ArrayList;

/**
The ULC class represents a ULC (Light Cargo Unit) vehicle.
It can transport only one pallet.
 */
public class ULC extends Veiculo {
    private final int codigoULC;
    private final int quantidadeMercadoria = 1;
    private int counter;
    private Palete carga;
    private double pesoCarga;
    private Armazém armazem;
    private Posicao posicao;
    private Direcao direcao;
    private LidarSensor lidarSensor;
    private UltrasonicSensor ultrasonicSensor;
    private CameraSensor cameraSensor;

    /**
    Constructor for the ULC class.
    @param ulcCode the ULC vehicle code
    @param warehouse the warehouse to which the vehicle is associated
     */
    public ULC(int codigoULC, Armazém armazem) {
        super(codigoULC);
        counter = 0;
        this.codigoULC = codigoULC;
        pesoCarga = 0.0;
        this.armazem = armazem;
        armazem.addVeiculo(this);
        posicao=armazem.getPosicao(this);
        direcao=Direcao.NULL;
        lidarSensor= new LidarSensor(this);
        ultrasonicSensor= new UltrasonicSensor(this);
        cameraSensor= new CameraSensor(this, lidarSensor, ultrasonicSensor);
    }

    /**
    Adds a pallet to the ULC vehicle, if possible.
    @param pallet the pallet to be added
     */
    public void addPalete(Palete palete) {
        if (palete != null && counter < quantidadeMercadoria) {
            carga = palete;
            pesoCarga = palete.getPesoPalete();
        } else {
            System.out.println("Impossível adicionar a palete.");
        }
    }

    /**
    Removes the pallet from the ULC vehicle.
     */
    public void removePalete(Palete palete) {
        if (carga != null) {
            carga = null;
            pesoCarga = 0;
        } else {
            System.out.println("Não há palete para remover.");
        }
    }

    /**
    Removes all the pallets from the ULC vehicle and returns them in a list.
    @return a list containing all the removed pallets
     */
    public ArrayList<Palete> retrieveAllPaletes() {
        ArrayList<Palete> paletes = new ArrayList<>();
        if (carga != null) {
            paletes.add(carga);
            carga = null;
            pesoCarga = 0;
        }
        return paletes;
    }

    /**
    Gets the total weight of the cargo in the ULC vehicle.
    @return the total weight of the cargo
     */
    public double getPesoCarga() {
        return pesoCarga;
    }

    /**
    Gets the code of the ULC vehicle.
    @return the vehicle code
     */
    public int getCodigoULC() {
        return codigoULC;
    }

    public Palete getPalete() {
        return carga;
    }

    /**
    Gets the quantity of cargo that the vehicle can transport.
    @return the quantity of cargo
     */
    public int getQuantidadeMercadoria() {
        return quantidadeMercadoria;
    }

    /**
    Gets the cargo counter of the ULC vehicle.
    @return the cargo counter
     */
    public int getCounter() {
        return counter;
    }

    @Override
    public Posicao getPosicao() {
        posicao=armazem.getPosicao(this);
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
    Returns a String representation of the ULC object.
    @return a String representing the ULC object
     */
    @Override
    public String toString() {
        return "ULC{" +
        "\n  codigoULC=" + codigoULC +
        "\n  quantidadeMercadoria=" + quantidadeMercadoria +
        "\n  counter=" + counter +
        "\n  carga=" + carga +
        "\n  pesoCarga=" + pesoCarga +
        "\n  armazem=" + armazem +
        "\n}";
    }
}
