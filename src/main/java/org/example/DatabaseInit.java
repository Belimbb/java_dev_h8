package org.example;

import org.flywaydb.core.Flyway;

public class DatabaseInit {
    public static void initDatabase() {
        Flyway flyway = Flyway.configure().dataSource(Database.getUrlConnection(), Database.getDbUser(), Database.getDbPass()).load();
        flyway.migrate();
    }
}
