package org.example;

public interface IAirport {
    int getBizId();
    String getBizName();
    String getAddress();
    String getCity();

    void setBizId(int bizId);
    void setBizName(String bizName);
    void setAddress(String address);
    void setCity(String city);
}
