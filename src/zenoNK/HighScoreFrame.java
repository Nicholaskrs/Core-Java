package zenoNK;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javafx.scene.layout.Border;

public class HighScoreFrame extends JFrame{
	JScrollPane spane;
	JTable table;
	
	Vector<Vector<Object>> tContent;
	Vector<Object> tHeader,tRow;
	Vector<Score>scores=new Vector<>();
	
	private static HighScoreFrame highScoreFrame=new HighScoreFrame();
	
	public static HighScoreFrame getInstance(){
		return highScoreFrame;
	}
	
	public void sort(){
		tContent.clear();
		Collections.sort(scores);
		for (int i = 0; i < scores.size(); i++) {
			scores.get(i).setRank(i+1);
			tRow=new Vector<>();
			tRow.add(scores.get(i).getRank());
			tRow.add(scores.get(i).getName());
			tRow.add(scores.get(i).getScore());
			
			tContent.add(tRow);
			
		}
	}
	JButton btnBack=new JButton("Back");
	private HighScoreFrame() {
		// TODO Auto-generated constructor stub
		setSize(600,400);	
		 setLocationRelativeTo(null);
		 setLayout(new BorderLayout());
		 
			tHeader = new Vector<Object>();
			tContent = new Vector<Vector<Object>>();
			
			tHeader.add("Rank");
			tHeader.add("Name");
			tHeader.add("Score");
			
			addScore("NK", 1500, 0);
			addScore("GD", 700, 0);
			addScore("JY", 1200, 0);
			addScore("CN", 500, 0);
			
			sort();
			DefaultTableModel dtm = new DefaultTableModel(tContent, tHeader);
			table = new JTable(dtm) {
				@Override
				public boolean isCellEditable(int arg0, int arg1) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			
			btnBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					MainFrame mainFrame=new MainFrame();
					setVisible(false);
				}
			});
			
			spane = new JScrollPane(table);
			add(spane,BorderLayout.CENTER);
			add(btnBack,BorderLayout.SOUTH);
		 setVisible(true);
		
		 
		 
	}
	
	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		sort();
		super.setVisible(b);
	}
	
	public void addScore(String name, int score,int rank) {
		Score newScore=new Score(score,name,rank);
		scores.add(newScore);
	}
}
