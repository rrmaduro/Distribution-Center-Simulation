package Veiculos;
import Embalagens.*;
import Elementos.*;
import Armazem.*;
import Sensores.CameraSensor;
import Sensores.LidarSensor;
import Sensores.UltrasonicSensor;

import java.util.ArrayList;

/**
 * Class representing an AGC (Automated Guided Cart).
 */
public class AGC extends Veiculo implements RestrictedMovable {
    private final double maxPeso = 100.0;
    private double pesoCarga;
    private ArrayList<Embalagem> embalagens;
    private int counterEmbalagens;
    private Armazém armazém;
    private Posicao posicao;
    private Direcao direcao;
    private LidarSensor lidarSensor;
    private UltrasonicSensor ultrasonicSensor;
    private CameraSensor cameraSensor;

    /**
     * Constructor for the AGC class.
     *
     * @param codigo  The AGC code.
     * @param armazem The warehouse associated with the AGC.
     */
    public AGC(int codigo, Armazém armazem) {
        super(codigo);
        pesoCarga = 0;
        counterEmbalagens = 0;
        embalagens = new ArrayList<>();
        this.armazém = armazem;
        armazem.addVeiculo(this);
        posicao=armazem.getPosicao(this);
        direcao=Direcao.NULL;
        lidarSensor= new LidarSensor(this);
        ultrasonicSensor= new UltrasonicSensor(this);
        cameraSensor= new CameraSensor(this, lidarSensor, ultrasonicSensor);
    }

    /**
     * Get the total number of packages loaded on the AGC.
     *
     * @return The total number of loaded packages.
     */
    public int getCargaTotal() {
        return counterEmbalagens;
    }

    /**
     * Get the maximum weight supported by the AGC.
     *
     * @return The maximum supported weight.
     */
    public double getMaxPeso() {
        return maxPeso;
    }

    /**
     * Add a package to the AGC if there is available space.
     *
     * @param embalagem The package to be added.
     */
    public void addPackage(Embalagem embalagem) {
        // Check the type of the package and if there is space to add
        if (embalagem instanceof CaixaCartao) {
            if (((CaixaCartao) embalagem).getCaixaCartaoPequena() != null) {
                if (((CaixaCartao) embalagem).getPesoCaixaCartao() + pesoCarga < maxPeso) {
                    embalagens.add(embalagem);
                    this.pesoCarga += ((CaixaCartao) embalagem).getPesoCaixaCartao();
                    counterEmbalagens++;
                }
            }
        } else if (embalagem instanceof Caixa) {
            if (((Caixa) embalagem).getCaixa() != null) {
                if (((Caixa) embalagem).getPesoCaixa() + pesoCarga < maxPeso) {
                    embalagens.add(embalagem);
                    this.pesoCarga += ((Caixa) embalagem).getPesoCaixa();
                    counterEmbalagens++;
                }
            }
        } else if (embalagem instanceof Saco) {
            if (((Saco) embalagem).getSaco() != null) {
                if (((Saco) embalagem).getPesoSaco() + pesoCarga < maxPeso) {
                    embalagens.add(embalagem);
                    this.pesoCarga += ((Saco) embalagem).getPesoSaco();
                    counterEmbalagens++;
                }
            }
        } else {
            System.out.println("Cannot add the package.");
        }
    }

    /**
     * Remove a package from the AGC if it is present.
     *
     * @param embalagem The package to be removed.
     */
    public void removePackage(Embalagem embalagem) {
        // Check the type of the package and remove if present
        if (embalagem instanceof CaixaCartao) {
            if (embalagens.contains(embalagem)) {
                embalagens.remove(embalagem);
                this.pesoCarga -= ((CaixaCartao) embalagem).getPesoCaixaCartao();
                counterEmbalagens--;
            }
        } else if (embalagem instanceof Caixa) {
            if (embalagens.contains(embalagem)) {
                embalagens.remove(embalagem);
                this.pesoCarga -= ((Caixa) embalagem).getPesoCaixa();
                counterEmbalagens--;
            }
        } else if (embalagem instanceof Saco) {
            if (embalagens.contains(embalagem)) {
                embalagens.remove(embalagem);
                this.pesoCarga -= ((Saco) embalagem).getPesoSaco();
                counterEmbalagens--;
            }
        } else {
            System.out.println("Cannot remove the package.");
        }
    }



    /**
     * Retrieve all the packages loaded on the AGC, emptying it.
     *
     * @return The list of retrieved packages.
     */
    public ArrayList<Embalagem> retrieveAllPackages() {
        ArrayList<Embalagem> embalagensRetiradas = new ArrayList<>(embalagens);

        embalagens.clear();
        pesoCarga = 0;
        counterEmbalagens = 0;

        return embalagensRetiradas;
    }

    /**
     * Set the position of the AGC.
     *
     * @param posicao The position to be set.
     */
    private void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    /**
     * Return a string representation of the AGC, displaying its properties.
     *
     * @return The string representation of the AGC.
     */
    @Override
    public String toString() {
        return "AGC:\n" +
                "Codigo: " + getCodigo() + "\n" +
                "Peso Carga: " + pesoCarga + "\n" +
                "Embalagens: " + embalagens + "\n" +
                "Counter Embalagens: " + counterEmbalagens + "\n" +
                "Armazém: " + armazém + "\n" +
                "Posicao: " + posicao + "\n";
    }

    public ArrayList<Embalagem> getEmbalagens() {
        return embalagens;
    }

    public Armazém getArmazém() {
        return armazém;
    }

    @Override
    public Posicao getPosicao() {
        posicao=armazém.getPosicao(this);
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
        return armazém;
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
}
