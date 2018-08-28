package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {


    @FXML
    TextField text1;
    @FXML
    TextField text2;
    @FXML
    public void buttonEvent(ActionEvent obj) throws SQLException,ClassNotFoundException
    {
        System.out.println("button clicked");

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement p = conn.prepareStatement("insert into javafx values(?,?)");
        String s=text1.getText();
        String s1=text2.getText();
        int n= Integer.parseInt(s1);
        System.out.println(s);
        p.setString(1, s);
        p.setInt(2,n);
        p.executeUpdate();
        conn.close();

    }


}
