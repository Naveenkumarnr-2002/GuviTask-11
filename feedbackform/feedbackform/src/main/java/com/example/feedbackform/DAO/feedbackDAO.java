package com.example.feedbackform.DAO;
import com.example.feedbackform.Entity.feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class feedbackDAO {

    @Autowired
    private DataSource dataSource;

    public void saveFeedback(feedback feedback) throws Exception {
        String sql = "INSERT INTO feedback (name, book_name, feedback) VALUES (?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, feedback.getName());
            ps.setString(2, feedback.getBookName());
            ps.setString(3, feedback.getFeedback());
            ps.executeUpdate();
        }
    }
}
