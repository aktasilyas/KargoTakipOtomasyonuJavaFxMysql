package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UyeOL {
	
	String sorgu="";
	Connection baglantiConnection=null;
	PreparedStatement sorguPreparedStatement=null;
	
	
    public UyeOL() {
    	baglantiConnection=sqlBaglanti.Baglan();
    	
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adi;

    @FXML
    private PasswordField sifre;

    @FXML
    private PasswordField sifretekrar;

    @FXML
    private TextField email;

    @FXML
    void btngiris(ActionEvent event) {

    }

    @FXML
    void btnuyeol(ActionEvent event) {
sorgu="insert into giris(adi,Mail,Sifre) values(?,?,?)";
    	
    	
    	String mesaj="";
    	if (sifre.getText().length()!=sifretekrar.getText().length()) {
    		mesaj+="Sifrelerin Boyutu Ayni Olmali\n";
			
		}
    	if (!(sifre.getText().equals(sifretekrar.getText()))) {
    		mesaj+="Sifreler  Ayni Olmali";
			
		}
    	if (mesaj.length()==0) {
    		try {
    			sorguPreparedStatement=baglantiConnection.prepareStatement(sorgu);
    			
    			sorguPreparedStatement.setString(1, adi.getText().trim());
    			sorguPreparedStatement.setString(2, email.getText().trim());
    			sorguPreparedStatement.setString(3, sifre.getText().trim());
    			
    			sorguPreparedStatement.executeUpdate();
    			Alert alert=new Alert(AlertType.CONFIRMATION);
    			alert.setContentText("Uye Basarili");
    			alert.show();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			
		}else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setContentText(mesaj);
			alert.showAndWait();
		}
    	

    }

    @FXML
    void initialize() {
        

    }
}
