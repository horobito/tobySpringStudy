package com.example.tobyspringstudy.step1_terribleDao;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        // DB 접속에 필요한 정보
        // url : jdbc:mysql://[host]:[port]/[instance]
        String url = "jdbc:mysql://172.30.1.41:3306/springPractice?serverTimezone=UTC&useSSL=false&autoReconnect=true";
        String userId = "root";
        String password = "";

        ////////////// 드라이버를 찾는 과정

        // <클래스 이름>에 해당하는  [JDBC 드라이버]를 로딩
        // 클래스 이름 = 드라이버 이름
//        Class.forName("com.mysql.jdbc.Driver");


        // 데이터베이스와 Connection 을 담당하는 Connection 객체를 생성
        // url 과 db 의 userid, password 를 사용해서 연결
        Connection c = DriverManager.getConnection(url, userId, password);


        String query = "insert into users(id, name, password) values(?,?,?)";

        // SQL 문을 실행해는 Statement 객체를 생성
        // PreparedStatement : Statement 를 상속한 것
        PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        // Update 문을 실행
        // executeUpdate : INSERT, UPDATE or DELETE 시 사용되는 함수
        ps.executeUpdate();

        // 실행이 끝나면, 사용된 리소스를 닫아준다.
        ps.close();
        c.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        // DB 접속에 필요한 정보
        // url : jdbc:mysql://[host]:[port]/[instance]
        String url = "jdbc:mysql://172.30.1.41:3306/springPractice?serverTimezone=UTC&useSSL=false&autoReconnect=true";
        String userId = "root";
        String password = "";


        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection(url, userId, password);

        String query = "select * from users where id = ?";

        // SQL 문을 실행하는 Statement 객체를 생성
        // PreparedStatement : Statement 를 상속한 것
        PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, id);

        // ResultSet
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }



}
