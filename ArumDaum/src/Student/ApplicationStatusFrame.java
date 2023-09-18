package Student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ApplicationStatusFrame extends JFrame{
	
	JPanel borderPanel = new JPanel(); // border를 넣을 panel
	JPanel buttonPanel = new JPanel(); // button을 넣을 panel
	
	JButton backBtn = new JButton("이전으로");
	
	//임시데이터입니다.
    String[] header = {"순번", "도서명", "신청일자", "카테고리", "신청현황"};
    String[][] contents = {
    		{"3", "잠자는 죽음을 깨워 길을 물었다.", "2023.09.18", "역사", "접수완료"},
    		{"2", "맑은 날이 아니어서 오히려 좋아.", "2023.04.25", "에세이", "입고완료"},
    		{"1", "나의 히어로 아카데미아", "2022.12.01", "만화", "승인거절"}
    };
    
    JTable statusTable = new JTable(contents, header); // 검색 결과를 표시할 테이블
	
	
	public ApplicationStatusFrame() {
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
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "신청 현황"));
		borderPanel.setLayout(null);
		add(borderPanel);
		
		buttonPanel.setBounds(20, 410, 440, 40);
		//buttonPanel.setBorder(new LineBorder(Color.BLACK));
		add(buttonPanel);
		
		JScrollPane tableScrollPane = new JScrollPane(statusTable);
        tableScrollPane.setBounds(20, 40, 400, 310);
        borderPanel.add(tableScrollPane);
        
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
				openChooseFrame();
			}
		});
	}
	
	private void openChooseFrame() {
		dispose();
		new ChooseFrame();
	}
}
