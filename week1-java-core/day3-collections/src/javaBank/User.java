package javaBank;

public class User {
    private String name;
    private int userId;

    User(String name, int userId){
        this.name = name;
        this. userId = userId;
    }
    public String getName(){
        return name;
    }
    public int getUserId(){
        return userId;
    }
}