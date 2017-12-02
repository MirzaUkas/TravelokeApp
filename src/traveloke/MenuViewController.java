/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import traveloke.TravelokeModel;

/**
 * FXML Controller class
 *
 * @author MirzaUY
 */
public class MenuViewController implements Initializable {
    /* Variable Declaration of MenuView */
    
    TravelokeModel MenuModel = new TravelokeModel();
    int saldo,total,id_user,hargahotel,price;
    String tArrive,tDepart,kArrive,kDepart,durasi,txtAirline,txtNama,tanggal,jenengmu;
    String namahotel,idguest,idroom,lokasi;
    String nmka,nmkls,wDepart,wArrive,sDepart,sArrive,duration;
    
    /*END*/
    @FXML
    private Pane flight;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXComboBox<String> seatclass;
    @FXML
    private Pane hotel;
    @FXML
    private Pane train;
     @FXML
    private ImageView mirza;

    @FXML
    private ImageView bonzie;

    @FXML
    private ImageView anon;
    @FXML
    private Label idnama;
    @FXML
    private Line lflight;
    @FXML
    private Line lhotel;
    @FXML
    private Line ltrain;
    @FXML
    private Label urbalance;
    @FXML
    private JFXDatePicker datein;

    @FXML
    private JFXDatePicker dateout;

    @FXML
    private JFXComboBox<String> guest;

    @FXML
    private JFXComboBox<String> room;
    
    @FXML
    private JFXDatePicker traindate;

    @FXML
    private JFXComboBox<String> adult;

    @FXML
    private JFXComboBox<String> infant;

