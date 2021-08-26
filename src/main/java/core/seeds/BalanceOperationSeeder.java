package core.seeds;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BalanceOperationSeeder extends BaseSeeder {
    public BalanceOperationSeeder() {
    }

    public void run() {
        BalanceOperationModel model = new BalanceOperationModel();


        for(int i = 0; i < 10; ++i) {
            model.setAccount_id(Integer.parseInt(this.faker.address().buildingNumber()));
            model.setAmount(Integer.parseInt(this.faker.address().buildingNumber()));
            model.setOperation_account_id(1);
            model.setType(3);
            model.setComment(this.faker.commerce().department());
            model.setCreated_at(dateNow());

            model.save();
        }

        this.db.insert(model);
       // this.db.delete(model, 3364);
        this.db.closeConnect();
    }




}