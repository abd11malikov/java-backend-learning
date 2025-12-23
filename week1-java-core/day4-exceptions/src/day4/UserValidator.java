package day4;

public class UserValidator {

    public void validateUser(String name, int age, String email){
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("No. Name cannot be empty!!!");
        }
        if (age<0){
            throw  new InvalidAgeException("No, Age cannot be negative!!!: "+ age);
        }
        if (age<18){
            throw new InvalidAgeException("No, User is too young!!!: "+age);
        }
        System.out.println("User "+name+" is valid and registered");
        if (!email.contains("@"))
            throw new InvalidEmailException("No. Email should contain @ symbol: "+email);
    }
}
