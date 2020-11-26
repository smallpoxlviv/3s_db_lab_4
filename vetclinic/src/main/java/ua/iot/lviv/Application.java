package ua.iot.lviv;

import ua.iot.lviv.view.MyView;

public class Application {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            new MyView().show();
        } catch (ClassNotFoundException ex) {
            System.out.println("MySql Driver is not loaded");
        }
    }
}