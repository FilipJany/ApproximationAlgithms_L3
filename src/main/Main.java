package main;

import logic.Clause;
import logic.Formula;
import logic.Solver;
import logic.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FiFi on 18.05.2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        List<Variable> variables = new ArrayList<>();
        variables.add(new Variable(0));
        variables.add(new Variable(1));
        List<Clause> clauses = new ArrayList<>();
        try
        {
            Clause clause = new Clause(10);
            clause.addVariable(new Variable(variables.get(0).getID()));
            clause.addVariable(new Variable(variables.get(1).getID()));
            clauses.add(clause);

            clause = new Clause(15);
            clause.addVariable(new Variable(variables.get(0).getID()));
            clause.addVariable(new Variable(variables.get(1).getID()).setNegated(true));
            clauses.add(clause);

            clause = new Clause(5);
            clause.addVariable(new Variable(variables.get(0).getID()).setNegated(true));
            clause.addVariable(new Variable(variables.get(1).getID()));
            clauses.add(clause);

            clause = new Clause(20);
            clause.addVariable(new Variable(variables.get(0).getID()).setNegated(true));
            clause.addVariable(new Variable(variables.get(0).getID()).setNegated(true));
            clauses.add(clause);

            Formula f = new Formula();
            f.setClauses(clauses);
            f.setVariables(variables);
            System.out.println("Formula looks like this:");
            System.out.println(f);
            Solver solver = new Solver(f);
            solver.solve();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
