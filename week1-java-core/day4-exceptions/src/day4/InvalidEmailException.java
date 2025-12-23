package day4;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String email){
        super(email);
    }
}
