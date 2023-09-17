package Student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class ChooseFrame extends JFrame {
	
    JButton applicationBtn = new JButton("도서 신청");
    JButton searchBtn = new JButton("도서 검색");
    JButton statusBtn = new JButton("신청 현황");
    JButton sInfoBtn = new JButton("회원 정보");
    
    JPanel welcomePanel = new JPanel();
    JTextArea welcomeTextArea = new JTextArea();
    
    //텍스트 파일 이름 목록
    String[] textFiles = {"text1.txt", "text2.txt", "text3.txt"};

    public ChooseFrame() {
        initializeUI();
        addComponentsUI();
        displayWelcomeTextFromFile();
        eventHandler();
        setVisible(true);
    }

    private void initializeUI() {
        // 창 초기설정
        setSize(500, 200);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponentsUI() {
    	// 텍스트를 표시할 TextArea
    	welcomeTextArea.setBounds(40, 25, 400, 70);
    	welcomeTextArea.setLineWrap(true); //자동 줄바꾸기
    	welcomePanel.setBorder(new LineBorder(Color.BLACK));
    	welcomePanel.setBounds(40, 25, 400, 70);
    	welcomePanel.add(welcomeTextArea);
    	add(welcomePanel);
    	
        // 버튼 위치 및 크기 설정
        applicationBtn.setBounds(40, 100, 100, 30);
        searchBtn.setBounds(140, 100, 100, 30);
        statusBtn.setBounds(240, 100, 100, 30);
        sInfoBtn.setBounds(340, 100, 100, 30);

        // 프레임에 버튼 추가
        add(applicationBtn);
        add(searchBtn);
        add(statusBtn);
        add(sInfoBtn);
    }
    
    private void eventHandler() {
        applicationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBookApplicationFrame();
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openBookSearchFrame();
            }
        });
        statusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openApplicationStatusFrame();
            }
        });
        sInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openStudentInfoFrame();
            }
        });
        
    }
    
    private void displayWelcomeTextFromFile() {
        try {
        	// 랜덤으로 텍스트 파일 나오게 함
        	Random random = new Random();
        	int randomIndex = random.nextInt(textFiles.length);
        	String randomTextFile = textFiles[randomIndex];
        	
            BufferedReader reader = new BufferedReader(new FileReader("./file/" + randomTextFile));
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            reader.close();
            welcomeTextArea.setText(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
            welcomeTextArea.setText("Failed to load welcome text from file.");
        }
    }
    
    private void openBookApplicationFrame() {
    	dispose();
    	new BookApplicationFrame();
    }
    
    private void openBookSearchFrame() {
    	dispose();
    	new BookSearchFrame();
    }
    
    private void openApplicationStatusFrame() {
    	dispose();
    	new ApplicationStatusFrame();
    }
    
    private void openStudentInfoFrame() {
    	dispose();
    	new StudentInfoFrame();
    }
}
