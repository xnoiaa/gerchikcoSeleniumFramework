package core.seeds;

import lombok.Data;

import java.util.HashMap;

@Data
public class TestSeeder implements ModelInterface {

    private String table = "accounts.balance_operation";
    private Integer account_id;
    private Integer  operation_account_id;
    private Integer  type;
    private Integer  amount;
    private String  comment;
    private String  created_at;
    private String  updated_at;

    private HashMap getValue()
    {
        HashMap<String, Object> test = new HashMap<>();

        test.put("account_id", account_id);
        test.put("operation_account_id", operation_account_id);
        test.put("type", type);

        return test;
    }
}
