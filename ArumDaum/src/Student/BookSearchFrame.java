package Student;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BookSearchFrame extends JFrame{
	
	TitledBorder Title = new TitledBorder(new LineBorder(Color.BLACK), "도서 신청"); // border
	
	JPanel borderPanel = new JPanel(); // border를 넣을 panel
	JPanel buttonPanel = new JPanel();
	
	JButton backBtn = new JButton("이전으로");
	
	public BookSearchFrame() {
		initializeUI();
		addComponentsUI();
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
		add(buttonPanel);
		
	}
}
