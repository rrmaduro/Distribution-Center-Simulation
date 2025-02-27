package Sensores;

import Elementos.Direcao;
import Veiculos.Veiculo;

/**
 * Represents an ultrasonic sensor used for detecting objects in a warehouse environment.
 * The sensor has a specified angle of view and maximum range for detecting objects.
 */
public class UltrasonicSensor extends Sensor {
    private final double angleOfView;
    private final double maxRange;

    /**
     * Constructs an UltrasonicSensor object for the given vehicle.
     *
     * @param veiculo the vehicle associated with the sensor.
     */
    public UltrasonicSensor(Veiculo veiculo) {
        super(180.0, 8.0, veiculo);
        angleOfView = 180.0;
        maxRange = 8.0;
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
                startY -= Math.cos(Math.toRadians(angleOfView / 2)) * maxRange;
                endY += Math.sin(Math.toRadians(angleOfView / 2)) * maxRange;
            }
            case DOWN -> {
                startY += Math.cos(Math.toRadians(angleOfView / 2)) * maxRange;
                endY -= Math.sin(Math.toRadians(angleOfView / 2)) * maxRange;
            }
            case RIGHT -> endX += Math.cos(Math.toRadians(angleOfView / 2)) * maxRange;
            case LEFT -> endX -= Math.cos(Math.toRadians(angleOfView / 2)) * maxRange;
            default -> {
            }
        }

        double distance = Math.sqrt(Math.pow(x - veiculoColuna, 2) + Math.pow(y - veiculoLinha, 2));
        boolean withinRange = distance <= maxRange;
        boolean validPosition = veiculo.getArmazem().isPosicaoValida(y, x);

        return withinRange && validPosition;
    }

    /**
     * Returns the angle of view of the ultrasonic sensor.
     *
     * @return the angle of view.
     */
    public double getAngleOfView() {
        return angleOfView;
    }

    /**
     * Returns the maximum range of the ultrasonic sensor.
     *
     * @return the maximum range.
     */
    public double getMaxRange() {
        return maxRange;
    }
}
