package Exceptions;

public class DuplicateModelNameException extends Exception // объявляемое
{
    public String ModelName;

    public  DuplicateModelNameException(String name)
    {
        super ("Модель с именем \"" + name + "\" уже существует");
        ModelName = name;
    }
}
