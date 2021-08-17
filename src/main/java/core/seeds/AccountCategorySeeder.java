package core.seeds;

public class AccountCategorySeeder extends BaseSeeder {
    public void run() {
        AccountCategoryModel model = new AccountCategoryModel();

        for (int i = 0;i < 1; i++) {
            model.setAccount_id(Integer.parseInt(faker.address().buildingNumber()));
            model.setCategory(Integer.parseInt(faker.address().buildingNumber()));
            model.setStatus(Integer.parseInt(faker.address().buildingNumber()));
            model.setUser_id(Integer.parseInt(faker.address().buildingNumber()));
            model.save();
        }

        db.insert(model);

        db.closeConnect();
    }
}
