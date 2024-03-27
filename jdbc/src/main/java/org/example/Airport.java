package org.example;

public class Airport implements IAirport {
    private int bizId;
    private String bizName;
    private String address;
    private String city;

    // skirtas esamo įrašo duomenų bazėje redagavimui ir paieškai (nes šiems veiksmams reikia ID(bizId)).
    public Airport(int bizId, String bizName, String address, String city){
        this.bizId = bizId;
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

    public Airport(){}

    // skirtas naujo įrašo kūrimui duomenų bazėje.
    // ID nereikia, nes jį priskiria pati DB (auto increment).
    public Airport(String bizName, String address, String city){
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

    public int getBizId() { return bizId; }
    public String getBizName() { return bizName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public void setBizId(int bizId) {
        this.bizId = bizId;
    }
    public void setBizName(String bizName) {
        this.bizName = bizName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "bizId=" + bizId +
                ", bizName='" + bizName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

