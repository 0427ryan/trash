package account;

public class Account {
    
    private final String name;
    private int money = 0;

    Account(){
        name = "unknown owner";
    }

    Account(String name){
        this.name = name;
    }
    
    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return money;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder().append("owner: ")
                                               .append(name)
                                               .append("\nmoney: ")
                                               .append(money);
        return ret.toString();
    }
}