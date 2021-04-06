package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Polynomial {
    public Integer max_power;
    private ArrayList<Monomial> polynomial;

    public Polynomial(ArrayList<Monomial> mon)
    {
        mon.sort(Comparator.comparing(Monomial::getPower));
        polynomial = mon;
        if (mon.size() == 0)
            max_power = null;
        else
            this.max_power = mon.get(mon.size() - 1).getPower();
    }

    public String toString()
    {
        String s = "";
        DecimalFormat x1;
        if (polynomial.isEmpty())
            return "0";
        for (Monomial m : polynomial) {
            if (m.getCoefficient() == (int)m.getCoefficient()) {
                x1 = new DecimalFormat("0");
            }
            else{
                x1 = new DecimalFormat("0.0");
            }
            if (m.getCoefficient() >= 0 && !s.equals("")) s += "+";
            if (m.getPower() == 1 && m.getCoefficient() == 1) s = s + "x";
            else if (m.getPower() == 1 && m.getCoefficient() > 0) s = s + x1.format(m.getCoefficient()) + "x";
            else if (m.getPower() == 1 && m.getCoefficient() == -1) s = s + "-x";
            else if (m.getPower() == 1 && m.getCoefficient() < -1) s = s + "-" + Math.abs(Integer.parseInt(x1.format(m.getCoefficient()))) + "x";
            else if (m.getPower() == 0) s = s + x1.format(m.getCoefficient());
            else if (m.getPower() > 1 && m.getCoefficient() == 1) s = s + "x^" + m.getPower();
            else if (m.getPower() > 1 && m.getCoefficient() > 0) s = s + x1.format(m.getCoefficient()) + "x^" + m.getPower();
            else if (m.getPower() > 1 && m.getCoefficient() == -1) s = s + "-x^" + m.getPower();
            else if (m.getPower() > 1 && m.getCoefficient() < -1) s = s + "-" + Math.abs(Integer.parseInt(x1.format(m.getCoefficient()))) + "x^" + m.getPower();
            else if (m.getPower() < 0 && m.getCoefficient() == 1) s = s + "x^" + m.getPower();
            else if (m.getPower() < 0 && m.getCoefficient() > 0) s = s + x1.format(m.getCoefficient()) + "x^" + m.getPower();
            else if (m.getPower() < 0 && m.getCoefficient() == -1) s = s + "-x^" + m.getPower();
            else if (m.getPower() < 0 && m.getCoefficient() < -1) s = s + "-" + Math.abs(Integer.parseInt(x1.format(m.getCoefficient()))) + "x^" + m.getPower();
        }
        return s;
    }

    public float getCoefficient(int pow)
    {
        for (Monomial m : polynomial) {
            if (m.getPower() == pow)
                return m.getCoefficient();
        }
        return 0;
    }

    public Polynomial add(Polynomial x)
    {
        ArrayList<Monomial> array1 = new ArrayList<>();
        for (int i = 0; i <= Integer.max(this.max_power, x.max_power); i++) {
            float coefficient = this.getCoefficient(i) + x.getCoefficient(i);
            if (coefficient != 0) {
                array1.add(new Monomial(coefficient, i));
            }
        }
        return new Polynomial(array1);
    }

    public Polynomial sub(Polynomial x)
    {
        ArrayList<Monomial> array1 = new ArrayList<>();
        for (int i = 0; i <= Integer.max(this.max_power, x.max_power); i++) {
            float coefficient = this.getCoefficient(i) - x.getCoefficient(i);
            if (coefficient != 0) {
                array1.add(new Monomial(coefficient, i));
            }
        }
        return new Polynomial(array1);
    }

    public Polynomial mul(Polynomial x)
    {
        ArrayList<Monomial> array1 = new ArrayList<>();
        HashMap<Integer, Monomial> map = new HashMap<>();
        for (int i = 0; i <= this.max_power; i++)
            for (int j = 0; j <= x.max_power; j++) {
                float coefficient = this.getCoefficient(i) * x.getCoefficient(j);
                if (coefficient != 0) {
                    if (map.containsKey(i + j))
                        map.put(i + j, new Monomial(map.get(i + j).getCoefficient() + coefficient, i + j));
                    else
                        map.put(i + j, new Monomial(coefficient, i + j));
                }
            }
        for (Integer power : map.keySet())
            array1.add(map.get(power));
        return new Polynomial(array1);
    }

    public Polynomial div(Polynomial x)
    {
        ArrayList<Monomial> array1 = new ArrayList<>();
        HashMap<Integer, Monomial> map = new HashMap<>();
        for (int i = 0; i <= this.max_power; i++)
            for (int j = 0; j <= x.max_power; j++) {
                float coefficient = this.getCoefficient(i) / x.getCoefficient(j);
                if (this.getCoefficient(i) != 0 && x.getCoefficient(j) != 0)
                    if (map.containsKey(i - j))
                        map.put(i - j, new Monomial(map.get(i - j).getCoefficient() + coefficient, i - j));
                    else
                        map.put(i - j, new Monomial(coefficient, i - j));
            }
        for (Integer power : map.keySet()) {
            array1.add(map.get(power));
        }
        return new Polynomial(array1);
    }

    public Polynomial der()
    {
        ArrayList<Monomial> array1 = new ArrayList<>();
        for (int i = 0; i <= this.max_power; i++) {
            float coefficient = this.getCoefficient(i);
            if (coefficient != 0 && i != 0) {
                array1.add(new Monomial(coefficient * i, i - 1));
            }
        }
        return new Polynomial(array1);
    }

    public Polynomial integ()
    {
        ArrayList<Monomial> array1 = new ArrayList<>();
        for (int i = 0; i <= this.max_power; i++) {
            float coefficient = this.getCoefficient(i);
            if (coefficient != 0) {
                array1.add(new Monomial((coefficient / (i + 1)), i + 1));
            }
        }
        return new Polynomial(array1);
    }
}
