package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MStudentInformationFrame extends JFrame{
	
	JPanel buttonPanel = new JPanel(); // button을 넣을 panel
	
	JButton backBtn = new JButton("이전으로");
	
	public MStudentInformationFrame(){
		initializeUI();
		addComponentsUI();
		eventHandler();
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
	
	private void addComponentsUI() {
		//button panel
      	buttonPanel.setBounds(20, 410, 440, 40);
      	add(buttonPanel);
      	
      	//panel에 이전버튼 생성
      	backBtn.setBounds(350, 0, 90, 40);
        buttonPanel.setLayout(null);
      	buttonPanel.add(backBtn);
	}
	
	private void eventHandler() {
		//이전버튼
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openMChooseFrame();
			}
		});
	}
	
	private void openMChooseFrame() {
		dispose();
		new MChooseFrame();
	}
}
