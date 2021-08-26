package core.seeds;

public class AccountTest {

    AccountSeeder accountSeeder = new AccountSeeder();

    public void createTable() {
        accountSeeder.createTable();
    }

    public void deleteTable(){
        accountSeeder.deleteTable();
    }

    public String getEmailModel(){
        return accountSeeder.getEmail();
    }

    public String getPassModel(){
        return accountSeeder.getPass();
    }

}
