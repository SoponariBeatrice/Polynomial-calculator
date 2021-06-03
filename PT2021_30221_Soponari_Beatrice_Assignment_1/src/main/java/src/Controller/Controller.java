package src.Controller;
import src.Model.ActionHandler;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import  src.View.*;
import src.Model.*;
public class Controller {
    ActionHandler ah = new ActionHandler();
    CalculatorGui view = new CalculatorGui();
    ActionHandlerOperations aho = new ActionHandlerOperations();
    String s1,s2;

    public void buttons()
    {
        view.zero.addActionListener(ah);
        view.one.addActionListener(ah);
        view.two.addActionListener(ah);
        view.three.addActionListener(ah);
        view.four.addActionListener(ah);
        view.five.addActionListener(ah);
        view.six.addActionListener(ah);
        view.seven.addActionListener(ah);
        view.eight.addActionListener(ah);
        view.nine.addActionListener(ah);
        view.plusButton.addActionListener(ah);
        view.minusButton.addActionListener(ah);
        view.multiplicationButton.addActionListener(ah);
        view.divideBarButton.addActionListener(ah);
        view.powButton.addActionListener(ah);
        view.xButton.addActionListener(ah);
        view.dotButton.addActionListener(ah);
        view.deleteButton.addActionListener(ah);
        view.setButtons();
    }

    public boolean polynomsCheck(String string)
    {
        String m1_pattern =  "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)";
        Pattern pattern = Pattern.compile(m1_pattern);
        Matcher matcher1 = pattern.matcher(string);
        while(matcher1.find())
        {
            if(!matcher1.matches())
            {
                System.out.println("The polynomial is invalid!");
                return false;
            }
        }
        return true;
    }
    public class ActionHandlerOperations implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source instanceof JButton) {
                s1 = view.enterFirstPolynomial.getText();
                s2 = view.enterSecondPolynomial.getText();
                    List<Integer> listCoef1 = new ArrayList<>();
                    List<Integer> listCoef2 = new ArrayList<>();
                    List<IntCoefficientMonomial> m1 = new ArrayList<>();
                    List<Integer> listPow1 = new ArrayList<>();
                    List<IntCoefficientMonomial> m2 = new ArrayList<>();
                    List<Integer> listPow2 = new ArrayList<>();
                    Integer powIndex1 = 0;
                    Polynomial strToP1 = new Polynomial();
                    strToP1 = coeffAndPower(s1);
                    Polynomial strToP2 = new Polynomial();
                    strToP2 = coeffAndPower(s2);
                    for (IntCoefficientMonomial i : strToP1.polynom
                    ) {
                        listPow1.add(i.getPower());
                        listCoef1.add(i.getCoefficient());

                    }
                    for (IntCoefficientMonomial i : strToP2.polynom
                    ) {
                        listPow2.add(i.getPower());
                        listCoef2.add(i.getCoefficient());
                    }
                    for (Integer i : listCoef1
                    ) {
                        IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                        mAux.setCoefficient(i);
                        mAux.setPower(listPow1.get(powIndex1));
                        m1.add(mAux);
                        powIndex1++;
                    }
                    Integer powIndex2 = 0;
                    for (Integer i : listCoef2
                    ) {
                        IntCoefficientMonomial mAux = new IntCoefficientMonomial();
                        mAux.setCoefficient(i);
                        mAux.setPower(listPow2.get(powIndex2));
                        m2.add(mAux);
                        powIndex2++;
                    }
                    Polynomial pol1 = new Polynomial();
                    pol1.setPolynom(m1);
                    Polynomial pol2 = new Polynomial();
                    pol2.setPolynom(m2);
                    Operations op = new Operations();
                    if (((JButton) source).getText().equals("Add")) {
                        Polynomial addResult;
                        addResult = op.addOperation(pol1, pol2);
                        String polToStr = polynomToString(addResult);
                        if(polToStr == null)
                        {
                            view.resultTxt.setText("Polinoame introduse gresit");
                        }else
                            view.resultTxt.setText(polToStr);
                    } else if (((JButton) source).getText().equals("Substract")) {
                        Polynomial subResult;
                        subResult = op.subOperation(pol1, pol2);
                        String polToStr = polynomToString(subResult);
                        if(polToStr == null)
                        {
                            view.resultTxt.setText("Polinoame introduse gresit");
                        }else
                            view.resultTxt.setText(polToStr);
                    } else if (((JButton) source).getText().equals("Multiplicate")) {
                        Polynomial mulResult = op.multiplicationOperation(pol1, pol2);
                        String polToStr = polynomToString(mulResult);
                        if(polToStr == null)
                        {
                            view.resultTxt.setText("Polinoame introduse gresit");
                        }else
                            view.resultTxt.setText(polToStr);
                    } else if (((JButton) source).getText().equals("Derivate")) {
                        Polynomial derivResult = op.derivateOperation(pol1);
                        String polToStr = polynomToString(derivResult);
                        if(polToStr == null)
                        {
                            view.resultTxt.setText("Polinoame introduse gresit");
                        }else
                            view.resultTxt.setText(polToStr);
                    } else if (((JButton) source).getText().equals("Integrate")) {
                        DoublePolynomial integrateResult = op.integrateOperation(pol1);
                        String polToStr = doublePolynomToString(integrateResult);
                        if(polToStr == null)
                        {
                            view.resultTxt.setText("Polinoame introduse gresit");
                        }else
                            view.resultTxt.setText(polToStr);
                    }

            }
        }
    }

    public String polynomToString(Polynomial p)
    {
        String result = null;
        for (IntCoefficientMonomial i : p.polynom
             ) {
            if(result == null)
            {

                    result = String.valueOf(i.coefficient) + "x^" + String.valueOf(i.power);
            }

            else
            if(i.coefficient >= 0)
                result = result.concat("+" + String.valueOf(i.coefficient) + "x^" + String.valueOf(i.power));
            else
                result = result.concat(String.valueOf(i.coefficient) + "x^" + String.valueOf(i.power));
        }
        return result;
    }
    public String doublePolynomToString(DoublePolynomial p)
    {
        String result = null;
        for (DoubleCoefficientMonomial i : p.doublePolynom
        ) {
            if(result == null)
            {
                result = String.valueOf(i.coefficient) + "x^" + String.valueOf(i.power);
            }

            else
            if(i.coefficient >= 0)
                result = result.concat("+" + String.valueOf(i.coefficient) + "x^" + String.valueOf(i.power));
            else
                result = result.concat(String.valueOf(i.coefficient) + "x^" + String.valueOf(i.power));
        }
        return result;
    }
    public void setButtons(){
        view.addButton.addActionListener(aho);
        view.substractButton.addActionListener(aho);
        view.multiplicateButton.addActionListener(aho);
        view.derivateButton.addActionListener(aho);
        view.integrationButton.addActionListener(aho);
    }
    public Polynomial coeffAndPower(String str)
    {
          Polynomial result = new Polynomial();
          List<IntCoefficientMonomial> listMonomials = new ArrayList<>();
          Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
          Matcher m = p.matcher(str);
          while(m.find())
          {
              IntCoefficientMonomial mAux = new IntCoefficientMonomial();
              mAux.setCoefficient(Integer.parseInt(m.group(1)));
              mAux.setPower(Integer.parseInt(m.group(2)));
              listMonomials.add(mAux);
          }
          result.setPolynom(listMonomials);
        return result;
    }
}
