/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveloke;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author MirzaUY
 */ 
public class PrintReport {
    Connection conn = koneksi.konektor();
    PreparedStatement pst = null;
    ResultSet rs = null; 
    public PrintReport() throws HeadlessException {
    }
    public void showReport(){
         try {
             
             JasperReport jasperReport = JasperCompileManager.compileReport("src/traveloke/Report/FlightReport.jrxml");
             JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
             JasperViewer.viewReport(JasperPrint, false); 
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
    }
    public void showReportTrain(){
         try {
             
             JasperReport jasperReport = JasperCompileManager.compileReport("src/traveloke/Report/TrainReport.jrxml");
             JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
             JasperViewer.viewReport(JasperPrint, false); 
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
    }
    public void showReportHotel(){
         try {
             
             JasperReport jasperReport = JasperCompileManager.compileReport("src/traveloke/Report/HotelReport.jrxml");
             JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
             JasperViewer.viewReport(JasperPrint, false); 
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
    }
}
