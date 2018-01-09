package zenoNK;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Until.Controller;

public class SetControlFrame extends JFrame implements KeyListener,ActionListener{
		JButton btnApply,btnCancel;
		JTextField txtAttack,txtUp,txtDown,txtLeft,txtRight;
	 public SetControlFrame() {
		// TODO Auto-generated constructor stub
		 JPanel inputPane=new JPanel(new GridLayout(6, 2));
		 JLabel lblAttack=new JLabel("Attack");
		 JLabel lblUp=new JLabel("Up");
		 JLabel lblDown=new JLabel("Down");
		 JLabel lblLeft=new JLabel("Left");
		 JLabel lblRight=new JLabel("Right");
		 
		 txtAttack=new JTextField(KeyEvent.getKeyText(Controller.ATTACK));
		 txtAttack.addKeyListener(this);
		 txtUp=new JTextField(KeyEvent.getKeyText(Controller.UP));
		 txtUp.addKeyListener(this);
		 txtDown=new JTextField(KeyEvent.getKeyText(Controller.DOWN));
		 txtDown.addKeyListener(this);
		 txtLeft=new JTextField(KeyEvent.getKeyText(Controller.LEFT));
		 txtLeft.addKeyListener(this);
		 txtRight=new JTextField(KeyEvent.getKeyText(Controller.RIGHT));
		 txtRight.addKeyListener(this);
		 
		 btnApply=new JButton("Apply");
		 btnApply.addActionListener(this);
		 btnCancel=new JButton("Reset");
		 btnCancel.addActionListener(this);
		 
		 inputPane.add(lblAttack);
		 inputPane.add(txtAttack);
		 inputPane.add(lblUp);
		 inputPane.add(txtUp);
		 inputPane.add(lblDown);
		 inputPane.add(txtDown);
		 inputPane.add(lblLeft);
		 inputPane.add(txtLeft);
		 inputPane.add(lblRight);
		 inputPane.add(txtRight);
		 inputPane.add(btnApply);
		 inputPane.add(btnCancel);
		 
		 setContentPane(inputPane);
		 
		 
		 
		 setSize(600,400);	
		 setLocationRelativeTo(null);
		 setVisible(true);
	}

	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
			e.consume();
			((JTextField)e.getSource()).setText(e.getKeyChar()+"");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnApply){
			if(txtAttack.getText().equals("")||txtDown.getText().equals("")||txtLeft.getText().equals("")||txtRight.getText().equals("")||txtUp.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Text must be filled");
			}
			else{
			Controller.ATTACK=KeyEvent.getExtendedKeyCodeForChar(txtAttack.getText().charAt(0));
			Controller.UP=KeyEvent.getExtendedKeyCodeForChar(txtUp.getText().charAt(0));
			Controller.DOWN=KeyEvent.getExtendedKeyCodeForChar(txtDown.getText().charAt(0));
			Controller.LEFT=KeyEvent.getExtendedKeyCodeForChar(txtLeft.getText().charAt(0));
			Controller.RIGHT=KeyEvent.getExtendedKeyCodeForChar(txtRight.getText().charAt(0));
			}
			new MainFrame();
			this.dispose();
		}else if(e.getSource()==btnCancel){
			Controller.setDefaultKey();
			new MainFrame();
			this.dispose();
		}
	}

}
