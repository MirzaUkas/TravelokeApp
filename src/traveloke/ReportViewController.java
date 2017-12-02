/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import traveloke.PrintReport;
import traveloke.koneksi;




/**
 * FXML Controller class
 *
 * @author MirzaUY
 */
public class ReportViewController implements Initializable {
    
    Connection conn = koneksi.konektor();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
   
    @FXML
    private Pane FlightReport;
    @FXML
    private ImageView airasia;
    @FXML
    private ImageView citilink;
    @FXML
    private ImageView garuda;
    @FXML
    private Label dateflght;
    @FXML
    private Label airline;
    @FXML
    private Label kotflightdep;
    @FXML
    private Label kotflghtariv;
    @FXML
    private Label wktflghtdep;
    @FXML
    private Label wktflghtariv;
    @FXML
    private Label kodebookflght;
    @FXML
    private Label idf;
    @FXML
    private Label namaf;
    @FXML
    private Label dobf;
    @FXML
    private Label baggagef;
    @FXML
    private ImageView no;
    @FXML
    private ImageView yes;
    @FXML
    private Pane HotelReport;
    @FXML
    private Label idcin;
    @FXML
    private Label hotelnm;
    @FXML
    private Label idlocation;
    @FXML
    private Label room;
    @FXML
    private Label guest;
    @FXML
    private Label kodebookhotel;
    @FXML
    private Label idh;
    @FXML
    private Label namah;
    @FXML
    private Label emailh;
    @FXML
    private Label numberh;
    @FXML
    private ImageView h1;
    @FXML
    private ImageView h2;
    @FXML
    private Label idcout;
    @FXML
    private ImageView h4;
    @FXML
    private ImageView h3;
    @FXML
    private Pane TrainReport;
    @FXML
    private Label datetrain;
    @FXML
    private Label train;
    @FXML
    private Label trainclass;
    @FXML
    private Label kottraindep;
    @FXML
    private Label kottrainariv;
    @FXML
    private Label wkttraindep;
    @FXML
    private Label wkttrainariv;
    @FXML
    private Label kodebooktrain;
    @FXML
    private Label idt;
    @FXML
    private Label namat;
    @FXML
    private Label idtype;
    @FXML
    private Label numbert;
    @FXML
    private ImageView not;
    @FXML
    private ImageView yest;

    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    public void setReportFlight(int idfi,String fixnama,String dob,String baggage,int status,String bAirline,String bdatebook, String btArrive, String btDepart, String bkArrive, String bkDepart,int selector){
    if(selector == 1){
        FlightReport.setVisible(true);
        TrainReport.setVisible(false);
        HotelReport.setVisible(false);
    }
        switch (bAirline) {
            case "Air Asia":
                garuda.setVisible(false);
                airasia.setVisible(true);
                citilink.setVisible(false);
                break;
            case "Citilink":
                garuda.setVisible(false);
                airasia.setVisible(false);
                citilink.setVisible(true);
                break;
            case "Garuda":
                garuda.setVisible(true);
                airasia.setVisible(false);
                citilink.setVisible(false);
                break;
            default:
                break;
        }
    airline.setText(bAirline);dateflght.setText(bdatebook);
    wktflghtdep.setText(btDepart);wktflghtariv.setText(btArrive);
    kotflightdep.setText(bkDepart);kotflghtariv.setText(bkArrive);
    idf.setText(idfi+"");namaf.setText(fixnama);dobf.setText(dob);baggagef.setText(baggage);
    if(status == 1){
    yes.setVisible(true);
    no.setVisible(false);
    }else if(status == 0){
    yes.setVisible(false);
    no.setVisible(true);
    }else{
    yes.setVisible(false);
    no.setVisible(false);
    }
    }
   
    public void setReportTrain(int idti,String fixnama,String IDtype,String IDnumb,int status,String nmkak,String nmklsk,String DateNowk,String Arrivet,String Departt,String Arrivek,String Departk,int selector){
    if(selector == 2){
        FlightReport.setVisible(false);
        TrainReport.setVisible(true);
        HotelReport.setVisible(false);
    }
        switch (status) {
            case 2:
                yest.setVisible(true);
                not.setVisible(false);
                break;
            case 3:
                yest.setVisible(false);
                not.setVisible(true);
                break;
            default:
                yest.setVisible(false);
                not.setVisible(false);
                break;
        }
    datetrain.setText(DateNowk);train.setText(nmkak);trainclass.setText(nmklsk);
    wkttraindep.setText(Departt);wkttrainariv.setText(Arrivet);
    kottraindep.setText(Departk);kottrainariv.setText(Arrivek);
    idt.setText(idti+"");namat.setText(fixnama);idtype.setText(IDtype);numbert.setText(IDnumb);
        
    }
    
    public void setReportHotel(int idhi,String guestnm,String email,String numbphone,String hotel,String location,String cin,String cout,String roomh,String guesth,int selector){
     if(selector == 3){
        FlightReport.setVisible(false);
        TrainReport.setVisible(false);
        HotelReport.setVisible(true);
    }
        switch (hotel) {
            case "Takes Mansion Hotel":
                h1.setVisible(false);
                h2.setVisible(false);
                h3.setVisible(true);
                h4.setVisible(false);
                break;
            case "Borobudur Hotel":
                h1.setVisible(false);
                h2.setVisible(true);
                h3.setVisible(false);
                h4.setVisible(false);
                break;
            case "Merlynn Park Hotel":
                h1.setVisible(true);
                h2.setVisible(false);
                h3.setVisible(false);
                h4.setVisible(false);
                break;
            case "Best Western Premiere":
                h1.setVisible(false);
                h2.setVisible(false);
                h3.setVisible(false);
                h4.setVisible(true);
                break;
            default:
                break;
        }
        hotelnm.setText(hotel);idlocation.setText(location);
        idcin.setText(cin);idcout.setText(cout);
        room.setText(roomh);guest.setText(guesth);
        idh.setText(idhi+"");namah.setText(guestnm);
        emailh.setText(email);numberh.setText(numbphone);
        
     
    }
    @FXML
    private void cetakflight(ActionEvent event) {
        PrintReport viewReport = new PrintReport();
        viewReport.showReport();  
    }
    @FXML
    private void cetakhotel(ActionEvent event) {
        PrintReport viewReport = new PrintReport();
        viewReport.showReportHotel();  
    }
    @FXML
    private void cetaktrain(ActionEvent event) {
         PrintReport viewReport = new PrintReport();
        viewReport.showReportTrain();  
    }
        @FXML
    void AksiKeluar(ActionEvent event) {
         System.exit(0);
         JOptionPane.showMessageDialog(null,"Thank you For Booking ");
               
    }

    @FXML
    void AksiOut(ActionEvent event) throws IOException {
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
