package Student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    DefaultTableModel tableModel;
    JTable resultTable;
    
    String[] header = {"도서명", "ISBN", "출판사", "저자", "대출상태"};
    String[][] contents = {};
	
	public BookSearchFrame() {
		initializeUI();
		addComponentsUI();
		eventHandler();
		loadDataFromDatabase();
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
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "도서 검색"));
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
        
		// JTable을 DefaultTableModel로 초기화합니다.
	    tableModel = new DefaultTableModel(contents, header);

	    // JTable을 DefaultTableModel로 설정합니다.
	    resultTable = new JTable(tableModel);

	    // JScrollPane을 사용하여 JTable을 감싸기
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
	
	private void loadDataFromDatabase() {
        // 데이터베이스 연결 URL, 사용자 이름 및 비밀번호를 정의합니다.
        String dbUrl = "jdbc:mysql://localhost:3306/arumdaum?useTimezone=true&serverTimezone=UTC";
        String dbUser = "root";
        String dbPassword = "0000";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM book"; 
            ResultSet resultSet = statement.executeQuery(query);

            // 테이블의 기존 데이터를 지웁니다.
            tableModel.setRowCount(0);

            // 데이터베이스에서 가져온 데이터로 JTable을 채웁니다.
            while (resultSet.next()) {
                String bookName = resultSet.getString("title"); 
                String isbn = resultSet.getString("ISBN");
                String publisher = resultSet.getString("publisher");
                String author = resultSet.getString("author");
                String status = resultSet.getString("totalCopies");

                // JTable에 새로운 행을 추가합니다.
                tableModel.addRow(new String[]{bookName, isbn, publisher, author, status});
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
