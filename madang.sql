drop table if exists Movies, Movie_Theaters, Movie_Plans, Seat_Infos, Ticket_Infos, Register_Infos, User_Infos;
 
 CREATE TABLE Movies (
   ID INTEGER NOT NULL ,
   Title VARCHAR(255) NOT NULL,
   Director VARCHAR(255) NOT NULL,
   Actor VARCHAR(255) NOT NULL,
   Genre VARCHAR(255) NOT NULL,
   Movie_time VARCHAR(255) NOT NULL,
   Movie_day VARCHAR(255) NOT NULL,
   Movie_rate VARCHAR(255) NOT NULL,
   Movie_open VARCHAR(255) NOT NULL ,
   Movie_Introduction varchar(255) not null,
   CONSTRAINT  Movies_ID_PK PRIMARY KEY (ID)
);
  CREATE TABLE Movie_Theaters (
   Theater_ID_NUM INTEGER NOT NULL ,
   Seat_quantity INTEGER NOT NULL,
   Used_OR_NOT boolean,
   CONSTRAINT  Theater_ID_NUM_PK PRIMARY KEY (Theater_ID_NUM)
 );
CREATE TABLE Movie_Plans(
    Movie_Plan_ID INTEGER NOT NULL ,
    Movie INTEGER NOT NULL ,
    CONSTRAINT Movies_ID_FK FOREIGN KEY (Movie) REFERENCES Movies(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    Movie_Theater INTEGER,
    CONSTRAINT Movie_Theater_FK FOREIGN KEY (Movie_Theater) REFERENCES Movie_Theaters(Theater_ID_NUM) ON DELETE CASCADE ON UPDATE CASCADE,
    Movie_Start_Date VARCHAR(255) not null ,
    Movie_Running_Day VARCHAR(255) not null,
    Movie_Running_Index INTEGER not null ,
    Movie_Starting_Time VARCHAR(255) not null,
    CONSTRAINT Movie_Plan_ID_PK PRIMARY KEY (Movie_Plan_ID)
);

CREATE TABLE Seat_Infos(
    Seat_Info_ID INTEGER PRIMARY KEY ,
    Seat_num integer not null ,
    Movie_Theater INTEGER,
    CONSTRAINT Movie_Theater_FK_FK FOREIGN KEY (Movie_Theater) REFERENCES Movie_Theaters(Theater_ID_NUM) ON DELETE CASCADE ON UPDATE CASCADE,
    USED_OR_NOT boolean not null
);

CREATE TABLE User_Infos(
    USER_ID_NUM INTEGER NOT NULL ,
    User_ID VARCHAR(255) not null ,
    USER_NAME VARCHAR(255) not null ,
    User_Phone VARCHAR(13) not null ,
    User_Email VARCHAR(255) not null,
    CONSTRAINT USER_ID_NUM_PK PRIMARY KEY (USER_ID_NUM)
);

CREATE TABLE Register_Infos(
    Register_ID_NUM INTEGER NOT NULL,
    Pay_method VARCHAR(255) not null,
    Pay_state boolean not null,
    Pay_price INTEGER not null,
    Pay_Date VARCHAR(255) not null,
    Registerer INTEGER,
    CONSTRAINT Registerer_FK FOREIGN KEY (Registerer) REFERENCES User_Infos(USER_ID_NUM) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT Register_ID_NUM_PK PRIMARY KEY (Register_ID_NUM)
);

CREATE TABLE Ticket_Infos (
    Ticket_ID INTEGER NOT NULL,
    Movie_Plan INTEGER NOT NULL ,
    CONSTRAINT  Movie_Plan_FK FOREIGN KEY (Movie_Plan) REFERENCES  Movie_Plans(Movie_Plan_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    Movie_Theater INTEGER NOT NULL ,
    CONSTRAINT  Movie_Theater_FK_FK_FK FOREIGN KEY (Movie_Theater) REFERENCES  Movie_Plans(Movie_Theater) ON DELETE CASCADE ON UPDATE CASCADE,
    Seat_Info INTEGER NOT NULL ,
    CONSTRAINT  Seat_Info_FK FOREIGN KEY (Seat_Info) REFERENCES  Seat_Infos(Seat_Info_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    Register_Info INTEGER NOT NULL ,
    CONSTRAINT  Register_Info_FK FOREIGN KEY (Register_Info) REFERENCES  Register_Infos(Register_ID_NUM) ON DELETE CASCADE ON UPDATE CASCADE,
    Print_OR_NOT boolean not null ,
    Std_Price INTEGER not null ,
    Sold_Price INTEGER not null,
    CONSTRAINT Ticket_ID_PK PRIMARY KEY (Ticket_ID)
);

INSERT INTO Movies values(1,'a','aack', 'aohn', 'horror', '0100', 'Wed', 'all', '2021/1/2', 'damnscarry');
INSERT INTO Movies values(2,'b','jack', 'john', 'horror', '0100', 'Thur', '12', '2021/2/2', 'fxxkinscarry');
INSERT INTO Movies values(3,'c','jack', 'aohn', 'comedy', '0200', 'Thur', '15', '2021/3/2', 'damnfun');
INSERT INTO Movies values(4,'d','aack', 'john', 'comedy', '0400', 'Fri', '15', '2021/4/2', 'fxxkinfun');
INSERT INTO Movies values(5,'e', 'yeon', 'kyungwon' , 'romance', '0200', 'Fri', '19', '2021/5/2', 'holyfxxk!!');
INSERT INTO Movies values(6,'f','yeon', 'kyungwon', 'fantasy', '0600', 'Sat', '19', '2021/6/2', 'goddamn');
INSERT INTO Movies values(7,'g','yeon', 'wook', 'Act', '0230', 'Sat', '12', '2021/7/2', 'destroyupupup');
INSERT INTO Movies values(8,'h','jack', 'aohn', 'Act', '0220', 'Sun', 'all', '2021/8/2', 'damnfunfunfun');
INSERT INTO Movies values(9,'i','jack', 'kyungwon', 'fantasy', '0300', 'Sun', '19', '2021/9/2', 'damnfunagain');
INSERT INTO Movies values(10,'j','yeon', 'aohn', 'romance', '0200', 'Wed', '15', '2021/10/2', 'damnfunfunfunfun');

INSERT INTO Movie_Theaters values(1,8,TRUE);
INSERT INTO Movie_Theaters values(2,8,TRUE);
INSERT INTO Movie_Theaters values(3,8,TRUE);
INSERT INTO Movie_Theaters values(4,8,TRUE);
INSERT INTO Movie_Theaters values(5,8,TRUE);
INSERT INTO Movie_Theaters values(6,8,TRUE);
INSERT INTO Movie_Theaters values(7,8,TRUE);
INSERT INTO Movie_Theaters values(8,8,TRUE);
INSERT INTO Movie_Theaters values(9,8,TRUE);
INSERT INTO Movie_Theaters values(10,8,TRUE);

INSERT INTO Movie_Plans values(1,1,1,'2021/1/3','Wed',1,0700);
INSERT INTO Movie_Plans values(2,2,2,'2021/2/3','Thur',2,0800);
INSERT INTO Movie_Plans values(3,3,3,'2021/3/3','Thur',3,0900);
INSERT INTO Movie_Plans values(4,4,4,'2021/4/3','Fri',4,1000);
INSERT INTO Movie_Plans values(5,5,5,'2021/5/3','Fri',5,1100);
INSERT INTO Movie_Plans values(6,6,6,'2021/6/3','Sat',6,1200);
INSERT INTO Movie_Plans values(7,7,7,'2021/7/3','Sat',7,1300);
INSERT INTO Movie_Plans values(8,8,8,'2021/8/3','Sun',8,1400);
INSERT INTO Movie_Plans values(9,9,9,'2021/9/3','Sun',9,1500);
INSERT INTO Movie_Plans values(10,10,10,'2021/10/3','Wed',10,1600);

INSERT INTO Seat_Infos values(1, 1, 1, TRUE);
INSERT INTO Seat_Infos values(11, 2, 1, FALSE);
INSERT INTO Seat_Infos values(12, 3, 1, FALSE);
INSERT INTO Seat_Infos values(13, 4, 1, FALSE);
INSERT INTO Seat_Infos values(14, 5, 1, FALSE);
INSERT INTO Seat_Infos values(15, 6, 1, FALSE);
INSERT INTO Seat_Infos values(16, 7, 1, FALSE);
INSERT INTO Seat_Infos values(17, 8, 1, FALSE);

INSERT INTO Seat_Infos values(10, 1, 2, FALSE);
INSERT INTO Seat_Infos values(6, 2, 2, TRUE);
INSERT INTO Seat_Infos values(2, 3, 2, TRUE);
INSERT INTO Seat_Infos values(3, 4, 2, TRUE);
INSERT INTO Seat_Infos values(21, 5, 2, FALSE);
INSERT INTO Seat_Infos values(22, 6, 2, FALSE);
INSERT INTO Seat_Infos values(23, 7, 2, FALSE);
INSERT INTO Seat_Infos values(24, 8, 2, FALSE);

INSERT INTO Seat_Infos values(5, 1, 3, TRUE);
INSERT INTO Seat_Infos values(25, 2, 3, FALSE);
INSERT INTO Seat_Infos values(26, 3, 3, FALSE);
INSERT INTO Seat_Infos values(27, 4, 3, FALSE);
INSERT INTO Seat_Infos values(4, 5, 3, FALSE);
INSERT INTO Seat_Infos values(28, 6, 3, FALSE);
INSERT INTO Seat_Infos values(29, 7, 3, FALSE);
INSERT INTO Seat_Infos values(9, 8, 3, TRUE);

INSERT INTO Seat_Infos values(30, 1, 4, FALSE);
INSERT INTO Seat_Infos values(31, 2, 4, FALSE);
INSERT INTO Seat_Infos values(32, 3, 4, FALSE);
INSERT INTO Seat_Infos values(33, 4, 4, FALSE);
INSERT INTO Seat_Infos values(34, 5, 4, FALSE);
INSERT INTO Seat_Infos values(35, 6, 4, FALSE);
INSERT INTO Seat_Infos values(36, 7, 4, FALSE);
INSERT INTO Seat_Infos values(37, 8, 4, FALSE);

INSERT INTO Seat_Infos values(38, 1, 5, FALSE);
INSERT INTO Seat_Infos values(39, 2, 5, FALSE);
INSERT INTO Seat_Infos values(40, 3, 5, FALSE);
INSERT INTO Seat_Infos values(41, 4, 5, FALSE);
INSERT INTO Seat_Infos values(42, 5, 5, FALSE);
INSERT INTO Seat_Infos values(43, 6, 5, FALSE);
INSERT INTO Seat_Infos values(44, 7, 5, FALSE);
INSERT INTO Seat_Infos values(45, 8, 5, FALSE);

INSERT INTO Seat_Infos values(46, 1, 6, FALSE);
INSERT INTO Seat_Infos values(47, 2, 6, FALSE);
INSERT INTO Seat_Infos values(7, 3, 6, False);
INSERT INTO Seat_Infos values(48, 4, 6, FALSE);
INSERT INTO Seat_Infos values(49, 5, 6, FALSE);
INSERT INTO Seat_Infos values(50, 6, 6, FALSE);
INSERT INTO Seat_Infos values(51, 7, 6, FALSE);
INSERT INTO Seat_Infos values(52, 8, 6, FALSE);

INSERT INTO Seat_Infos values(8, 1, 7, TRUE);
INSERT INTO Seat_Infos values(53, 2, 7, FALSE);
INSERT INTO Seat_Infos values(54, 3, 7, FALSE);
INSERT INTO Seat_Infos values(55, 4, 7, FALSE);
INSERT INTO Seat_Infos values(56, 5, 7, FALSE);
INSERT INTO Seat_Infos values(57, 6, 7, FALSE);
INSERT INTO Seat_Infos values(58, 7, 7, FALSE);
INSERT INTO Seat_Infos values(59, 8, 7, FALSE);

INSERT INTO Seat_Infos values(60, 1, 8, FALSE);
INSERT INTO Seat_Infos values(61, 2, 8, FALSE);
INSERT INTO Seat_Infos values(62, 3, 8, FALSE);
INSERT INTO Seat_Infos values(63, 4, 8, FALSE);
INSERT INTO Seat_Infos values(64, 5, 8, FALSE);
INSERT INTO Seat_Infos values(65, 6, 8, FALSE);
INSERT INTO Seat_Infos values(66, 7, 8, FALSE);
INSERT INTO Seat_Infos values(67, 8, 8, FALSE);

INSERT INTO Seat_Infos values(68, 1, 9, FALSE);
INSERT INTO Seat_Infos values(69, 2, 9, FALSE);
INSERT INTO Seat_Infos values(70, 3, 9, FALSE);
INSERT INTO Seat_Infos values(71, 4, 9, FALSE);
INSERT INTO Seat_Infos values(72, 5, 9, FALSE);
INSERT INTO Seat_Infos values(73, 6, 9, FALSE);
INSERT INTO Seat_Infos values(74, 7, 9, FALSE);
INSERT INTO Seat_Infos values(75, 8, 9, FALSE);

INSERT INTO Seat_Infos values(76, 1, 10, FALSE);
INSERT INTO Seat_Infos values(77, 2, 10, FALSE);
INSERT INTO Seat_Infos values(78, 3, 10, FALSE);
INSERT INTO Seat_Infos values(79, 4, 10, FALSE);
INSERT INTO Seat_Infos values(80, 5, 10, FALSE);
INSERT INTO Seat_Infos values(18, 6, 10, FALSE);
INSERT INTO Seat_Infos values(19, 7, 10, FALSE);
INSERT INTO Seat_Infos values(20, 8, 10, FALSE);



INSERT INTO User_Infos values(1, 'aeon', 'aeonwoo', '010-0000-0001', 'aeon@nav');
INSERT INTO User_Infos values(2, 'beon', 'beonwoo', '010-0000-0002', 'beon@nav');
INSERT INTO User_Infos values(3, 'ceon', 'ceonwoo', '010-0000-0003', 'ceon@nav');
INSERT INTO User_Infos values(4, 'deon', 'deonwoo', '010-0000-0004', 'deon@nav');
INSERT INTO User_Infos values(5, 'eeon', 'eeonwoo', '010-0000-0005', 'eeon@nav');
INSERT INTO User_Infos values(6, 'feon', 'feonwoo', '010-0000-0006', 'feon@nav');
INSERT INTO User_Infos values(7, 'geon', 'geonwoo', '010-0000-0007', 'geon@nav');
INSERT INTO User_Infos values(8, 'heon', 'heonwoo', '010-0000-0008', 'heon@nav');
INSERT INTO User_Infos values(9, 'ieon', 'ieonwoo', '010-0000-0009', 'ieon@nav');
INSERT INTO User_Infos values(10, 'jeon', 'jeonwoo', '010-0000-0010', 'jeon@nav');

INSERT INTO Register_Infos values(1, 'card', TRUE, 10000,'2021/1/1', 1);
INSERT INTO Register_Infos values(2, 'card', TRUE, 10000,'2021/1/1', 2);
INSERT INTO Register_Infos values(3, 'cash', TRUE, 10000,'2021/1/1', 1);
INSERT INTO Register_Infos values(4, 'none', FALSE, 0,'2021/1/1', 3);
INSERT INTO Register_Infos values(5, 'cash', TRUE, 10000,'2021/1/1', 4);
INSERT INTO Register_Infos values(6, 'card', TRUE, 10000,'2021/1/1', 6);
INSERT INTO Register_Infos values(7, 'none', FALSE, 0,'2021/1/1', 2);
INSERT INTO Register_Infos values(8, 'cash', TRUE, 10000,'2021/1/1', 1);
INSERT INTO Register_Infos values(9, 'card', TRUE, 10000,'2021/1/1', 7);
INSERT INTO Register_Infos values(10, 'card', TRUE, 10000,'2021/1/1', 8);

INSERT INTO Ticket_Infos values(1, 1, 1,1, 1, TRUE, 10000, 10000);
INSERT INTO Ticket_Infos values(2, 2, 2,2, 2, FALSE, 10000, 10000);
INSERT INTO Ticket_Infos values(3, 2, 2,3, 3, TRUE, 10000, 10000);
INSERT INTO Ticket_Infos values(4, 3, 3,4, 4, FALSE, 10000, 0);
INSERT INTO Ticket_Infos values(5, 3, 3,5, 5, TRUE, 10000, 10000);
INSERT INTO Ticket_Infos values(6, 2, 2,6, 6, FALSE, 10000, 10000);
INSERT INTO Ticket_Infos values(7, 6, 6,7, 7, FALSE, 10000, 0);
INSERT INTO Ticket_Infos values(8, 7, 7,8, 8, FALSE, 10000, 10000);
INSERT INTO Ticket_Infos values(9, 3, 3,9, 9, TRUE, 10000, 10000);
INSERT INTO Ticket_Infos values(10, 2, 2,10, 10, TRUE, 10000, 10000);