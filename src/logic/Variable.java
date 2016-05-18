package logic;

import logic.enums.Value;

/**
 * Created by FiFi on 18.05.2016.
 */
public class Variable
{
    private final int id;
    private Value value;
    private boolean negative;

    public Variable(int id)
    {
        this.id = id;
        this.value = Value.Undefined;
        this.negative = false;
    }

    public Variable(int id, Value value)
    {
        this.id = id;
        this.value = value;
        this.negative = false;
    }

    public Variable(int id, Value value, boolean negative)
    {
        this.id = id;
        this.value = value;
        this.negative = negative;
    }

    public int GetID() { return id; }
    public Value GetValue() { return value; }
    public void GetValue(Value value) { this.value = value; }
    public void ChangeValueTo(Value value) { this.value = value; }
    public void SwapNegative() { this.negative = !negative; }
    public Variable SetNegative(boolean negative)
    {
        this.negative = negative;
        return this;
    }

    @Override
    public String toString()
    {
        if(negative)
            return "~x" + id;
        return "x" + id;
    }
}
