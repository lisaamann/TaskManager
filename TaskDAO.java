package taskmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public List<TaskVO> getAllTasks() {
        // go to DB
        List<TaskVO> tasks = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Tasks", "admin", "123");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from tasks");

            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");

                TaskVO task = new TaskVO(id, name);
                tasks.add(task);

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }
        return tasks;
    }

    public void insertTask(TaskVO task) {
        String sql = "insert into tasks (name) values ('" + task.getName() + "')";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Tasks", "admin", "123");

            Statement stmt = con.createStatement();

            stmt.execute(sql);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }
    }

    public void deleteTask(TaskVO task) {
        String sql = "DELETE FROM `Tasks`.`tasks` WHERE (`id` = '" + task.getId() + "')";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Tasks", "admin", "123");

            Statement stmt = con.createStatement();

            stmt.execute(sql);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }
    }

}
