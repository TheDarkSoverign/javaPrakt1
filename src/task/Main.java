package task;

import java.sql.*;
import java.util.Scanner;

public class Main {
    protected Scanner sc = new Scanner(System.in);
    protected static Connection con;
    protected static Statement st;
    protected static ResultSet rs;

    static String Url = "jdbc:postgresql://localhost:5432/postgres";

    static {
        try {
            con = DriverManager.getConnection(Url, "postgres", "postgres");
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных: "+ e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}

class Task extends Main{
    protected static String tableName;


    public void task1(){

    }

    public void task2(){

    }

    public void task3(){

    }

    public void task4(){

    }

    public void task5(){

    }

    public void task6(){

    }

    public void task7(){

    }

    public void task8(){

    }

    public void task9(){

    }

    public void task10(){

    }
}