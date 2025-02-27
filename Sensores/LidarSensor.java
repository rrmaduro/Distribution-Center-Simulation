package Sensores;

import Elementos.Direcao;
import Veiculos.Veiculo;

/**
 * Represents a lidar sensor used for object detection in a warehouse environment.
 * The sensor has a specified angle of view and maximum range for detecting objects.
 */
public class LidarSensor extends Sensor {
    private final double angleOfView, maxRange;
    Veiculo veiculo;

    /**
     * Constructs a LidarSensor object for the given vehicle.
     *
     * @param veiculo the vehicle associated with the sensor.
     */
    public LidarSensor(Veiculo veiculo) {
        super(30.0, 20.0, veiculo);
        this.veiculo = veiculo;
        angleOfView = 30.0;
        maxRange = 20.0;
    }

    /**
     * Checks if the given position is empty based on the sensor's range and validity.
     *
     * @param y the y-coordinate of the position.
     * @param x the x-coordinate of the position.
     * @return true if the position is empty, false otherwise.
     */
    public boolean isPositionEmpty(int y, int x) {
        int veiculoLinha = veiculo.getPosicao().getLinha();
        int veiculoColuna = veiculo.getPosicao().getColuna();
        Direcao direction = veiculo.getDirecao();

        double startX = veiculoColuna;
        double endX = veiculoColuna;
        double startY = veiculoLinha;
        double endY = veiculoLinha;

        switch (direction) {
            case UP -> {
                startY -= Math.sin(Math.toRadians(angleOfView)) * maxRange / 2;
                endY += Math.sin(Math.toRadians(angleOfView)) * maxRange / 2;
            }
            case DOWN -> {
                startY += Math.sin(Math.toRadians(angleOfView)) * maxRange / 2;
                endY -= Math.sin(Math.toRadians(angleOfView)) * maxRange / 2;
            }
            case RIGHT -> {
                startX += Math.cos(Math.toRadians(angleOfView)) * maxRange / 2;
                endX -= Math.cos(Math.toRadians(angleOfView)) * maxRange / 2;
            }
            case LEFT -> {
                startX -= Math.cos(Math.toRadians(angleOfView)) * maxRange / 2;
                endX += Math.cos(Math.toRadians(angleOfView)) * maxRange / 2;
            }
            default -> {
            }
        }

        double distance = Math.sqrt(Math.pow(x - veiculoColuna, 2) + Math.pow(y - veiculoLinha, 2));
        boolean withinRange = distance <= maxRange;
        boolean validPosition = veiculo.getArmazem().isPosicaoValida(y, x);

        return withinRange && validPosition;
    }

    /**
     * Returns the vehicle associated with the lidar sensor.
     *
     * @return the associated vehicle.
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * Returns the angle of view of the lidar sensor.
     *
     * @return the angle of view.
     */
    public double getAngleOfView() {
        return angleOfView;
    }

    /**
     * Returns the maximum range of the lidar sensor.
     *
     * @return the maximum range.
     */
    public double getMaxRange() {
        return maxRange;
    }
}
