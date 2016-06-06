package logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FiFi on 30.05.2016.
 */
public class Formula
{
    private List<Clause> clauses;
    private List<Variable> availableVariables;

    public Formula()
    {
        clauses = new ArrayList<>();
        availableVariables = new ArrayList<>();
    }

    public List<Clause> getClauses() { return clauses; }
    public List<Variable> getVariables() { return availableVariables; }

    public void setVariables(List<Variable> variables)
    {
        this.availableVariables = variables;
    }

    public void setClauses(List<Clause> clauses)
    {
        this.clauses = clauses;
    }

    private boolean getVariableValue(Variable var)
    {
        for (Variable v : availableVariables)
            if(v.getID() == var.getID())
                return v.getValue();
        return false;//ni hu hu
    }

    public List<Clause> getSatisfiedClauses()
    {
        List<Clause> satisfiedClauses = new ArrayList<>();
        for (Clause c : clauses)
        {
            boolean satisfied = true;
            for (Variable v : c.getVariables())
            {
                if(v.isNegated())
                    satisfied &= !getVariableValue(v);
                else
                    satisfied &= getVariableValue(v);
            }
            if(satisfied)
                satisfiedClauses.add(c);
        }
        return satisfiedClauses;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");
        for(int i = 0; i < clauses.size()-1; ++i)
            builder.append(clauses.get(i).toString() + " /\\ ");
        builder.append(clauses.get(clauses.size()-1).toString() + "]");
        return builder.toString();
    }
}
