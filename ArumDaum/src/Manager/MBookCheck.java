package Manager;

import javax.swing.JFrame;

public class MBookCheck extends JFrame{

	public MBookCheck() {
		initializeUI();
		setVisible(true);
	}
	
	private void initializeUI() {
		// 창 초기설정
        setSize(500, 500);
        setResizable(false);
        setTitle("관리자 화면입니다.");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
