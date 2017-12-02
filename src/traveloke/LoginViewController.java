/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import traveloke.TravelokeModel;

/**
 * FXML Controller class
 *
 * @author MirzaUY
 */
public class LoginViewController implements Initializable {
    public TravelokeModel loginmodel = new TravelokeModel();
    @FXML
    private JFXTextField txtusername;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton signup;
    @FXML
    private JFXPasswordField txtpassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(loginmodel.isDBConnected()){
        System.out.println("Connected !");
        }else{
        System.out.println("Not Connected !");
        }
    }    

    @FXML
    private void AksiLogin(ActionEvent event) {
         String usrnm,pw;
        usrnm = txtusername.getText();
        pw = txtpassword.getText();
        try{
        if(loginmodel.isLogin(usrnm,pw)){
            String urname = loginmodel.jeneng;
            int urbal = loginmodel.bal;
            int iduser = loginmodel.iduser;
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("MenuView.fxml"));
            Parent root = (Parent)fxml.load();
            MenuViewController dashController = (MenuViewController)fxml.getController();
            dashController.setDataLogin(urname,urbal,iduser);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Dashboard");
            stage.show();
            
        }else{
            JOptionPane.showMessageDialog(null, " Not Correct ! "); 
        }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, " Failed ! "); 
        }
    }

    @FXML
    private void AksiSignup(ActionEvent event) throws IOException {
         ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxml = new FXMLLoader(getClass().getResource("SignupView.fxml"));
                Parent root = (Parent)fxml.load();
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("Sign Up");
            stage.show();
    }
    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    
}
