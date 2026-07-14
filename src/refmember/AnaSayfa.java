package refmember;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AnaSayfa extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image;
	private Image image2;

	/**
	 * Create the panel.
	 */
	public AnaSayfa(Main frame, String kulAd) {
		setPreferredSize(new Dimension(1000,750));
		setDoubleBuffered(true);
		setLayout(null);
		setBounds(0, 0, 1000, 750);
		
		image=new ImageIcon(getClass().getClassLoader().getResource("anasayfa.jpg")).getImage();
		
		JLabel kurallar = new JLabel();
		kurallar.setBounds(2, 2, 300, 450);
		kurallar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("kurallar.jpg")));
		kurallar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				kurallar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent me) {
				frame.degistir(new Kurallar(frame, kulAd));
			}
		});
		
		JPanel panel=new JPanel();
		panel.setBounds(58,218,304,454);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		add(panel);
		panel.add(kurallar);
		
		JLabel baslik = new JLabel("REFMEMBER");
		baslik.setFont(new Font("Eras Bold ITC", Font.BOLD, 47));
		baslik.setForeground(new Color(255, 255, 0));
		baslik.setBounds(25, 15, 325, 70);
		add(baslik);
		
		JLabel slogan = new JLabel("Sahada Otorite Sensin!");
		slogan.setFont(new Font("Eras Bold ITC", Font.BOLD, 24));
		slogan.setForeground(new Color(255, 255, 0));
		slogan.setBounds(25, 70, 350, 47);
		add(slogan);
		
		JButton test = new JButton("Kendini Test Et");
		test.setBackground(new Color(255, 255, 255));
		test.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		test.setBounds(570, 525, 304, 47);
		add(test);
		
		JButton sinav = new JButton("Kural Sınavı Simülasyonu");
		sinav.setBackground(new Color(255, 255, 255));
		sinav.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		sinav.setBounds(570, 594, 304, 47);
		sinav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.degistir(new Sinav(frame, kulAd));
			}
		});
		add(sinav);

		image2=new ImageIcon(getClass().getClassLoader().getResource("hakem profil.png")).getImage();
		
		JLabel label = new JLabel();
		label.setBackground(new Color(194, 161, 94));
		label.setBounds(870, 35, 94, 104);
		label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent me) {
				frame.degistir(new Profil(frame, kulAd));
			}
		});
		add(label);
		
		JLabel profil = new JLabel("Profil");
		profil.setHorizontalAlignment(SwingConstants.CENTER);
		profil.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		profil.setBounds(870, 110, 94, 24);
		add(profil);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,1000,750,null);
		g.setColor(new Color(194,161,94));
		g.fillRect(870, 35, 94, 104);
		g.drawImage(image2,880,40,74,70,null);
	}
}
