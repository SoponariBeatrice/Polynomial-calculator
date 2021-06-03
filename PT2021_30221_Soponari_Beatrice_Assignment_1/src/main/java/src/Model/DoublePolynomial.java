package src.Model;

import src.Model.DoubleCoefficientMonomial;

import java.util.List;

public class DoublePolynomial extends DoubleCoefficientMonomial {
    public List<DoubleCoefficientMonomial> doublePolynom;

    public List<DoubleCoefficientMonomial> getDoublePolynom() {
        return doublePolynom;
    }

    public void setDoublePolynom(List<DoubleCoefficientMonomial> doublePolynom) {
        this.doublePolynom = doublePolynom;
    }
}
