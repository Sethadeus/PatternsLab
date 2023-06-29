package Exceptions;

public class NoSuchModelNameException extends Exception // объявляемое
{
    public String ModelName;

    public NoSuchModelNameException(String name)
    {
        super ("Модель с именем \"" + name + "\" не найдена");
        ModelName = name;
    }

}
