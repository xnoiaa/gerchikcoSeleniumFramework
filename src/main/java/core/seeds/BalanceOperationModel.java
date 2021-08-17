package core.seeds;

import lombok.Data;

import java.util.HashMap;

@Data
public class BalanceOperationModel extends Model {
    public String getTable() {
        return "accounts.balance_operation";
    }

    private Integer account_id;
    private Integer  operation_account_id;
    private Integer  type;
    private Integer  amount;
    private String  comment;
    private String  created_at;
    private String  updated_at;

    public void save() {
        HashMap<String, Object> value = new HashMap<>();

        value.put("account_id", account_id);
        value.put("operation_account_id", operation_account_id);
        value.put("type", type);
        value.put("amount", amount);
        value.put("comment", comment);

        arrayData.add(value);
    }
}
