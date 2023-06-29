package Exceptions;

public class ModelPriceOutOfBoundsException extends IndexOutOfBoundsException // необъявляемое исключение
{
    public ModelPriceOutOfBoundsException() {}

    public ModelPriceOutOfBoundsException(String message)
    {
        super(message);
    }

}
