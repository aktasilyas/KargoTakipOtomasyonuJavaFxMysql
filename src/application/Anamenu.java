package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Anamenu {
	
	
	String sorgu="";
	Connection baglantiConnection=null;
	PreparedStatement sorguPreparedStatement=null;
	ResultSet getirilenResultSet=null;
	
    public Anamenu() {
    	baglantiConnection=sqlBaglanti.Baglan();
    	
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<KargoKayitlar> TableListele;

    @FXML
    private TableColumn<KargoKayitlar, Integer> FaturaNO;

    @FXML
    private TableColumn<KargoKayitlar, String> GTc;

    @FXML
    private TableColumn<KargoKayitlar, String> ATc;

    @FXML
    private TableColumn<KargoKayitlar, String> GÝsim;

    @FXML
    private TableColumn<KargoKayitlar, String> AÝsim;

    @FXML
    private TableColumn<KargoKayitlar, String> GTel;

    @FXML
    private TableColumn<KargoKayitlar, String> ATel;

    @FXML
    private TableColumn<KargoKayitlar, String> Urun;

    @FXML
    private TableColumn<KargoKayitlar, Integer> Adet;
    @FXML
    private TableColumn<KargoKayitlar, Integer> Agirilik;
    @FXML
    private TableColumn<KargoKayitlar, Integer>Fiyat;

    @FXML
    private TableColumn<KargoKayitlar, Integer> ID;
    
    @FXML
    private AnchorPane paneAnamenu;
  
    
    ObservableList<KargoKayitlar> veriler;
    

    @FXML
    void BtnPersonelListele(ActionEvent event) {

    }

    @FXML
    void BtnpersonelEkle(ActionEvent event) {

    }

    @FXML
    void TableClýck(MouseEvent event) {

    }

    @FXML
    void btnkargoEkleme(ActionEvent event) {
    	try {
    		
//    		Parent parent=FXMLLoader.load(getClass().getResource("KargoEkle.fxml"));
//    		paneAnamenu.getChildren().removeAll();
//    		paneAnamenu.getChildren().setAll(parent);
			AnchorPane root=FXMLLoader.load(getClass().getResource("KargoEkle.fxml"));
			Stage stage=new Stage();
			Scene scene=new Scene(root);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.showAndWait();
		} catch (IOException e) {
			
			e.printStackTrace();
		}


    }

    @FXML
    void btnkargoListele(ActionEvent event) {
    	TableListele.setVisible(true);

    }

    @FXML
    void btnkargoNerede(ActionEvent event) {
try {
    		
//    		Parent parent=FXMLLoader.load(getClass().getResource("KargoEkle.fxml"));
//    		paneAnamenu.getChildren().removeAll();
//    		paneAnamenu.getChildren().setAll(parent);
			AnchorPane root=FXMLLoader.load(getClass().getResource("KargoNerede.fxml"));
			Stage stage=new Stage();
			Scene scene=new Scene(root);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			
			stage.showAndWait();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

    @FXML
    void btnkargoTakip(ActionEvent event) {
try {
    		
//    		Parent parent=FXMLLoader.load(getClass().getResource("KargoEkle.fxml"));
//    		paneAnamenu.getChildren().removeAll();
//    		paneAnamenu.getChildren().setAll(parent);
			AnchorPane root=FXMLLoader.load(getClass().getResource("KargoTakip.fxml"));
			Stage stage=new Stage();
			Scene scene=new Scene(root);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.showAndWait();
		} catch (IOException e) {
			
			e.printStackTrace();
		}


    }
    
    public void Bilgiler(TableView<KargoKayitlar> table) {
    	
    	sorgu="select*from kargo";
    	
    	try {
			sorguPreparedStatement=baglantiConnection.prepareStatement(sorgu);
			
			getirilenResultSet=sorguPreparedStatement.executeQuery();
			
			veriler=FXCollections.observableArrayList();
			
			while(getirilenResultSet.next()) {
				veriler.add(new KargoKayitlar(getirilenResultSet.getInt("faturaNo"), getirilenResultSet.getString("GöndericiTc"),
						getirilenResultSet.getString("AliciTc"), getirilenResultSet.getString("GöndericiÝsim"),
						getirilenResultSet.getString("AliciÝsim"), getirilenResultSet.getString("GöndericiTel"), 
						getirilenResultSet.getString("AliciTel"), getirilenResultSet.getString("Urun"), getirilenResultSet.getInt("Adet"),
						getirilenResultSet.getInt("Agirlik"),getirilenResultSet.getInt("ID"),getirilenResultSet.getInt("fiyat")));
			}
			
			FaturaNO.setCellValueFactory(new PropertyValueFactory<>("faturaNo"));
			GTc.setCellValueFactory(new PropertyValueFactory<>("gondericiTc"));
			ATc.setCellValueFactory(new PropertyValueFactory<>("AliciTc"));
			GÝsim.setCellValueFactory(new PropertyValueFactory<>("gondericiÝsim"));
			AÝsim.setCellValueFactory(new PropertyValueFactory<>("AlýcýÝsim"));
			GTel.setCellValueFactory(new PropertyValueFactory<>("gondericiTel"));
			ATel.setCellValueFactory(new PropertyValueFactory<>("AlýcýTel"));
			Urun.setCellValueFactory(new PropertyValueFactory<>("Urun"));
			Adet.setCellValueFactory(new PropertyValueFactory<>("Adet"));
			Agirilik.setCellValueFactory(new PropertyValueFactory<>("Agýrlýk"));
			Fiyat.setCellValueFactory(new PropertyValueFactory<>("Fiyat"));
			TableListele.setItems(veriler);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

    @FXML
    void initialize() {
    	ID.setVisible(false);
       TableListele.setVisible(false);
       Bilgiler(TableListele);

    }
}
