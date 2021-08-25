
package hospital.dbutil;

  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;
  import javax.swing.JOptionPane;

    public class DBConnection {
       private static Connection conn;                     
     static{
                  //static block is used here so that it run only one time;
         try{
             Class.forName("oracle.jdbc.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-R50592F:1521/xe","sca","sca");
            JOptionPane.showMessageDialog(null,"Connection done successfully!");
            }
            catch(ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(null,"Cannot load the driver"+cnfe);
            cnfe.printStackTrace();
             }
            catch(SQLException sqlex)
                 {
            JOptionPane.showMessageDialog(null,"problem in db"+sqlex);
            sqlex.printStackTrace();
        }
    }
    public static Connection getConnection(){             //run whenever DBconnection.getConnection is called first tym
     return conn; 
    }                                                       //because connection is static thatwhy use static  here.
     public static void closeConnection(){
      try{
          if(conn!=null){
             conn.close();
               JOptionPane.showMessageDialog(null,"Connection done successfully!");
          }
          }
      
      catch(SQLException sqlex)
        {
            JOptionPane.showMessageDialog(null,"problem in closing connection!"+sqlex);
            sqlex.printStackTrace();
    
      }
     }
}
      
    
    
    

