package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Goster {
	private String hakKulAd;
	private int kurNo;
	
	public Goster(String hakKulAd) {
		this.hakKulAd=hakKulAd;
	}
	
	public Goster(int kurNo) {
		this.kurNo=kurNo;
	}
	
	public Goster() {}
	
	public String[] bilgiler() {
		String dizi[]=new String[8];
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
				String hakAd=sonuc.getString("hakAd");
				String hakSoyad=sonuc.getString("hakSoyad");
				String hakKlasman=sonuc.getString("hakKlasman");
				String hakLisans=String.valueOf(sonuc.getInt("hakLisans"));
				String hakDogru=sonuc.getString("hakDogru");
				String hakYanlis=sonuc.getString("hakYanlis");
				String hakBos=sonuc.getString("hakBos");
				String hakPerformans=sonuc.getString("hakPerformans");
				dizi=new String[]{hakAd,hakSoyad,hakKlasman,hakLisans,hakDogru,hakYanlis,hakBos,hakPerformans};
				return dizi;
			}else {
				return new String[] {"Sorun oluştu!"};
			}
		}catch(Exception e) {
			return new String[] {};
		}
	}
	
	public String[] kurallar() {
		String dizi[]=new String[4];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://HOSTNAME:PORTNO/DATABASENAME?autoReconnect=true&useSSL=false"
					+"&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"DBUSERNAME",
					"DBPASSWORD");
			*/
			String sqlSorgu="SELECT * FROM kural WHERE kurNo=?";
			PreparedStatement ps=baglanti.prepareStatement(sqlSorgu);
			ps.setInt(1, kurNo);
			ResultSet sonuc=ps.executeQuery();
			if(sonuc.next()) {
				String kurFoto=sonuc.getString("kurFoto");
				String kurAciklama=sonuc.getString("kurAciklama");
				int kurIlkSayfa=sonuc.getInt("kurIlkSayfa");
				int kurSonSayfa=sonuc.getInt("kurSonSayfa");
				dizi=new String[]{kurFoto,kurAciklama,String.valueOf(kurIlkSayfa),String.valueOf(kurSonSayfa)};
				return dizi;
			}else {
				return new String[] {"Sorun oluştu!"};
			}
		}catch(Exception e) {
			return new String[] {};
		}
	}
	
	public List<List<String>> sözlük() {
		List<List<String>> sözlük=new ArrayList<>();
		List<String> kavramlar=new ArrayList<>();
		List<String> tanımlar=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://HOSTNAME:PORTNO/DATABASENAME?autoReconnect=true&useSSL=false"
					+"&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"DBUSERNAME",
					"DBPASSWORD");
			*/
			String sqlSorgu="SELECT * FROM sozluk";
			PreparedStatement ps=baglanti.prepareStatement(sqlSorgu);
			ResultSet sonuc=ps.executeQuery();
			while(sonuc.next()) {
				String kavram=sonuc.getString("sozKavram");
				kavramlar.add(kavram);
				String tanım=sonuc.getString("sozTanım");
				tanımlar.add(tanım);
			}
		}catch(Exception e) {
			
		}
		sözlük.add(kavramlar);
		sözlük.add(tanımlar);
		return sözlük;
	}
	
	public List<List<String>> dySoru() {
		List<List<String>> soruCevap=new ArrayList<>();
		List<String> sorular=new ArrayList<>();
		List<String> cevaplar=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://HOSTNAME:PORTNO/DATABASENAME?autoReconnect=true&useSSL=false"
					+"&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"DBUSERNAME",
					"DBPASSWORD");
			*/
			String sqlSorgu="SELECT * FROM dysoru ORDER BY rand() LIMIT 20";
			PreparedStatement ps=baglanti.prepareStatement(sqlSorgu);
			ResultSet sonuc=ps.executeQuery();
			while(sonuc.next()) {
				sorular.add(sonuc.getString("dySoru"));
				cevaplar.add(sonuc.getString("dyCevap"));
			}
		}catch(Exception e) {
			
		}
		soruCevap.add(sorular);
		soruCevap.add(cevaplar);
		return soruCevap;
	}
}
