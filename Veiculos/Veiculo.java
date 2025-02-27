package Veiculos;

import Armazem.Armazém;
import Elementos.Caminho;
import Elementos.Direcao;
import Elementos.Posicao;
import Sensores.CameraSensor;
import Sensores.LidarSensor;
import Sensores.Sensor;
import Sensores.UltrasonicSensor;

import java.io.Serializable;

/**
 * A classe Veiculo é uma classe abstrata que representa um veículo genérico.
 */
public abstract class Veiculo implements Serializable {
    private final int codigo;
    private int totalCarga;
    private Posicao posicao;
    private Direcao direcao;
    private Armazém armazém;
    private LidarSensor lidarSensor;
    private UltrasonicSensor ultrasonicSensor;
    private CameraSensor cameraSensor;

    /**
     * Construtor da classe Veiculo.
     *
     * @param codigo o código do veículo
     */
    public Veiculo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o código do veículo.
     *
     * @return o código do veículo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna a carga total do veículo.
     *
     * @return a carga total do veículo
     */
    public int getTotalCarga() {
        return totalCarga;
    }
    public Posicao getPosicao(){return posicao;}

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public Armazém getArmazem() {
        return armazém;
    }

    public LidarSensor getLidarSensor() {
        return lidarSensor;
    }

    public UltrasonicSensor getUltrasonicSensor() {
        return ultrasonicSensor;
    }

    public CameraSensor getCameraSensor() {
        return cameraSensor;
    }
}
