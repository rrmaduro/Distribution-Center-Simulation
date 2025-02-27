package Armazem;

import Veiculos.*;
import Elementos.*;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Class representing a warehouse.
 */
public class Armazém {
    private ArrayList<Veiculo> veiculos; // lista de veículos no armazém
    private Posicao[][] posicoes;
    private int tamanhoLinha;
    private int tamanhoColuna;
    private int counterVeiculos;
    private int ULCcounter;
    private int AGCcounter;
    private int CarrinhoTransporteCounter;
    private int VeiculoRebocadorCounter;
    private Posicao posicaoVeiculo;
    private String status;

    /**
     * Constructor of the Warehouse class.
     *
     * @param tamanhoLinha  the size of the warehouse in rows
     * @param tamanhoColuna the size of the warehouse in columns
     */
    public Armazém(int tamanhoLinha, int tamanhoColuna) {
        veiculos = new ArrayList<>();
        counterVeiculos = 0;
        this.tamanhoLinha = tamanhoLinha;
        this.tamanhoColuna = tamanhoColuna;
        posicaoVeiculo = null;
        status = "";

        posicoes = new Posicao[this.tamanhoLinha][this.tamanhoColuna];

        // Construir caminhos em todas as posições não ocupadas por paredes, zonas de entrega ou zonas de recolha
        for (int linha = 0; linha < this.tamanhoLinha; linha++) {
            for (int coluna = 0; coluna < this.tamanhoColuna; coluna++) {
                posicoes[linha][coluna] = new Caminho(linha, coluna);
            }
        }

        // Definir paredes nos limites do armazém
        for (int linha = 0; linha < this.tamanhoLinha; linha++) {
            posicoes[linha][0] = new Parede(linha, 0);
            posicoes[linha][this.tamanhoColuna - 1] = new Parede(linha, this.tamanhoColuna - 1);
        }
        for (int coluna = 0; coluna < this.tamanhoColuna; coluna++) {
            posicoes[0][coluna] = new Parede(0, coluna);
            posicoes[this.tamanhoLinha - 1][coluna] = new Parede(this.tamanhoLinha - 1, coluna);
        }

        // Definir local de entrega na primeira metade da parede superior
        int tamanhoParedeSuperior = this.tamanhoColuna;
        int tamanhoZonaEntrega = tamanhoParedeSuperior / 2;
        int inicioZonaEntrega = 0;
        int fimZonaEntrega = inicioZonaEntrega + tamanhoZonaEntrega - 1;
        for (int coluna = inicioZonaEntrega; coluna <= fimZonaEntrega; coluna++) {
            posicoes[0][coluna] = new LocalEntrega(0, coluna);
        }

        // Define local de recolha na primeira metade da parede inferior
        int tamanhoParedeInferior = this.tamanhoColuna;
        int tamanhoZonaRecolha = tamanhoParedeInferior / 2;
        int fimZonaRecolha = tamanhoZonaRecolha - 1;
        for (int coluna = 0; coluna <= fimZonaRecolha; coluna++) {
            posicoes[this.tamanhoLinha - 1][coluna] = new LocalRecolha(this.tamanhoLinha - 1, coluna);
        }

    }

