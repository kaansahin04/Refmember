package refmember;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

import org.mindrot.jbcrypt.BCrypt;

import kontrol.GirisKontrol;
import kontrol.KayitKontrol;
import sql.Ekle;
import sql.Gir;
import javax.swing.JToggleButton;

public class KaydolGir extends JPanel {

	private static final long serialVersionUID = 1L;
	Image image, image2;
	private JTextField hakAd;
	private JTextField hakSoyad;
	private JTextField hakLisans;
	private JTextField hakKulAd;
	private JPasswordField hakSifre;
	private JTextField hakKulAd2;
	private JPasswordField hakSifre2;
	private JTextField hakSifreGor;
	private JTextField hakSifreGor2;
	private JToggleButton sifreGor;
	private JToggleButton sifreGor2;

	/**
	 * Create the panel.
	 */
	public KaydolGir(Main frame) {
		setPreferredSize(new Dimension(1000,750));
		setDoubleBuffered(true);
		setLayout(null);
		setBounds(0, 0, 1000, 750);
		
		image=new ImageIcon(getClass().getClassLoader().getResource("kaydolgir.jpg")).getImage();
		
		JLabel baslik = new JLabel("REFMEMBER");
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setFont(new Font("Eras Bold ITC", Font.BOLD, 70));
		baslik.setForeground(new Color(255, 255, 0));
		baslik.setBounds(250, 50, 500, 100);
		add(baslik);
		
		JLabel kaansahin = new JLabel("Kaan ŞAHİN - İstanbul Nişantaşı Üniversitesi, Bilgisayar Mühendisliği Öğrencisi");
		kaansahin.setForeground(new Color(255, 255, 255));
		kaansahin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		kaansahin.setBounds(35, 660, 715, 35);
		add(kaansahin);
		
		JLabel duduk = new JLabel();
		image2=new ImageIcon(getClass().getClassLoader().getResource("düdük.png")).getImage();
		add(duduk);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 155, 385, 450);
		panel.setLayout(null);
		panel.setOpaque(false);
		add(panel);
		
		JLabel hesapYoksa = new JLabel("Hesabın Yoksa");
		hesapYoksa.setBounds(105, 20, 200, 50);
		panel.add(hesapYoksa);
		hesapYoksa.setForeground(new Color(255, 255, 255));
		hesapYoksa.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel hesapYoksa2 = new JLabel("___________________");
		hesapYoksa2.setBounds(55, 30, 250, 50);
		panel.add(hesapYoksa2);
		hesapYoksa2.setForeground(new Color(255, 0, 0));
		hesapYoksa2.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel ad = new JLabel("Ad:");
		ad.setBounds(15, 70, 150, 50);
		panel.add(ad);
		ad.setBackground(new Color(240, 240, 240));
		ad.setHorizontalAlignment(SwingConstants.TRAILING);
		ad.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel soyad = new JLabel("Soyad:");
		soyad.setBounds(15, 120, 150, 50);
		panel.add(soyad);
		soyad.setHorizontalAlignment(SwingConstants.TRAILING);
		soyad.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel klasman = new JLabel("Klasman:");
		klasman.setBounds(15, 170, 150, 50);
		panel.add(klasman);
		klasman.setHorizontalAlignment(SwingConstants.TRAILING);
		klasman.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel lisansno = new JLabel("Lisans No:");
		lisansno.setBounds(15, 220, 150, 50);
		panel.add(lisansno);
		lisansno.setHorizontalAlignment(SwingConstants.TRAILING);
		lisansno.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel kullaniciadi = new JLabel("Kullanıcı Adı:");
		kullaniciadi.setBounds(15, 270, 150, 50);
		panel.add(kullaniciadi);
		kullaniciadi.setHorizontalAlignment(SwingConstants.TRAILING);
		kullaniciadi.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel sifre = new JLabel("Şifre:");
		sifre.setBounds(15, 320, 150, 50);
		panel.add(sifre);
		sifre.setHorizontalAlignment(SwingConstants.TRAILING);
		sifre.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		hakAd = new JTextField();
		hakAd.setBounds(194, 80, 150, 30);
		panel.add(hakAd);
		hakAd.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		hakAd.setColumns(10);
		
