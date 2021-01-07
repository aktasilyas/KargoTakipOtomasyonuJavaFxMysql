package application;

public class KargoKayitlar {
	
	private int  faturaNo;
	private String gondericiTc;
	private String AliciTc;
	private String gondericiİsim;
	private String Alıcıİsim;
	private String gondericiTel;
	private String AlıcıTel;
	private String Urun;
	private int  Adet;
	private int  Agırlık;
	private int  Fiyat;
	private int  ID;
	public KargoKayitlar() {
		super();
	}
	public KargoKayitlar(int faturaNo, String gondericiTc, String aliciTc, String gondericiİsim, String alıcıİsim,
			String gondericiTel, String alıcıTel, String urun, int adet, int agırlık,int ID,int Fiyat) {
		super();
		this.faturaNo = faturaNo;
		this.gondericiTc = gondericiTc;
		AliciTc = aliciTc;
		this.gondericiİsim = gondericiİsim;
		Alıcıİsim = alıcıİsim;
		this.gondericiTel = gondericiTel;
		AlıcıTel = alıcıTel;
		Urun = urun;
		Adet = adet;
		Agırlık = agırlık;
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
	public String getGondericiİsim() {
		return gondericiİsim;
	}
	public void setGondericiİsim(String gondericiİsim) {
		this.gondericiİsim = gondericiİsim;
	}
	public String getAlıcıİsim() {
		return Alıcıİsim;
	}
	public void setAlıcıİsim(String alıcıİsim) {
		Alıcıİsim = alıcıİsim;
	}
	public String getGondericiTel() {
		return gondericiTel;
	}
	public void setGondericiTel(String gondericiTel) {
		this.gondericiTel = gondericiTel;
	}
	public String getAlıcıTel() {
		return AlıcıTel;
	}
	public void setAlıcıTel(String alıcıTel) {
		AlıcıTel = alıcıTel;
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
	public int getAgırlık() {
		return Agırlık;
	}
	public void setAgırlık(int agırlık) {
		Agırlık = agırlık;
	}

}
