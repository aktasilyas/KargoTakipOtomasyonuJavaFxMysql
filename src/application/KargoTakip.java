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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class KargoTakip {
	String sorgu="";
	Connection baglantiConnection=null;
	PreparedStatement sorguPreparedStatement=null;
	ResultSet getirilenResultSet=null;
	
    public KargoTakip() {
    	baglantiConnection=sqlBaglanti.Baglan();
    	
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneKargoTakip;

    @FXML
    private ComboBox<String> combosorgula;

    @FXML
    private TextField gAdi;

    @FXML
    private TextArea Gadres;


    @FXML
    private TextField aAdi;

    @FXML
    private TextArea Aadres;

    @FXML
    private TextField Yer;

    @FXML
    private TextField durumu;

    @FXML
    private ComboBox<String> comboSehir;

    @FXML
    private ComboBox<String> combodurum;

    
    
    @FXML
    void btnanasayfa(ActionEvent event) {
    	try {
			
			
			AnchorPane root=FXMLLoader.load(getClass().getResource("Anamenu.fxml"));
			Scene scene=new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			paneKargoTakip.getScene().getWindow().hide();
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void btnguncelle(ActionEvent event) {
    	sorgu="update kargodetay set yer=? , durum=? where faturaNo=?";
    	
    	try {
			sorguPreparedStatement=baglantiConnection.prepareStatement(sorgu);
			
			sorguPreparedStatement.setString(1, comboSehir.getSelectionModel().getSelectedItem());
			sorguPreparedStatement.setString(2, combodurum.getSelectionModel().getSelectedItem());
			sorguPreparedStatement.setInt(3, Integer.parseInt(combosorgula.getSelectionModel().getSelectedItem()));
			
			sorguPreparedStatement.executeUpdate();
			Bilgiler();
			Alert alert=new Alert(AlertType.CONFIRMATION);
			
			alert.setContentText("guncelleme basarili");
			alert.show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    public void Bilgiler() {
sorgu="select *from kargodetay where faturaNo=?";
    	
    	try {
			sorguPreparedStatement=baglantiConnection.prepareStatement(sorgu);
			
			sorguPreparedStatement.setString(1, String.valueOf(combosorgula.getSelectionModel().getSelectedItem()));
			
			getirilenResultSet=sorguPreparedStatement.executeQuery();
			while(getirilenResultSet.next()) {
				
				gAdi.setText(getirilenResultSet.getString("gAdi"));
				Gadres.setText(getirilenResultSet.getString("gAdres"));
				aAdi.setText(getirilenResultSet.getString("aAdi"));
				Aadres.setText(getirilenResultSet.getString("aAdres"));
				Yer.setText(getirilenResultSet.getString("yer"));
				durumu.setText(getirilenResultSet.getString("durum"));
				comboSehir.getItems().add(getirilenResultSet.getString("sehir"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

    @FXML
    void btnsorgula(ActionEvent event) {
    	
    	Bilgiler();

    }

    @FXML
    void initialize() {
sorgu="select *from kargodetay";
    	
    	try {
			sorguPreparedStatement=baglantiConnection.prepareStatement(sorgu);
			
			
			
			getirilenResultSet=sorguPreparedStatement.executeQuery();
			while(getirilenResultSet.next()) {
				
				combosorgula.getItems().add(getirilenResultSet.getString("faturaNo"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
       gAdi.setEditable(false);
       Gadres.setEditable(false);
       aAdi.setEditable(false);
       Aadres.setEditable(false);
       Yer.setEditable(false);
       durumu.setEditable(false);
       combodurum.getItems().addAll("Yolda","Dagitimda","Vardi");
       comboSehir.getItems().addAll("Hatay","Igdir","Izmir");

    }
}