		hakSoyad = new JTextField();
		hakSoyad.setBounds(194, 130, 150, 30);
		panel.add(hakSoyad);
		hakSoyad.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		hakSoyad.setColumns(10);
		
		hakLisans = new JTextField();
		hakLisans.setBounds(194, 230, 150, 30);
		panel.add(hakLisans);
		hakLisans.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		hakLisans.setColumns(10);
		
		hakKulAd = new JTextField();
		hakKulAd.setBounds(194, 280, 150, 30);
		panel.add(hakKulAd);
		hakKulAd.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		hakKulAd.setColumns(10);
		
		JComboBox<String> hakKlasman = new JComboBox<String>();
		hakKlasman.setBounds(194, 180, 150, 30);
		panel.add(hakKlasman);
		hakKlasman.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		hakKlasman.setModel(new DefaultComboBoxModel<String>(new String[] {"AH", "İH", "BH", "KBH", "BYH", "KBYH"}));
		
		hakSifre = new JPasswordField();
		hakSifre.setBounds(194, 330, 150, 30);
		panel.add(hakSifre);
		hakSifre.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		JButton kaydol = new JButton("Kaydol");
		kaydol.setBounds(94, 380, 175, 35);
		panel.add(kaydol);
		kaydol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kayitAd=hakAd.getText().trim();
				String kayitSoyad=hakSoyad.getText().trim();
				String kayitKlasman=hakKlasman.getSelectedItem().toString();
				String kayitLisans=hakLisans.getText().trim();
				String kayitKulAd=hakKulAd.getText().trim();
				String sifreToString="";
				if(sifreGor.isSelected()) {
					sifreToString=hakSifreGor.getText();
				}else {
					char[] sifreAl = hakSifre.getPassword();
					sifreToString = new String(sifreAl);
				}
				String kayitSifre=BCrypt.hashpw(sifreToString, BCrypt.gensalt());
				KayitKontrol kayit=new KayitKontrol(kayitLisans, kayitAd, kayitSoyad, kayitKlasman, kayitKulAd, sifreToString);
				//boş alan kontrolü
				if(kayit.bosKontrolu()==true) {
					
					//ad, sayı içeriyor mu ya da 35'ten uzun mu kontrolü
					if(kayit.adKontrolu()==1) {
						JOptionPane.showMessageDialog(frame, "Adınız sayı içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kayit.adKontrolu()==2) {
						JOptionPane.showMessageDialog(frame, "Ad çok uzun.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kayit.adKontrolu()==4) {
						JOptionPane.showMessageDialog(frame, "Ad çok kısa.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kayit.adKontrolu()==3) {
						
						//soyad, 2 boşluk veya sayı içeriyor mu ya da 35'ten uzun mu kontrolü
						if(kayit.soyadKontrolu()==1) {
							JOptionPane.showMessageDialog(frame, "Soyad en fazla 2 tane olabilir.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kayit.soyadKontrolu()==2) {
							JOptionPane.showMessageDialog(frame, "Soyadınız sayı içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kayit.soyadKontrolu()==3) {
							JOptionPane.showMessageDialog(frame, "Soyad çok uzun.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kayit.soyadKontrolu()==5) {
							JOptionPane.showMessageDialog(frame, "Soyad çok kısa.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kayit.soyadKontrolu()==4) {
								
							//kullanıcı adı kontrolü
							if(kayit.kullaniciAdiKontrolu()=="boşluk") {
								JOptionPane.showMessageDialog(frame, "Kullanıcı adı boşluk içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
							}else if(kayit.kullaniciAdiKontrolu()=="harf") {
								JOptionPane.showMessageDialog(frame, "Kullanıcı adınız harf içermelidir.", "Hata!", JOptionPane.ERROR_MESSAGE);
							}else if(kayit.kullaniciAdiKontrolu()=="uzun") {
								JOptionPane.showMessageDialog(frame, "Kullanıcı adı çok uzun.", "Hata!", JOptionPane.ERROR_MESSAGE);
							}else if(kayit.kullaniciAdiKontrolu()=="büyük harf") {
								JOptionPane.showMessageDialog(frame, "Kullanıcı adı büyük harf içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
							}else if(kayit.kullaniciAdiKontrolu()=="kısa") {
								JOptionPane.showMessageDialog(frame, "Kullanıcı adı çok kısa.", "Hata!", JOptionPane.ERROR_MESSAGE);
							}else if(kayit.kullaniciAdiKontrolu()=="geçersiz") {
								JOptionPane.showMessageDialog(frame, "Kullanıcı adında geçersiz karakter girdiniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
							}else if(kayit.kullaniciAdiKontrolu()=="") {

								//şifre kontrolü
								if(kayit.sifreKontrolu()=="boşluk") {
									JOptionPane.showMessageDialog(frame, "Şifre boşluk içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kayit.sifreKontrolu()=="sayı") {
									JOptionPane.showMessageDialog(frame, "Şifre sayı içermelidir.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kayit.sifreKontrolu()=="harf") {
									JOptionPane.showMessageDialog(frame, "Şifre harf içermelidir.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kayit.sifreKontrolu()=="küçük harf") {
									JOptionPane.showMessageDialog(frame, "Şifre küçük harf içermelidir.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kayit.sifreKontrolu()=="büyük harf") {
									JOptionPane.showMessageDialog(frame, "Şifre büyük harf içermelidir.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kayit.sifreKontrolu()=="kısa") {
									JOptionPane.showMessageDialog(frame, "Şifre en az 6 haneli olmalıdır.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kayit.sifreKontrolu()=="uzun") {
									JOptionPane.showMessageDialog(frame, "Şifre en fazla 18 haneli olabilir.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kayit.sifreKontrolu()=="geçersiz") {
									JOptionPane.showMessageDialog(frame, "Şifrede geçersiz karakter girdiniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kayit.sifreKontrolu()=="") {

									//lisans kontrolü
									if(kayit.lisansKontrolu()==1) {
										JOptionPane.showMessageDialog(frame, "Lisans numarası boşluk içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
									}else if(kayit.lisansKontrolu()==2) {
										JOptionPane.showMessageDialog(frame, "Lisans numarası harf içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
									}else if(kayit.lisansKontrolu()==5) {
										JOptionPane.showMessageDialog(frame, "Lisans numarası en fazla 6 haneli olabilir.", "Hata!", JOptionPane.ERROR_MESSAGE);
									}else if(kayit.lisansKontrolu()==3) {
										JOptionPane.showMessageDialog(frame, "Lisans numarası 1000'den küçük olamaz.", "Hata!", JOptionPane.ERROR_MESSAGE);
									}else if(kayit.lisansKontrolu()==4) {
									
										//sql bağlantısı için kullan
										Ekle ekle=new Ekle(Integer.parseInt(kayitLisans), kayitAd, kayitSoyad, kayitKlasman, kayitKulAd, kayitSifre, 0, 0, 0, "Yok.");
										ekle.sorgulaEkle();
										
										hakAd.setText("");
										hakSoyad.setText("");
										hakKlasman.setSelectedIndex(0);
										hakLisans.setText("");
										hakKulAd.setText("");
										hakSifre.setText("");
									}
								}
							}
						}
					}
				}else {
					JOptionPane.showMessageDialog(frame, "Boş alan bıraktınız.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		kaydol.setBackground(new Color(255, 255, 255));
		kaydol.setForeground(new Color(255, 0, 0));
		kaydol.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		hakSifreGor = new JTextField();
		hakSifreGor.setBounds(194, 330, 150, 30);
		panel.add(hakSifreGor);
		hakSifreGor.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		hakSifreGor.setColumns(10);
		
		sifreGor = new JToggleButton();
		sifreGor.setBounds(349, 332, 26, 26);
		panel.add(sifreGor);
		sifreGor.setIcon(new ImageIcon(getClass().getClassLoader().getResource("şifre göster.jpg")));
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(400, 294, 370, 194);
		panel2.setLayout(null);
		panel2.setOpaque(false);
		add(panel2);
		
		JLabel hesapVarsa2 = new JLabel("___________________");
		hesapVarsa2.setBounds(25, 16, 250, 50);
		panel2.add(hesapVarsa2);
		hesapVarsa2.setForeground(new Color(3, 230, 241));
		hesapVarsa2.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel hesapVarsa = new JLabel("Hesabın Varsa");
		hesapVarsa.setBounds(35, 6, 200, 50);
		panel2.add(hesapVarsa);
		hesapVarsa.setForeground(new Color(255, 255, 255));
		hesapVarsa.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		JLabel kullaniciadi2 = new JLabel("Kullanıcı Adı:");
		kullaniciadi2.setBounds(25, 66, 150, 50);
		panel2.add(kullaniciadi2);
		kullaniciadi2.setHorizontalAlignment(SwingConstants.TRAILING);
		kullaniciadi2.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		hakKulAd2 = new JTextField();
		hakKulAd2.setBounds(179, 76, 150, 30);
		panel2.add(hakKulAd2);
		hakKulAd2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		hakKulAd2.setColumns(10);
		
		JLabel sifre2 = new JLabel("Şifre:");
		sifre2.setBounds(25, 116, 150, 50);
		panel2.add(sifre2);
		sifre2.setHorizontalAlignment(SwingConstants.TRAILING);
		sifre2.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		
		hakSifre2 = new JPasswordField();
		hakSifre2.setBounds(179, 126, 150, 30);
		panel2.add(hakSifre2);
		hakSifre2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		hakSifreGor2 = new JTextField();
		hakSifreGor2.setBounds(179, 126, 150, 30);
		panel2.add(hakSifreGor2);
		hakSifreGor2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		hakSifreGor2.setColumns(10);
		
		sifreGor2 = new JToggleButton();
		sifreGor2.setBounds(334, 128, 26, 26);
		panel2.add(sifreGor2);
		sifreGor2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("şifre göster.jpg")));
		sifreGor2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if(sifreGor2.isSelected()) {
					sifreGor2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("şifre gizle.jpg")));
					hakSifre2.setVisible(false);
					hakSifreGor2.setText(new String(hakSifre2.getPassword()));
					hakSifreGor2.setVisible(true);
				}else {
					sifreGor2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("şifre göster.jpg")));
					hakSifre2.setText(hakSifreGor2.getText());
					hakSifre2.setVisible(true);
					hakSifreGor2.setVisible(false);
				}
			}
		});
		hakSifreGor2.setVisible(false);
		sifreGor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if(sifreGor.isSelected()) {
					sifreGor.setIcon(new ImageIcon(getClass().getClassLoader().getResource("şifre gizle.jpg")));
					hakSifre.setVisible(false);
					hakSifreGor.setText(new String(hakSifre.getPassword()));
					hakSifreGor.setVisible(true);
				}else {
					sifreGor.setIcon(new ImageIcon(getClass().getClassLoader().getResource("şifre göster.jpg")));
					hakSifre.setText(hakSifreGor.getText());
					hakSifre.setVisible(true);
					hakSifreGor.setVisible(false);
				}
			}
		});
		hakSifreGor.setVisible(false);
		
		JButton girisyap = new JButton("Giriş Yap");
		girisyap.setForeground(new Color(255, 255, 255));
		girisyap.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		girisyap.setBackground(new Color(3, 230, 241));
		girisyap.setBounds(781, 392, 175, 35);
		girisyap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hakKulAd=hakKulAd2.getText().trim();
				String hakSifre="";
				if(sifreGor2.isSelected()) {
					hakSifre=hakSifreGor2.getText();
				}else {
					char[] sifreAl=hakSifre2.getPassword();
					hakSifre=new String(sifreAl);
				}
				GirisKontrol giris=new GirisKontrol(hakKulAd, hakSifre);
				
				//boş alan kontrolü
				if(giris.bosKontrolu()==true) {
					JOptionPane.showMessageDialog(frame, "Boş alan bıraktınız.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}else {
					Gir gir=new Gir(hakKulAd);
					String hashSifre=gir.sifreAl();
					if(hashSifre.equals("Kullanıcı Yok!")) {
						JOptionPane.showMessageDialog(frame, "Bu kullanıcı adına sahip bir kayıt yok.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(hashSifre.equals("Exception")) {
						
					}else {
						if(BCrypt.checkpw(hakSifre, hashSifre)) {
							frame.degistir(new AnaSayfa(frame, hakKulAd));
						}else {
							JOptionPane.showMessageDialog(frame, "Kullanıcı adı ve şifre eşleşmedi.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		add(girisyap);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,1000,750,null);
		g.drawImage(image2,167,67,70,70,null);
	}
}
