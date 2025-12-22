package javaBank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private List<User> users = new ArrayList<>();
    private Map<Integer,Double> balances = new HashMap<>();
    private Map<Integer,List<Transaction>> transactions = new HashMap<>();

    public boolean createAccount(String name, Integer userId){
        for (User user : users) {
            if (user.getUserId() == userId) return false;
        }
        User user = new User(name,userId);
        users.add(user);
        balances.put(userId,0.0);
        transactions.put(userId, new ArrayList<>());
        return true;
    }

    public boolean deposit(int userId, Double amount){
        for (User user : users) {
            if (user.getUserId() == userId){
                Transaction transaction = new Transaction("DEPOSIT",amount);

                balances.put(userId,balances.get(userId)+amount);

                transactions.get(userId).add(transaction);
                return true;
            }
        }
        return false;
    }

    public boolean withdrawal(int userId, Double amount){
        for (User user : users) {
            if(user.getUserId()== userId){

                double currentBalance = balances.get(userId);
                if (currentBalance<amount)
                    return false;
                balances.put(userId,currentBalance-amount);
                transactions.get(userId).add(new Transaction("WITHDRAWAL",amount));
                return true;
            }
        }
        return false;
    }

    public double getBalance(int userId){
        for (User user : users) {
            if(user.getUserId()==userId){
                return balances.get(userId);
            }
        }return -1;
    }

    public void printStatement(int userId){
        List<Transaction> history = transactions.get(userId);
        if (history !=null){
            int cnt = 1;
            for (Transaction transaction : history) {
                System.out.println(cnt+++". " + transaction);
            }
        }
    }

}
