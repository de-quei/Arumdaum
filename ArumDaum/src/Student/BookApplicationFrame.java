package Student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BookApplicationFrame extends JFrame{
	
	TitledBorder Title = new TitledBorder(new LineBorder(Color.BLACK), "도서 신청"); // border
	
	JPanel borderPanel = new JPanel(); // border를 넣을 panel
	JPanel buttonPanel = new JPanel(); // button을 넣을 panel
	
	JButton backBtn = new JButton("이전으로"); // 이전 버튼
	
	JTable bookCheck = new JTable();
	
	public BookApplicationFrame() {
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
		
		borderPanel.setBounds(20, 20, 440, 380);
		borderPanel.setBorder(Title); //panel에 border를 넣음.
		add(borderPanel);
		
		buttonPanel.setBounds(20, 410, 440, 40);
		//buttonPanel.setBorder(new LineBorder(Color.BLACK));
		add(buttonPanel);
		
		//panel에 이전버튼 생성
		buttonPanel.setLayout(null);
		backBtn.setBounds(350, 0, 90, 40); 
		buttonPanel.add(backBtn);
	}
	
	private void eventHandler() {
		
		//이전버튼
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openChooseFrame();
			}
		});
	}
	
	private void openChooseFrame() {
		dispose();
		new ChooseFrame();
	}
}
