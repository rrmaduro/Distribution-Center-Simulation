package Sensores;
import Veiculos.*;

public abstract class Sensor {
    protected double angleOfView;
    protected double maxRange;
    protected Veiculo veiculo;

    public Sensor(double angleOfView, double maxRange, Veiculo veiculo) {
        this.angleOfView = angleOfView;
        this.maxRange = maxRange;
        this.veiculo = veiculo;
    }

    public abstract double getAngleOfView();
    public abstract double getMaxRange();
    public abstract boolean isPositionEmpty(int y, int x);

    // Other common methods and properties can be added here
}
