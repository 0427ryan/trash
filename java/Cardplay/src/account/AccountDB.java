package account;

import java.util.HashMap;
import java.util.Map;

public class AccountDB {
    
    private int current = 0;
    private Map<Integer,Account> accts;

    public AccountDB(){
        accts = new HashMap<>();
    }
    
    public Account getAccount(Integer key){
        return accts.get(key);
    }

    public Integer newAccount(String name){
        accts.put(++current, new Account(name));
        return current;
    }

    public void deleteAccount(Integer key){
        accts.remove(key);
    }
}