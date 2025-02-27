package Simulacao;
import Armazem.*;
import Veiculos.*;
import Elementos.*;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    private static Armazém armazem;
    private static AGC agc;
    private static ULC ulc;
    private static VeiculoRebocador veiculoRebocador;
    private static CarrinhoTransporte carrinhoTransporte;

    /**
     * Reads and processes the CSV file.
     * This method reads a CSV file, creates objects based on the data,
     * and performs specific operations depending on the object type.
     */
    public static void readAndProcessCSV() {
        String csvFile = "armazem.csv";
        String line;
        String[] dimensions = null;
        int tamanhoLinha = 0;
        int tamanhoColuna = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the first line to get the dimensions
            line = br.readLine();
            dimensions = line.split(" ")[0].split("x");
            tamanhoLinha = Integer.parseInt(dimensions[0]);
            tamanhoColuna = Integer.parseInt(dimensions[1]);

            // Create a separate armazem instance for veiculos
            armazem = new Armazém(tamanhoLinha, tamanhoColuna);

            // Read the remaining lines to create objects
            while ((line = br.readLine()) != null) {
                String[] objectData = line.split(",");  // Split the line into attributes

                // Assuming the object has two attributes: linha and coluna
                int linha = Integer.parseInt(objectData[0]);
                int coluna = Integer.parseInt(objectData[1]);

                // Check the condition to determine if a Elementos.Prateleira should be created
                if (objectData.length == 2 && linha > 1 && coluna < 113) {
                    // Create the Elementos.Prateleira object and add it to the armazem
                    Prateleira prateleira = new Prateleira(linha, coluna);
                    armazem.addPrateleira(prateleira);
                } else if (objectData.length > 2) {
                    int veiculoType = Integer.parseInt(objectData[2]);
                    int codigo = Integer.parseInt(objectData[3]);

                    // Create the corresponding veiculo based on the veiculoType
                    // The linha coordinate of the veiculo
                    // The coluna coordinate of the veiculo
                    // The type of veiculo (1 for AGC, 2 for ULC, 3 for VeiculoRebocador, 4 for CarrinhoTransporte)
                    // The codigo of the veiculo

                    switch (veiculoType) {
                        case 1:
                            agc = new AGC(codigo, armazem);
                            break;
                        case 2:
                            ulc = new ULC(codigo, armazem);
                            break;
                        case 3:
                            veiculoRebocador = new VeiculoRebocador(codigo, armazem);
                            break;
                        case 4:
                            carrinhoTransporte = new CarrinhoTransporte(codigo, armazem);
                            break;
                        default:
                            // Invalid veiculo type
                            break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the warehouse object.
     *
     * @return The warehouse object.
     */
    public static Armazém getArmazem() {
        return armazem;
    }

    /**
     * Gets the AGC (Automated Guided Vehicle) object.
     *
     * @return The AGC object.
     */
    public static AGC getAGC() {
        return agc;
    }

    /**
     * Gets the ULC (Unit Load Carrier) object.
     *
     * @return The ULC object.
     */
    public static ULC getULC() {
        return ulc;
    }

    /**
     * Gets the VeiculoRebocador (Towing Vehicle) object.
     *
     * @return The VeiculoRebocador object.
     */
    public static VeiculoRebocador getVeiculoRebocador() {
        return veiculoRebocador;
    }

    /**
     * Gets the CarrinhoTransporte (Transport Cart) object.
     *
     * @return The CarrinhoTransporte object.
     */
    public static CarrinhoTransporte getCarrinhoTransporte() {
        return carrinhoTransporte;
    }

}
