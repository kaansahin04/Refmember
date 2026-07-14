package refmember;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sql.Goster;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Kurallar extends JPanel {

	private static final long serialVersionUID = 1L;
	private int sayfaSayisi=1;

	/**
	 * Create the panel.
	 */
	public Kurallar(Main frame, String kulAd) {
		setPreferredSize(new Dimension(1000,750));
		setDoubleBuffered(true);
		setLayout(null);
		setBounds(0,0,1000,750);
		setBackground(new Color(194,161,94));
		
		JPanel ekran=new JPanel();
		ekran.setBounds(32,32,926,616);
		ekran.setLayout(null);
		ekran.setBackground(Color.WHITE);
		add(ekran);
		
		JLabel baslik = new JLabel("IFAB OYUN KURALLARI 25/26");
		baslik.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		baslik.setForeground(new Color(0, 128, 0));
		baslik.setBounds(22, 10, 894, 75);
		ekran.add(baslik);
		
		JTextArea kurAciklama = new JTextArea();
		kurAciklama.setWrapStyleWord(true);
		kurAciklama.setLineWrap(true);
		kurAciklama.setFont(new Font("Calibri", Font.PLAIN, 13));
		kurAciklama.setText("Futbol, dünyadaki en büyük spordur ve oyuna adalet getiren kurallara sahip olmalıdır. Kurallar aynı zamanda oyuncuların güvenliğine ve refahına da katkıda bulunmalıdır. Hakemler, adil ve güvenli bir maç ortamı sağlamak için bu kuralları oyunun ruhu kapsamında uygulamalıdır.\r\n\r\nBu bölüm; futbolun amatör seviyesinde hakemlik yapanların, oyun kurallarına çalışarak futbolu daha iyi kavraması için ve hem sınavlarda hem de müsabakalarda daha başarılı olabilmesi için düzenlenmiştir.\r\n\r\nIFAB'ın güncel \"Oyun Kuralları\" kitapçığına tamamen paralel olarak hazırlanan bu bölümde, kitapçığın tamamı değil ama geniş bir özeti sunularak bir hakemin bilmesi ve dikkat etmesi gereken önemli noktalar vurgulanmıştır.\r\n\r\nFutbolun 17 kuralı anlatıldıktan sonra en son sayfada \"Terimler Sözlüğü\" yer almaktadır. Bu sözlük, açıklığa kavuşturulması veya detaylı izah edilmesi gereken ve/veya diğer dillere kolayca tercüme edilemeyen kelimeleri/ifadeleri kapsar.\r\n\r\nAmatör futbolun ruhunu yaşayan hakemlerimize iyi okumalar...");
		kurAciklama.setEditable(false);
		kurAciklama.setBounds(345, 94, 575, 555);
		ekran.add(kurAciklama);
		
		JLabel kurFoto = new JLabel();
		kurFoto.setBounds(10, 94, 320, 480);
		kurFoto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("kurallar.jpg")));
		ekran.add(kurFoto);
		
		JLabel detay = new JLabel("");
		detay.setVerticalAlignment(SwingConstants.BOTTOM);
		detay.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		detay.setBounds(15, 571, 313, 34);
		ekran.add(detay);
		
		JButton donus = new JButton("<- Ana Sayfaya Dön");
		donus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.degistir(new AnaSayfa(frame, kulAd));
			}
		});
		donus.setBackground(new Color(255, 255, 255));
		donus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		donus.setForeground(new Color(194, 161, 94));
		donus.setBounds(32, 658, 257, 42);
		add(donus);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 161, 94));
		panel.setBounds(400, 654, 200, 54);
		panel.setLayout(null);
		add(panel);
		
		JLabel sayfa = new JLabel(String.valueOf(sayfaSayisi)+"/19");
		sayfa.setForeground(new Color(255, 255, 255));
		sayfa.setFont(new Font("Tahoma", Font.BOLD, 18));
		sayfa.setHorizontalAlignment(SwingConstants.CENTER);
		sayfa.setBounds(54, 15, 92, 24);
		panel.add(sayfa);
		
		JButton oncekiSayfa = new JButton("<");
		oncekiSayfa.addActionListener(new ActionListener() {
			Goster goster;
			String[] kural;
			String[] aciklama;
			public void actionPerformed(ActionEvent e) {
				if(sayfaSayisi>2) {
					sayfaSayisi-=1;
					goster=new Goster(sayfaSayisi-1);
					kural=goster.kurallar();
					kurFoto.setIcon(new ImageIcon(getClass().getClassLoader().getResource(kural[0])));
					aciklama=kural[1].split("_");
					kurAciklama.setText("");
					for(int i=1; i<aciklama.length-1; i++) {
						kurAciklama.setText(kurAciklama.getText()+aciklama[i]+"\r\n\r\n");
					}
					kurAciklama.setText(kurAciklama.getText()+aciklama[aciklama.length-1]);
					baslik.setText((sayfaSayisi-1)+") "+aciklama[0].toUpperCase());
					detay.setText("Detaylı bilgi için: IFAB Oyun Kuralları kitabı, sayfa "+kural[2]+"-"+kural[3]+".");
					sayfa.setText(String.valueOf(sayfaSayisi)+"/19");
				}else if(sayfaSayisi==2) {
					kurFoto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("kurallar.jpg")));
					sayfaSayisi-=1;
					kurAciklama.setText("Futbol, dünyadaki en büyük spordur ve oyuna adalet getiren kurallara sahip olmalıdır. Kurallar aynı zamanda oyuncuların güvenliğine ve refahına da katkıda bulunmalıdır. Hakemler, adil ve güvenli bir maç ortamı sağlamak için bu kuralları oyunun ruhu kapsamında uygulamalıdır.\r\n\r\nBu bölüm; futbolun amatör seviyesinde hakemlik yapanların, oyun kurallarına çalışarak futbolu daha iyi kavraması için ve hem sınavlarda hem de müsabakalarda daha başarılı olabilmesi için düzenlenmiştir.\r\n\r\nIFAB'ın güncel \"Oyun Kuralları\" kitapçığına tamamen paralel olarak hazırlanan bu bölümde, kitapçığın tamamı değil ama geniş bir özeti sunularak bir hakemin bilmesi ve dikkat etmesi gereken önemli noktalar vurgulanmıştır.\r\n\r\nFutbolun 17 kuralı anlatıldıktan sonra en son sayfada \"Terimler Sözlüğü\" yer almaktadır. Bu sözlük, açıklığa kavuşturulması veya detaylı izah edilmesi gereken ve/veya diğer dillere kolayca tercüme edilemeyen kelimeleri/ifadeleri kapsar.\r\n\r\nAmatör futbolun ruhunu yaşayan hakemlerimize iyi okumalar...");
					baslik.setText("IFAB OYUN KURALLARI 25/26");
					detay.setText("");
					sayfa.setText(String.valueOf(sayfaSayisi)+"/19");
				}
			}
		});
		oncekiSayfa.setForeground(new Color(194, 161, 94));
		oncekiSayfa.setBackground(new Color(255, 255, 255));
		oncekiSayfa.setFont(new Font("Wide Latin", Font.PLAIN, 13));
		oncekiSayfa.setBounds(7, 7, 40, 40);
		panel.add(oncekiSayfa);
		
		JButton sonrakiSayfa = new JButton(">");
		sonrakiSayfa.addActionListener(new ActionListener() {
			Goster goster;
			String[] kural;
			String[] aciklama;
			public void actionPerformed(ActionEvent e) {
				if(sayfaSayisi<18) {
					sayfaSayisi+=1;
					goster=new Goster(sayfaSayisi-1);
					kural=goster.kurallar();
					kurFoto.setIcon(new ImageIcon(getClass().getClassLoader().getResource(kural[0])));
					aciklama=kural[1].split("_");
					kurAciklama.setText("");
					for(int i=1; i<aciklama.length-1; i++) {
						kurAciklama.setText(kurAciklama.getText()+aciklama[i]+"\r\n\r\n");
					}
					kurAciklama.setText(kurAciklama.getText()+aciklama[aciklama.length-1]);
					baslik.setText((sayfaSayisi-1)+") "+aciklama[0].toUpperCase());
					detay.setText("Detaylı bilgi için: IFAB Oyun Kuralları kitabı, sayfa "+kural[2]+"-"+kural[3]+".");
					sayfa.setText(String.valueOf(sayfaSayisi)+"/19");
				}else if(sayfaSayisi==18) {
					List<List<String>> sözlük=new ArrayList<>();
					goster=new Goster();
					sözlük=goster.sözlük();
					kurFoto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("sözlük.jpg")));
					sayfaSayisi+=1;
					kurAciklama.setText("");
					for(int i=0; i<sözlük.get(0).size()-1; i++) {
						kurAciklama.setText(kurAciklama.getText()+sözlük.get(0).get(i)+": "+sözlük.get(1).get(i)+"\r\n\r\n");
					}
					kurAciklama.setText(kurAciklama.getText()+sözlük.get(0).get(sözlük.get(0).size()-1)+": "+sözlük.get(1).get(sözlük.get(0).size()-1));
					baslik.setText("TERİMLER SÖZLÜĞÜ");
					detay.setText("");
					sayfa.setText(String.valueOf(sayfaSayisi)+"/19");
				}
			}
		});
		sonrakiSayfa.setBackground(new Color(255, 255, 255));
		sonrakiSayfa.setForeground(new Color(194, 161, 94));
		sonrakiSayfa.setFont(new Font("Wide Latin", Font.PLAIN, 13));
		sonrakiSayfa.setBounds(156, 7, 40, 40);
		panel.add(sonrakiSayfa);
	}
}
