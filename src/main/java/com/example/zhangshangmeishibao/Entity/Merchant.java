package com.example.zhangshangmeishibao.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    private String Merchant_id;
    private String Merchant_password;
    private String Merchant_phone;

    public String getMerchant_id() {
        return Merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        Merchant_id = merchant_id;
    }

    public String getMerchant_password() {
        return Merchant_password;
    }

    public void setMerchant_password(String merchant_password) {
        Merchant_password = merchant_password;
    }

    public String getMerchant_phone() {
        return Merchant_phone;
    }

    public void setMerchant_phone(String merchant_phone) {
        Merchant_phone = merchant_phone;
    }
}
