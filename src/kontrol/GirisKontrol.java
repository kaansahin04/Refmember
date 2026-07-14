package kontrol;

public class GirisKontrol {
	private String hakKulAd, hakSifre;
	
	public GirisKontrol(String hakKulAd, String hakSifre) {
		this.hakKulAd=hakKulAd;
		this.hakSifre=hakSifre;
	}
	
	public boolean bosKontrolu() {
		if(hakKulAd.isEmpty() || hakSifre.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
