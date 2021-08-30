package core.seeds;

import java.util.Properties;

public class StockConnect implements IConfigSql {
    public String getUrl() {
        return "jdbc:postgresql://localhost:5556/stocks";
    };
    public Properties getCredential()
    {
        Properties props = new Properties();

        props.put("user", "stocks");
        props.put("password", "stocks");
        props.put("ssl", "false");
        return props;
    }
}
