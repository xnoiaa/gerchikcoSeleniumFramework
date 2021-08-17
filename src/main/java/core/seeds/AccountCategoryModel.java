package core.seeds;

import lombok.Data;

import java.util.HashMap;

@Data
public class AccountCategoryModel extends Model {
    public String getTable() {
        return "accounts.account_category";
    }

    private Integer account_id;
    private Integer category;
    private Integer user_id;
    private Integer status;

    public void save() {
        HashMap<String, Object> value = new HashMap<>();

        value.put("account_id", account_id);
        value.put("category", category);
        value.put("user_id", user_id);
        value.put("status", status);

        arrayData.add(value);
    }
}
