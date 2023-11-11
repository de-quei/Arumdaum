package Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BookApplicationFrame extends JFrame{
	
	JPanel borderPanel = new JPanel(); // border를 넣을 panel
	JPanel buttonPanel = new JPanel(); // button을 넣을 panel
	
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
    String[] reason = {"학습도서", "공익도서", "필수도서", "유익도서", "기타"};
    
    JComboBox categoryBox = new JComboBox(category);
    JComboBox<Integer> publicationYearBox;
    JComboBox reasonBox = new JComboBox(reason);

    
    // 데이터베이스 연결 문자열에 시간대 설정 추가
    private static final String DB_URL = "jdbc:mysql://localhost:3306/arumdaum?useTimezone=true&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0000";

	
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
		titleLabel.setBounds(30, 50, 80, 25);
        titleField.setBounds(120, 50, 300, 25);
        borderPanel.add(titleLabel);
        borderPanel.add(titleField);
        
        //저자
        authorLabel.setBounds(30, 95, 80, 25);
        authorField.setBounds(120, 95, 300, 25);
        borderPanel.add(authorLabel);
        borderPanel.add(authorField);
        
        //출판사
        publisherLabel.setBounds(30, 140, 80, 25);
        publisherField.setBounds(120, 140, 300, 25);
        borderPanel.add(publisherLabel);
        borderPanel.add(publisherField);
        
        //카테고리
        categoryLabel.setBounds(30, 185, 80, 25);
        categoryBox.setBounds(120, 185, 300, 25);
        borderPanel.add(categoryLabel);
        borderPanel.add(categoryBox);
        
        //가격
        priceLabel.setBounds(30, 230, 80, 25);
        priceField.setBounds(120, 230, 300, 25);
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
        publicationYearLabel.setBounds(30, 275, 80, 25);
        publicationYearBox.setBounds(120, 275, 300, 25);
        borderPanel.add(publicationYearLabel);
        borderPanel.add(publicationYearBox);
        
        //신청사유
        applicationReasonLabel.setBounds(30, 320, 80, 25);
        reasonBox.setBounds(120, 320, 300, 25);
        borderPanel.add(applicationReasonLabel);
        borderPanel.add(reasonBox);
        
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
		
		// 신청하기 버튼의 Action 리스너
		applicationBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // 사용자가 입력한 정보 가져오기
		        String title = titleField.getText();
		        String author = authorField.getText();
		        String publisher = publisherField.getText();
		        String category = categoryBox.getSelectedItem().toString();
		        String priceText = priceField.getText();
		        String publicationYearText = publicationYearBox.getSelectedItem().toString();
		        String applicationReason = reasonBox.getSelectedItem().toString();

		        // 입력값이 비어있는지 확인
		        if (title.isEmpty() || author.isEmpty() || publisher.isEmpty() || category.isEmpty() || priceText.isEmpty() || publicationYearText.isEmpty() || applicationReason.isEmpty()) {
		            // 입력값 중 하나라도 비어있으면 알람창 띄우기
		            JOptionPane.showMessageDialog(null, "모든 필드에 값을 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
		        } else if (applicationReason.length() >= 255) {
		            // 신청사유가 255자를 초과하면 알람창 띄우기
		            JOptionPane.showMessageDialog(null, "신청사유는 255자 이하여야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
		        } else {
		            // 데이터베이스 연결 및 데이터 저장
		            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
		                // 쿼리 작성
		                String insertQuery = "INSERT INTO bookApplication (title, author, publisher, category, price, publicationYear, reason) VALUES (?, ?, ?, ?, ?, ?, ?)";

		                // PreparedStatement 생성
		                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
		                    preparedStatement.setString(1, title);
		                    preparedStatement.setString(2, author);
		                    preparedStatement.setString(3, publisher);
		                    preparedStatement.setString(4, category);
		                    preparedStatement.setInt(5, Integer.parseInt(priceText));
		                    preparedStatement.setInt(6, Integer.parseInt(publicationYearText));
		                    preparedStatement.setString(7, applicationReason);

		                    // 쿼리 실행
		                    int rowsAffected = preparedStatement.executeUpdate();
		                    if (rowsAffected > 0) {
		                        // 저장 성공
		                    	JOptionPane.showMessageDialog(null, "정상적으로 접수되었습니다.", "신청 완료", JOptionPane.INFORMATION_MESSAGE);
		                        System.out.println("도서 신청이 성공적으로 저장되었습니다.");
		                        
		                        // 초기화
		                        titleField.setText("");
		                        authorField.setText("");
		                        publisherField.setText("");
		                        priceField.setText("");
		                    } else {
		                        // 저장 실패
		                    	JOptionPane.showMessageDialog(null, "다시 시도하여주십시오.", "신청 실패", JOptionPane.ERROR_MESSAGE);
		                        System.out.println("도서 신청 저장에 실패했습니다.");
		                    }
		                }
		            } catch (SQLException ex) {
		                // 데이터베이스 연결 오류 처리
		                ex.printStackTrace();
		            }
		        }
		    }
		});

	}
	
	private void openChooseFrame() {
		dispose();
		new ChooseFrame();
	}
}
