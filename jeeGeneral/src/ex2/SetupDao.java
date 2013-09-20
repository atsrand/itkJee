package ex2;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;

public class SetupDao {

    public void createSchema() {
        executeSqlFromFile(getClassPathFile("schema.sql"));
    }

    private String getClassPathFile(String fileName) {
        return getClass().getClassLoader().getResource(fileName).getFile();
    }

    private void executeSqlFromFile(String sqlFilePath) {

        final class SqlExecuter extends SQLExec {
            public SqlExecuter() {
                Project project = new Project();
                project.init();
                setProject(project);
                setTaskType("sql");
                setTaskName("sql");
            }
        }

        SqlExecuter executer = new SqlExecuter();
        executer.setSrc(new File(sqlFilePath));
        executer.setDriver("org.hsqldb.jdbcDriver");
        executer.setUserid("sa");
        executer.setPassword("");
        executer.setUrl(ConnectionManager.DB_URL);
        executer.execute();
    }
}
