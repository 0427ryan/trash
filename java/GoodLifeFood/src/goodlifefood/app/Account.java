import java.security.SecureRandom;

public class Account {

    private String name;
    private String key;
    private Authority ath;

    public static enum Authority{//權限
        CLIENT,
        PRODUCER,
    }

    Account(String name, String key){
        this.name = name;
        this.key = key;
    }
    void setAuthority(Authority ath){
        this.ath = ath;
    }

    public Authority getAuthority(){
        return ath;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Account){
            if(this.name.equals(o.name) && this.key.equals(o.key)){
                return true;
            }
        }
        return false;
    }

    public String getName(){
        return name;
    }

    public boolean check(String key){
        return this.key.equals(key);
    }
}