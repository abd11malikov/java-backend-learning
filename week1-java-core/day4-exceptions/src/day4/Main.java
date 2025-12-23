package day4;

public class Main {
    public static void main(String[] args) {
        UserValidator validator = new UserValidator();

        // SCENARIO 1: Happy Path
        System.out.println("Test 1: Valid User");
        try {
            validator.validateUser("Otabek", 25,"otabekabd11malikov@gmail.com");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // SCENARIO 2: Too Young
        System.out.println("\nTest 2: Too Young");
        try {
            validator.validateUser("Kid", 15,"o.abdumalikov@newuu");
        } catch (InvalidAgeException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            System.out.println("Please  return when you are 18");
        }

        // SCENARIO 3: Empty Name
        System.out.println("\nTest 3: Empty Name");
        try {
            validator.validateUser("", 30,"karochemen@gmail.com");
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            System.out.println("Validation attempt finished");
        }
        // SCENARIO 4: Negative age
        System.out.println("\nTest 4: Negative age");
        try{
            validator.validateUser("Akmal",-5,"hullasshu@gmail.com");
        } catch (InvalidAgeException e){
            System.out.println("EXCEPTION: "+e.getMessage());
        }

        // SCENARIO 5: Invalid email
        System.out.println("\nTest 5: Invalid email");
        try {
            validator.validateUser("Ikrom",19,"blabla$gmail.com");
        }catch (InvalidEmailException e){
            System.out.println("EXCEPTION: "+e.getMessage());
        }
    }
}