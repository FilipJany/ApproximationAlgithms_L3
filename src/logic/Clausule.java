package logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FiFi on 18.05.2016.
 */
public class Clausule //karwa chyba nie ma takiego slowa :P jak znasz prawidlowe to daj refactor :)
{
    private List<Variable> variables;

    public Clausule()
    {
        variables = new ArrayList<>();
    }

    public Clausule AddVariable(Variable v)
    {
        variables.add(v);
        return this;
    }

    public List<Variable> GetVariables()
    {
        return variables;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("(");
        for (int i = 0; i < variables.size()-1; ++i)
            builder.append(variables.get(i).toString() + "\\/");
        builder.append(variables.get(variables.size()-1).toString() + ")");
        return builder.toString();
    }
}
