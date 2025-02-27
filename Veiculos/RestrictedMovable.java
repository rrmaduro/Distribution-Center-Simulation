package Veiculos;
import Embalagens.*;
import Sensores.LidarSensor;

/**
 * A interface RestrictedMovable para objetos que têm restrições diferentes.
 */
public interface RestrictedMovable extends Movable {
        /**
         * Adiciona uma embalagem ao objeto movível.
         *
         * @param embalagem a embalagem a ser adicionada
         */
        void addPackage(Embalagem embalagem);

        /**
         * Remove uma embalagem do objeto movível.
         *
         * @param embalagem a embalagem a ser removida
         */
        void removePackage(Embalagem embalagem);

        LidarSensor getLidarSensor();
}
