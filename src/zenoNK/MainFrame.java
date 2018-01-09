package zenoNK;

import java.awt.BorderLayout;
import java.awt.Color;import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.prism.Image;

import Scene.GameScene;

public class MainFrame extends JFrame implements ActionListener{

	JButton btnPlay=new JButton("Play");
	JButton btnHighScore=new JButton("HighScore");
	JButton btnKeySetting=new JButton("Key Setting");
	JTextField txtName=new JTextField();
	
	BufferedImage image;
	public MainFrame() {
		setTitle("ZenoNK");
		setSize(400,300);
		setResizable(false);
		File jpegFile = new File("Images/Background/backgroundTitle.jpg");
		BufferedImage image=null;
		try {
			image = ImageIO.read(jpegFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.image=image;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pane=new JPanel(new GridLayout(2, 0));
		JPanel outerPanel=new JPanel(new BorderLayout());
		JPanel flow=new JPanel(new FlowLayout());
		JPanel buttonPanel=new JPanel(new GridLayout(3, 0));
		Font font=new Font("Calibri", Font.BOLD, 20);
		JPanel panelName1=new JPanel(new FlowLayout());
		txtName.setColumns(20);
		txtName.setFont(font);
		panelName1.add(txtName);
		panelName1.setOpaque(false);
		JPanel panelName2=new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
		
		JLabel lblName=new JLabel("Name : ");
		outerPanel.setBackground(new Color(0, 0, 0, 5));
		panelName2.add(lblName);
		outerPanel.add(panelName2,BorderLayout.NORTH);
		outerPanel.add(panelName1,BorderLayout.CENTER);
		
		
		btnKeySetting.addActionListener(this);
		btnPlay.addActionListener(this);
		btnHighScore.addActionListener(this);
		
		
		pane.add(outerPanel);
		//pane.add(buttonPanel);
		
		
		buttonPanel.add(btnPlay);
		buttonPanel.add(btnHighScore);
		buttonPanel.add(btnKeySetting);
		buttonPanel.setOpaque(false);
		pane.setOpaque(false);
		flow.setOpaque(false);
		flow.add(buttonPanel);
		pane.add(flow);
//		pane.add(btnPlay);
//		pane.add(btnHighScore);
//		pane.add(btnKeySetting);

		JLabel background=new JLabel(new ImageIcon(image));
		background.setLayout(new FlowLayout());
		background.add(pane);
		setContentPane(background);
		
		
		
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnPlay) {
			File jpegFile = new File("Images/Background/background.jpg");
			BufferedImage image=null;
			try {
				image = ImageIO.read(jpegFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(txtName.getText().trim().equals("")){
				JOptionPane.showMessageDialog(null, "Please input your name!!");
			}
			else{
			new GameScene(image,txtName.getText());
			this.dispose();
			}
			
		}
		else if(e.getSource()==btnKeySetting){
			new SetControlFrame();
			this.dispose();
		}
		else if(e.getSource()==btnHighScore){
			HighScoreFrame highScoreFrame=HighScoreFrame.getInstance();
			highScoreFrame.setVisible(true);
			this.dispose();
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//g.drawImage(image,0,30,400,300,null);
		//revalidate();
		
	}
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
	}
}
