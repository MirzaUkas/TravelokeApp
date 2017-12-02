/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import traveloke.TravelokeModel;


/**
 * FXML Controller class
 *
 * @author MirzaUY
 */
public class BookFlightViewController implements Initializable {
    TravelokeModel booking = new TravelokeModel();
    @FXML
    private JFXTextField fxcontactnm;

    @FXML
    private JFXTextField fxnumber;

    @FXML
    private JFXTextField fxemail;

    @FXML
    private JFXComboBox<String> idtitle;

    @FXML
    private JFXTextField idpassenger;

    @FXML
    private JFXComboBox<String> idnational;

    @FXML
    private Label idbaggage;

    @FXML
    private JFXDatePicker iddate;

    @FXML
    private JFXButton fxcontinue;

    @FXML
    private Label airline;

    @FXML
    private Label idqty;

    @FXML
    private Label idharga;

    @FXML
    private Label idassurance;

    @FXML
    private Label idtotal;
     @FXML
    private JFXComboBox<String> idbagga;

    @FXML
    private Label idhari;

    @FXML
    private Label iddepart;

    @FXML
    private Label idarrive;

    @FXML
    private Label iddepartkota;

    @FXML
    private Label idarrivekota;

    @FXML
    private Label idairline;

    @FXML
    private JFXCheckBox ckassurance;

    @FXML
    private Label idduration;
    
    @FXML
    private Label idsaldo;
      
    @FXML
    private JFXButton Bayar;
    
    @FXML
    private ImageView airasia;

    @FXML
    private ImageView citilink;

    @FXML
    private ImageView garuda;

    
    /**
     * Initializes the controller class.
     */
    String ContName,NumPhone,Email,Title,PassName,National,dob,baggage,btDepart,bkDepart,btArrive,
            bkArrive,bdurasi,bAirline, bdatebook ;
    int TotalFix,FlightHarga,quantity,harga,asuransi,bagasi,balance,idusr,status,selector;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idtitle.setStyle("-fx-font-size:16px;");
        idnational.setStyle("-fx-font-size:16px;");
        idbagga.setStyle("-fx-font-size:16px;");
        iddate.setStyle("-fx-font-size:16px;");
        idtitle.getItems().add("Mr.");
        idtitle.getItems().add("Mrs.");
        idtitle.getItems().add("Ms");
        idnational.getItems().add("Brazil");
        idnational.getItems().add("United States");
        idnational.getItems().add("Malaysia");
        idnational.getItems().add("Singapore");
        idnational.getItems().add("Indonesia");
        idnational.getItems().add("Thailand");
        idbagga.getItems().add("15 kg - Rp 0");
        idbagga.getItems().add("20 kg - Rp 90.000");
        idbagga.getItems().add("25 kg - Rp 100.000");
         garuda.setVisible(false);
         airasia.setVisible(false);
         citilink.setVisible(false);
    }
    public void setData(String tArrive,String tDepart,String kArrive,String kDepart,String durasi,String txtAirline,String txNama,int total,String txtDate,int saldo,int id_user){
        btDepart = tDepart;bkDepart = kDepart;btArrive = tArrive;bkArrive = kArrive;
        bdurasi = durasi;bAirline = txtAirline;bdatebook = txtDate;        
        fxcontactnm.setText(txNama);
        idhari.setText(txtDate);
        idairline.setText(txtAirline);
        airline.setText(txtAirline);
        iddepart.setText(tDepart);iddepartkota.setText(kDepart);
        idarrive.setText(tArrive);idarrivekota.setText(kArrive);
        idduration.setText(durasi);idharga.setText(total+"");
        idsaldo.setText(saldo+"");
        balance = saldo;
        TotalFix = total;
        idtotal.setText(TotalFix+"");
        idusr = id_user;
             if(bAirline.equals("Air Asia")){
          garuda.setVisible(false);
         airasia.setVisible(true);
         citilink.setVisible(false);
        }else if(bAirline.equals("Citilink")){
        garuda.setVisible(false);
         airasia.setVisible(false);
         citilink.setVisible(true);
        }else if(bAirline.equals("Garuda")){
        garuda.setVisible(true);
         airasia.setVisible(false);
         citilink.setVisible(false);
        }
       
    }
    @FXML
    void AksiContinue(ActionEvent event) {
        
        ContName = fxcontactnm.getText();
        NumPhone = fxnumber.getText();
        Email = fxemail.getText();
        Title = idtitle.getValue();
        PassName = idpassenger.getText();
        National = idnational.getValue();
        dob = iddate.getValue().toString();
        baggage = idbagga.getValue().toString();
        if(baggage.equals("15 kg - Rp 0")){
        idbaggage.setText("0");TotalFix +=0;
        idtotal.setText(TotalFix+"");
        }else if(baggage.equals("20 kg - Rp 90.000")){
        idbaggage.setText("90000");TotalFix +=90000;
        idtotal.setText(TotalFix+"");
        }else if(baggage.equals("25 kg - Rp 100.000")){
        idbaggage.setText("100000");TotalFix +=100000;
        idtotal.setText(TotalFix+"");
        }
        fxcontinue.setDisable(true);
    }   
    @FXML
    void AksiAssurance(ActionEvent event) {
        if(ckassurance.isSelected()==true){
        idassurance.setText(500000+"");
        TotalFix +=500000;
        idtotal.setText(TotalFix+"");status = 1;
        }else{
        idassurance.setText("0");
        TotalFix -=500000;
        idtotal.setText(TotalFix+"");status = 0;
        }
        
    }
    @FXML
    void AksiBayar(ActionEvent event) throws IOException {
        int idf = 1;
        selector = 1;
        
        String fixnama = Title +" "+PassName;
        if(TotalFix < balance){
        int hasil = balance - TotalFix;
        booking.insertFlight(idusr, ContName, NumPhone, Email, Title, PassName, dob, National, baggage, bdatebook, bAirline, btArrive, btDepart, bkArrive, bkDepart, bdurasi,TotalFix+"", balance+"");
        JOptionPane.showMessageDialog(null," Payment Success,\n your Balance Now Rp. "+hasil);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader reportflight = new FXMLLoader(getClass().getResource("ReportView.fxml"));
        Parent root = (Parent)reportflight.load();
        ReportViewController ReportDataF = (ReportViewController)reportflight.getController();
        ReportDataF.setReportFlight(idf,fixnama,dob,baggage,status,bAirline,bdatebook, btArrive, btDepart, bkArrive, bkDepart,selector);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        }else if (TotalFix > balance){
        Bayar.setText("Not Enough Money");
        Bayar.setStyle("-fx-background-color:red;");
        
        }
    }
    

}
