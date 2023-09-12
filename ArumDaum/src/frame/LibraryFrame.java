package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LibraryFrame extends JFrame{
	
	JPanel header = new JPanel();
	JPanel BookCategory = new JPanel();
	JPanel wiseSaying = new JPanel();
	JPanel Student_Info = new JPanel();
	
	JLabel header_label = new JLabel("\"아름다움\"");
	JLabel categoryLabel = new JLabel("책 카테고리");
	
	JButton logoutBtn = new JButton("로그아웃");
	
	public LibraryFrame() {
		initializeUI();
		addComponentsUI();
		setLayout(null);
		setVisible(true);
	}
    
	private void initializeUI() {
    	// 창 초기설정
		setSize(1290, 750);
        setResizable(false);
        setBackground(Color.WHITE);
        setTitle("아름다움");
        setLocationRelativeTo(null);
    }
	
	private void addComponentsUI() {
		// BorderLayout을 사용하여 레이아웃 매니저 설정
		header.setLayout(new BorderLayout()); 
		
		// 헤더 초기 설정
		header.setSize(1280, 48);
		header.setLocation(0, 0);
		header.setBorder(new LineBorder(Color.decode("#E1E1E1")));
		header.setBackground(Color.WHITE);
		
		// 헤더에 텍스트 label 추가
		header_label.setFont(new Font("Gowun Batang", Font.PLAIN, 25));
		header_label.setHorizontalAlignment(SwingConstants.CENTER);
		header_label.setBounds(0, 0, 1280, 48);
		header.add(header_label);
		
		// 로그아웃 버튼
        header.add(logoutBtn, BorderLayout.EAST); // JButton을 header 패널의 오른쪽에 추가
        logoutBtn.setBackground(Color.decode("#1E6525")); 
        logoutBtn.setForeground(Color.WHITE); 
        logoutBtn.setFont(new Font("Gowun Batang", Font.BOLD, 16));
        
		add(header);
		
		// 책 카테고리
		BookCategory.setBounds(34, 88, 170, 34); 
	    BookCategory.setBackground(Color.decode("#81B486")); 
	    add(BookCategory); 
	    
	    categoryLabel.setFont(new Font("Gowun Batang", Font.PLAIN, 16)); 
	    categoryLabel.setForeground(Color.WHITE); 
	    BookCategory.add(categoryLabel); 
		
		// JList를 이용한 책 카테고리 선택창
		String[] bookCategories = {
	            "소설", "시/에세이", "인문", "자기계발", "종교", "요리",
	            "건강", "취미/실용/스포츠", "가정/육아", "예술", "기술/공학",
	            "외국어", "과학", "취업/수험서", "여행", "컴퓨터/IT", "만화"
	        	};
		JList<String> categoryList = new JList<String>(bookCategories);
		JScrollPane scrollPane = new JScrollPane(categoryList);
		scrollPane.setBounds(34, 122, 170, 280);
		
		add(scrollPane);
		
		// 파일 입출력, 혹은 데이터베이스를 통한 랜덤한 명언이 나올 자리 
		wiseSaying.setBounds(34, 416, 170, 271);
		wiseSaying.setBackground(Color.RED); 

		add(wiseSaying); 
		
		// 학생의 정보를 조회할 수 있는 panel 
		Student_Info.setBounds(882, 85, 368, 217);
		Student_Info.setBackground(Color.WHITE);
		Student_Info.setBorder(new LineBorder(Color.decode("#E1E1E1")));
		
		add(Student_Info);
		
		// TODO: 데이터베이스를 연동하여 할 것
		Object[][] tableData = {
			    {"1", "20230726", "잠자는 죽음을 깨워 길을 물었다.", "접수완료"},
			    {"2", "20230403", "맑은 날이 아니어서 오히려 좋아.", "배송중"},
			    {"3", "20221214", "우리가 살 수 없는 미래", "입고완료"},
			    {"4", "20220927", "나의 히어로 아카데미아", "승인거절"}
			};

			// JTable 열 이름
			String[] columnNames = {"순번", "신청일자", "도서제목", "현황"};

			// JTable 생성
			JTable status = new JTable(tableData, columnNames);
			status.setBounds(882, 321, 368, 366); // 크기와 위치 설정

			// JScrollPane에 JTable 추가
			JScrollPane scrollPane1 = new JScrollPane(status);
			scrollPane1.setBounds(882, 321, 368, 366); // JScrollPane 크기와 위치 설정

			add(scrollPane1); // 프레임에 JScrollPane 추가
	}
}
