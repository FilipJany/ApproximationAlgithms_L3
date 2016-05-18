package main;

import logic.Clausule;
import logic.Formula;
import logic.Variable;
import logic.enums.Value;

import java.util.List;

/**
 * Created by FiFi on 18.05.2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        FormulaTest();
    }
    //TODO: Search for the same variables in clauses
    //TODO: Randomisation alg
    //TODO: Derandomisation alg
    public static void FormulaTest()
    {
        Variable x0 = new Variable(0);
        Variable x1 = new Variable(1);
        Formula formula = new Formula()
                .AddClausule(new Clausule()
                        .AddVariable(new Variable(0))
                        .AddVariable(new Variable(1)))
                .AddClausule(new Clausule()
                        .AddVariable(new Variable(0))
                        .AddVariable(new Variable(1, Value.Undefined, true)))
                .AddClausule(new Clausule()
                        .AddVariable(new Variable(0, Value.Undefined, true))
                        .AddVariable(new Variable(1)))
                .AddClausule(new Clausule()
                        .AddVariable(new Variable(0, Value.Undefined, true))
                        .AddVariable(new Variable(1, Value.Undefined, true)));
        System.out.println(formula.toString());
    }
}
