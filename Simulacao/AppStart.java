package Simulacao;


import java.lang.reflect.Method;

public class AppStart {
    public static void main(String[] args) {
        runSimulation();
    }

    public static void runSimulation() {
        Simulation simulation = new Simulation();
        simulation.step1();
        for (int step = 2; step <= 136; step++) {
            switch (step) {
                case 2 -> simulation.step2();
                case 3 -> simulation.step3();
                case 4 -> simulation.step4();
                case 5 -> simulation.step5();
                case 6 -> simulation.step6();
                case 7 -> simulation.step7();
                case 8 -> simulation.step8();
                case 9 -> simulation.step9();
                case 10 -> simulation.step10();
                case 11 -> simulation.step11();
                case 12 -> simulation.step12();
                case 13 -> simulation.step13();
                case 14 -> simulation.step14();
                case 15 -> simulation.step15();
                case 16 -> simulation.step16();
                case 17 -> simulation.step17();
                case 18 -> simulation.step18();
                case 19 -> simulation.step19();
                case 20 -> simulation.step20();
                case 21 -> simulation.step21();
                case 22 -> simulation.step22();
                case 23 -> simulation.step23();
                case 24 -> simulation.step24();
                case 25 -> simulation.step25();
                case 26 -> simulation.step26();
                case 27 -> simulation.step27();
                case 28 -> simulation.step28();
                case 29 -> simulation.step29();
                case 30 -> simulation.step30();
                case 31 -> simulation.step31();
                case 32 -> simulation.step32();
                case 33 -> simulation.step33();
                case 34 -> simulation.step34();
                case 35 -> simulation.step35();
                case 36 -> simulation.step36();
                case 37 -> simulation.step37();
                case 38 -> simulation.step38();
                case 39 -> simulation.step39();
                case 40 -> simulation.step40();
                case 41 -> simulation.step41();
                case 42 -> simulation.step42();
                case 43 -> simulation.step43();
                case 44 -> simulation.step44();
                case 45 -> simulation.step45();
                case 46 -> simulation.step46();
                case 47 -> simulation.step47();
                case 48 -> simulation.step48();
                case 49 -> simulation.step49();
                case 50 -> simulation.step50();
                case 51 -> simulation.step51();
                case 52 -> simulation.step52();
                case 53 -> simulation.step53();
                case 54 -> simulation.step54();
                case 55 -> simulation.step55();
                case 56 -> simulation.step56();
                case 57 -> simulation.step57();
                case 58 -> simulation.step58();
                case 59 -> simulation.step59();
                case 60 -> simulation.step60();
                case 61 -> simulation.step61();
                case 62 -> simulation.step62();
                case 63 -> simulation.step63();
                case 64 -> simulation.step64();
                case 65 -> simulation.step65();
                case 66 -> simulation.step66();
                case 67 -> simulation.step67();
                case 68 -> simulation.step68();
                case 69 -> simulation.step69();
                case 70 -> simulation.step70();
                case 71 -> simulation.step71();
                case 72 -> simulation.step72();
                case 73 -> simulation.step73();
                case 74 -> simulation.step74();
                case 75 -> simulation.step75();
                case 76 -> simulation.step76();
                case 77 -> simulation.step77();
                case 78 -> simulation.step78();
                case 79 -> simulation.step79();
                case 80 -> simulation.step80();
                case 81 -> simulation.step81();
                case 82 -> simulation.step82();
                case 83 -> simulation.step83();
                case 84 -> simulation.step84();
                case 85 -> simulation.step85();
                case 86 -> simulation.step86();
                case 87 -> simulation.step87();
                case 88 -> simulation.step88();
                case 89 -> simulation.step89();
                case 90 -> simulation.step90();
                case 91 -> simulation.step91();
                case 92 -> simulation.step92();
                case 93 -> simulation.step93();
                case 94 -> simulation.step94();
                case 95 -> simulation.step95();
                case 96 -> simulation.step96();
                case 97 -> simulation.step97();
                case 98 -> simulation.step98();
                case 99 -> simulation.step99();
                case 100 -> simulation.step100();
                case 101 -> simulation.step101();
                case 102 -> simulation.step102();
                case 103 -> simulation.step103();
                case 104 -> simulation.step104();
                case 105 -> simulation.step105();
                case 106 -> simulation.step106();
                case 107 -> simulation.step107();
                case 108 -> simulation.step108();
                case 109 -> simulation.step109();
                case 110 -> simulation.step110();
                case 111 -> simulation.step111();
                case 112 -> simulation.step112();
                case 113 -> simulation.step113();
                case 114 -> simulation.step114();
                case 115 -> simulation.step115();
                case 116 -> simulation.step116();
                case 117 -> simulation.step117();
                case 118 -> simulation.step118();
                case 119 -> simulation.step119();
                case 120 -> simulation.step120();
                case 121 -> simulation.step121();
                case 122 -> simulation.step122();
                case 123 -> simulation.step123();
                case 124 -> simulation.step124();
                case 125 -> simulation.step125();
                case 126 -> simulation.step126();
                case 127 -> simulation.step127();
                case 128 -> simulation.step128();
                case 129 -> simulation.step129();
                case 130 -> simulation.step130();
                case 131 -> simulation.step131();
                case 132 -> simulation.step132();
                case 133 -> simulation.step133();
                case 134 -> simulation.step134();
                case 135 -> simulation.step135();
                case 136 -> simulation.step136();
                default -> throw new IllegalArgumentException("Invalid step: " + step);
            }
            wait(320);
        }
    }


    /**
     * Waits for the specified number of milliseconds.
     *
     * @param milliseconds The number of milliseconds to wait.
     */
    private static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // ignore the exception
        }
    }
}

