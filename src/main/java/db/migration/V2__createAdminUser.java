package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Statement;

public class V2__createAdminUser extends BaseJavaMigration {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Override
    public void migrate(Context context) throws Exception {
        Statement statment = context.getConnection().createStatement();

        // Insert Admin user
        statment.execute(
                "insert into system_users (user_name,user_password) values ('user1','" + ENCODER.encode("123")
                        + "')");

        statment.execute(
                "insert into system_users (user_name,user_password) values ('user2','" + ENCODER.encode("321")
                        + "')");

    }
    }