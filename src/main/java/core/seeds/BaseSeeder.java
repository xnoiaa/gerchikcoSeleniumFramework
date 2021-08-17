package core.seeds;

import com.github.javafaker.Faker;

public class BaseSeeder {
    Faker faker;
    ConnectToSql db;

    public BaseSeeder() {
        faker = new Faker();
        db = new ConnectToSql(new StockConnect());
    }
}
