package Model;

public class Monomial {
    private float coefficient;
    private int power;
    public Monomial(float Coef, int Pow)
    {
        this.coefficient = Coef;
        this.power = Pow;
    }

    public Monomial(String string1)
    {
        String[] list = string1.split("x");
        if (list[0].equals("-"))
            this.coefficient = -1;
        else if (list[0].equals("+"))
            this.coefficient = 1;
        else
        {
            this.coefficient = Integer.parseInt(list[0]);
        }
        if (list.length == 1)
        {
            this.power = 1;
            if (list[0] == string1)
                this.power = 0;
        }
        else if (list.length == 2)
        {
            this.power = Integer.parseInt(list[1].substring(1, list[1].length()));
        }
    }

    public String toString(){
        return Float.toString(this.coefficient) + "x^" + Integer.toString(this.power);
    }

    public float getCoefficient()
    {
        return this.coefficient;
    }

    public int getPower()
    {
        return this.power;
    }
}
