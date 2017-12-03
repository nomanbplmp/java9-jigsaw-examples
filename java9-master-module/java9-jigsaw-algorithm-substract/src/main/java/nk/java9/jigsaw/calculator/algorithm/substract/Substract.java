package nk.java9.jigsaw.calculator.algorithm.substract;

import nk.java9.jigsaw.calculator.algorithm.api.Algorithm;

public class Substract implements Algorithm {

    @Override
    public Integer calculate(Integer input, Integer input2) {
        return input - input2;
    }
}
