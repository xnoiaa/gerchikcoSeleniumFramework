package core.seeds;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseSeeder {
    Faker faker;
    ConnectToSql db;

    public BaseSeeder() {
        faker = new Faker();
        db = new ConnectToSql(new StockConnect());
    }

    public String dateNow(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String datetime = dateFormat.format(date);
        return datetime;
    }
}
