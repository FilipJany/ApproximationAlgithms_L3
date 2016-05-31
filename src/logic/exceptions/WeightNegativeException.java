package logic.exceptions;

/**
 * Created by FiFi on 30.05.2016.
 */
public class WeightNegativeException extends Exception
{
    public WeightNegativeException()
    {
        super("Clause weight has to be positive!");
    }
}