    @FXML
    private ToggleGroup rdbutton;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        flight.setVisible(true);
        lflight.setVisible(true);
        lhotel.setVisible(false);
        ltrain.setVisible(false);
        hotel.setVisible(false);
        train.setVisible(false);
        seatclass.setStyle("-fx-font-size:16px;");
        date.setStyle("-fx-font-size:16px;");
        guest.setStyle("-fx-font-size:16px;");
        room.setStyle("-fx-font-size:16px;");
        adult.setStyle("-fx-font-size:16px;");
        infant.setStyle("-fx-font-size:16px;");
        traindate.setStyle("-fx-font-size:16px;");
        datein.setStyle("-fx-font-size:16px;");
        dateout.setStyle("-fx-font-size:16px;");
        seatclass.getItems().add("Economy");
        seatclass.getItems().add("Bussines");
        seatclass.getItems().add("Premium");
        guest.getItems().add("1");
        guest.getItems().add("2");
        guest.getItems().add("3");
        room.getItems().add("1");
        room.getItems().add("2");
        room.getItems().add("3");
        adult.getItems().add("1");
        adult.getItems().add("2");
        adult.getItems().add("3");
        infant.getItems().add("1");
        infant.getItems().add("2");
        infant.getItems().add("3");
        
    }   
    
    public void setDataLogin(String urname,int urbal,int iduser){
        id_user = iduser;
        saldo =urbal;
        txtNama = urname;
        urbalance.setText(saldo+"");
        idnama.setText(txtNama);
        if(urname.equals("Mirza Ukasyah")){
        mirza.setVisible(true);
        bonzie.setVisible(false);
        anon.setVisible(false);
        }else if(urname.equals("Bhuwana Putra")){
        mirza.setVisible(false);
        bonzie.setVisible(true);
        anon.setVisible(false);
        }else{
        mirza.setVisible(false);
        bonzie.setVisible(false);
        anon.setVisible(true);
        }
    
    }
         
    @FXML
    private void out(ActionEvent event) throws IOException {
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
    
    @FXML
    private void AksiFlight(ActionEvent event) {
        flight.setVisible(true);
        lflight.setVisible(true);
        lhotel.setVisible(false);
        ltrain.setVisible(false);
        hotel.setVisible(false);
        train.setVisible(false);
    }

    @FXML
    private void AksiHotel(ActionEvent event) {
        flight.setVisible(false);
        hotel.setVisible(true);
        train.setVisible(false);
        lflight.setVisible(false);
        lhotel.setVisible(true);
        ltrain.setVisible(false);
    }

    @FXML
    private void AksiTrain(ActionEvent event) {
        flight.setVisible(false);
        hotel.setVisible(false);
        train.setVisible(true);
        lflight.setVisible(false);
        lhotel.setVisible(false);
        ltrain.setVisible(true);
    }

    @FXML
    private void flight1(ActionEvent event) throws IOException {
        
        String hari,bulan,tgl,bln,DateNow;
        int tglangka,thnangka;
        tDepart="15.10";tArrive="17.35";
        kDepart="Surabaya";kArrive="Balikpapan";
        durasi="1h 25m";txtAirline="Garuda";
        total = 526000;
        tgl = date.getValue().getDayOfWeek().toString();
        bln = date.getValue().getMonth().toString();
        tglangka = date.getValue().getDayOfMonth();thnangka = date.getValue().getYear();
        hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
        bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
        DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader flight = new FXMLLoader(getClass().getResource("BookFlightView.fxml"));
        Parent root = (Parent)flight.load();
        BookFlightViewController bookController = (BookFlightViewController)flight.getController();
        bookController.setData(tArrive,tDepart,kArrive,kDepart,durasi,txtAirline,txtNama,total,DateNow,saldo,id_user);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    private void flight2(ActionEvent event) throws IOException {
        String hari,bulan,tgl,bln,DateNow;
        int tglangka,thnangka;
        tDepart="16.40";tArrive="19.40";
        kDepart="Jakarta";kArrive="Bali";
        durasi="2h 0m";txtAirline="Citilink";
        total = 1307000;
         tgl = date.getValue().getDayOfWeek().toString();
        bln = date.getValue().getMonth().toString();
        tglangka = date.getValue().getDayOfMonth();thnangka = date.getValue().getYear();
        hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
        bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
        DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader flight2 = new FXMLLoader(getClass().getResource("BookFlightView.fxml"));
        Parent root = (Parent)flight2.load();
        BookFlightViewController bookController = (BookFlightViewController)flight2.getController();
        bookController.setData(tArrive,tDepart,kArrive,kDepart,durasi,txtAirline,txtNama,total,DateNow,saldo,id_user);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    private void flight3(ActionEvent event) throws IOException {
        String hari,bulan,tgl,bln,DateNow;
        int tglangka,thnangka;
        tDepart="17.55";tArrive="21.45";
        kDepart="Jakarta";kArrive="Medan";
        durasi="2h 50m";txtAirline="Air Asia";
        total = 1646000;
        tgl = date.getValue().getDayOfWeek().toString();
        bln = date.getValue().getMonth().toString();
        tglangka = date.getValue().getDayOfMonth();thnangka = date.getValue().getYear();
        hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
        bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
        DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader flight3 = new FXMLLoader(getClass().getResource("BookFlightView.fxml"));
        Parent root = (Parent)flight3.load();
        BookFlightViewController bookController = (BookFlightViewController)flight3.getController();
        bookController.setData(tArrive,tDepart,kArrive,kDepart,durasi,txtAirline,txtNama,total,DateNow,saldo,id_user);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    private void flight4(ActionEvent event) throws IOException {
        String hari,bulan,tgl,bln,DateNow;
        int tglangka,thnangka;
        tDepart="21.35";tArrive="00.35";
        kDepart="Malang";kArrive="Kupang";
        durasi="2h 0m";txtAirline="Garuda";
        total = 626000;
        tgl = date.getValue().getDayOfWeek().toString();
        bln = date.getValue().getMonth().toString();
        tglangka = date.getValue().getDayOfMonth();thnangka = date.getValue().getYear();
        hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
        bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
        DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader flight4 = new FXMLLoader(getClass().getResource("BookFlightView.fxml"));
        Parent root = (Parent)flight4.load();
        BookFlightViewController bookController = (BookFlightViewController)flight4.getController();
        bookController.setData(tArrive,tDepart,kArrive,kDepart,durasi,txtAirline,txtNama,total,DateNow,saldo,id_user);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    private void flight5(ActionEvent event) throws IOException {
        String hari,bulan,tgl,bln,DateNow;
        int tglangka,thnangka;
        tDepart="20.45";tArrive="23.35";
        kDepart="Bali";kArrive="Jakarta";
        durasi="1h 50m";txtAirline="Citilink";
        total = 519000;
        tgl = date.getValue().getDayOfWeek().toString();
        bln = date.getValue().getMonth().toString();
        tglangka = date.getValue().getDayOfMonth();thnangka = date.getValue().getYear();
        hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
        bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
        DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader flight5 = new FXMLLoader(getClass().getResource("BookFlightView.fxml"));
        Parent root = (Parent)flight5.load();
        BookFlightViewController bookController = (BookFlightViewController)flight5.getController();
        bookController.setData(tArrive,tDepart,kArrive,kDepart,durasi,txtAirline,txtNama,total,DateNow,saldo,id_user);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    private void flight6(ActionEvent event) throws IOException {
        String hari,bulan,tgl,bln,DateNow;
        int tglangka,thnangka;
        tDepart="12.05";tArrive="14.35";
        kDepart="Surabaya";kArrive="Balikpapan";
        durasi="1h 30m";txtAirline="Air Asia";
        total = 558000;
        tgl = date.getValue().getDayOfWeek().toString();
        bln = date.getValue().getMonth().toString();
        tglangka = date.getValue().getDayOfMonth();thnangka = date.getValue().getYear();
        hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
        bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
        DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader flight5 = new FXMLLoader(getClass().getResource("BookFlightView.fxml"));
        Parent root = (Parent)flight5.load();
        BookFlightViewController bookController = (BookFlightViewController)flight5.getController();
        bookController.setData(tArrive,tDepart,kArrive,kDepart,durasi,txtAirline,txtNama,total,DateNow,saldo,id_user);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        
    }
   
    @FXML
    void hotel1(ActionEvent event) throws IOException  {
        String hariin,bulanin,tglin,blnin,hariout,bulanout,tglout,blnout;
        String Datein,Dateout;
        int tglangkain,thnangkain,tglangkaout,thnangkaout;
        idguest = guest.getValue();
        idroom = room.getValue();
        tglin = datein.getValue().getDayOfWeek().toString();
        blnin = datein.getValue().getMonth().toString();
        hargahotel = 598000;namahotel="Takes Mansion Hotel";lokasi="Kuta,Bali";
        tglangkain = datein.getValue().getDayOfMonth();thnangkain = datein.getValue().getYear();
        hariin = tglin.substring(0,1).toUpperCase()+tglin.substring(1).toLowerCase();
        bulanin = blnin.substring(0,1).toUpperCase()+blnin.substring(1).toLowerCase();
        Datein = hariin.substring(0,3)+", "+tglangkain+" "+bulanin.substring(0,3)+" "+thnangkain;

        tglout = dateout.getValue().getDayOfWeek().toString();
        blnout = dateout.getValue().getMonth().toString();
        tglangkaout = dateout.getValue().getDayOfMonth();thnangkaout = dateout.getValue().getYear();
        hariout = tglout.substring(0,1).toUpperCase()+tglout.substring(1).toLowerCase();
        bulanout = blnout.substring(0,1).toUpperCase()+blnout.substring(1).toLowerCase();
        Dateout = hariout.substring(0,3)+", "+tglangkaout+" "+bulanout.substring(0,3)+" "+thnangkaout;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader hotel1 = new FXMLLoader(getClass().getResource("BookHotelView.fxml"));
        Parent root = (Parent)hotel1.load();
        BookHotelViewController hotelController = (BookHotelViewController)hotel1.getController();
        hotelController.setDataHotel(txtNama,namahotel,Datein,Dateout,idguest,idroom,hargahotel,saldo,id_user,lokasi);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        
    }

    @FXML
    void hotel2(ActionEvent event) throws IOException {
        String hariin,bulanin,tglin,blnin,hariout,bulanout,tglout,blnout;
        String Datein,Dateout;
        int tglangkain,thnangkain,tglangkaout,thnangkaout;
        hargahotel = 956000;namahotel="Borobudur Hotel";lokasi="Malang,East Java";
        idguest = guest.getValue();
        idroom = room.getValue();
        tglin = datein.getValue().getDayOfWeek().toString();
        blnin = datein.getValue().getMonth().toString();
        tglangkain = datein.getValue().getDayOfMonth();thnangkain = datein.getValue().getYear();
        hariin = tglin.substring(0,1).toUpperCase()+tglin.substring(1).toLowerCase();
        bulanin = blnin.substring(0,1).toUpperCase()+blnin.substring(1).toLowerCase();
        Datein = hariin.substring(0,3)+", "+tglangkain+" "+bulanin.substring(0,3)+" "+thnangkain;

        tglout = dateout.getValue().getDayOfWeek().toString();
        blnout = dateout.getValue().getMonth().toString();
        tglangkaout = dateout.getValue().getDayOfMonth();thnangkaout = dateout.getValue().getYear();
        hariout = tglout.substring(0,1).toUpperCase()+tglout.substring(1).toLowerCase();
        bulanout = blnout.substring(0,1).toUpperCase()+blnout.substring(1).toLowerCase();
        Dateout = hariout.substring(0,3)+", "+tglangkaout+" "+bulanout.substring(0,3)+" "+thnangkaout;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader hotel1 = new FXMLLoader(getClass().getResource("BookHotelView.fxml"));
        Parent root = (Parent)hotel1.load();
        BookHotelViewController hotelController = (BookHotelViewController)hotel1.getController();
        hotelController.setDataHotel(txtNama,namahotel,Datein,Dateout,idguest,idroom,hargahotel,saldo,id_user,lokasi);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    void hotel3(ActionEvent event) throws IOException {
        String hariin,bulanin,tglin,blnin,hariout,bulanout,tglout,blnout;
        String Datein,Dateout;
        int tglangkain,thnangkain,tglangkaout,thnangkaout;
        hargahotel = 618000;namahotel="Merlynn Park Hotel";lokasi="Gambir,Jakarta";
        idguest = guest.getValue();
        idroom = room.getValue();
        tglin = datein.getValue().getDayOfWeek().toString();
        blnin = datein.getValue().getMonth().toString();
        tglangkain = datein.getValue().getDayOfMonth();thnangkain = datein.getValue().getYear();
        hariin = tglin.substring(0,1).toUpperCase()+tglin.substring(1).toLowerCase();
        bulanin = blnin.substring(0,1).toUpperCase()+blnin.substring(1).toLowerCase();
        Datein = hariin.substring(0,3)+", "+tglangkain+" "+bulanin.substring(0,3)+" "+thnangkain;

        tglout = dateout.getValue().getDayOfWeek().toString();
        blnout = dateout.getValue().getMonth().toString();
        tglangkaout = dateout.getValue().getDayOfMonth();thnangkaout = dateout.getValue().getYear();
        hariout = tglout.substring(0,1).toUpperCase()+tglout.substring(1).toLowerCase();
        bulanout = blnout.substring(0,1).toUpperCase()+blnout.substring(1).toLowerCase();
        Dateout = hariout.substring(0,3)+", "+tglangkaout+" "+bulanout.substring(0,3)+" "+thnangkaout;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader hotel1 = new FXMLLoader(getClass().getResource("BookHotelView.fxml"));
        Parent root = (Parent)hotel1.load();
        BookHotelViewController hotelController = (BookHotelViewController)hotel1.getController();
        hotelController.setDataHotel(txtNama,namahotel,Datein,Dateout,idguest,idroom,hargahotel,saldo,id_user,lokasi);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    void hotel4(ActionEvent event) throws IOException {
        String hariin,bulanin,tglin,blnin,hariout,bulanout,tglout,blnout;
        String Datein,Dateout;
        int tglangkain,thnangkain,tglangkaout,thnangkaout;
        hargahotel = 570000;namahotel="Best Western Premiere";lokasi="Cawang,Jakarta";
        idguest = guest.getValue();
        idroom = room.getValue();
        tglin = datein.getValue().getDayOfWeek().toString();
        blnin = datein.getValue().getMonth().toString();
        tglangkain = datein.getValue().getDayOfMonth();thnangkain = datein.getValue().getYear();
        hariin = tglin.substring(0,1).toUpperCase()+tglin.substring(1).toLowerCase();
        bulanin = blnin.substring(0,1).toUpperCase()+blnin.substring(1).toLowerCase();
        Datein = hariin.substring(0,3)+", "+tglangkain+" "+bulanin.substring(0,3)+" "+thnangkain;

        tglout = dateout.getValue().getDayOfWeek().toString();
        blnout = dateout.getValue().getMonth().toString();
        tglangkaout = dateout.getValue().getDayOfMonth();thnangkaout = dateout.getValue().getYear();
        hariout = tglout.substring(0,1).toUpperCase()+tglout.substring(1).toLowerCase();
        bulanout = blnout.substring(0,1).toUpperCase()+blnout.substring(1).toLowerCase();
        Dateout = hariout.substring(0,3)+", "+tglangkaout+" "+bulanout.substring(0,3)+" "+thnangkaout;
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader hotel1 = new FXMLLoader(getClass().getResource("BookHotelView.fxml"));
        Parent root = (Parent)hotel1.load();
        BookHotelViewController hotelController = (BookHotelViewController)hotel1.getController();
        hotelController.setDataHotel(txtNama,namahotel,Datein,Dateout,idguest,idroom,hargahotel,saldo,id_user,lokasi);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    
    @FXML
    void train1(ActionEvent event) throws IOException {
       String hari,bulan,tgl,bln,DateNow,tnama;
       int tglangka,thnangka;
       nmka="Sembrani";nmkls="Executive(A)";
       wDepart="01.45";wArrive="05.43";
       sDepart="Semarang (SET)";sArrive="Surabaya (SUP)";
       duration="03h 58m";price=365000;
       tgl = traindate.getValue().getDayOfWeek().toString();
       bln = traindate.getValue().getMonth().toString();
       tglangka = traindate.getValue().getDayOfMonth();thnangka = traindate.getValue().getYear();
       hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
       bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
       DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
       ((Node)(event.getSource())).getScene().getWindow().hide();
       FXMLLoader train = new FXMLLoader(getClass().getResource("BookTrainView.fxml"));
       Parent root = (Parent)train.load();
       BookTrainViewController bookController = (BookTrainViewController)train.getController();
       bookController.setDataTrain(wArrive,wDepart,sArrive,sDepart,duration,nmka,nmkls,txtNama,DateNow,saldo,price,id_user);
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();
    }

    @FXML
    void train2(ActionEvent event) throws IOException {
       String hari,bulan,tgl,bln,DateNow,tnama;
       int tglangka,thnangka;
       nmka="Malabar";nmkls="Economy(C)";
       wDepart="15.45";wArrive="07.45";
       sDepart="Bandung";sArrive="Malang";
       duration="15h 20m";price=250000;
       tgl = traindate.getValue().getDayOfWeek().toString();
       bln = traindate.getValue().getMonth().toString();
       tglangka = traindate.getValue().getDayOfMonth();thnangka = traindate.getValue().getYear();
       hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
       bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
       DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
       ((Node)(event.getSource())).getScene().getWindow().hide();
       FXMLLoader train = new FXMLLoader(getClass().getResource("BookTrainView.fxml"));
       Parent root = (Parent)train.load();
       BookTrainViewController bookController = (BookTrainViewController)train.getController();
       bookController.setDataTrain(wArrive,wDepart,sArrive,sDepart,duration,nmka,nmkls,txtNama,DateNow,saldo,price,id_user);
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();
    }

    @FXML
    void train3(ActionEvent event) throws IOException {
       String hari,bulan,tgl,bln,DateNow,tnama;
       int tglangka,thnangka;
       nmka="Taksaka";nmkls="Executive(A)";
       wDepart="08.30";wArrive="16.25";
       sDepart="Gambir";sArrive="Yogyakarta";
       duration="07h 39m";price=380000;
       tgl = traindate.getValue().getDayOfWeek().toString();
       bln = traindate.getValue().getMonth().toString();
       tglangka = traindate.getValue().getDayOfMonth();thnangka = traindate.getValue().getYear();
       hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
       bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
       DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
       ((Node)(event.getSource())).getScene().getWindow().hide();
       FXMLLoader train = new FXMLLoader(getClass().getResource("BookTrainView.fxml"));
       Parent root = (Parent)train.load();
       BookTrainViewController bookController = (BookTrainViewController)train.getController();
       bookController.setDataTrain(wArrive,wDepart,sArrive,sDepart,duration,nmka,nmkls,txtNama,DateNow,saldo,price,id_user);
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();

    }

    @FXML
    void train4(ActionEvent event) throws IOException {
       String hari,bulan,tgl,bln,DateNow,tnama;
       int tglangka,thnangka;
       nmka="Jayabaya";nmkls="Economy(C)";
       wDepart="11.45";wArrive="14.03";
       sDepart="Malang";sArrive="Surabaya";
       duration="02h 18m";price=35000;
       tgl = traindate.getValue().getDayOfWeek().toString();
       bln = traindate.getValue().getMonth().toString();
       tglangka = traindate.getValue().getDayOfMonth();thnangka = traindate.getValue().getYear();
       hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
       bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
       DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
       ((Node)(event.getSource())).getScene().getWindow().hide();
       FXMLLoader train = new FXMLLoader(getClass().getResource("BookTrainView.fxml"));
       Parent root = (Parent)train.load();
       BookTrainViewController bookController = (BookTrainViewController)train.getController();
       bookController.setDataTrain(wArrive,wDepart,sArrive,sDepart,duration,nmka,nmkls,txtNama,DateNow,saldo,price,id_user);
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();

    }

    @FXML
    void train5(ActionEvent event) throws IOException {
       String hari,bulan,tgl,bln,DateNow,tnama;
       int tglangka,thnangka;
       nmka="Gajayana";nmkls="Executive(H)";
       wDepart="13.30";wArrive="20.22";
       sDepart="Malang";sArrive="Yogyakarta";
       duration="06h 52m";price=430000;
       tgl = traindate.getValue().getDayOfWeek().toString();
       bln = traindate.getValue().getMonth().toString();
       tglangka = traindate.getValue().getDayOfMonth();thnangka = traindate.getValue().getYear();
       hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
       bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
       DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
       ((Node)(event.getSource())).getScene().getWindow().hide();
       FXMLLoader train5 = new FXMLLoader(getClass().getResource("BookTrainView.fxml"));
       Parent root = (Parent)train5.load();
       BookTrainViewController bookController = (BookTrainViewController)train5.getController();
       bookController.setDataTrain(wArrive,wDepart,sArrive,sDepart,duration,nmka,nmkls,txtNama,DateNow,saldo,price,id_user);
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();
    }

    @FXML
    void train6(ActionEvent event) throws IOException {
       String hari,bulan,tgl,bln,DateNow,tnama;
       int tglangka,thnangka;
       nmka="Majapahit";nmkls="Executive(P)";
       wDepart="00.45";wArrive="10.05";
       sDepart="Semarang";sArrive="Malang";
       duration="09h 20m";price=210000;
       tgl = traindate.getValue().getDayOfWeek().toString();
       bln = traindate.getValue().getMonth().toString();
       tglangka = traindate.getValue().getDayOfMonth();thnangka = traindate.getValue().getYear();
       hari = tgl.substring(0,1).toUpperCase()+tgl.substring(1).toLowerCase();
       bulan = bln.substring(0,1).toUpperCase()+bln.substring(1).toLowerCase();
       DateNow = hari+", "+tglangka+" "+bulan+" "+thnangka;
       ((Node)(event.getSource())).getScene().getWindow().hide();
       FXMLLoader train = new FXMLLoader(getClass().getResource("BookTrainView.fxml"));
       Parent root = (Parent)train.load();
       BookTrainViewController bookController = (BookTrainViewController)train.getController();
       bookController.setDataTrain(wArrive,wDepart,sArrive,sDepart,duration,nmka,nmkls,txtNama,DateNow,saldo,price,id_user);
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();

    }
}
