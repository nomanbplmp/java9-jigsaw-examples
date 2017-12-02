module calculator.algorithm.add {
    requires calculator.algorithm.api;

    provides nk.java9.jigsaw.calculator.algorithm.api.Algorithm
            with nk.java9.jigsaw.calculator.algorithm.add.Add;
}