package nk.java9.jigsaw.calculator.algorithm.add;

import nk.java9.jigsaw.calculator.algorithm.api.Algorithm;

public class Add implements Algorithm {

    @Override
    public Integer calculate(Integer input, Integer input2) {
        return input + input2;
    }
}
