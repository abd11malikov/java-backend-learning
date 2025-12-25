package streams;

public enum Status {
    PENDING, SHIPPED, DELIVERED;

    static public Status helper(String s){
        try {
            return Status.valueOf(s);
        }catch (RuntimeException r){
            return PENDING;
        }
    }
}