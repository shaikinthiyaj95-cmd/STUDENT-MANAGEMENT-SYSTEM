import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student student) {
        String query = "INSERT INTO students (name, age, department, email, phone, mark1, mark2, mark3, total_marks, percentage, grade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getDepartment());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getPhone());
            stmt.setDouble(6, student.getMark1());
            stmt.setDouble(7, student.getMark2());
            stmt.setDouble(8, student.getMark3());
            stmt.setDouble(9, student.getTotalMarks());
            stmt.setDouble(10, student.getPercentage());
            stmt.setString(11, student.getGrade());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
            return false;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(mapResultSetToStudent(rs));
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
        return list;
    }

    public Student getStudentById(int id) {
        String query = "SELECT * FROM students WHERE student_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapResultSetToStudent(rs);
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
        return null;
    }

    public boolean updateStudent(Student student) {
        String query = "UPDATE students SET name=?, age=?, department=?, email=?, phone=?, mark1=?, mark2=?, mark3=?, total_marks=?, percentage=?, grade=? WHERE student_id=?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getDepartment());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getPhone());
            stmt.setDouble(6, student.getMark1());
            stmt.setDouble(7, student.getMark2());
            stmt.setDouble(8, student.getMark3());
            stmt.setDouble(9, student.getTotalMarks());
            stmt.setDouble(10, student.getPercentage());
            stmt.setString(11, student.getGrade());
            stmt.setInt(12, student.getStudentId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        String query = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
            return false;
        }
    }

    private Student mapResultSetToStudent(ResultSet rs) throws SQLException {
        Student s = new Student();
        s.setStudentId(rs.getInt("student_id"));
        s.setName(rs.getString("name"));
        s.setAge(rs.getInt("age"));
        s.setDepartment(rs.getString("department"));
        s.setEmail(rs.getString("email"));
        s.setPhone(rs.getString("phone"));
        s.setMark1(rs.getDouble("mark1"));
        s.setMark2(rs.getDouble("mark2"));
        s.setMark3(rs.getDouble("mark3"));
        s.setTotalMarks(rs.getDouble("total_marks"));
        s.setPercentage(rs.getDouble("percentage"));
        s.setGrade(rs.getString("grade"));
        return s;
    }
}