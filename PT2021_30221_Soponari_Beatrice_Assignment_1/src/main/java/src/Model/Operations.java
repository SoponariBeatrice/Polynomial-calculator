package src.Model;

import java.util.ArrayList;
import java.util.List;
public class Operations {
    public Polynomial addOperation(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        List<IntCoefficientMonomial> m = new ArrayList<>();
        int counterP1 = 0, counterP2 = 0;
        if (p1.polynom != null && p2.polynom != null) {
            while (counterP1 < p1.polynom.size()) {
                if (counterP2 == p2.polynom.size()) {
                    while (counterP1 < p1.polynom.size()) {
                        IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                        mAux.setPower(p1.polynom.get(counterP1).power);
                        mAux.setCoefficient(p1.polynom.get(counterP1).coefficient);
                        m.add(mAux);
                        counterP1++;
                    }
                    break;
                }
                if (p1.polynom.get(counterP1).power > p2.polynom.get(counterP2).power) {
                    IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                    mAux.setCoefficient(p1.polynom.get(counterP1).coefficient);
                    mAux.setPower(p1.polynom.get(counterP1).power);
                    m.add(mAux);
                    counterP1++;
                } else if (p1.polynom.get(counterP1).power == p2.polynom.get(counterP2).power) {
                    IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                    mAux.setCoefficient(p1.polynom.get(counterP1).coefficient + p2.polynom.get(counterP2).coefficient);
                    mAux.setPower(p1.polynom.get(counterP1).power);
                    m.add(mAux);
                    counterP1++;
                    counterP2++;
                } else if (p1.polynom.get(counterP1).power < p2.polynom.get(counterP2).power) {
                    IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                    mAux.setCoefficient(p2.polynom.get(counterP2).coefficient);
                    mAux.setPower(p2.polynom.get(counterP2).power);
                    m.add(mAux);
                    counterP2++;
                }

            }
        }

        if (p2.polynom != null)
            while (counterP2 < p2.polynom.size()) {
                IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                mAux.setCoefficient(p2.polynom.get(counterP2).coefficient);
                mAux.setPower(p2.polynom.get(counterP2).power);
                m.add(mAux);
                counterP2++;
            }
        if (p1.polynom != null) {
            while (counterP1 < p1.polynom.size()) {
                IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                mAux.setCoefficient(p1.polynom.get(counterP1).coefficient - 2 * p1.polynom.get(counterP1).coefficient);
                mAux.setPower(p1.polynom.get(counterP1).power);
                m.add(mAux);
                counterP1++;
            }
        }
            result.setPolynom(m);
            return result;

    }

    public Polynomial subOperation(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        List<IntCoefficientMonomial> m = new ArrayList<>();
        int counterP1 = 0,counterP2 = 0;
        if(p1 != null && p2 !=null)
        {
            while(counterP1 < p1.polynom.size())
            {
                if(counterP2 == p2.polynom.size())
                {
                    while(counterP1 < p1.polynom.size())
                    {
                        IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                        mAux.setPower(p1.polynom.get(counterP1).power);
                        mAux.setCoefficient(p1.polynom.get(counterP1).coefficient);
                        m.add(mAux);
                        counterP1++;
                    }
                    break;
                }
                if(p1.polynom.get(counterP1).power > p2.polynom.get(counterP2).power)
                {
                    IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                    mAux.setCoefficient(p1.polynom.get(counterP1).coefficient);
                    mAux.setPower(p1.polynom.get(counterP1).power);
                    m.add(mAux);
                    counterP1++;
                }
                else
                if(p1.polynom.get(counterP1).power == p2.polynom.get(counterP2).power) {
                    IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                    mAux.setCoefficient(p1.polynom.get(counterP1).coefficient - p2.polynom.get(counterP2).coefficient);
                    mAux.setPower(p1.polynom.get(counterP1).power);
                    m.add(mAux);
                    counterP1++;
                    counterP2++;
                }
                else
                if(p1.polynom.get(counterP1).power < p2.polynom.get(counterP2).power)
                {
                    IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                    mAux.setCoefficient(p2.polynom.get(counterP2).coefficient - 2*p2.polynom.get(counterP2).coefficient);
                    mAux.setPower(p2.polynom.get(counterP2).power);
                    m.add(mAux);
                    counterP2++;
                }

            }
        }
       if(p2 != null)
        while(counterP2 < p2.polynom.size())
        {
            IntCoefficientMonomial mAux = new IntCoefficientMonomial();
            mAux.setCoefficient(p2.polynom.get(counterP2).coefficient - 2*p2.polynom.get(counterP2).coefficient);
            mAux.setPower(p2.polynom.get(counterP2).power);
            m.add(mAux);
            counterP2++;
        }
        if(p1 != null && p2 == null)
        {
            while(counterP1 < p2.polynom.size())
            {
                IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                mAux.setCoefficient(p1.polynom.get(counterP1).coefficient - 2*p1.polynom.get(counterP1).coefficient);
                mAux.setPower(p1.polynom.get(counterP1).power);
                m.add(mAux);
                counterP1++;
            }
        }

        result.setPolynom(m);
        return result;
    }

    public Polynomial multiplicationOperation(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        Integer counter1 = 0,counter2;

        while(counter1 < p1.polynom.size())
        {
            counter2 = 0;
            List<IntCoefficientMonomial> listM = new ArrayList<>();
            while(counter2 < p2.polynom.size() )
            {
                IntCoefficientMonomial m = new IntCoefficientMonomial();
                m.setCoefficient(p1.polynom.get(counter1).coefficient * p2.polynom.get(counter2).coefficient);
                m.setPower(p1.polynom.get(counter1).power + p2.polynom.get(counter2).power);
                listM.add(m);
                counter2++;
            }
            Polynomial aux = new Polynomial();
            aux.setPolynom(listM);
            result = addOperation(result,aux);
            counter1++;
        }

        return result;
    }
    public Polynomial derivateOperation(Polynomial p1)
    {
        Polynomial result = new Polynomial();
        int counter = 0;
        List<IntCoefficientMonomial> listM = new ArrayList<>();
        while(counter < p1.polynom.size())
        {
            IntCoefficientMonomial m = new IntCoefficientMonomial();
            m.setCoefficient(p1.polynom.get(counter).coefficient*p1.polynom.get(counter).power);
            m.setPower(p1.polynom.get(counter).power - 1);
            listM.add(m);
            counter++;
        }
        result.setPolynom(listM);
        return result;
    }
    public DoublePolynomial integrateOperation(Polynomial p)
    {
        DoublePolynomial result = new DoublePolynomial();
        Integer counter = 0;
        List<DoubleCoefficientMonomial> listDoubleMonomial = new ArrayList<>();
        while(counter < p.polynom.size())
        {
            DoubleCoefficientMonomial m = new DoubleCoefficientMonomial();
            m.setPower(p.polynom.get(counter).power + 1);
            m.setCoefficient(((double)p.polynom.get(counter).coefficient *  ((double)1/(p.polynom.get(counter).power + 1))));
            listDoubleMonomial.add(m);
            counter++;
        }
        result.setDoublePolynom(listDoubleMonomial);
        return result;
    }
}


