/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.ToggleGroup;
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
public class SignupViewController implements Initializable {
 public TravelokeModel signupmodel = new TravelokeModel();
    @FXML
    private JFXTextField uname;
    @FXML
    private JFXTextField urname;
    @FXML
    private JFXRadioButton male;
    @FXML
    private ToggleGroup gender;
    @FXML
    private JFXRadioButton female;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXTextField uraddress;
    @FXML
    private JFXCheckBox checkbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AksiRegister(ActionEvent event) {
        String nm,usrnm,pw,gender,add;
        nm = urname.getText();
        usrnm = uname.getText();
        pw = pass.getText();
        add = uraddress.getText();
        if (male.isSelected()){
        gender = "Male";
        }else{
        gender = "Female";
        }
        if (checkbox.isSelected() == true){
              try{
        if(!nm.isEmpty() && !usrnm.isEmpty() && !pw.isEmpty() && !gender.isEmpty()){
            signupmodel.isSignUp(nm,usrnm,pw,gender,add);
            JOptionPane.showMessageDialog(null, "Success !! "); 
            ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxml = new FXMLLoader(getClass().getResource("LoginView.fxml"));
                Parent root = (Parent)fxml.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("Login");
                stage.show();
            
        }else{
          JOptionPane.showMessageDialog(null, "You Must Fill Out The Blank ! "); 
        }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "SIGN UP FAILED "); 
        }
        }else{
        JOptionPane.showMessageDialog(null, "You Must Agree with Our License and Agreement "); 
        }
    }
       @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void toLogin(ActionEvent event) throws IOException {
        
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxml = new FXMLLoader(getClass().getResource("LoginView.fxml"));
                Parent root = (Parent)fxml.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("Login");
                stage.show();
    }
    
}
