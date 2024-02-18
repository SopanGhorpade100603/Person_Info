import java.sql.*;
import java.text.*;
public class ShowData {
    public static void main(String[] args) {
        try{
            Connection con =ConnectionProvider.getConnection();
            String query;
            query="SELECT * FROM person_information";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
            while (rs.next()){
                int id=rs.getInt(1);
                String Name=rs.getString(2);
                int Age=rs.getInt(3);
                int Mnumber=rs.getInt(4);
                String Address =rs.getString(5);

                java.sql.Date sDate=rs.getDate(6);
                String date=sdf.format(sDate);

                Double Height=rs.getDouble(7);
                int Weight=rs.getInt(8);
                String Smoke=rs.getString(9);
                String Drink=rs.getString(10);

                System.out.println(id+" "+Name+" "+Age+" "+" "+Mnumber+" "+" "+Address+" "+
                        " "+date+" "+Height+" "+Weight+" "+Smoke+" "+Drink);
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
