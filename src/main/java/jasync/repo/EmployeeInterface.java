package jasync.repo;

import com.github.jasync.sql.db.QueryResult;
import jasync.model.Employee;
import jasync.model.Student;

import java.util.concurrent.CompletableFuture;

public interface EmployeeInterface {

    CompletableFuture<QueryResult> getStudent(String id);

    CompletableFuture<QueryResult> addStudent(Student student);

    CompletableFuture<QueryResult> updateStudent(Student student);

    CompletableFuture<QueryResult> getAllStudents();
}
