package src.Model;

import src.Model.IntCoefficientMonomial;

import java.util.List;

public class Polynomial extends IntCoefficientMonomial {
    public List<IntCoefficientMonomial> polynom;

    public List<IntCoefficientMonomial> getPolynom() {
        return polynom;
    }

    public void setPolynom(List<IntCoefficientMonomial> polynom) {
        this.polynom = polynom;
    }
}
