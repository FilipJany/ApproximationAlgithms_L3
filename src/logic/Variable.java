package logic;

/**
 * Created by FiFi on 30.05.2016.
 */
public class Variable
{
    private final int id;
    private boolean value;
    private boolean negated;

    public Variable(int id)
    {
        this.id = id;
        value = false;
        negated = false;
    }

    public Variable(int id, boolean negated)
    {
        this.id = id;
        value = false;
        this.negated = negated;
    }

    public Variable(int id, boolean value, boolean negated)
    {
        this.id = id;
        this.value = value;
        this.negated = negated;
    }

    public int getID() { return id; }
    public boolean getValue() { return value; }
    public boolean isNegated() { return negated; }

    public void setValue(boolean value) { this.value = value; }
    public Variable setNegated(boolean value)
    {
        this.negated = value;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Variable))
            return false;
        return id == ((Variable) obj).getID();
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString()
    {
        if(negated)
            return ("~X" + id);
        return ("X" + id);
    }
}
