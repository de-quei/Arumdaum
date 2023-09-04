package frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LibraryFrame extends JFrame{
	
	JPanel header = new JPanel();
    
	public LibraryFrame() {
		initializeUI();
		addComponentsUI();
		setLayout(null);
		setVisible(true);
	}
    
	private void initializeUI() {
    	// 창 초기설정
		setSize(1280, 750);
        setResizable(false);
        setTitle("아름다움");
        setLocationRelativeTo(null);
    }
	
	private void addComponentsUI() {
		header.setSize(1280, 48);
		header.setLocation(0, 0);
		header.setBorder(new LineBorder(Color.BLACK));
		add(header);
	}
}
