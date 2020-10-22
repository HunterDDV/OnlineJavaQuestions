
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Denzil Vorster
 * @version 1.0, May 9, 2018
 */
public class TestVetting {

    private int rows = 0;
    private int[][] arRates;
    private String teachName;
    Connection connection;
    
    public TestVetting() {
        dbConnection();
        insertToDatabase();
        show();
    }

    private void dbConnection() {
        try {
            //I had someone explain to me the steps to create and link to a db but could not get it to function propperly before i ran out of time
            connection = DriverManager.getConnection("jdbc:ucanaccess://AssessmentTable.accdb");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertToDatabase() {
        int[][] arRates = enterRates();
        
        String sqlDeleteCommand = "DELETE * FROM lecturer";
        String sqlInsertCommand;
        
        try {
            Statement state = connection.createStatement();
            state.executeUpdate(sqlDeleteCommand);
            
            for (int i = 0; i < arRates.length; i++) {
                sqlInsertCommand = "INSERT INTO lecturer (student, assessment1, assessment2, assessment3, assessment4, assessment5) " + "VALUES (" + (i + 1) + "," + arRates[i][0] + "," + arRates[i][1] + "," + arRates[i][2] + "," + arRates[i][3] + "," + arRates[i][4] + ")";
                state.executeUpdate(sqlInsertCommand);
            }
            
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TestVetting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void show() {        
        Vetting vetting = new Vetting(teachName, arRates);
        
        vetting.processRates();
        dbConnection();
        ResultSet result;
        
        try {
            Statement state = connection.createStatement();
            result = state.executeQuery("SELECT * FROM lecturer");
            ResultSetMetaData resultMeta = result.getMetaData();
            int columnAmount = resultMeta.getColumnCount();
            
            System.out.println("Student        " + "Assessment1    " + "Assessment2    " + "Assessment3    " + "Assessment4    " + "Assessment5");
            
            while (result.next()) {
                for (int i = 1; i <= columnAmount; i++) {
                    System.out.print(result.getString(i) + "              ");
                }
                
                System.out.println();
            }
            
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TestVetting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int[][] enterRates() {
        boolean valid = false;
        int score = 0;
        
        teachName = JOptionPane.showInputDialog("What is the teacher's name?");
        
        while (valid == false) {
            rows = Integer.parseInt(JOptionPane.showInputDialog("How many students will be part of this survey?"));
            
            if (rows <= 0) {
                valid = false;
                JOptionPane.showMessageDialog(null, "There must be at least 1 student participationg.");
            } else {
                valid = true;
            }
        }
        
        
        arRates = new int[rows][5];

        for (int i = 0; i < arRates.length; i++) {
            
            for (int j = 0; j < arRates[i].length; j++) {
                boolean validRate = false;
                
                while (validRate == false) {
                    score = Integer.parseInt(JOptionPane.showInputDialog("What was student " + (i + 1) + "'s score for assignment " + (j + 1) + "?"));
                    
                    if (score < 0 || score > 10) {
                        validRate = false;
                        JOptionPane.showMessageDialog(null, "The student can only score between 0 and 10, Please try again.");
                        
                    } else {
                        validRate = true;
                    }
                }

                arRates[i][j] = score;
            }
        }

        return arRates;
    }
    
    
    
        public static void main(String[] args) {
        new TestVetting();
    }
}
