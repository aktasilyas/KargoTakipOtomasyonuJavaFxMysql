package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class KargoNerede {
	String sorgu="";
	Connection baglantiConnection=null;
	PreparedStatement sorguPreparedStatement=null;
	ResultSet getirilenResultSet=null;
	
    public KargoNerede() {
    	baglantiConnection=sqlBaglanti.Baglan();
    	
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<KargoDetay> tableKargoNerede;

    @FXML
    private TableColumn<KargoDetay, Integer> ID;

    @FXML
    private TableColumn<KargoDetay, Integer> FaturaNo;
    @FXML
    private TableColumn<KargoDetay, String> gAdý;

    @FXML
    private TableColumn<KargoDetay, String> gAdres;

    @FXML
    private TableColumn<KargoDetay, String> aAdý;

    @FXML
    private TableColumn<KargoDetay, String> aAdres;

    @FXML
    private TableColumn<KargoDetay, String> Urun;

    @FXML
    private TableColumn<KargoDetay, String> Ucret;

    @FXML
    private TableColumn<KargoDetay, String> Durum;

    @FXML
    private TableColumn<KargoDetay, String> Yer;
    @FXML
    private TableColumn<KargoDetay, String> sehýr;
    
    ObservableList<KargoDetay> veriler;

    @FXML
    void initialize() {
sorgu="select*from kargodetay";
    	
    	try {
			sorguPreparedStatement=baglantiConnection.prepareStatement(sorgu);
			
			getirilenResultSet=sorguPreparedStatement.executeQuery();
			
			veriler=FXCollections.observableArrayList();
			
			while(getirilenResultSet.next()) {
				veriler.add(new KargoDetay(getirilenResultSet.getInt("id"), getirilenResultSet.getInt("faturaNo"), 
						getirilenResultSet.getString("gAdi"),getirilenResultSet.getString("gAdres"),getirilenResultSet.getString("aAdi"),
						getirilenResultSet.getString("aAdres"),getirilenResultSet.getString("urun"), getirilenResultSet.getString("ucret"),
						getirilenResultSet.getString("durum"), getirilenResultSet.getString("yer"), getirilenResultSet.getString("sehir")));
			}
			
			ID.setCellValueFactory(new PropertyValueFactory<>("id"));
			FaturaNo.setCellValueFactory(new PropertyValueFactory<>("faturano"));
			gAdý.setCellValueFactory(new PropertyValueFactory<>("gadi"));
			gAdres.setCellValueFactory(new PropertyValueFactory<>("gadres"));
			aAdý.setCellValueFactory(new PropertyValueFactory<>("aadi"));
			aAdres.setCellValueFactory(new PropertyValueFactory<>("aadres"));
			Urun.setCellValueFactory(new PropertyValueFactory<>("urun"));
			Ucret.setCellValueFactory(new PropertyValueFactory<>("ucret"));
			Durum.setCellValueFactory(new PropertyValueFactory<>("durum"));
			Yer.setCellValueFactory(new PropertyValueFactory<>("yer"));
			sehýr.setCellValueFactory(new PropertyValueFactory<>("sehir"));
			
			tableKargoNerede.setItems(veriler);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       
    	ID.setVisible(true);

    }
}
