package com.bee.passenger.model;



public class User {
    public String DriverType;
    public String name;
    public String email;
    public String avata;
    public String phone;
    public Status status;
    public Message message;


    public User(){
        status = new Status();
        message = new Message();
        status.isOnline = false;
        status.timestamp = 0;
        message.idReceiver = "0";
        message.idSender = "0";
        message.text = "";
        message.timestamp = 0;
    }
}
