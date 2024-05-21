import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class JC18011539Final extends JFrame{
	Connection conn;

	JTextField IDField=new JTextField();
	JTextField TitleField=new JTextField();
	JTextField DirectorField=new JTextField();
	JTextField ActorField=new JTextField();
	JTextField GenreField=new JTextField();
	JTextField Movie_timeField=new JTextField();
	JTextField Movie_dayField=new JTextField();
	JTextField Movie_rateField=new JTextField();
	JTextField Movie_openField=new JTextField();
	JTextField Movie_IntroductionField=new JTextField();

	JTextField Theater_ID_NUMField=new JTextField();
	JTextField Seat_quantityField=new JTextField();
	JTextField Used_OR_NOTField=new JTextField();

	JTextField Movie_Plan_IDField=new JTextField();
	JTextField MovieField=new JTextField();
	JTextField Movie_Theater_FKField=new JTextField();
	JTextField Movie_Start_DateField=new JTextField();
	JTextField Movie_Running_DayField=new JTextField();
	JTextField Movie_Running_IndexField=new JTextField();
	JTextField Movie_Starting_TimeField=new JTextField();

	JTextField Seat_Info_IDField=new JTextField();
	JTextField Seat_numField=new JTextField();
	JTextField Movie_Theater_FK_FKField=new JTextField();
	JTextField USED_OR_NOTField=new JTextField();

	JTextField USER_ID_NUMField=new JTextField();
	JTextField User_IDField=new JTextField();
	JTextField USER_NAMEField=new JTextField();
	JTextField User_PhoneField=new JTextField();
	JTextField User_EmailField=new JTextField();

	JTextField Register_ID_NUMField=new JTextField();
	JTextField Pay_methodField=new JTextField();
	JTextField Pay_stateField=new JTextField();
	JTextField Pay_priceField=new JTextField();
	JTextField Pay_DateField=new JTextField();
	JTextField RegistererField=new JTextField();

	JTextField Ticket_IDField=new JTextField();
	JTextField Movie_PlanField=new JTextField();
	JTextField Movie_Theater_FK_FK_FKField=new JTextField();
	JTextField Seat_InfoField=new JTextField();
	JTextField Register_InfoField=new JTextField();
	JTextField Print_OR_NOTField=new JTextField();
	JTextField Std_PriceField=new JTextField();
	JTextField Sold_PriceField=new JTextField();

	JTextField deleteInfoField=new JTextField();
	JTextField modifyInfoField=new JTextField();
	JTextField searchForModifyField=new JTextField();

	String [] tableName= {"Movies","Movie_Theaters","Movie_Plans","Seat_Infos","User_Infos","Register_Infos","Ticket_Infos"};
	JComboBox<String> tableNameComboForDeleteAdmin=new JComboBox<String>(tableName);
	JComboBox<String> tableNameComboForModifyAdmin=new JComboBox<String>(tableName);

	JTextField movieNameField=new JTextField(25);
	JTextField movieDirectorField=new JTextField(25);
	JTextField movieActorField=new JTextField(25);
	JTextField movieGenreField=new JTextField(25);

	String today=new String("2024/1/1");
	String myName=new String("root");

	JTable userTable;
	JTable underUserTable;

	JTextField seatNumField=new JTextField();
	public JC18011539Final(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbTest","root","0524");
			System.out.println("DB 연결 완료");
		}
		catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		}
		catch(SQLException e) {
			System.out.println("DB 연결 오류");
		}

		setTitle("영화 예매 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c=getContentPane();
		c.setLayout(new GridLayout(2,1));

		resetAll(1);

		JButton adminButton=new JButton("관리자");
		JButton userButton=new JButton("회원");

		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame adminFrame=new adminFrame();
			}
		});

		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame userFrame=new userFrame();
			}
		});

		c.add(adminButton);
		c.add(userButton);

		setSize(400,400);
		setVisible(true);
	}


	class adminFrame extends JFrame {
		public adminFrame() {
			setTitle("adminFrame");
			Container c1=getContentPane();
			c1.setLayout(new GridLayout(17,14,5,5));

			JButton resetAll=new JButton("초기화");
			JButton deleteInfo=new JButton("삭제");
			JButton modifyInfo=new JButton("변경");
			JButton viewAll=new JButton("전체조회");

			JButton insertInfo0=new JButton("Movies 입력");
			JButton cancelInsert0=new JButton("입력 취소");

			c1.add(new JLabel("ID",JLabel.RIGHT));
			c1.add(IDField);
			c1.add(new JLabel("Title",JLabel.RIGHT));
			c1.add(TitleField);
			c1.add(new JLabel("Director",JLabel.RIGHT));
			c1.add(DirectorField);
			c1.add(new JLabel("Actor",JLabel.RIGHT));
			c1.add(ActorField);
			c1.add(new JLabel("Genre",JLabel.RIGHT));
			c1.add(GenreField);
			c1.add(new JLabel("Movie_time",JLabel.RIGHT));
			c1.add(Movie_timeField);
			for(int z=0;z<2;z++) c1.add(new JLabel(""));

			c1.add(new JLabel("Movie_day",JLabel.RIGHT));
			c1.add(Movie_dayField);
			c1.add(new JLabel("Movie_rate",JLabel.RIGHT));
			c1.add(Movie_rateField);
			c1.add(new JLabel("Movie_open",JLabel.RIGHT));
			c1.add(Movie_openField);
			c1.add(new JLabel("Movie_Introduction",JLabel.RIGHT));
			c1.add(Movie_IntroductionField);
			for(int z=0;z<4;z++) c1.add(new JLabel(""));
			c1.add(insertInfo0);
			c1.add(cancelInsert0);
			for(int z=0;z<14;z++) c1.add(new JLabel(""));

			JButton insertInfo1=new JButton("Movie_Theaters 입력");
			JButton cancelInsert1=new JButton("입력 취소");

			c1.add(new JLabel("Theater_ID_NUM",JLabel.RIGHT));
			c1.add(Theater_ID_NUMField);
			c1.add(new JLabel("Seat_quantity",JLabel.RIGHT));
			c1.add(Seat_quantityField);
			c1.add(new JLabel("Used_OR_NOT",JLabel.RIGHT));
			c1.add(Used_OR_NOTField);
			for(int z=0;z<6;z++) c1.add(new JLabel(""));
			c1.add(insertInfo1);
			c1.add(cancelInsert1);
			for(int z=0;z<14;z++) c1.add(new JLabel(""));

			JButton insertInfo2=new JButton("Movie_Plans 입력");
			JButton cancelInsert2=new JButton("입력 취소");

			c1.add(new JLabel("Movie_Plan_ID",JLabel.RIGHT));
			c1.add(Movie_Plan_IDField);
			c1.add(new JLabel("Movie",JLabel.RIGHT));
			c1.add(MovieField);
			c1.add(new JLabel("Movie_Theater",JLabel.RIGHT));
			c1.add(Movie_Theater_FKField);
			c1.add(new JLabel("Movie_Start_Date",JLabel.RIGHT));
			c1.add(Movie_Start_DateField);
			c1.add(new JLabel("Movie_Running_Day",JLabel.RIGHT));
			c1.add(Movie_Running_DayField);
			c1.add(new JLabel("Movie_Running_Index",JLabel.RIGHT));
			c1.add(Movie_Running_IndexField);
			for(int z=0;z<2;z++) c1.add(new JLabel(""));
			c1.add(new JLabel("Movie_Starting_Time",JLabel.RIGHT));
			c1.add(Movie_Starting_TimeField);
			for(int z=0;z<10;z++) c1.add(new JLabel(""));
			c1.add(insertInfo2);
			c1.add(cancelInsert2);
			for(int z=0;z<14;z++) c1.add(new JLabel(""));

			JButton insertInfo3=new JButton("Seat_Infos 입력");
			JButton cancelInsert3=new JButton("입력 취소");

			c1.add(new JLabel("Seat_Info_ID",JLabel.RIGHT));
			c1.add(Seat_Info_IDField);
			c1.add(new JLabel("Seat_num",JLabel.RIGHT));
			c1.add(Seat_numField);
			c1.add(new JLabel("Movie_Theater",JLabel.RIGHT));
			c1.add(Movie_Theater_FK_FKField);
			c1.add(new JLabel("USED_OR_NOT",JLabel.RIGHT));
			c1.add(USED_OR_NOTField);
			for(int z=0;z<4;z++) c1.add(new JLabel(""));
			c1.add(insertInfo3);
			c1.add(cancelInsert3);
			for(int z=0;z<14;z++) c1.add(new JLabel(""));

			JButton insertInfo4=new JButton("User_Infos 입력");
			JButton cancelInsert4=new JButton("입력 취소");

			c1.add(new JLabel("USER_ID_NUM",JLabel.RIGHT));
			c1.add(USER_ID_NUMField);
			c1.add(new JLabel("User_ID",JLabel.RIGHT));
			c1.add(User_IDField);
			c1.add(new JLabel("USER_NAME",JLabel.RIGHT));
			c1.add(USER_NAMEField);
			c1.add(new JLabel("User_Phone",JLabel.RIGHT));
			c1.add(User_PhoneField);
			c1.add(new JLabel("User_Email",JLabel.RIGHT));
			c1.add(User_EmailField);
			for(int z=0;z<2;z++) c1.add(new JLabel(""));
			c1.add(insertInfo4);
			c1.add(cancelInsert4);
			for(int z=0;z<14;z++) c1.add(new JLabel(""));

			JButton insertInfo5=new JButton("Register_Infos 입력");
			JButton cancelInsert5=new JButton("입력 취소");

			c1.add(new JLabel("Register_ID_NUM",JLabel.RIGHT));
			c1.add(Register_ID_NUMField);
			c1.add(new JLabel("Pay_method",JLabel.RIGHT));
			c1.add(Pay_methodField);
			c1.add(new JLabel("Pay_state",JLabel.RIGHT));
			c1.add(Pay_stateField);
			c1.add(new JLabel("Pay_price",JLabel.RIGHT));
			c1.add(Pay_priceField);
			c1.add(new JLabel("Pay_Date",JLabel.RIGHT));
			c1.add(Pay_DateField);
			c1.add(new JLabel("Registerer",JLabel.RIGHT));
			c1.add(RegistererField);
			c1.add(insertInfo5);
			c1.add(cancelInsert5);
			for(int z=0;z<14;z++) c1.add(new JLabel(""));

			JButton insertInfo6=new JButton("Ticket_Infos 입력");
			JButton cancelInsert6=new JButton("입력 취소");

			c1.add(new JLabel("Ticket_ID",JLabel.RIGHT));
			c1.add(Ticket_IDField);
			c1.add(new JLabel("Movie_Plan",JLabel.RIGHT));
			c1.add(Movie_PlanField);
			c1.add(new JLabel("Movie_Theater",JLabel.RIGHT));
			c1.add(Movie_Theater_FK_FK_FKField);
			c1.add(new JLabel("Seat_Info",JLabel.RIGHT));
			c1.add(Seat_InfoField);
			c1.add(new JLabel("Register_Info",JLabel.RIGHT));
			c1.add(Register_InfoField);
			c1.add(new JLabel("Print_OR_NOT",JLabel.RIGHT));
			c1.add(Print_OR_NOTField);
			for(int z=0;z<2;z++) c1.add(new JLabel(""));
			c1.add(new JLabel("Std_Price",JLabel.RIGHT));
			c1.add(Std_PriceField);
			c1.add(new JLabel("Sold_Price",JLabel.RIGHT));
			c1.add(Sold_PriceField);
			for(int z=0;z<8;z++) c1.add(new JLabel(""));
			c1.add(insertInfo6);
			c1.add(cancelInsert6);


			resetAll.addActionListener(new adminAction());
			deleteInfo.addActionListener(new adminAction());
			modifyInfo.addActionListener(new adminAction());
			viewAll.addActionListener(new adminAction());
			insertInfo0.addActionListener(new adminAction());
			insertInfo1.addActionListener(new adminAction());
			insertInfo2.addActionListener(new adminAction());
			insertInfo3.addActionListener(new adminAction());
			insertInfo4.addActionListener(new adminAction());
			insertInfo5.addActionListener(new adminAction());
			insertInfo6.addActionListener(new adminAction());

			cancelInsert0.addActionListener(new cancelInsert0Action());
			cancelInsert1.addActionListener(new cancelInsert1Action());
			cancelInsert2.addActionListener(new cancelInsert2Action());
			cancelInsert3.addActionListener(new cancelInsert3Action());
			cancelInsert4.addActionListener(new cancelInsert4Action());
			cancelInsert5.addActionListener(new cancelInsert5Action());
			cancelInsert6.addActionListener(new cancelInsert6Action());

			c1.add(new JLabel(""));
			c1.add(resetAll);

			c1.add(new JLabel("테이블 선택",JLabel.RIGHT));
			c1.add(tableNameComboForDeleteAdmin);
			c1.add(deleteInfoField);
			c1.add(deleteInfo);

			c1.add(new JLabel("테이블 선택",JLabel.RIGHT));
			c1.add(tableNameComboForModifyAdmin);
			c1.add(new JLabel("찾을 정보",JLabel.CENTER));
			c1.add(searchForModifyField);
			c1.add(new JLabel("바꿀 정보",JLabel.CENTER));
			c1.add(modifyInfoField);
			c1.add(modifyInfo);

			c1.add(viewAll);

			setSize(2400,1000);
			setVisible(true);
		}
	}

	void resetAll(int flag) {
		String [] query={"drop table if exists Movies, Movie_Theaters, Movie_Plans, Seat_Infos, Ticket_Infos, Register_Infos, User_Infos;",
				" CREATE TABLE Movies ("
						+ "   ID INTEGER NOT NULL ,"
						+ "   Title VARCHAR(255) NOT NULL,"
						+ "   Director VARCHAR(255) NOT NULL,"
						+ "   Actor VARCHAR(255) NOT NULL,"
						+ "   Genre VARCHAR(255) NOT NULL,"
						+ "   Movie_time VARCHAR(255) NOT NULL,"
						+ "   Movie_day VARCHAR(255) NOT NULL,"
						+ "   Movie_rate VARCHAR(255) NOT NULL,"
						+ "   Movie_open VARCHAR(255) NOT NULL ,"
						+ "   Movie_Introduction varchar(255) not null,"
						+ "   CONSTRAINT  Movies_ID_PK PRIMARY KEY (ID)"
						+ ");",
				"CREATE TABLE Movie_Theaters ("
						+ "   Theater_ID_NUM INTEGER NOT NULL ,"
						+ "   Seat_quantity INTEGER NOT NULL,"
						+ "   Used_OR_NOT boolean,"
						+ "   CONSTRAINT  Theater_ID_NUM_PK PRIMARY KEY (Theater_ID_NUM)"
						+ " );",
				"CREATE TABLE Movie_Plans("
						+ "    Movie_Plan_ID INTEGER NOT NULL ,"
						+ "    Movie INTEGER NOT NULL ,"
						+ "    CONSTRAINT Movies_ID_FK FOREIGN KEY (Movie) REFERENCES Movies(ID) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "    Movie_Theater INTEGER,"
						+ "    CONSTRAINT Movie_Theater_FK FOREIGN KEY (Movie_Theater) REFERENCES Movie_Theaters(Theater_ID_NUM) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "    Movie_Start_Date VARCHAR(255) not null ,"
						+ "    Movie_Running_Day VARCHAR(255) not null,"
						+ "    Movie_Running_Index INTEGER not null ,"
						+ "    Movie_Starting_Time VARCHAR(255) not null,"
						+ "    CONSTRAINT Movie_Plan_ID_PK PRIMARY KEY (Movie_Plan_ID)"
						+ ");",
				"CREATE TABLE Seat_Infos("
						+ "    Seat_Info_ID INTEGER PRIMARY KEY ,"
						+ "    Seat_num integer not null ,"
						+ "    Movie_Theater INTEGER,"
						+ "    CONSTRAINT Movie_Theater_FK_FK FOREIGN KEY (Movie_Theater) REFERENCES Movie_Theaters(Theater_ID_NUM) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "    USED_OR_NOT boolean not null"
						+ ");",
				"CREATE TABLE User_Infos("
						+ "    USER_ID_NUM INTEGER NOT NULL ,"
						+ "    User_ID VARCHAR(255) not null ,"
						+ "    USER_NAME VARCHAR(255) not null ,"
						+ "    User_Phone VARCHAR(13) not null ,"
						+ "    User_Email VARCHAR(255) not null,"
						+ "    CONSTRAINT USER_ID_NUM_PK PRIMARY KEY (USER_ID_NUM)"
						+ ");",
				"CREATE TABLE Register_Infos("
						+ "    Register_ID_NUM INTEGER NOT NULL,"
						+ "    Pay_method VARCHAR(255) not null,"
						+ "    Pay_state boolean not null,"
						+ "    Pay_price INTEGER not null,"
						+ "    Pay_Date VARCHAR(255) not null,"
						+ "    Registerer INTEGER,"
						+ "    CONSTRAINT Registerer_FK FOREIGN KEY (Registerer) REFERENCES User_Infos(USER_ID_NUM) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "    CONSTRAINT Register_ID_NUM_PK PRIMARY KEY (Register_ID_NUM)"
						+ ");",
				"CREATE TABLE Ticket_Infos ("
						+ "    Ticket_ID INTEGER NOT NULL,"
						+ "    Movie_Plan INTEGER NOT NULL ,"
						+ "    CONSTRAINT  Movie_Plan_FK FOREIGN KEY (Movie_Plan) REFERENCES  Movie_Plans(Movie_Plan_ID) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "    Movie_Theater INTEGER NOT NULL ,"
						+ "    CONSTRAINT  Movie_Theater_FK_FK_FK FOREIGN KEY (Movie_Theater) REFERENCES  Movie_Plans(Movie_Theater) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "    Seat_Info INTEGER NOT NULL ,"
						+ "    CONSTRAINT  Seat_Info_FK FOREIGN KEY (Seat_Info) REFERENCES  Seat_Infos(Seat_Info_ID) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "    Register_Info INTEGER NOT NULL ,"
						+ "    CONSTRAINT  Register_Info_FK FOREIGN KEY (Register_Info) REFERENCES  Register_Infos(Register_ID_NUM) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "    Print_OR_NOT boolean not null ,"
						+ "    Std_Price INTEGER not null ,"
						+ "    Sold_Price INTEGER not null,"
						+ "    CONSTRAINT Ticket_ID_PK PRIMARY KEY (Ticket_ID)"
						+ ");",
				"INSERT INTO Movies values(1,'a','aack', 'aohn', 'horror', '0100', 'Wed', 'all', '2021/1/2', 'damnscarry');",
				"INSERT INTO Movies values(2,'b','jack', 'john', 'horror', '0100', 'Thur', '12', '2021/2/2', 'fxxkinscarry');",
				"INSERT INTO Movies values(3,'c','jack', 'aohn', 'comedy', '0200', 'Thur', '15', '2021/3/2', 'damnfun');",
				"INSERT INTO Movies values(4,'d','aack', 'john', 'comedy', '0400', 'Fri', '15', '2021/4/2', 'fxxkinfun');",
				"INSERT INTO Movies values(5,'e', 'yeon', 'kyungwon' , 'romance', '0200', 'Fri', '19', '2021/5/2', 'holyfxxk!!');",
				"INSERT INTO Movies values(6,'f','yeon', 'kyungwon', 'fantasy', '0600', 'Sat', '19', '2021/6/2', 'goddamn');",
				"INSERT INTO Movies values(7,'g','yeon', 'wook', 'Act', '0230', 'Sat', '12', '2021/7/2', 'destroyupupup');",
				"INSERT INTO Movies values(8,'h','jack', 'aohn', 'Act', '0220', 'Sun', 'all', '2021/8/2', 'damnfunfunfun');",
				"INSERT INTO Movies values(9,'i','jack', 'kyungwon', 'fantasy', '0300', 'Sun', '19', '2021/9/2', 'damnfunagain');",
				"INSERT INTO Movies values(10,'j','yeon', 'aohn', 'romance', '0200', 'Wed', '15', '2021/10/2', 'damnfunfunfunfun');",
				"INSERT INTO Movie_Theaters values(1,8,TRUE);",
				"INSERT INTO Movie_Theaters values(2,8,TRUE);",
				"INSERT INTO Movie_Theaters values(3,8,TRUE);",
				"INSERT INTO Movie_Theaters values(4,8,TRUE);",
				"INSERT INTO Movie_Theaters values(5,8,TRUE);",
				"INSERT INTO Movie_Theaters values(6,8,TRUE);",
				"INSERT INTO Movie_Theaters values(7,8,TRUE);",
				"INSERT INTO Movie_Theaters values(8,8,TRUE);",
				"INSERT INTO Movie_Theaters values(9,8,TRUE);",
				"INSERT INTO Movie_Theaters values(10,8,TRUE);",
				"INSERT INTO Movie_Plans values(1,1,1,'2021/1/3','Wed',1,0700);",
				"INSERT INTO Movie_Plans values(2,2,2,'2021/2/3','Thur',2,0800);",
				"INSERT INTO Movie_Plans values(3,3,3,'2021/3/3','Thur',3,0900);",
				"INSERT INTO Movie_Plans values(4,4,4,'2021/4/3','Fri',4,1000);",
				"INSERT INTO Movie_Plans values(5,5,5,'2021/5/3','Fri',5,1100);",
				"INSERT INTO Movie_Plans values(6,6,6,'2021/6/3','Sat',6,1200);",
				"INSERT INTO Movie_Plans values(7,7,7,'2021/7/3','Sat',7,1300);",
				"INSERT INTO Movie_Plans values(8,8,8,'2021/8/3','Sun',8,1400);",
				"INSERT INTO Movie_Plans values(9,9,9,'2021/9/3','Sun',9,1500);",
				"INSERT INTO Movie_Plans values(10,10,10,'2021/10/3','Wed',10,1600);",

				"INSERT INTO Seat_Infos values(1, 1, 1, TRUE);",
				"INSERT INTO Seat_Infos values(11, 2, 1, FALSE);",
				"INSERT INTO Seat_Infos values(12, 3, 1, FALSE);",
				"INSERT INTO Seat_Infos values(13, 4, 1, FALSE);",
				"INSERT INTO Seat_Infos values(14, 5, 1, FALSE);",
				"INSERT INTO Seat_Infos values(15, 6, 1, FALSE);",
				"INSERT INTO Seat_Infos values(16, 7, 1, FALSE);",
				"INSERT INTO Seat_Infos values(17, 8, 1, FALSE);",

				"INSERT INTO Seat_Infos values(10, 1, 2, FALSE);",
				"INSERT INTO Seat_Infos values(6, 2, 2, TRUE);",
				"INSERT INTO Seat_Infos values(2, 3, 2, TRUE);",
				"INSERT INTO Seat_Infos values(3, 4, 2, TRUE);",
				"INSERT INTO Seat_Infos values(21, 5, 2, FALSE);",
				"INSERT INTO Seat_Infos values(22, 6, 2, FALSE);",
				"INSERT INTO Seat_Infos values(23, 7, 2, FALSE);",
				"INSERT INTO Seat_Infos values(24, 8, 2, FALSE);",

				"INSERT INTO Seat_Infos values(5, 1, 3, TRUE);",
				"INSERT INTO Seat_Infos values(25, 2, 3, FALSE);",
				"INSERT INTO Seat_Infos values(26, 3, 3, FALSE);",
				"INSERT INTO Seat_Infos values(27, 4, 3, FALSE);",
				"INSERT INTO Seat_Infos values(4, 5, 3, FALSE);",
				"INSERT INTO Seat_Infos values(28, 6, 3, FALSE);",
				"INSERT INTO Seat_Infos values(29, 7, 3, FALSE);",
				"INSERT INTO Seat_Infos values(9, 8, 3, TRUE);",

				"INSERT INTO Seat_Infos values(30, 1, 4, FALSE);",
				"INSERT INTO Seat_Infos values(31, 2, 4, FALSE);",
				"INSERT INTO Seat_Infos values(32, 3, 4, FALSE);",
				"INSERT INTO Seat_Infos values(33, 4, 4, FALSE);",
				"INSERT INTO Seat_Infos values(34, 5, 4, FALSE);",
				"INSERT INTO Seat_Infos values(35, 6, 4, FALSE);",
				"INSERT INTO Seat_Infos values(36, 7, 4, FALSE);",
				"INSERT INTO Seat_Infos values(37, 8, 4, FALSE);",

				"INSERT INTO Seat_Infos values(38, 1, 5, FALSE);",
				"INSERT INTO Seat_Infos values(39, 2, 5, FALSE);",
				"INSERT INTO Seat_Infos values(40, 3, 5, FALSE);",
				"INSERT INTO Seat_Infos values(41, 4, 5, FALSE);",
				"INSERT INTO Seat_Infos values(42, 5, 5, FALSE);",
				"INSERT INTO Seat_Infos values(43, 6, 5, FALSE);",
				"INSERT INTO Seat_Infos values(44, 7, 5, FALSE);",
				"INSERT INTO Seat_Infos values(45, 8, 5, FALSE);",

				"INSERT INTO Seat_Infos values(46, 1, 6, FALSE);",
				"INSERT INTO Seat_Infos values(47, 2, 6, FALSE);",
				"INSERT INTO Seat_Infos values(7, 3, 6, False);",
				"INSERT INTO Seat_Infos values(48, 4, 6, FALSE);",
				"INSERT INTO Seat_Infos values(49, 5, 6, FALSE);",
				"INSERT INTO Seat_Infos values(50, 6, 6, FALSE);",
				"INSERT INTO Seat_Infos values(51, 7, 6, FALSE);",
				"INSERT INTO Seat_Infos values(52, 8, 6, FALSE);",

				"INSERT INTO Seat_Infos values(8, 1, 7, TRUE);",
				"INSERT INTO Seat_Infos values(53, 2, 7, FALSE);",
				"INSERT INTO Seat_Infos values(54, 3, 7, FALSE);",
				"INSERT INTO Seat_Infos values(55, 4, 7, FALSE);",
				"INSERT INTO Seat_Infos values(56, 5, 7, FALSE);",
				"INSERT INTO Seat_Infos values(57, 6, 7, FALSE);",
				"INSERT INTO Seat_Infos values(58, 7, 7, FALSE);",
				"INSERT INTO Seat_Infos values(59, 8, 7, FALSE);",

				"INSERT INTO Seat_Infos values(60, 1, 8, FALSE);",
				"INSERT INTO Seat_Infos values(61, 2, 8, FALSE);",
				"INSERT INTO Seat_Infos values(62, 3, 8, FALSE);",
				"INSERT INTO Seat_Infos values(63, 4, 8, FALSE);",
				"INSERT INTO Seat_Infos values(64, 5, 8, FALSE);",
				"INSERT INTO Seat_Infos values(65, 6, 8, FALSE);",
				"INSERT INTO Seat_Infos values(66, 7, 8, FALSE);",
				"INSERT INTO Seat_Infos values(67, 8, 8, FALSE);",

				"INSERT INTO Seat_Infos values(68, 1, 9, FALSE);",
				"INSERT INTO Seat_Infos values(69, 2, 9, FALSE);",
				"INSERT INTO Seat_Infos values(70, 3, 9, FALSE);",
				"INSERT INTO Seat_Infos values(71, 4, 9, FALSE);",
				"INSERT INTO Seat_Infos values(72, 5, 9, FALSE);",
				"INSERT INTO Seat_Infos values(73, 6, 9, FALSE);",
				"INSERT INTO Seat_Infos values(74, 7, 9, FALSE);",
				"INSERT INTO Seat_Infos values(75, 8, 9, FALSE);",

				"INSERT INTO Seat_Infos values(76, 1, 10, FALSE);",
				"INSERT INTO Seat_Infos values(77, 2, 10, FALSE);",
				"INSERT INTO Seat_Infos values(78, 3, 10, FALSE);",
				"INSERT INTO Seat_Infos values(79, 4, 10, FALSE);",
				"INSERT INTO Seat_Infos values(80, 5, 10, FALSE);",
				"INSERT INTO Seat_Infos values(18, 6, 10, FALSE);",
				"INSERT INTO Seat_Infos values(19, 7, 10, FALSE);",
				"INSERT INTO Seat_Infos values(20, 8, 10, FALSE);",


				"INSERT INTO User_Infos values(1, 'aeon', 'aeonwoo', '010-0000-0001', 'aeon@nav');",
				"INSERT INTO User_Infos values(2, 'beon', 'beonwoo', '010-0000-0002', 'beon@nav');",
				"INSERT INTO User_Infos values(3, 'ceon', 'ceonwoo', '010-0000-0003', 'ceon@nav');",
				"INSERT INTO User_Infos values(4, 'deon', 'deonwoo', '010-0000-0004', 'deon@nav');",
				"INSERT INTO User_Infos values(5, 'eeon', 'eeonwoo', '010-0000-0005', 'eeon@nav');",
				"INSERT INTO User_Infos values(6, 'feon', 'feonwoo', '010-0000-0006', 'feon@nav');",
				"INSERT INTO User_Infos values(7, 'geon', 'geonwoo', '010-0000-0007', 'geon@nav');",
				"INSERT INTO User_Infos values(8, 'heon', 'heonwoo', '010-0000-0008', 'heon@nav');",
				"INSERT INTO User_Infos values(9, 'ieon', 'ieonwoo', '010-0000-0009', 'ieon@nav');",
				"INSERT INTO User_Infos values(10, 'jeon', 'jeonwoo', '010-0000-0010', 'jeon@nav');",
				"INSERT INTO Register_Infos values(1, 'card', TRUE, 10000,'2021/1/1', 1);",
				"INSERT INTO Register_Infos values(2, 'card', TRUE, 10000,'2021/1/1', 2);",
				"INSERT INTO Register_Infos values(3, 'cash', TRUE, 10000,'2021/1/1', 1);",
				"INSERT INTO Register_Infos values(4, 'none', FALSE, 0,'2021/1/1', 3);",
				"INSERT INTO Register_Infos values(5, 'cash', TRUE, 10000,'2021/1/1', 4);",
				"INSERT INTO Register_Infos values(6, 'card', TRUE, 10000,'2021/1/1', 6);",
				"INSERT INTO Register_Infos values(7, 'none', FALSE, 0,'2021/1/1', 2);",
				"INSERT INTO Register_Infos values(8, 'cash', TRUE, 10000,'2021/1/1', 1);",
				"INSERT INTO Register_Infos values(9, 'card', TRUE, 10000,'2021/1/1', 7);",
				"INSERT INTO Register_Infos values(10, 'card', TRUE, 10000,'2021/1/1', 8);",
				"INSERT INTO Ticket_Infos values(1, 1, 1,1, 1, TRUE, 10000, 10000);",
				"INSERT INTO Ticket_Infos values(2, 2, 2,2, 2, FALSE, 10000, 10000);",
				"INSERT INTO Ticket_Infos values(3, 2, 2,3, 3, TRUE, 10000, 10000);",
				"INSERT INTO Ticket_Infos values(4, 3, 3,4, 4, FALSE, 10000, 0);",
				"INSERT INTO Ticket_Infos values(5, 3, 3,5, 5, TRUE, 10000, 10000);",
				"INSERT INTO Ticket_Infos values(6, 2, 2,6, 6, FALSE, 10000, 10000);",
				"INSERT INTO Ticket_Infos values(7, 6, 6,7, 7, FALSE, 10000, 0);",
				"INSERT INTO Ticket_Infos values(8, 7, 7,8, 8, FALSE, 10000, 10000);",
				"INSERT INTO Ticket_Infos values(9, 3, 3,9, 9, TRUE, 10000, 10000);",
				"INSERT INTO Ticket_Infos values(10, 2, 2,10, 10, TRUE, 10000, 10000);"
		};

		try {
			Statement stmt=conn.createStatement();
			for(int i=0;i<query.length;i++) stmt.execute(query[i]);
			if(flag==0) JOptionPane.showMessageDialog(null, "초기화 성공");
		}
		catch(Exception a) {
			a.printStackTrace();
		}
	}

	void insertInfo0() {
		try {
			Statement stmt=conn.createStatement();
			if(IDField.getText().equals("")||TitleField.getText().equals("")||DirectorField.getText().equals("")||ActorField.getText().equals("")||GenreField.getText().equals("")||Movie_timeField.getText().equals("")||Movie_dayField.getText().equals("")||Movie_rateField.getText().equals("")||Movie_openField.getText().equals("")||Movie_IntroductionField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "데이터를 모두 입력해주세요.");
				return;
			}

			ResultSet rs=stmt.executeQuery("SELECT * from Movies");
			while(rs.next()) {
				if(Integer.parseInt(IDField.getText())==rs.getInt(1)) {
					JOptionPane.showMessageDialog(null, "이미 동일한 ID가 있습니다.");
					return;
				}
			}

			String query="INSERT INTO Movies values("+IDField.getText()+",'"+TitleField.getText()+"','"+DirectorField.getText()+"','"+ActorField.getText()+"','"+GenreField.getText()+"','"+Movie_timeField.getText()+"','"+Movie_dayField.getText()+"','"+Movie_rateField.getText()+"','"+Movie_openField.getText()+"','"+Movie_IntroductionField.getText()+"');";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "입력 성공");

		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			a.printStackTrace();
		}
	}

	void insertInfo1() {
		try {
			Statement stmt=conn.createStatement();
			if(Theater_ID_NUMField.getText().equals("")||Seat_quantityField.getText().equals("")||Used_OR_NOTField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "데이터를 모두 입력해주세요.");
				return;
			}

			ResultSet rs=stmt.executeQuery("SELECT * FROM Movie_Theaters");
			while(rs.next()) {
				if(Integer.parseInt(Theater_ID_NUMField.getText())==rs.getInt(1)) {
					JOptionPane.showMessageDialog(null, "이미 동일한 Theater_ID_NUM이 있습니다.");
					return;
				}
			}

			String query="INSERT INTO Movie_Theaters values("+Theater_ID_NUMField.getText()+","+Seat_quantityField.getText()+","+Used_OR_NOTField.getText()+");";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "입력 성공");

		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			a.printStackTrace();
		}
	}

	void insertInfo2() {
		int flag=0;
		try {
			Statement stmt=conn.createStatement();
			if(Movie_Plan_IDField.getText().equals("")||MovieField.getText().equals("")||Movie_Theater_FKField.getText().equals("")||Movie_Start_DateField.getText().equals("")||Movie_Running_DayField.getText().equals("")||Movie_Running_IndexField.getText().equals("")||Movie_Starting_TimeField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "데이터를 모두 입력해주세요.");
				return;
			}

			ResultSet rs=stmt.executeQuery("SELECT * FROM Movie_Plans");
			while(rs.next()) {
				if(Integer.parseInt(Movie_Plan_IDField.getText())==rs.getInt(1)) {
					JOptionPane.showMessageDialog(null, "이미 동일한 Movie_Plan_ID가 있습니다.");
					return;
				}
			}

			rs=stmt.executeQuery("SELECT ID FROM Movies");
			while(rs.next()) {
				if(Integer.parseInt(MovieField.getText())==rs.getInt(1)) flag=1;
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "Movies 테이블에 해당하는 ID가 없습니다.");
				return;
			}
			flag=0;

			rs=stmt.executeQuery("SELECT Theater_ID_NUM FROM Movie_Theaters");
			while(rs.next()) {
				if(Integer.parseInt(Movie_Theater_FKField.getText())==rs.getInt(1)) flag=1;
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "Movie_Theaters 테이블에 해당하는 Theater_ID_NUM이 없습니다.");
				return;
			}
			flag=0;

			String query="INSERT INTO Movie_Plans values("+Movie_Plan_IDField.getText()+","+MovieField.getText()+","+Movie_Theater_FKField.getText()+",'"+Movie_Start_DateField.getText()+"','"+Movie_Running_DayField.getText()+"',"+Movie_Running_IndexField.getText()+","+Movie_Starting_TimeField.getText()+");";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "입력 성공");


			query="UPDATE Movie_Theaters SET Used_OR_NOT=TRUE WHERE Theater_ID_NUM="+Movie_Theater_FKField.getText()+";";
			stmt.execute(query);
		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다");
			a.printStackTrace();
		}
	}

	void insertInfo3() {
		int flag=0;
		try {
			Statement stmt=conn.createStatement();
			if(Seat_Info_IDField.getText().equals("")||Seat_numField.getText().equals("")||Movie_Theater_FK_FKField.getText().equals("")||USED_OR_NOTField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "데이터를 모두 입력해주세요.");
				return;
			}

			ResultSet rs=stmt.executeQuery("SELECT * FROM Seat_Infos");
			while(rs.next()) {
				if(Integer.parseInt(Seat_Info_IDField.getText())==rs.getInt(1)) {
					JOptionPane.showMessageDialog(null, "이미 동일한 Seat_Info_ID가 있습니다.");
					return;
				}
			}

			rs=stmt.executeQuery("SELECT Seat_quantity FROM Movie_Theaters WHERE Theater_ID_NUM="+Movie_Theater_FK_FKField.getText()+" AND Seat_quantity>"+Seat_numField.getText()+";");
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(null, "해당하는 좌석번호는 "+Movie_Theater_FK_FKField.getText()+"상영관에 없는 좌석번호 입니다.");
				return;
			}

			rs=stmt.executeQuery("SELECT Theater_ID_NUM FROM Movie_Theaters");
			while(rs.next()) {
				if(Integer.parseInt(Movie_Theater_FK_FKField.getText())==rs.getInt(1)) flag=1;
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "Movie_Theaters 테이블에 해당하는 Theater_ID_NUM이 없습니다.");
				return;
			}
			flag=0;

			String query="INSERT INTO Seat_Infos values("+Seat_Info_IDField.getText()+","+Seat_numField.getText()+","+Movie_Theater_FK_FKField.getText()+","+USED_OR_NOTField.getText()+");";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "입력 성공");

		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다");
			a.printStackTrace();
		}
	}

	void insertInfo4() {
		try {
			Statement stmt=conn.createStatement();
			if(USER_ID_NUMField.getText().equals("")||User_IDField.getText().equals("")||USER_NAMEField.getText().equals("")||User_PhoneField.getText().equals("")||User_EmailField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "데이터를 모두 입력해주세요.");
				return;
			}

			ResultSet rs=stmt.executeQuery("SELECT * FROM User_Infos");
			while(rs.next()) {
				if(Integer.parseInt(USER_ID_NUMField.getText())==rs.getInt(1)) {
					JOptionPane.showMessageDialog(null, "이미 동일한 USER_ID_NUM이 있습니다.");
					return;
				}
			}

			rs=stmt.executeQuery("SELECT User_ID FROM User_Infos");
			while(rs.next()) {
				if(rs.getString(1).equals(User_IDField.getText())) {
					JOptionPane.showMessageDialog(null, "이미 동일한 User_ID가 있습니다.");
					return;
				}
			}

			rs=stmt.executeQuery("SELECT User_Phone FROM User_Infos");
			while(rs.next()) {
				if(rs.getString(1).equals(User_PhoneField.getText())) {
					JOptionPane.showMessageDialog(null, "이미 동일한 User_Phone이 있습니다.");
					return;
				}
			}

			rs=stmt.executeQuery("SELECT User_Email FROM User_Infos");
			while(rs.next()) {
				if(rs.getString(1).equals(User_EmailField.getText())) {
					JOptionPane.showMessageDialog(null, "이미 동일한 User_Email이 있습니다.");
					return;
				}
			}

			String query="INSERT INTO User_Infos values("+USER_ID_NUMField.getText()+",'"+User_IDField.getText()+"','"+USER_NAMEField.getText()+"','"+User_PhoneField.getText()+"','"+User_EmailField.getText()+"');";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "입력 성공");

		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다");
			a.printStackTrace();
		}
	}

	void insertInfo5() {
		int flag=0;
		try {
			Statement stmt=conn.createStatement();
			if(Register_ID_NUMField.getText().equals("")||Pay_methodField.getText().equals("")||Pay_stateField.getText().equals("")||Pay_priceField.getText().equals("")||Pay_DateField.getText().equals("")||RegistererField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "데이터를 모두 입력해주세요.");
				return;
			}

			ResultSet rs=stmt.executeQuery("SELECT * FROM Register_Infos");
			while(rs.next()) {
				if(Integer.parseInt(Register_ID_NUMField.getText())==rs.getInt(1)) {
					JOptionPane.showMessageDialog(null, "이미 동일한 Register_ID_NUM이 있습니다.");
					return;
				}
			}

			rs=stmt.executeQuery("SELECT USER_ID_NUM FROM User_Infos");
			while(rs.next()) {
				if(Integer.parseInt(RegistererField.getText())==rs.getInt(1)) flag=1;
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "User_Infos 테이블에 해당하는 USER_ID_NUM이 없습니다.");
				return;
			}
			flag=0;

			String query="INSERT INTO Register_Infos values("+Register_ID_NUMField.getText()+",'"+Pay_methodField.getText()+"',"+Pay_stateField.getText()+","+Pay_priceField.getText()+",'"+Pay_DateField.getText()+"',"+RegistererField.getText()+");";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "입력 성공");

		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다");
			a.printStackTrace();
		}
	}

	void insertInfo6() {
		int flag=0;
		try {
			Statement stmt=conn.createStatement();
			if(Ticket_IDField.getText().equals("")||Movie_PlanField.getText().equals("")||Movie_Theater_FK_FK_FKField.getText().equals("")||Seat_InfoField.getText().equals("")||Register_InfoField.getText().equals("")||Print_OR_NOTField.getText().equals("")||Std_PriceField.getText().equals("")||Sold_PriceField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "데이터를 모두 입력해주세요.");
				return;
			}

			ResultSet rs=stmt.executeQuery("SELECT * FROM Ticket_Infos");
			while(rs.next()) {
				if(Integer.parseInt(Ticket_IDField.getText())==rs.getInt(1)) {
					JOptionPane.showMessageDialog(null, "이미 동일한 Ticket_ID가 있습니다.");
					return;
				}
			}

			rs=stmt.executeQuery("SELECT Movie_Plan_ID FROM Movie_Plans");
			while(rs.next()) {
				if(Integer.parseInt(Movie_PlanField.getText())==rs.getInt(1)) flag=1;
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "Movie_Plans 테이블에 해당하는 Movie_Plan_ID가 없습니다.");
				return;
			}
			flag=0;

			rs=stmt.executeQuery("SELECT Movie_Theater FROM Movie_Plans");
			while(rs.next()) {
				if(Integer.parseInt(Movie_Theater_FK_FK_FKField.getText())==rs.getInt(1)) flag=1;
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "Movie_Plans 테이블에 해당하는 Movie_Theater이 없습니다.");
				return;
			}
			flag=0;

			rs=stmt.executeQuery("SELECT Seat_Info_ID FROM Seat_Infos");
			while(rs.next()) {
				if(Integer.parseInt(Seat_InfoField.getText())==rs.getInt(1)) flag=1;
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "Seat_Infos 테이블에 해당하는 Seat_Info_ID가 없습니다.");
				return;
			}
			flag=0;

			rs=stmt.executeQuery("SELECT Register_ID_NUM FROM Register_Infos");
			while(rs.next()) {
				if(Integer.parseInt(Register_InfoField.getText())==rs.getInt(1)) flag=1;
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "Register_Infos 테이블에 해당하는 Register_ID_NUM이 없습니다.");
				return;
			}
			flag=0;

			String query="INSERT INTO Ticket_Infos values("+Ticket_IDField.getText()+","+Movie_PlanField.getText()+","+Movie_Theater_FK_FK_FKField.getText()+","+Seat_InfoField.getText()+","+Register_InfoField.getText()+","+Print_OR_NOTField.getText()+","+Std_PriceField.getText()+","+Sold_PriceField.getText()+");";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "입력 성공");

		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			a.printStackTrace();
		}
	}

	void deleteInfo() {
		try {
			Statement stmt=conn.createStatement();
			String deleteLocation=tableNameComboForDeleteAdmin.getSelectedItem().toString();
			String deleteCondition=deleteInfoField.getText();

			if(deleteCondition.length()==0) {
				JOptionPane.showMessageDialog(null, "조건식을 입력해주세요.");
				return;
			}

			String query="SELECT * FROM "+deleteLocation+" WHERE "+deleteCondition+";";
			ResultSet rs=stmt.executeQuery(query);

			if(rs.next()==false) {
				JOptionPane.showMessageDialog(null, "삭제할 데이터가 없습니다.");
				return;
			}

			query="DELETE FROM "+deleteLocation+" Where "+deleteCondition+";";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "삭제 성공");

		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null,"잘못된 입력입니다.");
			a.printStackTrace();
		}
	}

	void modifyInfo() {
		try {
			Statement stmt=conn.createStatement();
			String modifyLocation=tableNameComboForModifyAdmin.getSelectedItem().toString();
			String searchForModifyCondition=searchForModifyField.getText();
			String modifyCondition=modifyInfoField.getText();

			if(modifyCondition.length()==0 || searchForModifyCondition.length()==0) {
				JOptionPane.showMessageDialog(null, "조건식을 입력해주세요.");
				return;
			}

			String query="SELECT * FROM "+modifyLocation+" WHERE "+searchForModifyCondition+";";
			ResultSet rs=stmt.executeQuery(query);

			if(rs.next()==false) {
				JOptionPane.showMessageDialog(null, "수정할 데이터가 없습니다.");
				return;
			}

			query="UPDATE "+modifyLocation+" SET "+modifyCondition+" WHERE "+searchForModifyCondition+";";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "수정 성공");

		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null,"잘못된 입력입니다.");
			a.printStackTrace();
		}
	}

	void viewAll() {
		int cnt, i, j;
		String [] query= new String [7];

		JFrame answer=new JFrame();
		answer.setTitle("전체조회");
		answer.setLayout(new GridLayout(4,2,5,5));
		answer.setSize(2500,1000);

		query[0]="SELECT * FROM Movies";
		query[1]="SELECT * FROM Movie_Theaters";
		query[2]="SELECT * FROM Movie_Plans";
		query[3]="SELECT * FROM Seat_Infos";
		query[4]="SELECT * FROM User_Infos";
		query[5]="SELECT * FROM Register_Infos";
		query[6]="SELECT * FROM Ticket_Infos";

		try {
			Statement stmt=conn.createStatement();
			for(i=0;i<7;i++) {
				ResultSet rs=stmt.executeQuery(query[i]);
				ResultSetMetaData metaData=rs.getMetaData();
				cnt=metaData.getColumnCount();

				String [] head=new String[cnt];
				for(j=0;j<cnt;j++) head[j]=metaData.getColumnName(j+1);
				DefaultTableModel tableModel=new DefaultTableModel(head,0);

				while(rs.next()) {
					String [] value=new String[cnt];
					for(j=0;j<cnt;j++) value[j]=rs.getString(j+1);
					tableModel.addRow(value);;
				}

				JTable table=new JTable(tableModel);
				JScrollPane scrollTable=new JScrollPane(table);
				answer.add(scrollTable);
			}
		}
		catch(Exception a) {
			a.printStackTrace();
		}

		answer.setVisible(true);
	}

	class adminAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton tmpButton=(JButton)e.getSource();
			String buttonContext=tmpButton.getText();
			if(buttonContext=="초기화") resetAll(0);

			else if(buttonContext=="Movies 입력") insertInfo0();
			else if(buttonContext=="Movie_Theaters 입력") insertInfo1();
			else if(buttonContext=="Movie_Plans 입력") insertInfo2();
			else if(buttonContext=="Seat_Infos 입력") insertInfo3();
			else if(buttonContext=="User_Infos 입력") insertInfo4();
			else if(buttonContext=="Register_Infos 입력") insertInfo5();
			else if(buttonContext=="Ticket_Infos 입력") insertInfo6();

			else if(buttonContext=="삭제") deleteInfo();
			else if(buttonContext=="변경") modifyInfo();
			else if(buttonContext=="전체조회") viewAll();
		}
	}

	class cancelInsert0Action  implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			IDField.setText("");
			TitleField.setText("");
			DirectorField.setText("");
			ActorField.setText("");
			GenreField.setText("");
			Movie_timeField.setText("");
			Movie_dayField.setText("");
			Movie_rateField.setText("");
			Movie_openField.setText("");
			Movie_IntroductionField.setText("");
		}
	}

	class cancelInsert1Action  implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Theater_ID_NUMField.setText("");
			Seat_quantityField.setText("");
			Used_OR_NOTField.setText("");
		}
	}

	class cancelInsert2Action  implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Movie_Plan_IDField.setText("");
			MovieField.setText("");
			Movie_Theater_FKField.setText("");
			Movie_Start_DateField.setText("");
			Movie_Running_DayField.setText("");
			Movie_Running_IndexField.setText("");
			Movie_Starting_TimeField.setText("");
		}
	}

	class cancelInsert3Action  implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Seat_Info_IDField.setText("");
			Seat_numField.setText("");
			Movie_Theater_FK_FKField.setText("");
			USED_OR_NOTField.setText("");
		}
	}

	class cancelInsert4Action  implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			USER_ID_NUMField.setText("");
			User_IDField.setText("");
			USER_NAMEField.setText("");
			User_PhoneField.setText("");
			User_EmailField.setText("");
		}
	}

	class cancelInsert5Action  implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Register_ID_NUMField.setText("");
			Pay_methodField.setText("");
			Pay_stateField.setText("");
			Pay_priceField.setText("");
			Pay_DateField.setText("");
			RegistererField.setText("");
		}
	}

	class cancelInsert6Action  implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Ticket_IDField.setText("");
			Movie_PlanField.setText("");
			Movie_Theater_FK_FK_FKField.setText("");
			Seat_InfoField.setText("");
			Register_InfoField.setText("");
			Print_OR_NOTField.setText("");
			Std_PriceField.setText("");
			Sold_PriceField.setText("");
		}
	}




	class userFrame extends JFrame{
		public userFrame() {
			setTitle("userFrame");
			Container c2= getContentPane();
			c2.setLayout(new GridLayout(2,11,5,5));


			JButton searchMovieInfo=new JButton("영화 검색");
			JButton cancelInsert7=new JButton("영화 검색 입력 취소");
			JButton searchMyReservInfo=new JButton("예매한 영화 조회");

			c2.add(new JLabel("오늘 날짜", JLabel.RIGHT));
			c2.add(new JLabel(today));
			c2.add(new JLabel("회원명",JLabel.RIGHT));
			c2.add(new JLabel(myName));
			for(int z=0;z<7;z++) c2.add(new JLabel(""));

			c2.add(new JLabel("영화명",JLabel.RIGHT));
			c2.add(movieNameField);
			c2.add(new JLabel("감독명",JLabel.RIGHT));
			c2.add(movieDirectorField);
			c2.add(new JLabel("배우명",JLabel.RIGHT));
			c2.add(movieActorField);
			c2.add(new JLabel("장르명",JLabel.RIGHT));
			c2.add(movieGenreField);
			c2.add(searchMovieInfo);
			c2.add(cancelInsert7);
			c2.add(searchMyReservInfo);

			searchMovieInfo.addActionListener(new userAction());
			cancelInsert7.addActionListener(new userAction());
			searchMyReservInfo.addActionListener(new userAction());

			setSize(1700,200);
			setVisible(true);
		}
	}

	void cancelInsert7Action() {
		movieNameField.setText("");
		movieDirectorField.setText("");
		movieActorField.setText("");
		movieGenreField.setText("");
	}

	void reservFromSearchedMovie(int row) {
		int z;
		JFrame answer=new JFrame();
		answer.setTitle("이 영화 예매하기");
		answer.setLayout(new GridLayout(5,1,5,5));
		answer.setSize(1200,750);

		String Movie_IDCondition=userTable.getValueAt(row,0).toString();


		String query="SELECT * FROM Movie_Plans WHERE Movie="+Movie_IDCondition+";";

		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData metaData=rs.getMetaData();
			int cnt=metaData.getColumnCount();

			String[] head=new String[cnt];
			for(z=0;z<cnt;z++) head[z]=metaData.getColumnName(z+1);
			DefaultTableModel tableModel=new DefaultTableModel(head,0);

			while(rs.next()) {
				String[] value=new String[cnt];
				for(z=0;z<cnt;z++) value[z]=rs.getString(z+1);
				tableModel.addRow(value);
			}

			underUserTable=new JTable(tableModel);
			JScrollPane scrolltable=new JScrollPane(underUserTable);
			answer.add(scrolltable);


		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			e.printStackTrace();
		}

		JLabel seatNumLabel=new JLabel("좌석 번호",JLabel.CENTER);

		answer.add(seatNumLabel);
		answer.add(seatNumField);
		JPanel seatPanel = new JPanel(new GridLayout(6, 5, 5, 5)); // 6 rows, 5 columns
		for (int i = 1; i <= 30; i++) {
			JButton seatButton = new JButton(String.valueOf(i));
			seatButton.setPreferredSize(new Dimension(15, 10));
			seatButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seatNumField.setText(seatButton.getText());
				}
			});
			seatPanel.add(seatButton);
		}
		answer.add(seatPanel);

		JButton isReservAvailable=new JButton("이 좌석 예매하기");

		answer.add(isReservAvailable);

		isReservAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(underUserTable.getSelectedRow()!=-1) reserveTicket(underUserTable.getValueAt(underUserTable.getSelectedRow(),0).toString());
				else {
					JOptionPane.showMessageDialog(null, "영화를 선택하세요.");
					return;
				}
			}
		});

		JButton cancleInsert8=new JButton("입력 취소");
		answer.add(cancleInsert8);
		cancleInsert8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNumField.setText("");
			}
		});
		answer.setVisible(true);
	}

	void reserveTicket(String Movie_Plan_IDCondition) {
		String seatNumValue=seatNumField.getText();
		if(seatNumValue.length()==0) {
			JOptionPane.showMessageDialog(null, "좌석번호를 입력하세요.");
			return;
		}

		String theaterNumValue=underUserTable.getValueAt(underUserTable.getSelectedRow(),2).toString();
		String query="SELECT USED_OR_NOT,Seat_Info_ID FROM Seat_Infos WHERE Seat_num="+seatNumValue+" AND Movie_Theater="+theaterNumValue+";";
		try {
			Statement stmtt=conn.createStatement();
			ResultSet rss=stmtt.executeQuery(query);

			while(rss.next()) {
				int seatInfoID=rss.getInt(2);

				if(rss.getBoolean(1)==false) {
					query="SELECT MAX(Register_ID_NUM) FROM Register_Infos;";
					String registerIdCondition=new String();
					try{
						Statement stmttt=conn.createStatement();
						ResultSet rsss=stmttt.executeQuery(query);
						rsss.next();
						registerIdCondition=String.valueOf(rsss.getInt(1)+1);
						query="INSERT INTO Register_Infos values("+registerIdCondition+",'card',TRUE,10000,'"+today+"',1);";
						stmttt.execute(query);
						JOptionPane.showMessageDialog(null, "Register_Infos 입력 성공");
					}
					catch(Exception b) {
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
						b.printStackTrace();
					}

					query="SELECT MAX(Ticket_ID) FROM Ticket_Infos;";

					try {
						Statement stmttt=conn.createStatement();
						ResultSet rsss=stmttt.executeQuery(query);
						rsss.next();
						query="INSERT INTO Ticket_Infos values("+String.valueOf(rsss.getInt(1)+1)+","+Movie_Plan_IDCondition+","+theaterNumValue+","+seatInfoID+","+registerIdCondition+",FALSE,10000,10000);";
						stmttt.execute(query);
						JOptionPane.showMessageDialog(null, "Ticket_Infos 입력 성공");
					}
					catch(Exception b) {
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
						b.printStackTrace();
					}

					stmtt=conn.createStatement();
					query="UPDATE Seat_Infos SET USED_OR_NOT=TRUE WHERE Seat_Info_ID="+seatInfoID+";";
					stmtt.execute(query);
					JOptionPane.showMessageDialog(null, "Seat_Infos 수정 성공");
				}
				else {
					JOptionPane.showMessageDialog(null, "이미 선택된 좌석입니다.");
					return;
				}
			}
		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			a.printStackTrace();
		}
	}


	void searchMovie() {
		int cnt=0,flag=0,z,y=0;

		JFrame answer=new JFrame();
		answer.setTitle("영화 검색");
		answer.setLayout(new GridLayout(2,1,5,5));
		answer.setSize(1250,500);

		String [] movieSearchCondition=new String [4];
		movieSearchCondition[0]=movieNameField.getText();
		movieSearchCondition[1]=movieDirectorField.getText();
		movieSearchCondition[2]=movieActorField.getText();
		movieSearchCondition[3]=movieGenreField.getText();

		String condition=new String("");
		for(z=0;z<4;z++) if(movieSearchCondition[z].length()!=0) cnt++;

		if(cnt!=0) condition+=" WHERE ";

		for(z=0;z<4;z++) {
			if(movieSearchCondition[z].length()!=0) {
				flag=1;
				if(z==0) condition+="Movies.Title=";
				else if(z==1) condition+="Movies.Director=";
				else if(z==2) condition+="Movies.Actor=";
				else if(z==3) condition+="Movies.Genre=";
				condition=condition+"'"+movieSearchCondition[z]+"'";
			}
			if(y<cnt-1) {
				condition+=" AND ";
				y++;
			}
		}
		String query="SELECT * FROM Movies"+condition+";";

		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData metaData=rs.getMetaData();
			cnt=metaData.getColumnCount();

			String[] head=new String[cnt];
			for(z=0;z<cnt;z++) head[z]=metaData.getColumnName(z+1);
			DefaultTableModel tableModel=new DefaultTableModel(head,0);

			while(rs.next()) {
				String [] value=new String[cnt];
				for(z=0;z<cnt;z++) value[z]=rs.getString(z+1);
				tableModel.addRow(value);
			}

			userTable=new JTable(tableModel);
			JScrollPane scrolltable=new JScrollPane(userTable);
			answer.add(scrolltable);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			return;
		}

		answer.setVisible(true);
		JButton newReservation=new JButton("이 영화 예매하기");
		answer.add(newReservation);
		answer.setVisible(true);
		newReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userTable.getSelectedRow()!=-1) reservFromSearchedMovie(userTable.getSelectedRow());
				else {
					JOptionPane.showMessageDialog(null, "영화를 선택하세요.");
					return;
				}
			}
		});
	}

	void searchMyReservInfo() {
		int cnt=0, z;
		JFrame answer=new JFrame();
		answer.setTitle("예매한 영화 조회");
		answer.setLayout(new GridLayout(4,1,5,5));
		answer.setSize(1250,500);
		String query="SELECT Ri.Register_ID_NUM, Mv.Title, Mp.Movie_Start_Date, Ti.Movie_Theater, Ti.Seat_Info, Ti.Sold_Price "+
				"FROM Ticket_Infos Ti, Register_Infos Ri, Movies Mv, Movie_Plans Mp "+
				"WHERE Ri.Registerer=1 "+
				"AND Ti.Register_Info=Ri.Register_ID_NUM "+
				"AND Ti.Movie_Plan=Mp.Movie_Plan_ID "+
				"AND Mv.ID=Mp.Movie;";

		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData metaData=rs.getMetaData();
			cnt=metaData.getColumnCount();

			String [] head=new String[cnt];
			for(z=0;z<cnt;z++) head[z]=metaData.getColumnName(z+1);
			DefaultTableModel tableModel=new DefaultTableModel(head,0);

			while(rs.next()) {
				String [] value=new String[cnt];
				for(z=0;z<cnt;z++) value[z]=rs.getString(z+1);
				tableModel.addRow(value);
			}

			userTable=new JTable(tableModel);
			userTable.addMouseListener(new tableAction());
			JScrollPane scrolltable=new JScrollPane(userTable);
			answer.add(scrolltable);

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			return;
		}

		answer.setVisible(true);
		JButton deleteThisReserv=new JButton("이 예매정보 삭제");
		deleteThisReserv.addActionListener(new userAction());
		answer.add(deleteThisReserv);

		JButton modifyToOtherMovie=new JButton("다른 영화로 예매");
		modifyToOtherMovie.addActionListener(new userAction());
		answer.add(modifyToOtherMovie);

		JButton modifyToOtherPlan=new JButton("상영시간 교체");
		modifyToOtherPlan.addActionListener(new userAction());
		answer.add(modifyToOtherPlan);


	}
	void showSelectedInfo(int clickedRow, int clickedCol, String condition) {
		String query="SELECT Mv.Title, Mp.Movie_Start_Date, Mp.Movie_Theater, Si.Seat_num "+
				"FROM Movies Mv, Movie_Plans Mp, Seat_Infos Si "+
				"WHERE Mv.ID=Mp.Movie AND Mp.Movie_Theater=Si.Movie_Theater AND Si.USED_OR_NOT=false AND ";
		JFrame sInfo=new JFrame();
		sInfo.setTitle("선택된 정보");
		sInfo.setSize(1250,300);

		int cnt=0,z;
		if(clickedCol==1) {
			query=query+"Mv.Title='"+condition+"';";
		}
		else if(clickedCol==2) {
			query=query+"Mp.Movie_Start_Date='"+condition+"';";
		}
		else if(clickedCol==3) {
			query=query+"Mp.Movie_Theater="+condition+";";
		}
		else {
			JOptionPane.showMessageDialog(null,"다른 정보를 보려면, 다른 열을 선택해주세요.");
			return;
		}

		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData metaData=rs.getMetaData();
			cnt=metaData.getColumnCount();

			String [] head=new String[cnt];
			for(z=0;z<cnt;z++) head[z]=metaData.getColumnName(z+1);
			DefaultTableModel tableModel=new DefaultTableModel(head,0);

			while(rs.next()) {
				String [] value=new String[cnt];
				for(z=0;z<cnt;z++) value[z]=rs.getString(z+1);
				tableModel.addRow(value);
			}

			underUserTable=new JTable(tableModel);
			JScrollPane scrolltable=new JScrollPane(underUserTable);
			sInfo.add(scrolltable);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"잘못된 입력입니다.");
			e.printStackTrace();
		}
		sInfo.setVisible(true);
	}

	void deleteThisReservAction() {
		int [] selectedRow=new int[userTable.getSelectedRowCount()];
		selectedRow=userTable.getSelectedRows();
		try {
			for(int i=0;i<selectedRow.length;i++) {
				String registerID=userTable.getValueAt(selectedRow[i], 0).toString();
				String query="DELETE FROM Register_Infos WHERE Register_ID_NUM="+registerID+";";

				Statement stmt=conn.createStatement();
				stmt.execute(query);
			}
			JOptionPane.showMessageDialog(null, "선택한 예매 모두 삭제 성공, 창을 닫고 다시 조회해주세요.");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"잘못된 입력입니다.");
			e.printStackTrace();
		}
	}

	void modifyToOtherMovie() {
		int selectedRow=userTable.getSelectedRow(), cnt,z;
		String movieTitle=userTable.getValueAt(selectedRow,1).toString();
		String query="SELECT Mp.Movie_Plan_ID, Mv.Title,Mp.Movie_Start_Date, Mp.Movie_Theater, Si.Seat_num\r\n"
				+ "FROM Movie_Plans Mp, Seat_Infos Si, Movies Mv\r\n"
				+ "WHERE Mv.Title!='"+movieTitle+"'\r\n"
				+ "	AND Mv.ID=Mp.Movie\r\n"
				+ "	AND Si.USED_OR_NOT=false\r\n"
				+ "	AND	Mp.Movie_Theater=Si.Movie_Theater";

		JFrame answer=new JFrame();
		answer.setTitle("다른 영화로 예매");
		answer.setLayout(new GridLayout(2,1,5,5));
		answer.setSize(1250,500);

		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData metaData=rs.getMetaData();
			cnt=metaData.getColumnCount();

			String [] head=new String[cnt];
			for(z=0;z<cnt;z++) head[z]=metaData.getColumnName(z+1);
			DefaultTableModel tableModel=new DefaultTableModel(head,0);

			while(rs.next()) {
				String [] value=new String[cnt];
				for(z=0;z<cnt;z++) value[z]=rs.getString(z+1);
				tableModel.addRow(value);
			}

			underUserTable=new JTable(tableModel);
			JScrollPane scrolltable=new JScrollPane(underUserTable);
			answer.add(scrolltable);

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			return;
		}

		answer.setVisible(true);
		JButton modifyTOMButton=new JButton("예매 교체");
		modifyTOMButton.addActionListener(new userAction());
		answer.add(modifyTOMButton);

	}

	void doModifyTOM() {
		int userTableRow=userTable.getSelectedRow();
		int selectedRow=underUserTable.getSelectedRow();

		if(selectedRow==-1) {
			JOptionPane.showMessageDialog(null, "데이터가 없습니다");
			return;
		}
		String planID=underUserTable.getValueAt(selectedRow, 0).toString();
		String beforeplanID=userTable.getValueAt(userTableRow, 0).toString();

		String movieTheater=underUserTable.getValueAt(selectedRow, 3).toString();
		String beforemovieTheater=userTable.getValueAt(userTableRow, 3).toString();

		String Seat_num=underUserTable.getValueAt(selectedRow, 4).toString();
		String beforeSeat_num=userTable.getValueAt(userTableRow,4).toString();

		String query="UPDATE Ticket_Infos SET Movie_Plan="+planID+" WHERE Movie_Plan="+beforeplanID+";";
		try {
			Statement stmt=conn.createStatement();
			stmt.execute(query);

			query="UPDATE Ticket_Infos SET Movie_Theater="+movieTheater+" WHERE Movie_Theater="+beforemovieTheater+";";
			stmt.execute(query);

			query="UPDATE Ticket_Infos SET Seat_Info="+Seat_num+" WHERE Seat_Info="+beforeSeat_num+";";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "수정 성공");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"잘못된 입력입니다.");
			e.printStackTrace();
		}
	}

	void modifyToOtherPlan() {
		int selectedRow=userTable.getSelectedRow(), cnt,z;
		String movieTitle=userTable.getValueAt(selectedRow,1).toString();
		String movieStartDate=userTable.getValueAt(selectedRow, 2).toString();
		String query="SELECT Mp.Movie_Plan_ID, Mv.Title,Mp.Movie_Start_Date, Mp.Movie_Theater, Si.Seat_num\r\n"
				+ "FROM Movie_Plans Mp, Seat_Infos Si, Movies Mv\r\n"
				+ "WHERE Mv.Title='"+movieTitle+"'\r\n"
				+ "	AND Mv.ID=Mp.Movie\r\n"
				+ "	AND Si.USED_OR_NOT=false\r\n"
				+ "	AND	Mp.Movie_Theater=Si.Movie_Theater"
				+ " AND Mp.Movie_Start_Date!='"+movieStartDate+"';";

		JFrame answer=new JFrame();
		answer.setTitle("상영시간 교체");
		answer.setLayout(new GridLayout(2,1,5,5));
		answer.setSize(1250,500);

		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData metaData=rs.getMetaData();
			cnt=metaData.getColumnCount();

			String [] head=new String[cnt];
			for(z=0;z<cnt;z++) head[z]=metaData.getColumnName(z+1);
			DefaultTableModel tableModel=new DefaultTableModel(head,0);

			while(rs.next()) {
				String [] value=new String[cnt];
				for(z=0;z<cnt;z++) value[z]=rs.getString(z+1);
				tableModel.addRow(value);
			}

			underUserTable=new JTable(tableModel);
			JScrollPane scrolltable=new JScrollPane(underUserTable);
			answer.add(scrolltable);

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			return;
		}

		answer.setVisible(true);
		JButton modifyTOMButton=new JButton("다른 시간으로 교체");
		modifyTOMButton.addActionListener(new userAction());
		answer.add(modifyTOMButton);
	}

	void doModifyTOP() {
		int userTableRow=userTable.getSelectedRow();
		int selectedRow=underUserTable.getSelectedRow();

		if(selectedRow==-1) {
			JOptionPane.showMessageDialog(null, "데이터가 없습니다");
			return;
		}

		String planID=underUserTable.getValueAt(selectedRow, 0).toString();
		String beforeplanID=userTable.getValueAt(userTableRow, 0).toString();

		String movieTheater=underUserTable.getValueAt(selectedRow, 3).toString();
		String beforemovieTheater=userTable.getValueAt(userTableRow, 3).toString();

		String Seat_num=underUserTable.getValueAt(selectedRow, 4).toString();
		String beforeSeat_num=userTable.getValueAt(userTableRow,4).toString();

		String query="UPDATE Ticket_Infos SET Movie_Plan="+planID+" WHERE Movie_Plan="+beforeplanID+";";
		try {
			Statement stmt=conn.createStatement();
			stmt.execute(query);

			query="UPDATE Ticket_Infos SET Movie_Theater="+movieTheater+" WHERE Movie_Theater="+beforemovieTheater+";";
			stmt.execute(query);

			query="UPDATE Ticket_Infos SET Seat_Info="+Seat_num+" WHERE Seat_Info="+beforeSeat_num+";";
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "수정 성공");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"잘못된 입력입니다.");
			e.printStackTrace();
		}
	}

	class userAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton tmpButton=(JButton)e.getSource();
			String buttonContext=tmpButton.getText();
			if(buttonContext=="영화 검색") searchMovie();
			else if(buttonContext=="영화 검색 입력 취소") cancelInsert7Action();
			else if(buttonContext=="예매한 영화 조회") searchMyReservInfo();
			else if(buttonContext=="이 예매정보 삭제") deleteThisReservAction();
			else if(buttonContext=="다른 영화로 예매") modifyToOtherMovie();
			else if(buttonContext=="상영시간 교체") modifyToOtherPlan();
			else if(buttonContext=="예매 교체") doModifyTOM();
			else if(buttonContext=="다른 시간으로 교체") doModifyTOP();
		}
	}
	class tableAction extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()==1) {
				JTable cell=(JTable)e.getSource();
				int clickedRow=cell.getSelectedRow();
				int clickedCol=cell.getSelectedColumn();
				String condition=cell.getValueAt(clickedRow, clickedCol).toString();
				showSelectedInfo(clickedRow,clickedCol,condition);
			}
		}
	}

	public static void main(String args[]) {
		JC18011539Final frame=new JC18011539Final();
	}
}