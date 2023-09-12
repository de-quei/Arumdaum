package Manager;

import javax.swing.JFrame;

public class ManagerFrame extends JFrame{

	public ManagerFrame() {
        initailzeUI();
        setVisible(true);
    }

	private void initailzeUI() {
		setSize(1280, 750);
        setResizable(false);
        setTitle("관리자 화면");
        setLayout(null);
        setLocationRelativeTo(null);
	}
	
}
