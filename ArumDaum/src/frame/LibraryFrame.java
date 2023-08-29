package frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LibraryFrame extends JFrame{
    
	public LibraryFrame() {
		initializeUI();
	}
    
	private void initializeUI() {
    	// 창 초기설정
		setSize(1280, 750);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);
    }
	
}
