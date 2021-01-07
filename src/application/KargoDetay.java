package application;

public class KargoDetay {
	private int id;
	private int faturano;
	private String gadi;
	private String gadres;
	private String aadi;
	private String aadres;
	private String urun;
	private String ucret;
	private String durum;
	private String yer;
	private String sehir;
	public String getGadi() {
		return gadi;
	}
	public void setGadi(String gadi) {
		this.gadi = gadi;
	}
	public String getGadres() {
		return gadres;
	}
	public void setGadres(String gadres) {
		this.gadres = gadres;
	}
	public String getAadi() {
		return aadi;
	}
	public void setAadi(String aadi) {
		this.aadi = aadi;
	}
	public String getAadres() {
		return aadres;
	}
	public void setAadres(String aadres) {
		this.aadres = aadres;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public KargoDetay(int id, int faturano,String gadi, String gadres, String aadi, String aadres, String urun, String ucret, String durum, String yer,String sehir) {
		super();
		this.id = id;
		this.faturano = faturano;
		this.gadi = gadi;
		this.gadres = gadres;
		this.aadi = aadi;
		this.aadres = aadres;
		this.urun = urun;
		this.ucret = ucret;
		this.durum = durum;
		this.yer = yer;
		this.sehir = sehir;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFaturano() {
		return faturano;
	}
	public void setFaturano(int faturano) {
		this.faturano = faturano;
	}
	public String getUrun() {
		return urun;
	}
	public void setUrun(String urun) {
		this.urun = urun;
	}
	public String getUcret() {
		return ucret;
	}
	public void setUcret(String ucret) {
		this.ucret = ucret;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	public String getYer() {
		return yer;
	}
	public void setYer(String yer) {
		this.yer = yer;
	}

}
