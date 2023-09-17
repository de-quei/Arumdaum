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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class BookSearchFrame extends JFrame{

	JPanel borderPanel = new JPanel(); // border를 넣을 panel
	JPanel buttonPanel = new JPanel(); // button을 넣을 panel
	
	JButton backBtn = new JButton("이전으로"); // 이전 버튼
	JButton searchBtn = new JButton("검색");
	
	JLabel searchLabel = new JLabel("도서 검색 : ");
	
	JTextField searchField = new JTextField(); // 도서 검색 바
	
	//임시데이터입니다.
    String[] header = {"도서명", "ISBN", "출판사", "저자", "대출상태"};
    String[][] contents = {
    		{"냠냠굳", "ㅇㅁ3fe", "SM", "장지안", "대출중"},
    		{"으르렁", "ㅁㅏㅅ7g", "YG", "김지우", "대출가능"},
    		{"안타날려", "ㅂㅡ5jk", "두산베어스", "정선영", "대출가능"}
    };
    
    JTable resultTable = new JTable(contents, header); // 검색 결과를 표시할 테이블
	
	public BookSearchFrame() {
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
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "도서 신청"));
		borderPanel.setLayout(null);
		add(borderPanel);
		
		buttonPanel.setBounds(20, 410, 440, 40);
		//buttonPanel.setBorder(new LineBorder(Color.BLACK));
		add(buttonPanel);
		
		//검색 바
		searchLabel.setBounds(30, 40, 80, 25);
		searchField.setBounds(120, 40, 230, 25);
		searchBtn.setBounds(360, 40, 60, 25);
		borderPanel.add(searchLabel);
		borderPanel.add(searchField);
		borderPanel.add(searchBtn);
        
        //테이블을 JScrollPane으로 감싸기
        JScrollPane tableScrollPane = new JScrollPane(resultTable);
        tableScrollPane.setBounds(30, 90, 390, 270);
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
