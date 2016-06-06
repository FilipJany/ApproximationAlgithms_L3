package logic;


import java.util.Random;

/**
 * Created by FiFi on 30.05.2016.
 */
public class Solver
{
    public Formula formula;

    public Solver(Formula formula)
    {
        this.formula = formula;
    }

    private void randomize()
    {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < formula.getVariables().size(); ++i)
            formula.getVariables().get(i).setValue(random.nextBoolean());
    }

    public void solve() {
        randomize();
        int totalValue = 0;
        for (Clause c : formula.getSatisfiedClauses())
            totalValue += c.getWeight();

        System.out.println(formula.toString());
        for (Variable v : formula.getVariables())
            System.out.println(v.toString() + ": " + v.getValue());
        System.out.println("Total value: " + totalValue);
    }
}
