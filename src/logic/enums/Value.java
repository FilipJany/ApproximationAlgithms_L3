package logic.enums;

/**
 * Created by FiFi on 18.05.2016.
 */
public enum Value
{
    Undefined("?"),
    True("true"),
    False("false");

    private String repr;

    Value(String repr)
    {
        this.repr = repr;
    }

    public String Representation()
    {
        return repr;
    }
}
