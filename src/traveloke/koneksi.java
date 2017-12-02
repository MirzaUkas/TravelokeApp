/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author MirzaUY
 */
public class koneksi {
    public static Connection konektor(){
        try{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:travelokeDB.sqlite");
        return conn;
        }catch(Exception e){
            System.out.println(e);
        return null;
        }
    }
}
