package refmember;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sql.Goster;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profil extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Profil(Main frame, String kulAd) {
		setPreferredSize(new Dimension(1000,750));
		setDoubleBuffered(true);
		setLayout(null);
		setBounds(0, 0, 1000, 750);
		setBackground(new Color(194,161,94));
		
		JLabel baslik = new JLabel("HAKEM PROFİLİ");
		baslik.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(10, 100, 980, 70);
		add(baslik);
		
		JLabel kisisel = new JLabel("KİŞİSEL BİLGİLER");
		kisisel.setForeground(new Color(255, 255, 0));
		kisisel.setHorizontalAlignment(SwingConstants.CENTER);
		kisisel.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		kisisel.setBounds(10, 194, 485, 70);
		add(kisisel);
		
		JLabel sinav = new JLabel("SINAV BİLGİLERİ");
		sinav.setHorizontalAlignment(SwingConstants.CENTER);
		sinav.setForeground(new Color(0, 255, 255));
		sinav.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		sinav.setBounds(505, 194, 485, 70);
		add(sinav);
		
		JLabel hakAd = new JLabel("Ad: ");
		hakAd.setHorizontalAlignment(SwingConstants.CENTER);
		hakAd.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		hakAd.setBounds(10, 290, 485, 35);
		add(hakAd);
		
		JLabel hakSoyad = new JLabel("Soyad: ");
		hakSoyad.setHorizontalAlignment(SwingConstants.CENTER);
		hakSoyad.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		hakSoyad.setBounds(10, 335, 485, 35);
		add(hakSoyad);
		
		JLabel hakKlasman = new JLabel("Klasman: ");
		hakKlasman.setHorizontalAlignment(SwingConstants.CENTER);
		hakKlasman.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		hakKlasman.setBounds(10, 380, 485, 35);
		add(hakKlasman);
		
		JLabel hakLisans = new JLabel("Lisans No: ");
		hakLisans.setHorizontalAlignment(SwingConstants.CENTER);
		hakLisans.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		hakLisans.setBounds(10, 425, 485, 35);
		add(hakLisans);
		
		JLabel hakDogru = new JLabel("Doğru Sayısı: ");
		hakDogru.setForeground(new Color(0, 255, 0));
		hakDogru.setHorizontalAlignment(SwingConstants.CENTER);
		hakDogru.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		hakDogru.setBounds(505, 290, 485, 35);
		add(hakDogru);
		
		JLabel hakYanlis = new JLabel("Yanlış Sayısı: ");
		hakYanlis.setForeground(new Color(255, 0, 0));
		hakYanlis.setHorizontalAlignment(SwingConstants.CENTER);
		hakYanlis.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		hakYanlis.setBounds(505, 335, 485, 35);
		add(hakYanlis);
		
		JLabel hakBos = new JLabel("Boş Sayısı: ");
		hakBos.setForeground(new Color(255, 255, 255));
		hakBos.setHorizontalAlignment(SwingConstants.CENTER);
		hakBos.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		hakBos.setBounds(505, 380, 485, 35);
		add(hakBos);
		
		JLabel hakPerformans = new JLabel("Performans: ");
		hakPerformans.setForeground(new Color(0, 255, 255));
		hakPerformans.setHorizontalAlignment(SwingConstants.CENTER);
		hakPerformans.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		hakPerformans.setBounds(505, 425, 485, 35);
		add(hakPerformans);
		
		JLabel hakKulAd = new JLabel(kulAd);
		hakKulAd.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		hakKulAd.setHorizontalAlignment(SwingConstants.CENTER);
		hakKulAd.setBounds(375, 94, 250, 21);
		add(hakKulAd);
		
		JButton donus = new JButton("<- Ana Sayfaya Dön");
		donus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.degistir(new AnaSayfa(frame, kulAd));
			}
		});
		donus.setForeground(new Color(0, 0, 0));
		donus.setFont(new Font("Tahoma", Font.BOLD, 20));
		donus.setBackground(Color.WHITE);
		donus.setBounds(375, 594, 250, 42);
		add(donus);
		
		JLabel yz = new JLabel("Hakemin Gireceği Bir Sonraki Sınava Dair Yapay Zekâ'nın Puan Tahmini: ");
		yz.setHorizontalAlignment(SwingConstants.CENTER);
		yz.setForeground(new Color(0, 0, 255));
		yz.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		yz.setBounds(47, 494, 900, 55);
		add(yz);
		
		JButton cikis = new JButton("Çıkış Yap");
		cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.degistir(new KaydolGir(frame));
			}
		});
		cikis.setForeground(new Color(255, 255, 255));
		cikis.setFont(new Font("Tahoma", Font.BOLD, 20));
		cikis.setBackground(new Color(255, 0, 0));
		cikis.setBounds(375, 646, 250, 42);
		add(cikis);
		
		Goster goster=new Goster(kulAd);
		String bilgiler[]=goster.bilgiler();
		hakAd.setText(hakAd.getText()+bilgiler[0]);
		hakSoyad.setText(hakSoyad.getText()+bilgiler[1]);
		hakKlasman.setText(hakKlasman.getText()+bilgiler[2]);
		hakLisans.setText(hakLisans.getText()+bilgiler[3]);
		hakDogru.setText(hakDogru.getText()+bilgiler[4]);
		hakYanlis.setText(hakYanlis.getText()+bilgiler[5]);
		hakBos.setText(hakBos.getText()+bilgiler[6]);
		if(bilgiler[7].equals("Yok.")) {
			hakPerformans.setText(hakPerformans.getText()+bilgiler[7]);
		}else {
			hakPerformans.setText(hakPerformans.getText()+"%"+bilgiler[7]);
		}
		
		try {
			Tahmin tahmin=new Tahmin();
			if(bilgiler[7].equals("Yok.")) {
				yz.setText("Elde veri olmadığından, gelecek sınav hakkında Yapay Zekâ tahmini henüz yok.");
			}else {
				int sinavSayisi=((Integer.parseInt(bilgiler[4]))+(Integer.parseInt(bilgiler[5]))+(Integer.parseInt(bilgiler[6])))/20;
				int ortDogru=(int) Math.round((double)Integer.parseInt(bilgiler[4])/sinavSayisi);
				int ortYanlis=(int) Math.round((double)Integer.parseInt(bilgiler[5])/sinavSayisi);
				int ortBos=(int) Math.round((double)Integer.parseInt(bilgiler[6])/sinavSayisi);
				String yzBaglanti=tahmin.puanTahmini(ortDogru, ortYanlis, ortBos, ortDogru*5);
				String yzTahmin="";
				int i=10;
				while(Character.isDigit(yzBaglanti.charAt(i))) {
					yzTahmin+=yzBaglanti.charAt(i);
					i++;
				}
				if(Integer.parseInt(yzTahmin)<0) {
					yzTahmin="0";
				}else if(Integer.parseInt(yzTahmin)>100) {
					yzTahmin="100";
				}
				if((Integer.parseInt(yzTahmin)%5)==0) {
					yz.setText(yz.getText()+yzTahmin);
				}else {
					int altSinir=Integer.parseInt(yzTahmin) - (Integer.parseInt(yzTahmin) % 5);
					int ustSinir=altSinir + 5;
					yz.setText(yz.getText()+altSinir+"-"+ustSinir);
				}
			}
		}catch(Exception e) {
			yz.setText("Uvicorn terminali devre dışı olduğundan Yapay Zekâ bağlantısı başarısız oldu.");
		}
	}

}