    /**
     * Retrieves the list of vehicles in the warehouse.
     *
     * @return the list of vehicles in the warehouse
     */
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * Retrieves the ULC (Unmanned Luggage Carrier) vehicle in the warehouse.
     *
     * @return the ULC vehicle, or null if not found
     */
    public ULC getULC() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof ULC) {
                return (ULC) veiculo;
            }
        }
        return null;

    }

    /**
     * Retrieves the AGC (Automated Guided Cart) vehicle in the warehouse.
     *
     * @return the AGC vehicle, or null if not found
     */
    public AGC getAGC() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof AGC) {
                return (AGC) veiculo;
            }
        }
        return null;

    }

    /**
     * Retrieves the Transport Cart vehicle in the warehouse.
     *
     * @return the Transport Cart vehicle, or null if not found
     */
    public CarrinhoTransporte getCarrinhoTransporte() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof CarrinhoTransporte) {
                return (CarrinhoTransporte) veiculo;
            }
        }
        return null;
    }

    /**
     * Retrieves the Tugger vehicle in the warehouse.
     *
     * @return the Tugger vehicle, or null if not found
     */
    public VeiculoRebocador getVeiculoRebocador() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof VeiculoRebocador) {
                return (VeiculoRebocador) veiculo;
            }
        }
        return null;
    }

    /**
     * Adds a vehicle to the warehouse.
     *
     * @param vehicle the vehicle to be added
     */
    public void addVeiculo(Veiculo veiculo) {
        Posicao posicao = null;

        if (veiculo instanceof ULC) {
            if (ULCcounter < 1) {
                posicao = getCantos(counterVeiculos);
                ULCcounter++;
                counterVeiculos++;
            } else {
                System.out.println("Não é possível adicionar mais veículos ULC.");
            }
        } else if (veiculo instanceof AGC) {
            if (AGCcounter < 1) {
                posicao = getCantos(counterVeiculos);
                AGCcounter++;
                counterVeiculos++;
            } else {
                System.out.println("Não é possível adicionar mais veículos AGC.");
            }
        } else if (veiculo instanceof CarrinhoTransporte) {
            if (CarrinhoTransporteCounter < 1) {
                posicao = getCantos(counterVeiculos);
                CarrinhoTransporteCounter++;
                counterVeiculos++;
            } else {
                System.out.println("Não é possível adicionar mais veículos Carrinho de Transporte.");
            }
        } else if (veiculo instanceof VeiculoRebocador) {
            if (VeiculoRebocadorCounter < 1) {
                posicao = getCantos(counterVeiculos);
                VeiculoRebocadorCounter++;
                counterVeiculos++;
            } else {
                System.out.println("Não é possível adicionar mais veículos Carrinho Rebocador.");
            }
        }

        if (posicao != null) {
            int linha = posicao.getLinha();
            int coluna = posicao.getColuna();

            if (linha >= 0 && linha < tamanhoLinha && coluna >= 0 && coluna < tamanhoColuna) {
                if (posicoes[linha][coluna] instanceof Caminho) {
                    Caminho caminho = (Caminho) posicoes[linha][coluna];
                    caminho.addVeiculo(veiculo);
                    veiculos.add(veiculo);
                    System.out.println("Veículo " + veiculo.getCodigo() + " adicionado ao armazém na posição (" + linha + ", " + coluna + ").");
                } else {
                    System.out.println("Não é possível adicionar o veículo na posição (" + linha + ", " + coluna + "). A posição não é um caminho.");
                }
            } else {
                System.out.println("Não é possível adicionar o veículo na posição (" + linha + ", " + coluna + "). A posição está fora dos limites do armazém.");
            }
        } else {
            System.out.println("Não foi possível obter a posição do veículo. Verifique se o veículo está presente no armazém.");
        }
    }

    /**
     * Removes a vehicle from the warehouse.
     *
     * @param vehicle the vehicle to be removed
     */
    public void removeVeiculo(Veiculo veiculo) {
        boolean veiculoEncontrado = false;

        for (int linha = 0; linha < tamanhoLinha; linha++) {
            for (int coluna = 0; coluna < tamanhoColuna; coluna++) {
                if (posicoes[linha][coluna] instanceof Caminho) {
                    Caminho caminho = (Caminho) posicoes[linha][coluna];
                    if (caminho.getVeiculos().contains(veiculo)) {
                        caminho.getVeiculos().remove(veiculo);
                        veiculoEncontrado = true;
                        break;
                    }
                }
            }

            if (veiculoEncontrado) {
                break;
            }
        }

        if (veiculoEncontrado) {
            veiculos.remove(veiculo);
            System.out.println("Veículo " + veiculo.getCodigo() + " removido do armazém.");
        } else {
            System.out.println("Não foi possível encontrar o veículo no armazém.");
        }
    }

    /**
     * Moves a vehicle to a new position in the warehouse.
     *
     * @param vehicle     the vehicle to be moved
     * @param newPosition the new position for the vehicle
     */
    public void moveVeiculo(Veiculo veiculo, Posicao novaPosicao) {
        if (veiculos.contains(veiculo)) {
            int novaLinha = novaPosicao.getLinha();
            int novaColuna = novaPosicao.getColuna();

            if (posicoes[novaLinha][novaColuna] instanceof Caminho novaCaminho) {

                // VeiculoRebocador e CarrinhoTransporte
                if (veiculo instanceof VeiculoRebocador veiculoRebocador && novaCaminho.getVeiculos().size() > 0) {
                    Veiculo primeiroVeiculoCaminho = novaCaminho.getVeiculos().get(0);

                    if (primeiroVeiculoCaminho instanceof CarrinhoTransporte carrinhoTransporte) {
                        veiculoRebocador.rebocarCarrinho(carrinhoTransporte);

                        // Remove o CarrinhoTransporte do novaCaminho
                        novaCaminho.removeVeiculo(carrinhoTransporte);
                    }
                }

                // Remove o veículo da posição atual (Elementos.Prateleira, Caminho, LocalEntrega, or LocalRecolha)
                for (int linha = 0; linha < tamanhoLinha; linha++) {
                    for (int coluna = 0; coluna < tamanhoColuna; coluna++) {
                        if (posicoes[linha][coluna] instanceof Caminho) {
                            Caminho caminho = (Caminho) posicoes[linha][coluna];
                            if (caminho.getVeiculos().contains(veiculo)) {
                                caminho.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = caminho; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof Prateleira) {
                            Prateleira prateleira = (Prateleira) posicoes[linha][coluna];
                            if (prateleira.getVeiculo().contains(veiculo)) {
                                prateleira.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = prateleira; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof LocalEntrega) {
                            LocalEntrega localEntrega = (LocalEntrega) posicoes[linha][coluna];
                            if (localEntrega.getVeiculo().contains(veiculo)) {
                                localEntrega.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = localEntrega; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof LocalRecolha) {
                            LocalRecolha localRecolha = (LocalRecolha) posicoes[linha][coluna];
                            if (localRecolha.getVeiculos().contains(veiculo)) {
                                localRecolha.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = localRecolha; // Atualiza a posição no array posicoes
                                break;
                            }
                        }
                    }
                }

                // Adiciona o veículo à nova posição (Caminho)
                novaCaminho.addVeiculo(veiculo);
                posicoes[novaLinha][novaColuna] = novaCaminho; // Atualiza a posição no array posicoes
                System.out.println("Veículo " + veiculo.getCodigo() + " movido para a posição (" + novaLinha + ", " + novaColuna + ").");

            } else if (posicoes[novaLinha][novaColuna] instanceof Prateleira novaPrateleira) {

                // Remove o veículo da posição atual (Elementos.Prateleira, Caminho, LocalEntrega, or LocalRecolha)
                for (int linha = 0; linha < tamanhoLinha; linha++) {
                    for (int coluna = 0; coluna < tamanhoColuna; coluna++) {
                        if (posicoes[linha][coluna] instanceof Caminho) {
                            Caminho caminho = (Caminho) posicoes[linha][coluna];
                            if (caminho.getVeiculos().contains(veiculo)) {
                                caminho.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = caminho; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof Prateleira) {
                            Prateleira prateleira = (Prateleira) posicoes[linha][coluna];
                            if (prateleira.getVeiculo().contains(veiculo)) {
                                prateleira.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = prateleira; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof LocalEntrega) {
                            LocalEntrega localEntrega = (LocalEntrega) posicoes[linha][coluna];
                            if (localEntrega.getVeiculo().contains(veiculo)) {
                                localEntrega.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = localEntrega; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof LocalRecolha) {
                            LocalRecolha localRecolha = (LocalRecolha) posicoes[linha][coluna];
                            if (localRecolha.getVeiculos().contains(veiculo)) {
                                localRecolha.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = localRecolha; // Atualiza a posição no array posicoes
                                break;
                            }
                        }
                    }
                }

                // Adiciona o veículo à nova posição (Elementos.Prateleira)
                novaPrateleira.addVeiculo(veiculo);
                posicoes[novaLinha][novaColuna] = novaPrateleira; // Atualiza a posição no array posicoes
                System.out.println("Veículo " + veiculo.getCodigo() + " movido para a posição (" + novaLinha + ", " + novaColuna + ").");

            } else if (posicoes[novaLinha][novaColuna] instanceof LocalEntrega novoLocalEntrega) {

                // Remove o veículo da posição atual (Elementos.Prateleira, Caminho, LocalEntrega, or LocalRecolha)
                for (int linha = 0; linha < tamanhoLinha; linha++) {
                    for (int coluna = 0; coluna < tamanhoColuna; coluna++) {
                        if (posicoes[linha][coluna] instanceof Caminho) {
                            Caminho caminho = (Caminho) posicoes[linha][coluna];
                            if (caminho.getVeiculos().contains(veiculo)) {
                                caminho.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = caminho; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof Prateleira) {
                            Prateleira prateleira = (Prateleira) posicoes[linha][coluna];
                            if (prateleira.getVeiculo().contains(veiculo)) {
                                prateleira.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = prateleira; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof LocalEntrega) {
                            LocalEntrega localEntrega = (LocalEntrega) posicoes[linha][coluna];
                            if (localEntrega.getVeiculo().contains(veiculo)) {
                                localEntrega.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = localEntrega; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof LocalRecolha) {
                            LocalRecolha localRecolha = (LocalRecolha) posicoes[linha][coluna];
                            if (localRecolha.getVeiculos().contains(veiculo)) {
                                localRecolha.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = localRecolha; // Atualiza a posição no array posicoes
                                break;
                            }
                        }
                    }
                }

                // Adiciona o veículo à nova posição (LocalEntrega)
                novoLocalEntrega.addVeiculo(veiculo);
                posicoes[novaLinha][novaColuna] = novoLocalEntrega; // Atualiza a posição no array posicoes
                System.out.println("Veículo " + veiculo.getCodigo() + " movido para a posição (" + novaLinha + ", " + novaColuna + ").");

            } else if (posicoes[novaLinha][novaColuna] instanceof LocalRecolha novoLocalRecolha) {

                // Remove o veículo da posição atual (Elementos.Prateleira, Caminho, LocalEntrega, or LocalRecolha)
                for (int linha = 0; linha < tamanhoLinha; linha++) {
                    for (int coluna = 0; coluna < tamanhoColuna; coluna++) {
                        if (posicoes[linha][coluna] instanceof Caminho) {
                            Caminho caminho = (Caminho) posicoes[linha][coluna];
                            if (caminho.getVeiculos().contains(veiculo)) {
                                caminho.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = caminho; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof Prateleira) {
                            Prateleira prateleira = (Prateleira) posicoes[linha][coluna];
                            if (prateleira.getVeiculo().contains(veiculo)) {
                                prateleira.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = prateleira; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof LocalEntrega) {
                            LocalEntrega localEntrega = (LocalEntrega) posicoes[linha][coluna];
                            if (localEntrega.getVeiculo().contains(veiculo)) {
                                localEntrega.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = localEntrega; // Atualiza a posição no array posicoes
                                break;
                            }
                        } else if (posicoes[linha][coluna] instanceof LocalRecolha) {
                            LocalRecolha localRecolha = (LocalRecolha) posicoes[linha][coluna];
                            if (localRecolha.getVeiculos().contains(veiculo)) {
                                localRecolha.removeVeiculo(veiculo);
                                posicoes[linha][coluna] = localRecolha; // Atualiza a posição no array posicoes
                                break;
                            }
                        }
                    }
                }

                // Adiciona o veículo à nova posição (LocalRecolha)
                novoLocalRecolha.addVeiculo(veiculo);
                posicoes[novaLinha][novaColuna] = novoLocalRecolha; // Atualiza a posição no array posicoes
                System.out.println("Veículo " + veiculo.getCodigo() + " movido para a posição (" + novaLinha + ", " + novaColuna + ").");

            } else {
                System.out.println("Posição inválida para movimentação do veículo.");
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public void moveVeiculoWithDirecao(Veiculo veiculo, Direcao direcao) {
        if (veiculos.contains(veiculo)) {
            Posicao posicaoAtual = veiculo.getPosicao();
            int linhaAtual = posicaoAtual.getLinha();
            int colunaAtual = posicaoAtual.getColuna();

            // Calculate the new position based on the current position and direction
            int novaLinha = linhaAtual;
            int novaColuna = colunaAtual;
            switch (direcao) {
                case UP -> {
                    novaLinha--;
                    veiculo.setDirecao(Direcao.UP);
                }
                case DOWN -> {
                    novaLinha++;
                    veiculo.setDirecao(Direcao.DOWN);
                }
                case RIGHT -> {
                    novaColuna++;
                    veiculo.setDirecao(Direcao.RIGHT);
                }
                case LEFT -> {
                    novaColuna--;
                    veiculo.setDirecao(Direcao.LEFT);
                }
            }

            // Check if the new position is within bounds
            if (isPosicaoValida(novaLinha, novaColuna)) {
                Posicao novaPosicao = posicoes[novaLinha][novaColuna];

                // Perform position detection using the Lidar and Ultrasonic sensors

                // Check if the new position is empty using the Lidar and Ultrasonic sensors
                boolean isPositionEmpty = veiculo.getCameraSensor().isPositionEmpty(novaLinha, novaColuna);

                if (isPositionEmpty) {
                    moveVeiculo(veiculo, novaPosicao);
                } else {
                    System.out.println("Posição inválida!");
                }
            } else {
                System.out.println("Posição inválida! O veículo não se pode movimentar nessa direção");
            }
        }
    }


    public boolean isPosicaoValida(int linha, int coluna) {
        if (linha < 0 || linha >= tamanhoLinha || coluna < 0 || coluna >= tamanhoColuna)
            return false;

        Posicao posicao = posicoes[linha][coluna];
        if (posicao instanceof Caminho caminho) {
            if (caminho.hasCarrinhoTransporte()) {
                return true;
            }
            if (caminho.hasAGC() || caminho.hasULC() || caminho.hasVeiculoRebocador()) {
                return false;
            }
        }
        if (posicao instanceof Prateleira prateleira) {
            return prateleira.getVeiculo().isEmpty();
        }
        if (posicao instanceof LocalEntrega localEntrega) {
            return localEntrega.getVeiculo().isEmpty();
        }
        if (posicao instanceof LocalRecolha localRecolha) {
            return localRecolha.getVeiculos().isEmpty();
        }
        // acrescentar parede
        return true;
    }


    /**
     * Gets the corners' positions of the warehouse based on the vehicle counter.
     *
     * @param counterVeiculos the vehicle counter
     * @return the corners' positions of the warehouse
     */
    private Posicao getCantos(int counterVeiculos) {
        int linha;
        int coluna;

        int ultimoIndiceLinha = tamanhoLinha - 1;
        int ultimoIndiceColuna = tamanhoColuna - 1;

        switch (counterVeiculos) {
            case 0 -> { // Canto superior esquerdo
                linha = 1;
                coluna = 1;
            }
            case 1 -> { // Canto superior direito
                linha = 1;
                coluna = ultimoIndiceColuna - 1;
            }
            case 2 -> { // Canto inferior direito
                linha = ultimoIndiceLinha - 1;
                coluna = ultimoIndiceColuna - 1;
            }
            case 3 -> { // Canto inferior esquerdo
                linha = ultimoIndiceLinha - 1;
                coluna = 1;
            }
            default -> {
                // Caso o contador de veículos seja inválido, retorna posição inválida (-1, -1)
                linha = -1;
                coluna = -1;
            }
        }

        // Retorna a posição dos cantos do armazém
        return new Posicao(linha, coluna);
    }

    /**
     * Checks if the position is free in the warehouse.
     *
     * @param posicao the position
     * @return a boolean value indicating if the position is free
     */
    public boolean isPosicaoFree(Posicao posicao) {
        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();

        if (linha >= 0 && linha < tamanhoLinha && coluna >= 0 && coluna < tamanhoColuna) {
            return posicoes[linha][coluna] instanceof Caminho;
        } else {
            return false;
        }
    }

    public String getElementoAt(int linha, int coluna) {
        // Check if the position is within the bounds of the warehouse
        if (isPosicaoValida(linha, coluna)) {
            // Retrieve the element at the specified position
            TipoElemento elemento = posicoes[linha][coluna].getTipoElemento();
            if (elemento == TipoElemento.CAMINHO) {
                return "caminho";
            } else if (elemento == TipoElemento.PRATELEIRA) {
                return "prateleira";
            } else if (elemento == TipoElemento.LOCAL_ENTREGA) {
                return "local_entrega";
            } else if (elemento == TipoElemento.LOCAL_RECOLHA) {
                return "local_recolha";
            } else if (elemento == TipoElemento.PAREDE) {
                return "parede";
            }

        }
        // Return null or throw an exception to indicate that the position is invalid or empty
        return "invalid";
    }

    /**
     * Gets the position of a vehicle in the warehouse.
     *
     * @param veiculo the vehicle to be located
     * @return the position of the vehicle in the warehouse, or null if not found
     */
    public Posicao getPosicao(Veiculo veiculo) {
        for (int linha = 0; linha < tamanhoLinha; linha++) {
            for (int coluna = 0; coluna < tamanhoColuna; coluna++) {
                if (posicoes[linha][coluna] instanceof Caminho) {
                    Caminho caminho = (Caminho) posicoes[linha][coluna];
                    if (caminho.getVeiculos().contains(veiculo)) {
                        return new Posicao(linha, coluna);
                    }
                }
                if (posicoes[linha][coluna] instanceof Prateleira) {
                    Prateleira prateleira = (Prateleira) posicoes[linha][coluna];
                    if (prateleira.getVeiculo().contains(veiculo)) {
                        return new Posicao(linha, coluna);
                    }
                }
                if (posicoes[linha][coluna] instanceof LocalEntrega) {
                    LocalEntrega localEntrega = (LocalEntrega) posicoes[linha][coluna];
                    if (localEntrega.getVeiculo().contains(veiculo)) {
                        return new Posicao(linha, coluna);
                    }
                }
                if (posicoes[linha][coluna] instanceof LocalRecolha) {
                    LocalRecolha localRecolha = (LocalRecolha) posicoes[linha][coluna];
                    if (localRecolha.getVeiculos().contains(veiculo)) {
                        return new Posicao(linha, coluna);
                    }
                }
            }
        }
        return null;
    }


    /**
     * Adds a shelf to the warehouse at a specific position.
     *
     * @param prateleira the shelf to be added
     */
    public void addPrateleira(Prateleira prateleira) {
        int linha = prateleira.getLinha();
        int coluna = prateleira.getColuna();

        if (linha >= 0 && linha < tamanhoLinha && coluna >= 0 && coluna < tamanhoColuna) {
            if (posicoes[linha][coluna] instanceof Caminho) {
                posicoes[linha][coluna] = prateleira;
                System.out.println("Elementos.Prateleira adicionada ao armazém na posição (" + linha + ", " + coluna + ").");
            } else {
                System.out.println("Não é possível adicionar a prateleira na posição (" + linha + ", " + coluna + "). A posição não é um caminho.");
            }
        } else {
            System.out.println("Não é possível adicionar a prateleira na posição (" + linha + ", " + coluna + "). A posição está fora dos limites do armazém.");
        }
    }

    /**
     * Gets the shelf at a given position in the warehouse.
     *
     * @param posicao the position in the warehouse
     * @return the shelf at the specified position, or null if there is no shelf
     */
    public Prateleira getPrateleira(Posicao posicao) {
        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();

        if (linha >= 0 && linha < tamanhoLinha && coluna >= 0 && coluna < tamanhoColuna) {
            if (posicoes[linha][coluna] instanceof Prateleira) {
                return (Prateleira) posicoes[linha][coluna];
            } else {
                System.out.println("Não há prateleira na posição (" + linha + ", " + coluna + ").");
            }
        } else {
            System.out.println("A posição (" + linha + ", " + coluna + ") está fora dos limites do armazém.");
        }

        return null;
    }

    /**
     * Gets a Delivery Location at a specific position in the warehouse.
     *
     * @param linha  the row of the warehouse position
     * @param coluna the column of the warehouse position
     * @return the Delivery Location at the specified position, or null if it is not a Delivery Location
     */
    public LocalEntrega getLocalEntrega(int linha, int coluna) {
        if (linha >= 0 && linha < tamanhoLinha && coluna >= 0 && coluna < tamanhoColuna) {
            if (posicoes[linha][coluna] instanceof LocalEntrega) {
                return (LocalEntrega) posicoes[linha][coluna];
            } else {
                System.out.println("A posição (" + linha + ", " + coluna + ") não é um Local de Entrega.");
            }
        } else {
            System.out.println("A posição (" + linha + ", " + coluna + ") está fora dos limites do armazém.");
        }

        return null;
    }

    /**
     * Gets a Pickup Location at a specific position in the warehouse.
     *
     * @param linha  the row of the warehouse position
     * @param coluna the column of the warehouse position
     * @return the Pickup Location at the specified position, or null if it is not a Pickup Location
     */
    public LocalRecolha getLocalRecolha(int linha, int coluna) {
        if (linha >= 0 && linha < tamanhoLinha && coluna >= 0 && coluna < tamanhoColuna) {
            if (posicoes[linha][coluna] instanceof LocalRecolha) {
                return (LocalRecolha) posicoes[linha][coluna];
            } else {
                System.out.println("A posição (" + linha + ", " + coluna + ") não é um Local de Recolha.");
            }
        } else {
            System.out.println("A posição (" + linha + ", " + coluna + ") está fora dos limites do armazém.");
        }

        return null;
    }


    /**
     * Visualizes the layout of the warehouse, printing its representation to the standard output.
     * The layout displays the different positions in the warehouse and indicates the presence of vehicles
     * and other elements at each position.
     */
    public void visualizeArmazem() {
        System.out.println();
        System.out.println("Layout do Armazém:");
        System.out.println("- - - - - - - - - - - - - - - - -");

        for (int linha = 0; linha < tamanhoLinha; linha++) {
            for (int coluna = 0; coluna < tamanhoColuna; coluna++) {
                Object posicao = posicoes[linha][coluna];

                if (posicao instanceof Parede) {
                    System.out.print(" X ");
                } else if (posicao instanceof LocalRecolha) {
                    LocalRecolha localRecolha = (LocalRecolha) posicao;
                    if (localRecolha.hasVeiculo()) {
                        System.out.print("RV "); // Print 'RV' when the LocalRecolha has a vehicle
                    } else {
                        System.out.print(" R ");
                    }
                } else if (posicao instanceof LocalEntrega) {
                    LocalEntrega localEntrega = (LocalEntrega) posicao;
                    if (localEntrega.hasVeiculo()) {
                        System.out.print("DV "); // Print 'DV' when the LocalEntrega has a vehicle
                    } else {
                        System.out.print(" D ");
                    }
                } else if (posicao instanceof Caminho) {
                    Caminho caminho = (Caminho) posicao;
                    if (caminho.hasAGC()) {
                        System.out.print("AC ");
                    } else if (caminho.hasULC()) {
                        System.out.print("UC ");
                    } else if (caminho.hasVeiculoRebocador()) {
                        System.out.print("VR ");
                    } else if (caminho.hasCarrinhoTransporte()) {
                        System.out.print("CT ");
                    } else {
                        System.out.print(" . ");
                    }
                } else if (posicao instanceof Prateleira) {
                    Prateleira prateleira = (Prateleira) posicao;
                    if (prateleira.getVeiculo().isEmpty()) {
                        System.out.print(" P ");
                    } else {
                        System.out.print("PV "); // Print 'V' to represent the presence of a vehicle
                    }
                } else {
                    System.out.print(" ? ");
                }
            }
            System.out.println();
        }
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("");

    }

    /**
     * Sets the current position of the vehicle in the warehouse.
     *
     * @param posicao The position to be set for the vehicle.
     */
    public void setPosicao(Posicao posicao) {
        this.posicaoVeiculo = posicao;
    }

    /**
     * Sets the status of the vehicle.
     *
     * @param status The status to be assigned to the vehicle.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the current status of the vehicle.
     *
     * @return The current status of the vehicle.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Writes the warehouse information to a CSV file.
     * The file will include the dimensions of the warehouse, the pickup location, and the delivery location.
     *
     * @param filename The name of the CSV file.
     */
    public void writeToCSV(String filename) {
        try (FileWriter writer = new FileWriter("armazem.csv")) {
            writer.write("Dimensao do armazem: " + this.tamanhoLinha + "x" + this.tamanhoColuna + "\n");
            writer.write("Local de recolha: " + "\n");
            writer.write("Local de entrega: " + "\n");
            System.out.println("File 'armazem.csv' created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
