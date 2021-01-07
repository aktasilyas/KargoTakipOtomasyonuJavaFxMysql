package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;



public class KargoEkle {
	
	
	
	String sorgu="";
	Connection baglantiConnection=null;
	PreparedStatement sorguPreparedStatement=null;
	ResultSet getirilenResultSet=null;
	
    public KargoEkle() {
    	baglantiConnection=sqlBaglanti.Baglan();
    	
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneKargoekle;

    @FXML
    private TextField Gtc;

    @FXML
    private TextField Gadsoyad;

    @FXML
    private TextField Gtel;

    @FXML
    private TextField Atc;

    @FXML
    private TextField Aadsoyad;

    @FXML
    private TextField Atel;

    @FXML
    private TextField KfaturaNo;

    @FXML
    private TextField Kurun;

    @FXML
    private TextField Kadet;

    @FXML
    private Button Khesapla;

    @FXML
    private TextField Khamfýyat;

    @FXML
    private TextField Kagýrlýk;
    int sonuc=0;

    @FXML
    void btnKhesapla(ActionEvent event) {
    	
    	int adet=Integer.parseInt(Kadet.getText());
    	int agirlik=Integer.parseInt(Kagýrlýk.getText());
    	sonuc=adet*agirlik;
    	Khamfýyat.setText(String.valueOf(sonuc));

    }

    @FXML
    void btnanamenu(ActionEvent event) {
    	
    	try {
    		Parent parent=FXMLLoader.load(getClass().getResource("Anamenu.fxml"));
    		paneKargoekle.getChildren().removeAll();
    		paneKargoekle.getChildren().setAll(parent);
//			AnchorPane root=FXMLLoader.load(getClass().getResource("Anamenu.fxml"));
//			Stage stage=new Stage();
//			Scene scene=new Scene(root);
//			stage.setScene(scene);
//			stage.initModality(Modality.APPLICATION_MODAL);
//			paneKargoekle.getScene().getWindow().hide();
//			stage.showAndWait();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

    @FXML
    void btnekle(ActionEvent event) {
    	
    	sorgu="insert into kargo(faturaNo,GöndericiTc,AliciTc,GöndericiÝsim,AliciÝsim,GöndericiTel,AliciTel,Urun,Adet,Agirlik,fiyat)"
    			+ "values(?,?,?,?,?,?,?,?,?,?,?)";
    	
    	try {
			sorguPreparedStatement=baglantiConnection.prepareStatement(sorgu);
			
			sorguPreparedStatement.setInt(1, Integer.parseInt(KfaturaNo.getText().trim()));
			sorguPreparedStatement.setString(2,String.valueOf( Gtc.getText().trim()));
			sorguPreparedStatement.setString(3, String.valueOf(Atc.getText().trim()));
			sorguPreparedStatement.setString(4, Gadsoyad.getText().trim());
			sorguPreparedStatement.setString(5, Aadsoyad.getText().trim());
			sorguPreparedStatement.setString(6,String.valueOf( Gtel.getText().trim()));
			sorguPreparedStatement.setString(7,String.valueOf( Atel.getText().trim()));
			sorguPreparedStatement.setString(8, Kurun.getText().trim());
			sorguPreparedStatement.setInt(9, Integer.parseInt(Kadet.getText().trim()));
			sorguPreparedStatement.setInt(10, Integer.parseInt(Kagýrlýk.getText().trim()));
			sorguPreparedStatement.setInt(11,sonuc);
			
			sorguPreparedStatement.executeUpdate();
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Ekleme Basarili");
			alert.showAndWait();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void btniptal(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void initialize() {
        

    }
}
