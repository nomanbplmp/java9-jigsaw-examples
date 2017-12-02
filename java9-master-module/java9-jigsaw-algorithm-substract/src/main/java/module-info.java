module calculator.algorithm.substract {
    requires calculator.algorithm.api;

    provides nk.java9.jigsaw.calculator.algorithm.api.Algorithm
            with nk.java9.jigsaw.calculator.algorithm.substract.Substract;
}