import java.util.HashMap;
import static Account.Authority;

public class AccountSystem {
    
    private HashMap<String, Account> accountList = new TreeSet<>();

    public AccountSystem(){
    }

    public boolean register(String name, String key, Authority ath){
        if(accountList.get(name) != null){
            return false;
        }
        Account a = new Account(name, key);
        a.setAuthority(ath);
        accountList.put(name, a);
        return true;
    }

    public boolean login(String name, String key){
        Account a = accountList.get(name);
        return a != null && a.check(key);
    }

}