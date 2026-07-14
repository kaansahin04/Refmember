package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Gir {
	private String hakKulAd;
	
	public Gir(String hakKulAd) {
		this.hakKulAd=hakKulAd;
	}
	
	public String sifreAl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://HOSTNAME:PORTNO/DATABASENAME?autoReconnect=true&useSSL=false"
					+"&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"DBUSERNAME",
					"DBPASSWORD");
			*/
			String sqlSorgu="SELECT hakSifre FROM hakem WHERE hakKulAd=?";
			PreparedStatement ps=baglanti.prepareStatement(sqlSorgu);
			ps.setString(1, hakKulAd);
			ResultSet sonuc=ps.executeQuery();
			if(sonuc.next()) {
				return sonuc.getString("hakSifre");
			}else {
				return "Kullanıcı Yok!";
			}
		}catch(Exception e) {
			return "Exception";
		}
	}
}
