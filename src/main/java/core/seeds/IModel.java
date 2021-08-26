package core.seeds;

import java.util.ArrayList;
import java.util.HashMap;

public interface IModel {
     String getTable();
     ArrayList<HashMap<String, Object>> getArrayData();
     void save();
}
