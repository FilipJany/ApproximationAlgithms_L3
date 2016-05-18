package logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FiFi on 18.05.2016.
 */
public class Formula
{
    private List<Clausule> clausules;

    public Formula()
    {
        clausules = new ArrayList<>();
    }

    public Formula AddClausule(Clausule c)
    {
        clausules.add(c);
        return this;
    }

    public Formula RemoveClausule(Clausule c)
    {
        clausules.remove(c);
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < clausules.size()-1; ++i)
            builder.append(clausules.get(i).toString() + "/\\");
        builder.append(clausules.get(clausules.size()-1) + "]");
        return builder.toString();
    }
}
