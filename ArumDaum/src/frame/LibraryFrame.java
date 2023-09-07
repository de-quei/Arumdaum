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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LibraryFrame extends JFrame{
	
	JPanel header = new JPanel();
	JLabel header_label = new JLabel("\"아름다움\"");
	JButton logoutBtn = new JButton("로그아웃");
	JPanel BookCategory = new JPanel();
	JLabel categoryLabel = new JLabel("책 카테고리");
    
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
        setTitle("아름다움");
        setLocationRelativeTo(null);
    }
	
	private void addComponentsUI() {
		// BorderLayout을 사용하여 레이아웃 매니저 설정
		header.setLayout(new BorderLayout()); 
		
		// 헤더 초기 설정
		header.setSize(1280, 48);
		header.setLocation(0, 0);
		header.setBorder(new LineBorder(Color.BLACK));
		
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
	}
}
