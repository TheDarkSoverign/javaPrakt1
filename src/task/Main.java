package task;

import java.sql.*;
import java.util.Scanner;

public class Main {
    protected static Scanner sc = new Scanner(System.in);
    protected static Connection con;

    static String Url = "jdbc:postgresql://localhost:5432/postgres";

    static {
        try {
            con = DriverManager.getConnection(Url, "postgres", "postgres");
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных: "+ e.getMessage());
        }
    }
    protected static void menu() {
        int x = 0;
        String s = "";
        Task tasks = new Task();
        while (!"0".equals(s)) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Вывести все таблицы.");
            System.out.println("2. Создать таблицу.");
            System.out.println("0. Выход");
            s = sc.next();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода");
            }
            switch (x) {
                case 1 -> tasks.task1();
                case 2 -> tasks.task2();
                //case 3 -> tasks.task3();
                //...
            }
            x = 0;
        }
        System.out.println("Пока!");
    }

    public static void main(String[] args) {
        System.out.println("Подключились к БД. ");
        menu();
    }
}

class Task extends Main{
    static String table;

    public void task1(){
        String query = "SELECT table_name AS Названия_таблиц FROM information_schema.tables WHERE table_schema = 'public'";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            try {
                System.out.println("Список таблиц:");
                while (rs.next()) {
                    String tableName = rs.getString("Названия_таблиц");
                    System.out.println(tableName);
                }
            } catch (SQLException e) {
                System.out.println("Не удалось вывести результат, " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Не удалось выполнить запрос, " + e.getMessage());
        }
    }

    public void task2(){
        System.out.print("Введите название таблицы: ");
        table = sc.next();
        String query = "CREATE TABLE IF NOT EXISTS '" + table + "' (id SERIAL, sum FLOAT, sub FLOAT, mult FLOAT, div FLOAT, module_div FLOAT, abs FLOAT, pow FLOAT)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("Таблица " + table + " успешно создана");
        } catch (SQLException e) {
            System.out.println("Не удалось выполнить запрос, " + e.getMessage());
        }
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