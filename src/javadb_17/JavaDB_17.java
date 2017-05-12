/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb_17;

import java.sql.*;

/**
 *
 * @author rober
 */
public class JavaDB_17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        // load sqlite drive
        Class.forName("org.sqlite.JDBC");
        
        // create connection to database and create database
        Connection con = DriverManager.getConnection("jdbc:sqlite:veaDatabase.db");
        
        // create statement
        Statement st = con.createStatement();
        
        // create SQL query
        String sqlForDrop = "DROP TABLE IF EXISTS Student;";
        String sqlForCreate = "CREATE TABLE Student (StudentID Integer NOT NULL PRIMARY KEY AUTOINCREMENT, FirstName varchar(255) NOT NULL, LastName varchar(255) NOT NULL, Age int ) ;";
       
        // execute SQL query
        st.executeUpdate(sqlForDrop);
        st.executeUpdate(sqlForCreate);
        
        String sqlForInsert1 = "INSERT INTO Student ( FirstName, LastName, Age) VALUES ( 'Roberts', 'Staskevics', 22 );";
        st.execute(sqlForInsert1);
        String sqlForInsert2 = "INSERT INTO Student ( FirstName, LastName, Age) VALUES ( 'Janis', 'Berzins', 20 );";
        st.execute(sqlForInsert2);
        String sqlForInsert3 = "INSERT INTO Student ( FirstName, LastName, Age) VALUES ( 'Arturs', 'Kristaps', 18 );";
        st.execute(sqlForInsert3);
        String sqlForInsert4 = "INSERT INTO Student ( FirstName, LastName, Age) VALUES ( 'Olgerts', 'Zalitits', 18 );";
        st.execute(sqlForInsert4);
        
        String sqlForSelect = "SELECT * FROM Student;";
        ResultSet result = st.executeQuery(sqlForSelect);
        
        // get variables and print out
        while(result.next())
        {
            int _id = result.getInt("StudentID");
            String _firstname = result.getString("FirstName");
            String _lastname = result.getString("LastName");
            int _age = result.getInt("Age");
            
            System.out.println(_id + " " + _firstname + " " + _lastname + " " + _age);
        }
        
    }
    
}
