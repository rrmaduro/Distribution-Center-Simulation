package Sensores;

import Elementos.*;
import Veiculos.Veiculo;

/**
 * The CameraSensor class represents a camera sensor used for detecting elements in the environment.
 * It extends the Sensor class.
 */
public class CameraSensor extends Sensor {
    private final double angleOfView;
    private final double maxRange;
    private LidarSensor lidarSensor;
    private UltrasonicSensor ultrasonicSensor;

    /**
     * Constructs a CameraSensor object with the specified vehicle, LidarSensor, and UltrasonicSensor.
     *
     * @param veiculo          The vehicle associated with the sensor.
     * @param lidarSensor      The LidarSensor used for distance detection.
     * @param ultrasonicSensor The UltrasonicSensor used for distance detection.
     */
    public CameraSensor(Veiculo veiculo, LidarSensor lidarSensor, UltrasonicSensor ultrasonicSensor) {
        super(90.0, 30.0, veiculo);
        angleOfView = 90.0;
        maxRange = 30.0;
        this.lidarSensor = lidarSensor;
        this.ultrasonicSensor = ultrasonicSensor;
    }

    /**
     * Checks if a position is empty using the camera, Lidar, and Ultrasonic sensors.
     *
     * @param y The vertical coordinate of the position.
     * @param x The horizontal coordinate of the position.
     * @return true if the position is empty, false otherwise.
     */
    public boolean isPositionEmpty(int y, int x) {
        return lidarSensor.isPositionEmpty(y, x) && ultrasonicSensor.isPositionEmpty(y, x);
    }

    /**
     * Returns the LidarSensor associated with the camera sensor.
     *
     * @return The LidarSensor object.
     */
    public LidarSensor getLidarSensor() {
        return lidarSensor;
    }

    /**
     * Returns the UltrasonicSensor associated with the camera sensor.
     *
     * @return The UltrasonicSensor object.
     */
    public UltrasonicSensor getUltrasonicSensor() {
        return ultrasonicSensor;
    }

    /**
     * Returns the angle of view of the camera sensor.
     *
     * @return The angle of view.
     */
    public double getAngleOfView() {
        return angleOfView;
    }

    /**
     * Returns the maximum range of the camera sensor.
     *
     * @return The maximum range.
     */
    public double getMaxRange() {
        return maxRange;
    }
}
