package logic;

import logic.exceptions.WeightNegativeException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FiFi on 30.05.2016.
 */
public class Clause
{
    private List<Variable> variables;
    private int weight;

    public Clause() throws WeightNegativeException
    {
        variables = new ArrayList<>();
        setWeight(0);
    }

    public Clause(int weight) throws WeightNegativeException
    {
        variables = new ArrayList<>();
        setWeight(weight);
    }

    public Clause(int weight, List<Variable> variables) throws WeightNegativeException
    {
        this.variables = variables;
        setWeight(weight);
    }

    public List<Variable> getVariables() { return variables; }

    public int getWeight() { return weight; }

    public void setVariables(List<Variable> variables) { this.variables = variables; }

    public void setWeight(int weight) throws WeightNegativeException
    {
        if(weight < 0)
            throw new WeightNegativeException();
        this.weight = weight;
    }

    public void addVariable(Variable variable)
    {
        variables.add(variable);
    }

    public void removeVariable(int variableIndex)
    {
        variables.remove(variableIndex);
    }

    public void removeVariable(Variable variable)
    {
         removeVariable(variables.indexOf(variable));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("(");
        for (int i = 0; i < variables.size()-1; ++i)
            builder.append(variables.get(i).toString() + "\\/");
        builder.append(variables.get(variables.size()-1).toString() + "){" + weight + "}");
        return builder.toString();
    }
}
