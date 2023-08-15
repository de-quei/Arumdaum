package frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LibraryFrame extends JFrame{

	//배경 이미지 상대경로
    JLabel MainHeader = new JLabel(new ImageIcon("./img/MainHeader.png"));
    
	public LibraryFrame() {
		// 창 초기설정
		setSize(1280, 750);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);
        
        // 이미지의 위치, 크기
        MainHeader.setBounds(0, 0, 1280, 48);
        add(MainHeader);
        
        setVisible(true);
	}
    
}
