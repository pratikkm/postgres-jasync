package jasync.repo;

import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import jasync.model.Employee;
import jasync.model.Student;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Singleton
public class EmployeeInterfaceImpl implements EmployeeInterface{

    private final Connection connection;

    public EmployeeInterfaceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public CompletableFuture<QueryResult> getStudent(String id) {
        List<String> param= new ArrayList<>();
        param.add(id);
        String sql= "select* from student where student.id=?";
        CompletableFuture<QueryResult> future = connection.sendPreparedStatement(sql ,param);
        return future;
    }

    @Override
    public CompletableFuture<QueryResult> addStudent(Student student) {
        List<String> param= new ArrayList<>();
        param.add(student.getId());
        param.add(student.getName());
        param.add(student.getSubject());
        param.add(student.getRemark());
        String sql= "insert into student(id,name,subject,remark) values(?,?,?,?)";
        CompletableFuture<QueryResult> future = connection.sendPreparedStatement(sql ,param);
        return future;
    }


    @Override
    public CompletableFuture<QueryResult> updateStudent(Student student) {
        List<String> param= new ArrayList<>();

        param.add(student.getName());
        param.add(student.getSubject());
        param.add(student.getRemark());
        param.add(student.getId());

        String sql= "update employee set name=?  subject=? remark=? where id=?";
        CompletableFuture<QueryResult> future = connection.sendPreparedStatement(sql ,param);
        return future;

    }

    @Override
    public CompletableFuture<QueryResult> getAllStudents() {
        String sql= "select* from student ";
        CompletableFuture<QueryResult> future = connection.sendPreparedStatement(sql );
        return future;
    }


}
