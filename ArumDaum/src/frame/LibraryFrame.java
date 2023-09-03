package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LibraryFrame extends JFrame{
	
	JPanel header_panel = new JPanel();
	JLabel header_label = new JLabel("아름다움");
    
	public LibraryFrame() {
		initializeUI();
		addComponentsUI();
		setVisible(true);
	}
    
	private void initializeUI() {
    	// 창 초기설정
		setSize(1280, 750);
        setResizable(false);
        setTitle("아름다움");
        setLocationRelativeTo(null);
        
        // TODO:헤더 크기 1280*50으로 줄이기
        // 헤더 패널에 GridBagLayout 설정
        header_panel.setLayout(new GridBagLayout());
    }
	
	private void addComponentsUI() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH; // 텍스트를 화면 상단으로 정렬
		gbc.weighty = 1.0; // 수직 방향으로의 추가 공간을 확보하여 텍스트를 상단으로 이동
		
		// 텍스트 기준 위, 아래 10px 마진
		header_label.setBorder(new EmptyBorder(10, 0, 10, 0));
		
		// 헤더 레이블 텍스트 스타일
		header_label.setFont(new Font("Gowun Batang", Font.PLAIN, 30));
		header_label.setForeground(Color.decode("#1E6525"));
		
		// 패널에 빨간색 테두리 추가
        Border border = BorderFactory.createLineBorder(Color.RED);
        header_panel.setBorder(border);
        
		header_panel.add(header_label, gbc);
		add(header_panel);
	}
}
