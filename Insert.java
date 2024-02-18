import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Insert {
    public static void main(String[] args) {
        try{
            Connection con=ConnectionProvider.getConnection();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String query;
            query="INSERT INTO person_Information(Id,Name,Age,Mnumber,Address,DOB,Height,Weight,Smoking,Drinking)VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            while(true){
                System.out.println("Enter your id");
                int id=Integer.parseInt(br.readLine());

                System.out.println("Enter your Name");
                String Name=br.readLine();

                System.out.println("Enter your age");
                int age=Integer.parseInt(br.readLine());

                System.out.println("Enter your mobile number");
                int MNumber=Integer.parseInt(br.readLine());

                System.out.println("Enter your Address");
                String Address=br.readLine();

                System.out.println("Enter your DOB [dd-MM-yyyy]");
                String dob=br.readLine();
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date udate=sdf.parse(dob);
                long l=udate.getTime();
                java.sql.Date sdate=new java.sql.Date(l);

                System.out.println("Enter your Height");
                Double Height=Double.parseDouble(br.readLine());

                System.out.println("Enter your Weight");
                int Weight=Integer.parseInt(br.readLine());

                System.out.println("Do you Smoking[Yes/No]");
                String Smoke=br.readLine();

                System.out.println("Do you Drinking[Yes/No]");
                String Drink=br.readLine();

                pst.setInt(1,id);
                pst.setString(2,Name);
                pst.setInt(3,age);
                pst.setInt(4,MNumber);
                pst.setString(5,Address);
                pst.setDate(6,sdate);
                pst.setDouble(7,Height);
                pst.setInt(8,Weight);
                pst.setString(9,Smoke);
                pst.setString(10,Drink);

                pst.executeUpdate();
                System.out.println("Data Inserted");

                System.out.println("in you want to more data Inserted[Yes/No]");
                String option= br.readLine();

                if(option.equalsIgnoreCase("No")){
                    System.out.println("All Data Inserted Successfully");
                    break;
                }
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
