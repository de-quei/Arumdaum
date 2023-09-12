package Student;

import javax.swing.JFrame;

public class ApplicationStatusFrame extends JFrame{
	
	public ApplicationStatusFrame() {
		initializeUI();
		setVisible(true);
	}
	
	
	private void initializeUI() {
        // 창 초기설정
        setSize(500, 500);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
