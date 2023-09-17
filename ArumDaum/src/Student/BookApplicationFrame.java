package Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BookApplicationFrame extends JFrame{
	
	JPanel borderPanel = new JPanel(); // border를 넣을 panel
	JPanel buttonPanel = new JPanel(); // button을 넣을 panel
	JPanel bookTitlePanel = new JPanel();
	
	JButton backBtn = new JButton("이전으로"); // 이전 버튼
	JButton applicationBtn = new JButton("신청하기"); //TODO:멘트 더 생각해보기
	
	JLabel titleLabel = new JLabel("도서명 : ");
	JLabel authorLabel = new JLabel("저자 : ");
	JLabel publisherLabel = new JLabel("출판사 : ");
	JLabel categoryLabel = new JLabel("카테고리 : ");
	JLabel priceLabel = new JLabel("가격 : ");
	JLabel publicationYearLabel = new JLabel("출판연도 : ");
	JLabel applicationReasonLabel = new JLabel("신청사유 : ");
	
    JTextField titleField = new JTextField();
    JTextField authorField = new JTextField();
    JTextField publisherField = new JTextField();
    JTextField priceField = new JTextField();
    
    String[] category = {"소설", "시/에세이", "인문", "가정", "요리", "건강", "취미/실용/스포츠", 
    					 "경제/경영", "자기계발", "정치/사회", "역사/문화", "종교", "예술/대중문화", 
    					 "기술/공학", "외국어", "과학", "취업", "여행", "컴퓨터/IT"};
    
    JComboBox categoryBox = new JComboBox(category);
    JComboBox<Integer> publicationYearBox;
    
    TextArea reasonArea = new TextArea();
	
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
		
		//border panel
		borderPanel.setBounds(20, 20, 440, 380);
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "도서 신청"));
		borderPanel.setLayout(null);
		add(borderPanel);
		
		//도서명
		titleLabel.setBounds(30, 40, 80, 25);
        titleField.setBounds(120, 40, 300, 25);
        borderPanel.add(titleLabel);
        borderPanel.add(titleField);
        
        //저자
        authorLabel.setBounds(30, 80, 80, 25);
        authorField.setBounds(120, 80, 300, 25);
        borderPanel.add(authorLabel);
        borderPanel.add(authorField);
        
        //출판사
        publisherLabel.setBounds(30, 120, 80, 25);
        publisherField.setBounds(120, 120, 300, 25);
        borderPanel.add(publisherLabel);
        borderPanel.add(publisherField);
        
        //카테고리
        categoryLabel.setBounds(30, 160, 80, 25);
        categoryBox.setBounds(120, 160, 300, 25);
        borderPanel.add(categoryLabel);
        borderPanel.add(categoryBox);
        
        //가격
        priceLabel.setBounds(30, 200, 80, 25);
        priceField.setBounds(120, 200, 300, 25);
        borderPanel.add(priceLabel);
        borderPanel.add(priceField);
        
        //출판연도 ArrayList 초기화
        ArrayList<Integer> publicationYearList = new ArrayList<Integer>();
        for(int year = 2023; year >= 1985; year--) {
        	publicationYearList.add(year);
        }
        //출판연도 JComoboBox 초기화
        Integer[] yearsArray = publicationYearList.toArray(new Integer[0]);
        publicationYearBox = new JComboBox<>(yearsArray);
        
        //출판연도
        publicationYearLabel.setBounds(30, 240, 80, 25);
        publicationYearBox.setBounds(120, 240, 300, 25);
        borderPanel.add(publicationYearLabel);
        borderPanel.add(publicationYearBox);
        
        //신청사유
        applicationReasonLabel.setBounds(30, 280, 80, 25);
        reasonArea.setBounds(120, 280, 300, 70);
        borderPanel.add(applicationReasonLabel);
        borderPanel.add(reasonArea);
        
        //button panel
      	buttonPanel.setBounds(20, 410, 440, 40);
      	add(buttonPanel);
      		
      	applicationBtn.setBounds(250, 0, 90, 40);
      	buttonPanel.add(applicationBtn);
      	
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
