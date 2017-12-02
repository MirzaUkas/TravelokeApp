/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import traveloke.TravelokeModel;

/**
 * FXML Controller class
 *
 * @author MirzaUY
 */
public class BookTrainViewController implements Initializable {
    TravelokeModel BookTrain = new TravelokeModel();
    @FXML
    private JFXTextField fxcontactnm;
    @FXML
    private JFXTextField fxnumber;
    @FXML
    private JFXTextField fxemail;
    @FXML
    private Label tgltrain;
    @FXML
    private Label iddepart;
    @FXML
    private Label idarrive;
    @FXML
    private Label iddeparts;
    @FXML
    private Label idarrives;
    @FXML
    private Label idtrain;
    @FXML
    private Label idduration;
    @FXML
    private JFXComboBox<String> idtitle;
    @FXML
    private JFXTextField idpassenger;
    @FXML
    private JFXComboBox<String> idtype;
    @FXML
    private JFXTextField idnumber;
    @FXML
    private JFXCheckBox ckassurance;
    @FXML
    private Label idharga;
    @FXML
    private Label itrainame;
    @FXML
    private Label idinsurance;
    @FXML
    private Label idtotal;
    @FXML
    private Label idsaldo;
    @FXML
    private JFXButton Bayar;
    @FXML
    private Label idkls;

    /**
     * Initializes the controller class.
     */
    
    String Arrivet, Departt, Arrivek, Departk,durationk, nmkak, nmklsk, urname,DateNowk,numbphone,email,title,passnm,IDtype,IDnumb;
    int balance,idusr,totalfix,status;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idtitle.setStyle("-fx-font-size:16px;");
        idtype.setStyle("-fx-font-size:16px;");
        idtitle.getItems().add("Mr.");
        idtitle.getItems().add("Mrs.");
        idtitle.getItems().add("Ms");
        idtype.getItems().add("ID Card/KTP");
        idtype.getItems().add("Driving License/SIM");
        idtype.getItems().add("Passport");
        idtype.getItems().add("Others");
    }    

    @FXML
    private void AksiAssurance(ActionEvent event) {
        if(ckassurance.isSelected() == true){
        idinsurance.setText("500000");totalfix+=500000;idtotal.setText(totalfix+"");status = 2;
        }else{
        idinsurance.setText("0");totalfix-=500000;idtotal.setText(totalfix+"");status = 3;
        }
    }
    
    public void setDataTrain(String wArrive,String wDepart,String sArrive,String sDepart,String duration,String nmka,String nmkls,String txtNama,String DateNow,int saldo, int price,int id_user){
    fxcontactnm.setText(txtNama);
    idarrive.setText(wArrive);iddepart.setText(wDepart);
    idarrives.setText(sArrive);iddeparts.setText(sDepart);
    idduration.setText(duration);itrainame.setText(nmka);idtrain.setText(nmka);
    idkls.setText(nmkls);tgltrain.setText(DateNow);idharga.setText(price+"");
    idsaldo.setText(saldo+"");totalfix+=price;idtotal.setText(totalfix+"");
    Arrivet=wArrive;
    Departt=wDepart;
    Arrivek=sArrive;
    Departk=sDepart;
    durationk=duration;
    nmkak = nmka;
    nmklsk =nmkls;
    DateNowk = DateNow;
    balance = saldo;
    idusr = id_user;
    urname = txtNama;
    }
    @FXML
    private void AksiBayar(ActionEvent event) throws IOException {
       email = fxemail.getText();
       numbphone = fxnumber.getText();
       title = idtitle.getValue();
       passnm = idpassenger.getText();
       IDtype = idtype.getValue();
       IDnumb = idnumber.getText();
       int idt = 1,selector = 2;
       String fixnama = title +" "+passnm;
        if( totalfix< balance){
        int hasil = balance - totalfix;
        BookTrain.insertTrain(idusr,urname,numbphone,email,title,passnm,IDtype,IDnumb,DateNowk,nmkak,nmklsk,Arrivet,Departt,Arrivek,Departk,durationk,totalfix+"",balance+"");
        JOptionPane.showMessageDialog(null," Payment Success,\n your Balance Now Rp. "+hasil);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader reportTrain = new FXMLLoader(getClass().getResource("ReportView.fxml"));
        Parent root = (Parent)reportTrain.load();
        ReportViewController ReportDataT = (ReportViewController)reportTrain.getController();
        ReportDataT.setReportTrain(idt,fixnama,IDtype,IDnumb,status,nmkak,nmklsk,DateNowk, Arrivet, Departt, Arrivek, Departk,selector);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        }else if (totalfix> balance){
        Bayar.setText("Not Enough Money");
        Bayar.setStyle("-fx-background-color:red;");
    }
    
}
}
