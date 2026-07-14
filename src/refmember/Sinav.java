package refmember;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import sql.Ekle;
import sql.Goster;

import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class Sinav extends JPanel {

	private static final long serialVersionUID = 1L;
	private Cursor kalem=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getClassLoader().getResource("kalem.png")).getImage(), new Point(0,0), "kalem");
	private Color bitRenk;
	
	/**
	 * Create the panel.
	 */
	public Sinav(Main frame, String kulAd) {
		setPreferredSize(new Dimension(1000,750));
		setDoubleBuffered(true);
		setLayout(null);
		setBounds(0, 0, 1000, 750);
		setBackground(new Color(204,194,161));
		setCursor(kalem);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(265, 35, 470, 660);
		panel.setLayout(null);
		add(panel);
		
		JLabel baslik = new JLabel("HAKEMLİK KURAL SINAVI SİMÜLASYONU");
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setFont(new Font("Tahoma", Font.BOLD, 18));
		baslik.setBounds(35, 20, 394, 22);
		panel.add(baslik);
		
		JLabel aciklama = new JLabel("Bu sınavda toplam 20 soru olup her biri 5 puan değerindedir.");
		aciklama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aciklama.setHorizontalAlignment(SwingConstants.CENTER);
		aciklama.setBounds(10, 42, 450, 22);
		panel.add(aciklama);
		
		JLabel ad = new JLabel("");
		ad.setFont(new Font("Tahoma", Font.ITALIC, 13));
		ad.setBounds(35, 79, 394, 23);
		panel.add(ad);
		
		JLabel soyad = new JLabel("");
		soyad.setFont(new Font("Tahoma", Font.ITALIC, 13));
		soyad.setBounds(35, 94, 394, 23);
		panel.add(soyad);
		
		JLabel lisans = new JLabel("");
		lisans.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lisans.setBounds(35, 109, 394, 23);
		panel.add(lisans);
		
		Goster gosterHakem=new Goster(kulAd);
		ad.setText("Ad: "+gosterHakem.bilgiler()[0]);
		soyad.setText("Soyad: "+gosterHakem.bilgiler()[1]);
		lisans.setText("Lisans No: "+gosterHakem.bilgiler()[3]);
		
		
		JTextArea soru1 = new JTextArea();
		soru1.setLineWrap(true);
		soru1.setWrapStyleWord(true);
		soru1.setEditable(false);
		soru1.setText("1) ");
		soru1.setFont(new Font("Arial", Font.BOLD, 11));
		soru1.setBounds(10, 147, 394, 42);
		panel.add(soru1);
		
		JTextArea soru2 = new JTextArea();
		soru2.setWrapStyleWord(true);
		soru2.setText("2) ");
		soru2.setLineWrap(true);
		soru2.setFont(new Font("Arial", Font.BOLD, 11));
		soru2.setEditable(false);
		soru2.setBounds(10, 194, 394, 42);
		panel.add(soru2);
		
		JTextArea soru3 = new JTextArea();
		soru3.setWrapStyleWord(true);
		soru3.setText("3) ");
		soru3.setLineWrap(true);
		soru3.setFont(new Font("Arial", Font.BOLD, 11));
		soru3.setEditable(false);
		soru3.setBounds(10, 241, 394, 42);
		panel.add(soru3);
		
		JTextArea soru4 = new JTextArea();
		soru4.setWrapStyleWord(true);
		soru4.setText("4) ");
		soru4.setLineWrap(true);
		soru4.setFont(new Font("Arial", Font.BOLD, 11));
		soru4.setEditable(false);
		soru4.setBounds(10, 288, 394, 42);
		panel.add(soru4);
		
		JTextArea soru5 = new JTextArea();
		soru5.setWrapStyleWord(true);
		soru5.setText("5) ");
		soru5.setLineWrap(true);
		soru5.setFont(new Font("Arial", Font.BOLD, 11));
		soru5.setEditable(false);
		soru5.setBounds(10, 335, 394, 42);
		panel.add(soru5);
		
		JTextArea soru6 = new JTextArea();
		soru6.setWrapStyleWord(true);
		soru6.setText("6) ");
		soru6.setLineWrap(true);
		soru6.setFont(new Font("Arial", Font.BOLD, 11));
		soru6.setEditable(false);
		soru6.setBounds(10, 382, 394, 42);
		panel.add(soru6);
		
		JTextArea soru7 = new JTextArea();
		soru7.setWrapStyleWord(true);
		soru7.setText("7) ");
		soru7.setLineWrap(true);
		soru7.setFont(new Font("Arial", Font.BOLD, 11));
		soru7.setEditable(false);
		soru7.setBounds(10, 429, 394, 42);
		panel.add(soru7);
		
		JTextArea soru8 = new JTextArea();
		soru8.setWrapStyleWord(true);
		soru8.setText("8) ");
		soru8.setLineWrap(true);
		soru8.setFont(new Font("Arial", Font.BOLD, 11));
		soru8.setEditable(false);
		soru8.setBounds(10, 476, 394, 42);
		panel.add(soru8);
		
		JTextArea soru9 = new JTextArea();
		soru9.setWrapStyleWord(true);
		soru9.setText("9) ");
		soru9.setLineWrap(true);
		soru9.setFont(new Font("Arial", Font.BOLD, 11));
		soru9.setEditable(false);
		soru9.setBounds(10, 523, 394, 42);
		panel.add(soru9);
		
		JTextArea soru10 = new JTextArea();
		soru10.setWrapStyleWord(true);
		soru10.setText("10) ");
		soru10.setLineWrap(true);
		soru10.setFont(new Font("Arial", Font.BOLD, 11));
		soru10.setEditable(false);
		soru10.setBounds(10, 570, 394, 42);
		panel.add(soru10);
		
		JToggleButton d1 = new JToggleButton("");
		d1.setBackground(new Color(255, 255, 255));
		d1.setBounds(405, 150, 32, 32);
		d1.setOpaque(false);
		panel.add(d1);
		
		JToggleButton y1 = new JToggleButton("");
		y1.setBackground(new Color(255, 255, 255));
		y1.setBounds(437, 150, 32, 32);
		y1.setOpaque(false);
		panel.add(y1);
		
		JLabel dd1 = new JLabel("D");
		dd1.setVerticalAlignment(SwingConstants.BOTTOM);
		dd1.setHorizontalAlignment(SwingConstants.CENTER);
		dd1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd1.setBounds(408, 154, 24, 24);
		panel.add(dd1);
		
		JLabel yy1 = new JLabel("Y");
		yy1.setVerticalAlignment(SwingConstants.BOTTOM);
		yy1.setHorizontalAlignment(SwingConstants.CENTER);
		yy1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy1.setBounds(440, 154, 24, 24);
		panel.add(yy1);
		
		JToggleButton d2 = new JToggleButton("");
		d2.setOpaque(false);
		d2.setBackground(Color.WHITE);
		d2.setBounds(405, 197, 32, 32);
		panel.add(d2);
		
		JToggleButton y2 = new JToggleButton("");
		y2.setOpaque(false);
		y2.setBackground(Color.WHITE);
		y2.setBounds(437, 197, 32, 32);
		panel.add(y2);
		
		JLabel dd2 = new JLabel("D");
		dd2.setVerticalAlignment(SwingConstants.BOTTOM);
		dd2.setHorizontalAlignment(SwingConstants.CENTER);
		dd2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd2.setBounds(408, 201, 24, 24);
		panel.add(dd2);
		
		JLabel yy2 = new JLabel("Y");
		yy2.setVerticalAlignment(SwingConstants.BOTTOM);
		yy2.setHorizontalAlignment(SwingConstants.CENTER);
		yy2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy2.setBounds(440, 201, 24, 24);
		panel.add(yy2);
		
		JToggleButton d3 = new JToggleButton("");
		d3.setOpaque(false);
		d3.setBackground(Color.WHITE);
		d3.setBounds(405, 244, 32, 32);
		panel.add(d3);
		
		JToggleButton y3 = new JToggleButton("");
		y3.setOpaque(false);
		y3.setBackground(Color.WHITE);
		y3.setBounds(437, 244, 32, 32);
		panel.add(y3);
		
		JLabel dd3 = new JLabel("D");
		dd3.setVerticalAlignment(SwingConstants.BOTTOM);
		dd3.setHorizontalAlignment(SwingConstants.CENTER);
		dd3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd3.setBounds(408, 248, 24, 24);
		panel.add(dd3);
		
		JLabel yy3 = new JLabel("Y");
		yy3.setVerticalAlignment(SwingConstants.BOTTOM);
		yy3.setHorizontalAlignment(SwingConstants.CENTER);
		yy3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy3.setBounds(440, 248, 24, 24);
		panel.add(yy3);
		
		JToggleButton d4 = new JToggleButton("");
		d4.setOpaque(false);
		d4.setBackground(Color.WHITE);
		d4.setBounds(405, 291, 32, 32);
		panel.add(d4);
		
		JToggleButton y4 = new JToggleButton("");
		y4.setOpaque(false);
		y4.setBackground(Color.WHITE);
		y4.setBounds(437, 291, 32, 32);
		panel.add(y4);
		
		JLabel dd4 = new JLabel("D");
		dd4.setVerticalAlignment(SwingConstants.BOTTOM);
		dd4.setHorizontalAlignment(SwingConstants.CENTER);
		dd4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd4.setBounds(408, 295, 24, 24);
		panel.add(dd4);
		
		JLabel yy4 = new JLabel("Y");
		yy4.setVerticalAlignment(SwingConstants.BOTTOM);
		yy4.setHorizontalAlignment(SwingConstants.CENTER);
		yy4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy4.setBounds(440, 295, 24, 24);
		panel.add(yy4);
		
		JToggleButton d5 = new JToggleButton("");
		d5.setOpaque(false);
		d5.setBackground(Color.WHITE);
		d5.setBounds(405, 338, 32, 32);
		panel.add(d5);
		
		JToggleButton y5 = new JToggleButton("");
		y5.setOpaque(false);
		y5.setBackground(Color.WHITE);
		y5.setBounds(437, 338, 32, 32);
		panel.add(y5);
		
		JLabel dd5 = new JLabel("D");
		dd5.setVerticalAlignment(SwingConstants.BOTTOM);
		dd5.setHorizontalAlignment(SwingConstants.CENTER);
		dd5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd5.setBounds(408, 342, 24, 24);
		panel.add(dd5);
		
		JLabel yy5 = new JLabel("Y");
		yy5.setVerticalAlignment(SwingConstants.BOTTOM);
		yy5.setHorizontalAlignment(SwingConstants.CENTER);
		yy5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy5.setBounds(440, 342, 24, 24);
		panel.add(yy5);
		
		JToggleButton d6 = new JToggleButton("");
		d6.setOpaque(false);
		d6.setBackground(Color.WHITE);
		d6.setBounds(405, 385, 32, 32);
		panel.add(d6);
		
		JToggleButton y6 = new JToggleButton("");
		y6.setOpaque(false);
		y6.setBackground(Color.WHITE);
		y6.setBounds(437, 385, 32, 32);
		panel.add(y6);
		
		JLabel dd6 = new JLabel("D");
		dd6.setVerticalAlignment(SwingConstants.BOTTOM);
		dd6.setHorizontalAlignment(SwingConstants.CENTER);
		dd6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd6.setBounds(408, 389, 24, 24);
		panel.add(dd6);
		
		JLabel yy6 = new JLabel("Y");
		yy6.setVerticalAlignment(SwingConstants.BOTTOM);
		yy6.setHorizontalAlignment(SwingConstants.CENTER);
		yy6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy6.setBounds(440, 389, 24, 24);
		panel.add(yy6);
		
		JToggleButton d7 = new JToggleButton("");
		d7.setOpaque(false);
		d7.setBackground(Color.WHITE);
		d7.setBounds(405, 432, 32, 32);
		panel.add(d7);
		
		JToggleButton y7 = new JToggleButton("");
		y7.setOpaque(false);
		y7.setBackground(Color.WHITE);
		y7.setBounds(437, 432, 32, 32);
		panel.add(y7);
		
		JLabel dd7 = new JLabel("D");
		dd7.setVerticalAlignment(SwingConstants.BOTTOM);
		dd7.setHorizontalAlignment(SwingConstants.CENTER);
		dd7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd7.setBounds(408, 436, 24, 24);
		panel.add(dd7);
		
		JLabel yy7 = new JLabel("Y");
		yy7.setVerticalAlignment(SwingConstants.BOTTOM);
		yy7.setHorizontalAlignment(SwingConstants.CENTER);
		yy7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy7.setBounds(440, 436, 24, 24);
		panel.add(yy7);
		
		JToggleButton d8 = new JToggleButton("");
		d8.setOpaque(false);
		d8.setBackground(Color.WHITE);
		d8.setBounds(405, 479, 32, 32);
		panel.add(d8);
		
		JToggleButton y8 = new JToggleButton("");
		y8.setOpaque(false);
		y8.setBackground(Color.WHITE);
		y8.setBounds(437, 479, 32, 32);
		panel.add(y8);
		
		JLabel dd8 = new JLabel("D");
		dd8.setVerticalAlignment(SwingConstants.BOTTOM);
		dd8.setHorizontalAlignment(SwingConstants.CENTER);
		dd8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd8.setBounds(408, 483, 24, 24);
		panel.add(dd8);
		
		JLabel yy8 = new JLabel("Y");
		yy8.setVerticalAlignment(SwingConstants.BOTTOM);
		yy8.setHorizontalAlignment(SwingConstants.CENTER);
		yy8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy8.setBounds(440, 483, 24, 24);
		panel.add(yy8);
		
		JToggleButton d9 = new JToggleButton("");
		d9.setOpaque(false);
		d9.setBackground(Color.WHITE);
		d9.setBounds(405, 526, 32, 32);
		panel.add(d9);
		
		JToggleButton y9 = new JToggleButton("");
		y9.setOpaque(false);
		y9.setBackground(Color.WHITE);
		y9.setBounds(437, 526, 32, 32);
		panel.add(y9);
		
		JLabel dd9 = new JLabel("D");
		dd9.setVerticalAlignment(SwingConstants.BOTTOM);
		dd9.setHorizontalAlignment(SwingConstants.CENTER);
		dd9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd9.setBounds(408, 530, 24, 24);
		panel.add(dd9);
		
		JLabel yy9 = new JLabel("Y");
		yy9.setVerticalAlignment(SwingConstants.BOTTOM);
		yy9.setHorizontalAlignment(SwingConstants.CENTER);
		yy9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy9.setBounds(440, 530, 24, 24);
		panel.add(yy9);
		
		JToggleButton d10 = new JToggleButton("");
		d10.setOpaque(false);
		d10.setBackground(Color.WHITE);
		d10.setBounds(405, 573, 32, 32);
		panel.add(d10);
		
		JToggleButton y10 = new JToggleButton("");
		y10.setOpaque(false);
		y10.setBackground(Color.WHITE);
		y10.setBounds(437, 573, 32, 32);
		panel.add(y10);
		
		JLabel dd10 = new JLabel("D");
		dd10.setVerticalAlignment(SwingConstants.BOTTOM);
		dd10.setHorizontalAlignment(SwingConstants.CENTER);
		dd10.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd10.setBounds(408, 577, 24, 24);
		panel.add(dd10);
		
		JLabel yy10 = new JLabel("Y");
		yy10.setVerticalAlignment(SwingConstants.BOTTOM);
		yy10.setHorizontalAlignment(SwingConstants.CENTER);
		yy10.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy10.setBounds(440, 577, 24, 24);
		panel.add(yy10);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(265, 35, 470, 660);
		panel2.setVisible(false);
		add(panel2);
		
		JLabel aciklama2 = new JLabel("Sınava giren tüm hakemlerimize başarılar...");
		aciklama2.setHorizontalAlignment(SwingConstants.CENTER);
		aciklama2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aciklama2.setBounds(10, 550, 450, 22);
		panel2.add(aciklama2);
		
		JTextArea soru11 = new JTextArea();
		soru11.setWrapStyleWord(true);
		soru11.setText("11) ");
		soru11.setLineWrap(true);
		soru11.setFont(new Font("Arial", Font.BOLD, 11));
		soru11.setEditable(false);
		soru11.setBounds(10, 47, 394, 42);
		panel2.add(soru11);
		
		JTextArea soru12 = new JTextArea();
		soru12.setWrapStyleWord(true);
		soru12.setText("12) ");
		soru12.setLineWrap(true);
		soru12.setFont(new Font("Arial", Font.BOLD, 11));
		soru12.setEditable(false);
		soru12.setBounds(10, 94, 394, 42);
		panel2.add(soru12);
		
		JTextArea soru13 = new JTextArea();
		soru13.setWrapStyleWord(true);
		soru13.setText("13) ");
		soru13.setLineWrap(true);
		soru13.setFont(new Font("Arial", Font.BOLD, 11));
		soru13.setEditable(false);
		soru13.setBounds(10, 141, 394, 42);
		panel2.add(soru13);
		
		JTextArea soru14 = new JTextArea();
		soru14.setWrapStyleWord(true);
		soru14.setText("14) ");
		soru14.setLineWrap(true);
		soru14.setFont(new Font("Arial", Font.BOLD, 11));
		soru14.setEditable(false);
		soru14.setBounds(10, 188, 394, 42);
		panel2.add(soru14);
		
		JTextArea soru15 = new JTextArea();
		soru15.setWrapStyleWord(true);
		soru15.setText("15) ");
		soru15.setLineWrap(true);
		soru15.setFont(new Font("Arial", Font.BOLD, 11));
		soru15.setEditable(false);
		soru15.setBounds(10, 235, 394, 42);
		panel2.add(soru15);
		
		JTextArea soru16 = new JTextArea();
		soru16.setWrapStyleWord(true);
		soru16.setText("16) ");
		soru16.setLineWrap(true);
		soru16.setFont(new Font("Arial", Font.BOLD, 11));
		soru16.setEditable(false);
		soru16.setBounds(10, 282, 394, 42);
		panel2.add(soru16);
		
		JTextArea soru17 = new JTextArea();
		soru17.setWrapStyleWord(true);
		soru17.setText("17) ");
		soru17.setLineWrap(true);
		soru17.setFont(new Font("Arial", Font.BOLD, 11));
		soru17.setEditable(false);
		soru17.setBounds(10, 329, 394, 42);
		panel2.add(soru17);
		
		JTextArea soru18 = new JTextArea();
		soru18.setWrapStyleWord(true);
		soru18.setText("18) ");
		soru18.setLineWrap(true);
		soru18.setFont(new Font("Arial", Font.BOLD, 11));
		soru18.setEditable(false);
		soru18.setBounds(10, 376, 394, 42);
		panel2.add(soru18);
		
		JTextArea soru19 = new JTextArea();
		soru19.setWrapStyleWord(true);
		soru19.setText("19) ");
		soru19.setLineWrap(true);
		soru19.setFont(new Font("Arial", Font.BOLD, 11));
		soru19.setEditable(false);
		soru19.setBounds(10, 423, 394, 42);
		panel2.add(soru19);
		
		JTextArea soru20 = new JTextArea();
		soru20.setWrapStyleWord(true);
		soru20.setText("20) ");
		soru20.setLineWrap(true);
		soru20.setFont(new Font("Arial", Font.BOLD, 11));
		soru20.setEditable(false);
		soru20.setBounds(10, 470, 394, 42);
		panel2.add(soru20);
		
		JToggleButton d11 = new JToggleButton("");
		d11.setOpaque(false);
		d11.setBackground(Color.WHITE);
		d11.setBounds(405, 50, 32, 32);
		panel2.add(d11);
		
		JToggleButton y11 = new JToggleButton("");
		y11.setOpaque(false);
		y11.setBackground(Color.WHITE);
		y11.setBounds(437, 50, 32, 32);
		panel2.add(y11);
		
		JLabel dd11 = new JLabel("D");
		dd11.setVerticalAlignment(SwingConstants.BOTTOM);
		dd11.setHorizontalAlignment(SwingConstants.CENTER);
		dd11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd11.setBounds(408, 54, 24, 24);
		panel2.add(dd11);
		
		JLabel yy11 = new JLabel("Y");
		yy11.setVerticalAlignment(SwingConstants.BOTTOM);
		yy11.setHorizontalAlignment(SwingConstants.CENTER);
		yy11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy11.setBounds(440, 54, 24, 24);
		panel2.add(yy11);
		
		JToggleButton d12 = new JToggleButton("");
		d12.setOpaque(false);
		d12.setBackground(Color.WHITE);
		d12.setBounds(405, 97, 32, 32);
		panel2.add(d12);
		
		JToggleButton y12 = new JToggleButton("");
		y12.setOpaque(false);
		y12.setBackground(Color.WHITE);
		y12.setBounds(437, 97, 32, 32);
		panel2.add(y12);
		
		JLabel dd12 = new JLabel("D");
		dd12.setVerticalAlignment(SwingConstants.BOTTOM);
		dd12.setHorizontalAlignment(SwingConstants.CENTER);
		dd12.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd12.setBounds(408, 101, 24, 24);
		panel2.add(dd12);
		
		JLabel yy12 = new JLabel("Y");
		yy12.setVerticalAlignment(SwingConstants.BOTTOM);
		yy12.setHorizontalAlignment(SwingConstants.CENTER);
		yy12.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy12.setBounds(440, 101, 24, 24);
		panel2.add(yy12);
		
		JToggleButton d13 = new JToggleButton("");
		d13.setOpaque(false);
		d13.setBackground(Color.WHITE);
		d13.setBounds(405, 144, 32, 32);
		panel2.add(d13);
		
		JToggleButton y13 = new JToggleButton("");
		y13.setOpaque(false);
		y13.setBackground(Color.WHITE);
		y13.setBounds(437, 144, 32, 32);
		panel2.add(y13);
		
		JLabel dd13 = new JLabel("D");
		dd13.setVerticalAlignment(SwingConstants.BOTTOM);
		dd13.setHorizontalAlignment(SwingConstants.CENTER);
		dd13.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd13.setBounds(408, 148, 24, 24);
		panel2.add(dd13);
		
		JLabel yy13 = new JLabel("Y");
		yy13.setVerticalAlignment(SwingConstants.BOTTOM);
		yy13.setHorizontalAlignment(SwingConstants.CENTER);
		yy13.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy13.setBounds(440, 148, 24, 24);
		panel2.add(yy13);
		
		JToggleButton d14 = new JToggleButton("");
		d14.setOpaque(false);
		d14.setBackground(Color.WHITE);
		d14.setBounds(405, 191, 32, 32);
		panel2.add(d14);
		
		JToggleButton y14 = new JToggleButton("");
		y14.setOpaque(false);
		y14.setBackground(Color.WHITE);
		y14.setBounds(437, 191, 32, 32);
		panel2.add(y14);
		
		JLabel dd14 = new JLabel("D");
		dd14.setVerticalAlignment(SwingConstants.BOTTOM);
		dd14.setHorizontalAlignment(SwingConstants.CENTER);
		dd14.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd14.setBounds(408, 195, 24, 24);
		panel2.add(dd14);
		
		JLabel yy14 = new JLabel("Y");
		yy14.setVerticalAlignment(SwingConstants.BOTTOM);
		yy14.setHorizontalAlignment(SwingConstants.CENTER);
		yy14.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy14.setBounds(440, 195, 24, 24);
		panel2.add(yy14);
		
		JToggleButton d15 = new JToggleButton("");
		d15.setOpaque(false);
		d15.setBackground(Color.WHITE);
		d15.setBounds(405, 238, 32, 32);
		panel2.add(d15);
		
		JToggleButton y15 = new JToggleButton("");
		y15.setOpaque(false);
		y15.setBackground(Color.WHITE);
		y15.setBounds(437, 238, 32, 32);
		panel2.add(y15);
		
		JLabel dd15 = new JLabel("D");
		dd15.setVerticalAlignment(SwingConstants.BOTTOM);
		dd15.setHorizontalAlignment(SwingConstants.CENTER);
		dd15.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd15.setBounds(408, 242, 24, 24);
		panel2.add(dd15);
		
		JLabel yy15 = new JLabel("Y");
		yy15.setVerticalAlignment(SwingConstants.BOTTOM);
		yy15.setHorizontalAlignment(SwingConstants.CENTER);
		yy15.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy15.setBounds(440, 242, 24, 24);
		panel2.add(yy15);
		
		JToggleButton d16 = new JToggleButton("");
		d16.setOpaque(false);
		d16.setBackground(Color.WHITE);
		d16.setBounds(405, 285, 32, 32);
		panel2.add(d16);
		
		JToggleButton y16 = new JToggleButton("");
		y16.setOpaque(false);
		y16.setBackground(Color.WHITE);
		y16.setBounds(437, 285, 32, 32);
		panel2.add(y16);
		
		JLabel dd16 = new JLabel("D");
		dd16.setVerticalAlignment(SwingConstants.BOTTOM);
		dd16.setHorizontalAlignment(SwingConstants.CENTER);
		dd16.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd16.setBounds(408, 289, 24, 24);
		panel2.add(dd16);
		
		JLabel yy16 = new JLabel("Y");
		yy16.setVerticalAlignment(SwingConstants.BOTTOM);
		yy16.setHorizontalAlignment(SwingConstants.CENTER);
		yy16.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy16.setBounds(440, 289, 24, 24);
		panel2.add(yy16);
		
		JToggleButton d17 = new JToggleButton("");
		d17.setOpaque(false);
		d17.setBackground(Color.WHITE);
		d17.setBounds(405, 332, 32, 32);
		panel2.add(d17);
		
		JToggleButton y17 = new JToggleButton("");
		y17.setOpaque(false);
		y17.setBackground(Color.WHITE);
		y17.setBounds(437, 332, 32, 32);
		panel2.add(y17);
		
		JLabel dd17 = new JLabel("D");
		dd17.setVerticalAlignment(SwingConstants.BOTTOM);
		dd17.setHorizontalAlignment(SwingConstants.CENTER);
		dd17.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd17.setBounds(408, 336, 24, 24);
		panel2.add(dd17);
		
		JLabel yy17 = new JLabel("Y");
		yy17.setVerticalAlignment(SwingConstants.BOTTOM);
		yy17.setHorizontalAlignment(SwingConstants.CENTER);
		yy17.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy17.setBounds(440, 336, 24, 24);
		panel2.add(yy17);
		
		JToggleButton d18 = new JToggleButton("");
		d18.setOpaque(false);
		d18.setBackground(Color.WHITE);
		d18.setBounds(405, 379, 32, 32);
		panel2.add(d18);
		
		JToggleButton y18 = new JToggleButton("");
		y18.setOpaque(false);
		y18.setBackground(Color.WHITE);
		y18.setBounds(437, 379, 32, 32);
		panel2.add(y18);
		
		JLabel dd18 = new JLabel("D");
		dd18.setVerticalAlignment(SwingConstants.BOTTOM);
		dd18.setHorizontalAlignment(SwingConstants.CENTER);
		dd18.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd18.setBounds(408, 383, 24, 24);
		panel2.add(dd18);
		
		JLabel yy18 = new JLabel("Y");
		yy18.setVerticalAlignment(SwingConstants.BOTTOM);
		yy18.setHorizontalAlignment(SwingConstants.CENTER);
		yy18.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy18.setBounds(440, 383, 24, 24);
		panel2.add(yy18);
		
		JToggleButton d19 = new JToggleButton("");
		d19.setOpaque(false);
		d19.setBackground(Color.WHITE);
		d19.setBounds(405, 426, 32, 32);
		panel2.add(d19);
		
		JToggleButton y19 = new JToggleButton("");
		y19.setOpaque(false);
		y19.setBackground(Color.WHITE);
		y19.setBounds(437, 426, 32, 32);
		panel2.add(y19);
		
		JLabel dd19 = new JLabel("D");
		dd19.setVerticalAlignment(SwingConstants.BOTTOM);
		dd19.setHorizontalAlignment(SwingConstants.CENTER);
		dd19.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd19.setBounds(408, 430, 24, 24);
		panel2.add(dd19);
		
		JLabel yy19 = new JLabel("Y");
		yy19.setVerticalAlignment(SwingConstants.BOTTOM);
		yy19.setHorizontalAlignment(SwingConstants.CENTER);
		yy19.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy19.setBounds(440, 430, 24, 24);
		panel2.add(yy19);
		
		JToggleButton d20 = new JToggleButton("");
		d20.setOpaque(false);
		d20.setBackground(Color.WHITE);
		d20.setBounds(405, 473, 32, 32);
		panel2.add(d20);
		
		JToggleButton y20 = new JToggleButton("");
		y20.setOpaque(false);
		y20.setBackground(Color.WHITE);
		y20.setBounds(437, 473, 32, 32);
		panel2.add(y20);
		
		JLabel dd20 = new JLabel("D");
		dd20.setVerticalAlignment(SwingConstants.BOTTOM);
		dd20.setHorizontalAlignment(SwingConstants.CENTER);
		dd20.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dd20.setBounds(408, 477, 24, 24);
		panel2.add(dd20);
		
		JLabel yy20 = new JLabel("Y");
		yy20.setVerticalAlignment(SwingConstants.BOTTOM);
		yy20.setHorizontalAlignment(SwingConstants.CENTER);
		yy20.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yy20.setBounds(440, 477, 24, 24);
		panel2.add(yy20);
		
		List<JToggleButton> şıklar=List.of(d1,y1,d2,y2,d3,y3,d4,y4,d5,y5,d6,y6,d7,y7,d8,y8,d9,y9,d10,y10,d11,y11,d12,y12,d13,y13,d14,y14,d15,y15,d16,y16,d17,y17,d18,y18,d19,y19,d20,y20);
		List<JTextArea> sorular=List.of(soru1,soru2,soru3,soru4,soru5,soru6,soru7,soru8,soru9,soru10,soru11,soru12,soru13,soru14,soru15,soru16,soru17,soru18,soru19,soru20);
		List<Character> cevapAnahtari=new ArrayList<>();
		
		Goster gosterSoru=new Goster();
		List<List<String>> soruCevap=gosterSoru.dySoru();
		for(int i=0; i<sorular.size(); i++) {
			sorular.get(i).setText(sorular.get(i).getText()+soruCevap.get(0).get(i));
			cevapAnahtari.add(soruCevap.get(1).get(i).charAt(0));
		}
		
		JLabel sayfa2 = new JLabel("Arka sayfaya geç");
		sayfa2.setHorizontalAlignment(SwingConstants.CENTER);
		sayfa2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		sayfa2.setBounds(138, 616, 194, 32);
		sayfa2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				panel.setVisible(false);
				panel2.setVisible(true);
			}
		});
		panel.add(sayfa2);
		
		JLabel sayfa1 = new JLabel("Ön sayfaya geç");
		sayfa1.setHorizontalAlignment(SwingConstants.CENTER);
		sayfa1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		sayfa1.setBounds(138, 616, 194, 32);
		sayfa1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				panel2.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel2.add(sayfa1);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(194, 161, 94));
		panel3.setBounds(760, 94, 204, 525);
		panel3.setLayout(null);
		panel3.setVisible(false);
		add(panel3);
		
		JLabel sonuc = new JLabel("SINAV SONUÇLARI");
		sonuc.setForeground(new Color(0, 255, 255));
		sonuc.setHorizontalAlignment(SwingConstants.CENTER);
		sonuc.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		sonuc.setBounds(10, 10, 184, 32);
		panel3.add(sonuc);
		
		JLabel dogru = new JLabel("Doğru:");
		dogru.setForeground(new Color(0, 255, 0));
		dogru.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		dogru.setBounds(20, 47, 94, 24);
		panel3.add(dogru);
		
		JLabel yanlis = new JLabel("Yanlış:");
		yanlis.setForeground(new Color(255, 0, 0));
		yanlis.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		yanlis.setBounds(20, 70, 94, 24);
		panel3.add(yanlis);
		
		JLabel bos = new JLabel("Boş:");
		bos.setForeground(new Color(255, 255, 255));
		bos.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		bos.setBounds(20, 93, 94, 24);
		panel3.add(bos);
		
		JTextArea yanlislar = new JTextArea("");
		yanlislar.setEditable(false);
		yanlislar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		yanlislar.setBounds(10, 127, 184, 388);
		yanlislar.setOpaque(false);
		panel3.add(yanlislar);
		
		JLabel puan = new JLabel("Puan:");
		puan.setHorizontalAlignment(SwingConstants.TRAILING);
		puan.setForeground(new Color(0, 0, 255));
		puan.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		puan.setBounds(104, 60, 85, 24);
		panel3.add(puan);
		
		JLabel kacPuan = new JLabel("");
		kacPuan.setHorizontalAlignment(SwingConstants.CENTER);
		kacPuan.setForeground(Color.BLUE);
		kacPuan.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		kacPuan.setBounds(135, 85, 55, 24);
		panel3.add(kacPuan);
		
		JToggleButton bitirdim = new JToggleButton("BİTİRDİM");
		bitirdim.setFont(new Font("Tahoma", Font.PLAIN, 24));
		bitRenk=new Color(255, 0, 0);
		bitirdim.setBackground(bitRenk);
		bitirdim.setForeground(new Color(255, 255, 255));
		bitirdim.setBounds(765, 654, 194, 32);
		bitirdim.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				List<Character> cevaplar=new ArrayList<>();
				int dogruSayisi=0;
				int yanlisSayisi=0;
				int bosSayisi=0;
				if(bitirdim.getText()=="BİTİRDİM") {
					bitirdim.setText("ÇIKIŞ");
					for(int i=0; i<şıklar.size(); i+=2) {
						if(şıklar.get(i).isSelected() && !şıklar.get(i+1).isSelected()) {
							cevaplar.add('D');
						}else if(!şıklar.get(i).isSelected() && şıklar.get(i+1).isSelected()) {
							cevaplar.add('Y');
						}else if(!şıklar.get(i).isSelected() && !şıklar.get(i).isSelected()) {
							cevaplar.add('B');
						}
					}
					List<Integer> yanlisSorular=new ArrayList<>();
					for(int i=0; i<cevapAnahtari.size(); i++) {
						if(cevapAnahtari.get(i)==cevaplar.get(i)) {
							dogruSayisi++;
						}else {
							if(cevaplar.get(i)=='B') {
								bosSayisi++;
							}else {
								yanlisSayisi++;
								yanlisSorular.add(i+1);
							}
						}
					}
					dogru.setText(dogru.getText()+String.valueOf(dogruSayisi));
					yanlis.setText(yanlis.getText()+String.valueOf(yanlisSayisi));
					bos.setText(bos.getText()+String.valueOf(bosSayisi));
					kacPuan.setText(String.valueOf(dogruSayisi*5));
					if(yanlisSayisi==1) {
						yanlislar.setText("Yanlışınız:");
					}else if(yanlisSayisi>1) {
						yanlislar.setText("Yanlışlarınız:");
					}else if(yanlisSayisi==0) {
						yanlislar.setText("Hiç yanlışınız yok.");
					}
					for(int i:yanlisSorular) {
						yanlislar.setText(yanlislar.getText()+"\r\n"+i+". Soru");
					}
					Ekle ekle=new Ekle();
					ekle.performans(dogruSayisi, yanlisSayisi, bosSayisi, Integer.parseInt(gosterHakem.bilgiler()[3]));
					panel3.setVisible(true);
				}else if(bitirdim.getText()=="ÇIKIŞ") {
					frame.degistir(new AnaSayfa(frame, kulAd));
				}
			}
		});
		add(bitirdim);
		
		for(int i=0; i<şıklar.size(); i+=2) {
			secim(şıklar.get(i), şıklar.get(i+1), bitirdim);
		}
	}
	
	public void secim(JToggleButton d, JToggleButton y, JToggleButton bitirdim) {
		d.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if(d.isSelected()) {
					y.setSelected(false);
				}
			}
		});
		y.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if(y.isSelected()) {
					d.setSelected(false);
				}
			}
		});
		bitirdim.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if(bitirdim.getBackground()==bitRenk) {
					d.setEnabled(false);
					y.setEnabled(false);
				}
			}
		});
	}
}
