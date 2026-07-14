package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Ekle {
	private int hakLisans, hakDogru, hakYanlis, hakBos;
	private String hakAd, hakSoyad, hakKlasman, hakKulAd, hakSifre, hakPerformans;
	
	public Ekle(int hakLisans, String hakAd, String hakSoyad, String hakKlasman, String hakKulAd, String hakSifre, int hakDogru, int hakYanlis, int hakBos, String hakPerformans) {
		this.hakLisans=hakLisans;
		this.hakAd=hakAd;
		this.hakSoyad=hakSoyad;
		this.hakKlasman=hakKlasman;
		this.hakKulAd=hakKulAd;
		this.hakSifre=hakSifre;
		this.hakDogru=hakDogru;
		this.hakYanlis=hakYanlis;
		this.hakBos=hakBos;
		this.hakPerformans=hakPerformans;
	}
	
	public Ekle() {}
	
	public void sorgulaEkle() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://HOSTNAME:PORTNO/DATABASENAME?autoReconnect=true&useSSL=false"
					+"&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"DBUSERNAME",
					"DBPASSWORD");
			*/
			String sqlSorgu="SELECT * FROM hakem WHERE hakKulAd=?";
			PreparedStatement ps=baglanti.prepareStatement(sqlSorgu);
			ps.setString(1, hakKulAd);
			ResultSet sonuc=ps.executeQuery();
			if(sonuc.next()) {
				JOptionPane.showMessageDialog(null, "Bu kullanıcı adında bir hakem zaten var.", "Hata!", JOptionPane.ERROR_MESSAGE);
			}else {
				String sqlSorgu2="SELECT * FROM hakem WHERE hakLisans=?";
				PreparedStatement ps2=baglanti.prepareStatement(sqlSorgu2);
				ps2.setInt(1, hakLisans);
				ResultSet sonuc2=ps2.executeQuery();
				if(sonuc2.next()) {
					JOptionPane.showMessageDialog(null, "Bu lisans numarasına sahip bir hakem zaten var.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}else {
					String sqlSorgu3="INSERT INTO hakem VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement ps3=baglanti.prepareStatement(sqlSorgu3);
					ps3.setString(1, hakAd);
					ps3.setString(2, hakSoyad);
					ps3.setString(3, hakKulAd);
					ps3.setString(4, hakSifre);
					ps3.setString(5, hakKlasman);
					ps3.setInt(6, hakLisans);
					ps3.setInt(7, hakDogru);
					ps3.setInt(8, hakYanlis);
					ps3.setInt(9, hakBos);
					ps3.setString(10, hakPerformans);
					int sonuc3=ps3.executeUpdate();
					if(sonuc3==1) {
						JOptionPane.showMessageDialog(null, "Hakem kaydınız başarıyla sisteme eklendi.", "İşlem başarılı!", JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Kaydınız sisteme eklenemedi.", "İşlem başarısız!", JOptionPane.ERROR_MESSAGE);
					}
					ps3.close();
				}
				ps2.close();
			}
			ps.close();
			baglanti.close();
		}catch(Exception e) {
			
		}
	}
	
	public void performans(int hakDogru, int hakYanlis, int hakBos, int hakLisans) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://HOSTNAME:PORTNO/DATABASENAME?autoReconnect=true&useSSL=false"
					+"&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"DBUSERNAME",
					"DBPASSWORD");
			*/
			String sqlSorgu="SELECT * FROM hakem WHERE hakLisans=?";
			PreparedStatement ps=baglanti.prepareStatement(sqlSorgu);
			ps.setInt(1, hakLisans);
			ResultSet sonuc=ps.executeQuery();
			if(sonuc.next()) {
				String sqlSorgu2="UPDATE hakem SET hakDogru=hakDogru+?, hakYanlis=hakYanlis+?, hakBos=hakBos+?, hakPerformans=ROUND((hakDogru)*100.0/(hakDogru+hakYanlis+hakBos)) WHERE hakLisans=?";
				PreparedStatement ps2=baglanti.prepareStatement(sqlSorgu2);
				ps2.setInt(1, hakDogru);
				ps2.setInt(2, hakYanlis);
				ps2.setInt(3, hakBos);
				ps2.setInt(4, hakLisans);
				ps2.executeUpdate();
				ps2.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
