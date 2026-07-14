package kontrol;

public class KayitKontrol {
	
	private String hakLisans;
	private String hakAd, hakSoyad, hakKlasman, hakKulAd, hakSifre;
	
	public KayitKontrol(String hakLisans, String hakAd, String hakSoyad, String hakKlasman, String hakKulAd, String hakSifre) {
		this.hakLisans=hakLisans;
		this.hakAd=hakAd;
		this.hakSoyad=hakSoyad;
		this.hakKlasman=hakKlasman;
		this.hakKulAd=hakKulAd;
		this.hakSifre=hakSifre;
	}

	public String getHakLisans() {
		return hakLisans;
	}

	public void setHakLisans(String hakLisans) {
		this.hakLisans = hakLisans;
	}

	public String getHakAd() {
		return hakAd;
	}

	public void setHakAd(String hakAd) {
		this.hakAd = hakAd;
	}

	public String getHakSoyad() {
		return hakSoyad;
	}

	public void setHakSoyad(String hakSoyad) {
		this.hakSoyad = hakSoyad;
	}

	public String getHakKlasman() {
		return hakKlasman;
	}

	public void setHakKlasman(String hakKlasman) {
		this.hakKlasman = hakKlasman;
	}
	
	public String getHakKulAd() {
		return hakKulAd;
	}

	public void setHakKulAd(String hakKulAd) {
		this.hakKulAd = hakKulAd;
	}

	public String getHakSifre() {
		return hakSifre;
	}

	public void setHakSifre(String hakSifre) {
		this.hakSifre = hakSifre;
	}
	
	public boolean bosKontrolu(){
		if(String.valueOf(hakLisans).isEmpty() || hakAd.isEmpty() || hakSoyad.isEmpty() || hakKlasman.isEmpty() || hakKulAd.isEmpty() || hakSifre.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public int adKontrolu() {
		char[] hakAdKontrol=hakAd.toCharArray();
		int sayi=0;
		for(int i:hakAdKontrol) {
			if(Character.isDigit(i)) {
				sayi++;
			}
		}
		if(sayi>0) {
			return 1;
		}else {
			if(hakAdKontrol.length>35) {
				return 2;
			}else {
				if(hakAdKontrol.length<2) {
					return 4;
				}else {
					return 3;
				}
			}
		}
	}
	
	public int soyadKontrolu() {
		char[] hakSoyadKontrol=hakSoyad.toCharArray();
		int sayi=0;
		int bosluk=0;
		for(char i:hakSoyadKontrol) {
			if(Character.isDigit(i)) {
				sayi++;
			}
			if(i==' ') {
				bosluk++;
			}
		}
		if(bosluk>1) {
			return 1;
		}else{
			if(sayi>0) {
				return 2;
			}else {
				if(hakSoyadKontrol.length>35) {
					return 3;
				}else {
					if(hakSoyadKontrol.length<2) {
						return 5;
					}else {
						return 4;
					}
				}
			}
		}
	}
	
	public String kullaniciAdiKontrolu() {
		char[] hakKulAdKontrol=hakKulAd.toCharArray();
		char[] harfler="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_.".toCharArray();
		int gecerli=0;
		int harf=0;
		int bosluk=0;
		int buyukHarf=0;
		for (char i:hakKulAdKontrol){
			if(i==' ') {
				bosluk++;
			}
			if(Character.isLetter(i)) {
				harf++;
			}
			if(Character.isUpperCase(i)) {
				buyukHarf++;
			}
			for(char j:harfler) {
				if(i==j) {
					gecerli++;
					break;
				}
			}
		}
		if(bosluk>0) {
			return "boşluk";
		}else {
			if(harf==0) {
				return "harf";
			}else {
				if(hakKulAdKontrol.length>24) {
					return "uzun";
				}else {
					if(buyukHarf>0) {
						return "büyük harf";
					}else {
						if(hakKulAdKontrol.length<2) {
							return "kısa";
						}else {
							if(gecerli!=hakKulAdKontrol.length) {
								return "geçersiz";
							}else {
								return "";	
							}
						}
					}
				}
			}
		}
	}
	
	public String sifreKontrolu() {
		char[] hakSifreKontrol=hakSifre.toCharArray();
		char[] harfler="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_.*".toCharArray();
		int gecerli=0;
		int harf=0;
		int kucukHarf=0;
		int buyukHarf=0;
		int sayi=0;
		int bosluk=0;
		for (char i:hakSifreKontrol){
			if(i==' ') {
				bosluk++;
			}
			if(Character.isDigit(i)) {
				sayi++;
			}
			if(Character.isLetter(i)) {
				harf++;
			}
			if(Character.isLowerCase(i)) {
				kucukHarf++;
			}
			if(Character.isUpperCase(i)) {
				buyukHarf++;
			}
			for(char j:harfler) {
				if(i==j) {
					gecerli++;
					break;
				}
			}
		}
		if(bosluk>0) {
			return "boşluk";
		}else {
			if(sayi==0) {
				return "sayı";
			}else {
				if(harf==0) {
					return "harf";
				}else {
					if(kucukHarf==0) {
						return "küçük harf";
					}else {
						if(buyukHarf==0) {
							return "büyük harf";
						}else {
							if(hakSifreKontrol.length<6) {
								return "kısa";
							}else {
								if(hakSifreKontrol.length>18) {
									return "uzun";
								}else {
									if(gecerli!=hakSifreKontrol.length) {
										return "geçersiz";
									}else{
										return "";
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public int lisansKontrolu() {
		char[] hakLisansKontrol=hakLisans.toCharArray();
		int harf=0;
		int bosluk=0;
		for (char i:hakLisansKontrol){
			if(Character.isLetter(i)) {
				harf++;
			}
			if(i==' ') {
				bosluk++;
			}
		}
		if(bosluk>0) {
			return 1;
		}else{
			if(harf>0) {
				return 2;
			}else {
				if(hakLisansKontrol.length>6) {
					return 5;
				}
				else{
					if(Integer.parseInt(hakLisans)<1000) {
						return 3;
					}else {
						return 4;
					}
					
				}
			}
		}
	}
	

}
