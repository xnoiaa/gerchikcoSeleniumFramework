import core.seeds.AccountTest;
import core.seeds.BalanceOperationTest;
import org.junit.Test;

public class Seeds {

    @Test

    public void balanceoperationCreation() {
        BalanceOperationTest balanceOperationTest = new BalanceOperationTest();
        balanceOperationTest.test();
    }

    @Test
    public void accountsCreation(){
        AccountTest accountTest = new AccountTest();
        accountTest.createTable();
    }

    @Test
    public void accountsDeleteTable(){
        AccountTest accountTest = new AccountTest();
        accountTest.deleteTable();
    }
}
