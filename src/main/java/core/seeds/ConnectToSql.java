package core.seeds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class ConnectToSql {
    Connection connection = null;
    Statement statement = null;

    public ConnectToSql(IConfigSql config) {
        try {
            connection  = DriverManager.getConnection(config.getUrl(), config.getCredential());
            statement   = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(IModel model, Integer count) {
        try {
            String query = String.format("DELETE FROM %s WHERE id in (\n" +
                    "      SELECT id \n" +
                    "      FROM %s \n" +
                    "      ORDER BY id desc\n" +
                    "      LIMIT %d\n" +
                    "     )", model.getTable(), model.getTable(), count);

            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(IModel model) {
        String keys = "";
        String values = "";
        int keyCount = 0;

        for(int i = 0; i < model.getArrayData().size(); i++) {
            String dot = ", ";
            int count = 0;

            if (model.getArrayData().size() - 1 == i) dot = "";

            values += "(";

            for (HashMap.Entry<String, Object> entry : model.getArrayData().get(i).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                String dotTwo = ", ";

                if (model.getArrayData().get(i).size() - 1 == count) dotTwo = "";
                if (model.getArrayData().get(i).size() - 1 >= keyCount) keys += key+dotTwo;

                values += "'"+value+"'"+dotTwo;
                ++count;
                ++keyCount;
            }

            values += ")"+dot;
        };

        try {
            String query = String.format("INSERT INTO %s (%s) VALUES %s", model.getTable(), keys, values);

            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
