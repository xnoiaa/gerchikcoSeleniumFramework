package core.seeds;

import java.util.ArrayList;
import java.util.HashMap;

public interface IModel {
    public String getTable();
    public ArrayList<HashMap<String, Object>> getArrayData();
    public void save();
}
