package core.seeds;

import lombok.Data;

import java.util.HashMap;


@Data
public class AccountModel extends Model {

    public String getTable() {
        return "accounts.account";
    }

//    private Integer user_id;
//    private Integer verify_api_id; //
    private String email;
//    private String new_email;
    private String phone;
//    private String new_phone;
    private String password;
    private Integer status;
//    private Integer is_online;
//    private Integer remember_token;//
//    private Integer token;//
//    private String register_token;
//    private Integer description; //
    private String name;
    private String surname;
    private String patronymic;
//    private String name_latin;
//    private String surname_latin;
//    private Integer gender;
    private Integer country_id;
    private Integer city_id;
    private Integer language_id;
    private Integer nationality_id;
//    private Integer birth_date;
    private Integer time_zone_id;
//    private String city;
//    private String address;
//    private String state;
//    private String zip_code;
//    private String referrer_page;
    private Integer is_verify_document;
    private Integer is_email_verify;
    private Integer is_phone_verify;
    private Integer is_replenished;
    private Integer is_signed_with_platform;
//    private String email_verified_at;
//    private String phone_verified_at;
//    private String document_verified_at;
//    private String replenished_at;
//    private Integer is_politically_person;
//    private String additional_info;
//    private String registration_language;
//    private String last_contact_at;
//    private String last_online_at;
//    private String created_at;
//    private String updated_at;
//    private String send_document_at;

    public void save() {
        HashMap<String, Object> value = new HashMap<>();

//        value.put("user_id", user_id);
//        value.put("verify_api_id", verify_api_id);
        value.put("email", email);
//        value.put("new_email", new_email);
        value.put("phone", phone);
//        value.put("new_phone", new_phone);
        value.put("password", password);
        value.put("status", status);
//        value.put("is_online", is_online);
//        value.put("remember_token", remember_token);
//        value.put("token", token);
//        value.put("register_token", register_token);
//        value.put("description", description);
        value.put("name", name);
        value.put("surname", surname);
        value.put("patronymic", patronymic);
//        value.put("name_latin	", name_latin);
//        value.put("surname_latin", surname_latin);
//        value.put("gender", gender);
        value.put("country_id", country_id);
        value.put("city_id", city_id);
        value.put("language_id", language_id);
        value.put("nationality_id", nationality_id);
//        value.put("birth_date", birth_date);
        value.put("time_zone_id	", time_zone_id);
//        value.put("city", city);
//        value.put("address", address);
//        value.put("state", state);
//        value.put("zip_code", zip_code);
//        value.put("referrer_page", referrer_page);
        value.put("is_verify_document", is_verify_document);
        value.put("is_email_verify", is_email_verify);
        value.put("is_phone_verify	", is_phone_verify);
        value.put("is_replenished", is_replenished);
        value.put("is_signed_with_platform", is_signed_with_platform);
//        value.put("email_verified_at", email_verified_at);
//        value.put("phone_verified_at", phone_verified_at);
//        value.put("document_verified_at", document_verified_at);
//        value.put("replenished_at", replenished_at);
//        value.put("is_politically_person", is_politically_person);
//        value.put("additional_info", additional_info);
//        value.put("registration_language", registration_language);
//        value.put("last_contact_at", last_contact_at);
//        value.put("last_online_at", last_online_at);
//        value.put("created_at", created_at);
//        value.put("updated_at", updated_at);
//        value.put("send_document_at", send_document_at);

        arrayData.add(value);
    }
}
