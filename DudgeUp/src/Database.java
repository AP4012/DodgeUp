import java.sql.*;


public abstract class Database {


    public static long popHighScore() {
        long highScore = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/dodgeup";
            String user = "root";
            String pass = "@Javadss3";

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from score");

            while (resultSet.next()) {
                highScore = resultSet.getLong(1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return highScore;
    }

    public static void pushHighScore(long newHighScore) {

        try {
            String url = "jdbc:mysql://localhost:3306/dodgeup";
            String user = "root";
            String pass = "@Javadss3";

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement statement = connection.prepareStatement("update score set highScore =?");

            statement.setLong(1, newHighScore);
            statement.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}