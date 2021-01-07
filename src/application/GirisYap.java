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
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GirisYap {
	String sorgu="";
	Connection baglantiConnection=null;
	PreparedStatement sorguPreparedStatement=null;
	ResultSet getirilenResultSet=null;
	
    public GirisYap() {
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
    private AnchorPane paneGiris;

    @FXML
    void btngiris(ActionEvent event) {
	sorgu="select*from giris where adi=? and Sifre=?";
	
    	
    	try {
			sorguPreparedStatement=baglantiConnection.prepareStatement(sorgu);
			sorguPreparedStatement.setString(1, adi.getText().trim());
			sorguPreparedStatement.setString(2, sifre.getText().trim());
			
			getirilenResultSet=sorguPreparedStatement.executeQuery();
			
			
			while(getirilenResultSet.next()) {
				
				if (getirilenResultSet.getString("adi").equals(adi.getText())&&getirilenResultSet.getString("Sifre").equals(sifre.getText())) {
					
					try {
						Parent parent=FXMLLoader.load(getClass().getResource("Anamenu.fxml"));
						paneGiris.getChildren().removeAll();
						paneGiris.getChildren().setAll(parent);
						
//						AnchorPane root=FXMLLoader.load(getClass().getResource("Anamenu.fxml"));
//						Scene scene=new Scene(root);
//						Stage stage=new Stage();
//						stage.setScene(scene);
//						stage.initModality(Modality.APPLICATION_MODAL);
//						paneGiris.getScene().getWindow().hide();
//						stage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void btnuyeol(ActionEvent event) {
    	
    	try {
			AnchorPane root=FXMLLoader.load(getClass().getResource("UyeOL.fxml"));
			Scene scene=new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() {
       

    }
}
