/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MirzaUY
 */
public class TravelokeModel {
    Connection conection;
    public String jeneng;
    public int bal,iduser;
    public TravelokeModel(){
    conection = koneksi.konektor();
    if(conection == null) System.exit(1);
    }
    
    public boolean isDBConnected(){
    try{
        return !conection.isClosed();
    }catch(SQLException e){
    e.printStackTrace();
    return false;
    }
    }

    
    public boolean isLogin(String name,String pass) throws SQLException{
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    String query = "select * from tb_user where username = ? and password = ?";
    try{
    preparedStatement = conection.prepareStatement(query);
    preparedStatement.setString(1,name);
    preparedStatement.setString(2,pass);
    resultSet = preparedStatement.executeQuery();
    jeneng = resultSet.getString("nm_usr");
    bal = resultSet.getInt("balance");
    iduser = resultSet.getInt("id_user");
    if(resultSet.next()){
    return true;
    }else{
    return false;
    }
    }catch(Exception e){
    return false;
    } finally {
        if( resultSet!= null){
             try{
                  resultSet.close();
             } catch(Exception e){
                 e.printStackTrace();
             }
        }
        if( preparedStatement!= null){
             try{
                  preparedStatement.close();
             } catch(Exception e){
                 e.printStackTrace();
             }
        }
    }
}
    
    public void isSignUp(String nm_usr,String username,String password,String gender,String alamat){
  
    String query = "INSERT INTO tb_user (id_user,nm_usr,username,password,gender,alamat) VALUES (?,?,?,?,?,?)";
    try (
          PreparedStatement pstmt = conection.prepareStatement(query)) {
            pstmt.setString(2, nm_usr);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.setString(5, gender);
            pstmt.setString(6, alamat);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
           
        }
    }
    
    public void insertFlight(int fid_user,String fcontname,String fnumbphone,String femail,String ftitle,String fnmpass,String fdob,String fnational,String fbaggage,String fdatebook,String fairline,String ftarrive,String ftdepart,String fkarrive,String fkdepart,String fduration,String ftotal,String fsaldo){
      
        String query = "INSERT INTO tb_flight (id_flight,id_user,contname,numbphone,email,title,nmpass,dob,national,baggage,datebook,airline,tarrive,tdepart,karrive,kdepart,duration,total,saldo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try (PreparedStatement  pstmt = conection.prepareStatement(query)) {
            
            pstmt.setInt(2, fid_user);
            pstmt.setString(3, fcontname);
            pstmt.setString(4, fnumbphone);
            pstmt.setString(5, femail);
            pstmt.setString(6, ftitle);
            pstmt.setString(7, fnmpass);
            pstmt.setString(8, fdob);
            pstmt.setString(9, fnational);
            pstmt.setString(10, fbaggage);
            pstmt.setString(11, fdatebook);
            pstmt.setString(12, fairline);
            pstmt.setString(13, ftarrive);
            pstmt.setString(14, ftdepart);
            pstmt.setString(15, fkarrive);
            pstmt.setString(16, fkdepart);
            pstmt.setString(17, fduration);
            pstmt.setString(18, ftotal);
            pstmt.setString(19, fsaldo);
            pstmt.executeUpdate();
            pstmt.close();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertHotel(int hid_user,String hcontname,String hnumbphone,String hemail,String hguestnm,String hhotelnm,String hhotelloc,String hcheckin,String hcheckout,String hroom,String hguest,String htotal,String hsaldo){
      String query = "INSERT INTO tb_hotel (id_hotel,id_user,contname,numbphone,email,guestname,hotelnm,hotelloc,checkin,checkout,room,guest,total,saldo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try (
          PreparedStatement pstmt = conection.prepareStatement(query)) {      
            pstmt.setInt(2, hid_user);
            pstmt.setString(3, hcontname);
            pstmt.setString(4, hnumbphone);
            pstmt.setString(5, hemail);
            pstmt.setString(6, hguestnm);
            pstmt.setString(7, hhotelnm);
            pstmt.setString(8, hhotelloc);
            pstmt.setString(9, hcheckin);
            pstmt.setString(10, hcheckout);
            pstmt.setString(11, hroom);
            pstmt.setString(12, hguest);
            pstmt.setString(13, htotal);
            pstmt.setString(14, hsaldo);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
           
        }
    
    
    }
    
    public void insertTrain(int tid_user,String tcontname,String tnumbphone,String temail,String ttitle,String tnmpass,String tIDtype,String tIDnumb,String tdeparture,String ttrainnm,String ttrclass,String ttarrive,String ttdepart,String tkarrive,String tkdepart,String tduration,String ttotal,String tsaldo){
      
        String query = "INSERT INTO tb_train (id_train,id_user,contname,numbphone,email,title,nmpass,IDtype,IDnumb,departure,trainnm,trclass,tarrive,tdepart,karrive,kdepart,duration,total,saldo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try (PreparedStatement  pstmt = conection.prepareStatement(query)) {
            
            pstmt.setInt(2, tid_user);
            pstmt.setString(3, tcontname);
            pstmt.setString(4, tnumbphone);
            pstmt.setString(5, temail);
            pstmt.setString(6, ttitle);
            pstmt.setString(7, tnmpass);
            pstmt.setString(8, tIDtype);
            pstmt.setString(9, tIDnumb);
            pstmt.setString(10, tdeparture);
            pstmt.setString(11, ttrainnm);
            pstmt.setString(12, ttrclass);
            pstmt.setString(13, ttarrive);
            pstmt.setString(14, ttdepart);
            pstmt.setString(15, tkarrive);
            pstmt.setString(16, tkdepart);
            pstmt.setString(17, tduration);
            pstmt.setString(18, ttotal);
            pstmt.setString(19, tsaldo);
            pstmt.executeUpdate();
            pstmt.close();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
}
