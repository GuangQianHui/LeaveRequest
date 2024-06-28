package utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MySQLJDBCUtil {

    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties properties = new Properties();
            try (InputStream input = MySQLJDBCUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
                if (input == null) {
                    throw new RuntimeException("Unable to find db.properties");
                }
                properties.load(input);
                URL = properties.getProperty("db.url");
                USER = properties.getProperty("db.user");
                PASSWORD = properties.getProperty("db.password");
            } catch (IOException ex) {
                throw new RuntimeException("Failed to load database properties file", ex);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL driver", e);
        }
    }


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get database connection", e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close connection", e);
            }
        }
    }

    public static void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close statement", e);
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close result set", e);
            }
        }
    }

    /**
     * 执行插入操作
     * @param sql SQL语句
     * @param params SQL语句中的参数
     * @return 影响的行数
     */
    public static int insert(String sql, Object... params) {
        return executeUpdate(sql, params);
    }

    /**
     * 执行更新操作
     * @param sql SQL语句
     * @param params SQL语句中的参数
     * @return 影响的行数
     */
    public static int update(String sql, Object... params) {
        return executeUpdate(sql, params);
    }

    /**
     * 执行删除操作
     * @param sql SQL语句
     * @param params SQL语句中的参数
     * @return 影响的行数
     */
    public static int delete(String sql, Object... params) {
        return executeUpdate(sql, params);
    }

    /**
     * 通用执行更新、插入、删除的方法
     * @param sql SQL语句
     * @param params SQL语句中的参数
     * @return 影响的行数
     */
    private static int executeUpdate(String sql, Object... params) {
        int affectedRows = 0;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            // 设置SQL语句参数
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            // 执行更新，并获取影响的行数
            affectedRows = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error :"+ e.getMessage());
        }
        return affectedRows;
    }

    /**
     * 执行查询操作
     * @param sql SQL语句
     * @param params SQL语句中的参数
     * @return 查询结果集
     */
    public static ResultSet query(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            closeResultSet(resultSet);
            closeStatement(statement);
            closeConnection(connection);
            throw new RuntimeException("Failed to execute query", e);
        }
    }

//    public static void main(String[] args) {
////         插入数据示例
//        String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";
//        int insertedRows = MySQLJDBCUtil.insert(insertSQL, "john_doe", "john@example.com");
//        System.out.println("Inserted rows: " + insertedRows);
//
//        // 更新数据示例
//        String updateSQL = "UPDATE users SET email = ? WHERE name = ?";
//        int updatedRows = MySQLJDBCUtil.update(updateSQL, "new_email@example.com", "john_doe");
//        System.out.println("Updated rows: " + updatedRows);
//
//        // 删除数据示例
//        String deleteSQL = "DELETE FROM users WHERE name = ?";
//        int deletedRows = MySQLJDBCUtil.delete(deleteSQL, "john_doe");
//        System.out.println("Deleted rows: " + deletedRows);
//
//        // 查询数据示例
////        String querySQL = "SELECT * FROM users WHERE name = ?";
//        String querySQL = "SELECT * FROM users";
//        try {
//            ResultSet resultSet = MySQLJDBCUtil.query(querySQL);
//            while (resultSet.next()) {
//                String username = resultSet.getString("name");
//                String email = resultSet.getString("email");
//                System.out.println("Username: " + username + ", Email: " + email);
//            }
//        } catch (SQLException e) {
//
//            System.err.println("Error executing query: " + e.getMessage());
//        }
//    }
}
