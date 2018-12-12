import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.datatransfer.*;

public class GreekAlphabet implements ActionListener {
	JButton[] btnList = new JButton[2*24];
	char[] chList = new char[2*24];
	
	public static void main(String[] args) {
		new GreekAlphabet();
	}

	public GreekAlphabet() {
		JFrame frame = new JFrame("Greek Alphabet");
		frame.setLayout(null);
		char ch = 0x03b1;
		int x = 0;
		int y = 0;
		for (int i = 0; i < 2*24; i++) {
			JButton button = new JButton("" + ch);
			button.addActionListener(this);
			button.setBounds(x,y,50,40);
			button.setLayout(null);
			frame.add(button);
			btnList[i] = button;
			chList[i] = ch;
			if (x >= 50*11) {
				x = 0;
				y += 40;
			}
			else {
				x += 50;
			}
			if (ch == 0x03c9) {
				ch = 0x0391;
				x = 0;
				y += 10;
			}
			else if (ch == 0x03c1 || ch == 0x03a1) {
				ch += 2;
			}
			else {
				ch++;
			}
		}
		frame.setSize(50*12, 220);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 2*24; i++) {
			if (e.getSource() == btnList[i]) {
				char ch = chList[i];
				StringSelection selection = new StringSelection("" + ch);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, selection);
				System.out.println(ch);
			}
		}
	}
}
