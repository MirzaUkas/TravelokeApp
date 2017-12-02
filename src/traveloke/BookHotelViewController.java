/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import com.jfoenix.controls.JFXButton;
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
public class BookHotelViewController implements Initializable {
TravelokeModel BookHotel = new TravelokeModel();
        
    @FXML
    private JFXTextField idcontactnm;
    @FXML
    private JFXTextField idnumber;
    @FXML
    private JFXTextField idemail;
    @FXML
    private Label airline;
    @FXML
    private Label idharga;
    @FXML
    private Label idtotal;
    @FXML
    private Label idsaldo;
    @FXML
    private JFXButton Bayar;
    @FXML
    private JFXTextField idfullname;
    @FXML
    private ImageView idimage1;
    @FXML
    private Label idhotelnm;
    @FXML
    private Label idhotelname;
    @FXML
    private Label idcin;
    @FXML
    private Label idcout;
    @FXML
    private Label roomid;
    @FXML
    private Label guestid;
    @FXML
    private ImageView idimage2;
    @FXML
    private ImageView idimage3;
    @FXML
    private ImageView idimage4;
    
    @FXML
    private Label idlokasi;

    /**
     * Initializes the controller class.
     */
    String hotel,nama,cin,cout,guest,room,location,guestnm,email,numbphone;
    int balance,idusr,total,idh,selector;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
    }    
    public void setDataHotel(String txtNama,String namahotel,String Datein,String Dateout,String idguest,String idroom,int hargahotel,int saldo,int id_user,String lokasi){
        nama = txtNama;cin = Datein;cout = Dateout;guest = idguest;room = idroom;
        hotel = namahotel;balance = saldo;idusr=id_user;location = lokasi;total = hargahotel;
        idhotelname.setText(hotel);idhotelnm.setText(hotel);guestid.setText(guest);
        roomid.setText(room);idcin.setText(cin);idcout.setText(cout);idcontactnm.setText(nama);
        idharga.setText(hargahotel+"");idsaldo.setText(saldo+"");idtotal.setText(hargahotel+"");idlokasi.setText(lokasi);
        if(hotel.equals("Takes Mansion Hotel")){
            idimage1.setVisible(false);
            idimage2.setVisible(false);
            idimage3.setVisible(true);
            idimage4.setVisible(false);
        }else if(hotel.equals("Borobudur Hotel")){
            idimage1.setVisible(false);
            idimage2.setVisible(true);
            idimage3.setVisible(false);
            idimage4.setVisible(false);
        }else if(hotel.equals("Merlynn Park Hotel")){
            idimage1.setVisible(true);
            idimage2.setVisible(false);
            idimage3.setVisible(false);
            idimage4.setVisible(false);
        }else if(hotel.equals("Best Western Premiere")){
            idimage1.setVisible(false);
            idimage2.setVisible(false);
            idimage3.setVisible(false);
            idimage4.setVisible(true);
        }
        
    }

    @FXML
    private void AksiBayar(ActionEvent event) throws IOException {
        numbphone = idnumber.getText();
        email  = idemail.getText();
        guestnm = idfullname.getText();
        idh = 1;selector = 3;
         if( total< balance){
        int hasil = balance - total;
        BookHotel.insertHotel(idusr,nama,numbphone,email,guestnm,hotel,location,cin,cout,room,guest,total+"",balance+"");
        JOptionPane.showMessageDialog(null," Payment Success,\n your Balance Now Rp. "+hasil);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader reportHotel = new FXMLLoader(getClass().getResource("ReportView.fxml"));
        Parent root = (Parent)reportHotel.load();
        ReportViewController ReportDataH = (ReportViewController)reportHotel.getController();
        ReportDataH.setReportHotel(idh,guestnm,email,numbphone,hotel,location,cin, cout, room, guest,selector);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        }else if (total> balance){
        Bayar.setText("Not Enough Money");
        Bayar.setStyle("-fx-background-color:red;");
    }
    }
        
    
    
}
