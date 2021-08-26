package core.seeds;



public class AccountSeeder extends BaseSeeder {

    AccountModel model = new AccountModel();

    public void createTable() {

          model.setEmail(this.faker.internet().emailAddress());
          model.setPhone(this.faker.phoneNumber().phoneNumber());
          model.setPassword(this.faker.internet().password());
          model.setCity_id(1);
          model.setCountry_id(1);
          model.setLanguage_id(1);
          model.setNationality_id(1);
          model.setTime_zone_id(1);
          model.setIs_email_verify(1);
          model.setIs_phone_verify(1);
          model.setIs_replenished(1);
          model.setIs_signed_with_platform(1);
          model.setIs_verify_document(1);
          model.setName("test");
          model.setSurname("test");
          model.setStatus(1);
          model.save();
          db.insert(model);
          db.closeConnect();
    }

    public void deleteTable(){
        this.db.delete(model, 1);
    }

    public String getEmail(){
        return model.getEmail();
    }

    public String getPass(){
        return model.getPassword();
    }



}
