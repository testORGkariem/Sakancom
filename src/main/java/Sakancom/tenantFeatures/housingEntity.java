package Sakancom.tenantFeatures;


import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class housingEntity {
    String Picture, Price, Location, Services, Available, Owner, Tenant, ID;
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    public int showAvailable() {
        int counter = 1;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = new String();
            query = "Select * from housing where available='Yes' and accept='true'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(counter + "-");
                System.out.println("ID : " + resultSet.getString(8));
                System.out.println("Picture : " + resultSet.getString(1));
                System.out.println("Price : " + resultSet.getString(2));
                System.out.println("Location : " + resultSet.getString(3));
                System.out.println("Services : " + resultSet.getString(4));
                System.out.println("Number of people lived in : " + resultSet.getString(11));
                System.out.println("Floor Number: " + resultSet.getString(9));
                System.out.println("Department Name : " + resultSet.getString(10));
                counter++;
                System.out.println("_____________________________________________");

            }
        } catch (Exception e) {
            return counter;
        }
        return counter;
    }

    public boolean availableWithID(String id){
        int counter = 1;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the MySQL database!");
            Statement statement = connection.createStatement();
            String query = new String();
            query = "Select * from housing where id='"+id+"'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                counter++;
            }}
        catch (Exception E){
            return false;
        }
        if(counter>1){
            return true;
        }return false;

    }

    public boolean booking(String id,String userName){
        int flag1=0;
        try {
            Integer.parseInt(id);
            flag1 = 1;
        } catch (Exception ex) {
            flag1 = 0;
        }
        if (flag1 == 1 && id.isEmpty() == false) {
            int flagg = 0;
            int counter = 1;
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connected to the MySQL database!");
                Statement statement = connection.createStatement();
                Statement statement1 = connection.createStatement();
                String query = new String();
                query="select * from housing where id='" + id + "'";
                ResultSet res=statement.executeQuery(query);

                while(res.next()){
                    int num=      Integer.parseInt(res.getString(11));

                    if(num<4){
                        num++;
                        String n=Integer.toString(num);
                        if(num==4){
                            query="update housing set peopleNum='"+n+"',available='No',tenant='"+userName+"' where id='"+id+"'";
                            statement1.executeUpdate(query);

                        }else{
                            query="update housing set peopleNum='"+n+"',tenant='"+userName+"' where id='"+id+"'";
                            statement1.executeUpdate(query);
                        }
                        query="insert into booking (tenantUserName,houseID,Owner) value ('"+userName+"','"+id+"','"+res.getString(6)+"')";

                        statement1.executeUpdate(query);

                    }
                    else{
                        query = "update housing set available='No',peopleNum='+"+num+"',tenant='"+userName+"' where id='" + id + "'";
                        statement1.executeUpdate(query);
                    }

                }


                System.out.println("done");
                if (availableWithID(id)) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;

            }
        }
        else{

            return false;
        }
    }

}