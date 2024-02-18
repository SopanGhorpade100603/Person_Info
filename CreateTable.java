import java.sql.*;
public class CreateTable {
    public static void main(String[] args) {
        try{
            Connection con =ConnectionProvider.getConnection();
            String query;
            query="CREATE TABLE person_information(Id INT,Name VARCHAR(200),Age INT,Mnumber INT,Address VARCHAR(200),DOB DATE,Height DOUBLE,Weight INT,Smoking VARCHAR(20),Drinking VARCHAR(20),Images LONGBLOB)";

            Statement st=con.createStatement();
            st.executeUpdate(query);
            System.out.println("Table Created Successfully");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
