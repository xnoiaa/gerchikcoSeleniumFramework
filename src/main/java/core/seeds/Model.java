package core.seeds;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Model implements IModel {
    public ArrayList<HashMap<String, Object>> arrayData = new ArrayList<>();

    @Override
    public String getTable() {
        return "unknownTable";
    }

    public ArrayList<HashMap<String, Object>> getArrayData() {
        return arrayData;
    }
}
