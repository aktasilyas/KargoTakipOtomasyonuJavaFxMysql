package application;

public class KargoKayitlar {
	
	private int  faturaNo;
	private String gondericiTc;
	private String AliciTc;
	private String gonderici�sim;
	private String Al�c��sim;
	private String gondericiTel;
	private String Al�c�Tel;
	private String Urun;
	private int  Adet;
	private int  Ag�rl�k;
	private int  Fiyat;
	private int  ID;
	public KargoKayitlar() {
		super();
	}
	public KargoKayitlar(int faturaNo, String gondericiTc, String aliciTc, String gonderici�sim, String al�c��sim,
			String gondericiTel, String al�c�Tel, String urun, int adet, int ag�rl�k,int ID,int Fiyat) {
		super();
		this.faturaNo = faturaNo;
		this.gondericiTc = gondericiTc;
		AliciTc = aliciTc;
		this.gonderici�sim = gonderici�sim;
		Al�c��sim = al�c��sim;
		this.gondericiTel = gondericiTel;
		Al�c�Tel = al�c�Tel;
		Urun = urun;
		Adet = adet;
		Ag�rl�k = ag�rl�k;
		this.Fiyat=Fiyat;
		this.ID=ID;
	}
	public int getFiyat() {
		return Fiyat;
	}
	public void setFiyat(int fiyat) {
		Fiyat = fiyat;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getFaturaNo() {
		return faturaNo;
	}
	public void setFaturaNo(int faturaNo) {
		this.faturaNo = faturaNo;
	}
	public String getGondericiTc() {
		return gondericiTc;
	}
	public void setGondericiTc(String gondericiTc) {
		this.gondericiTc = gondericiTc;
	}
	public String getAliciTc() {
		return AliciTc;
	}
	public void setAliciTc(String aliciTc) {
		AliciTc = aliciTc;
	}
	public String getGonderici�sim() {
		return gonderici�sim;
	}
	public void setGonderici�sim(String gonderici�sim) {
		this.gonderici�sim = gonderici�sim;
	}
	public String getAl�c��sim() {
		return Al�c��sim;
	}
	public void setAl�c��sim(String al�c��sim) {
		Al�c��sim = al�c��sim;
	}
	public String getGondericiTel() {
		return gondericiTel;
	}
	public void setGondericiTel(String gondericiTel) {
		this.gondericiTel = gondericiTel;
	}
	public String getAl�c�Tel() {
		return Al�c�Tel;
	}
	public void setAl�c�Tel(String al�c�Tel) {
		Al�c�Tel = al�c�Tel;
	}
	public String getUrun() {
		return Urun;
	}
	public void setUrun(String urun) {
		Urun = urun;
	}
	public int getAdet() {
		return Adet;
	}
	public void setAdet(int adet) {
		Adet = adet;
	}
	public int getAg�rl�k() {
		return Ag�rl�k;
	}
	public void setAg�rl�k(int ag�rl�k) {
		Ag�rl�k = ag�rl�k;
	}

}
