package refmember;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private KaydolGir kaydolgir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000,750));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Refmember");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("düdük.png (bilgisayardaki full path)"));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		kaydolgir=new KaydolGir(this);
		degistir(kaydolgir);
	}
	
	public void degistir(JPanel panel){
		getContentPane().removeAll();
		getContentPane().add(panel);
		revalidate();
		repaint();
	}
}
