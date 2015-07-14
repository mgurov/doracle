package hello;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class Greeter {
    public String sayHello() {
        return countLines() + " rows";
    }

    private OracleDataSource oracleDataSource() {
        System.out.println("ora.port: " + System.getProperty("ora.port"));
        System.out.println("docker.host.address: " + System.getProperty("docker.host.address"));

        final String oraclePort = System.getProperty("ora.port", "1521");
        final String oracleHost = System.getProperty("docker.host.address", "localhost");

        final String connectionString = System.getProperty("connectionString",
                String.format("jdbc:oracle:thin:system/oracle@%s:%s:XE", oracleHost, oraclePort));
        final OracleDataSource ods;
        try {
            ods = new OracleDataSource();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ods.setURL(connectionString);
        return ods;
    }

    public int countLines() {
        return new JdbcTemplate(oracleDataSource()).queryForInt("Select count(*) from SPEC_SHEET");
    }
}