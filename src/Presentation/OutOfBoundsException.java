package Presentation;
public class OutOfBoundsException extends Exception
{
    OutOfBoundsException(){
        super("This slide does not exist");
    }
}
