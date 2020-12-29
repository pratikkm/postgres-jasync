package jasync;


import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import io.micronaut.http.annotation.*;
import jasync.model.Employee;
import jasync.model.Student;
import jasync.repo.EmployeeInterface;

import java.util.concurrent.CompletableFuture;

@Controller
public class HomeController {


    private final Connection connection;

    private final EmployeeInterface employeeInterface;

    public HomeController(Connection connection, EmployeeInterface employeeInterface) {
        this.connection = connection;
        this.employeeInterface = employeeInterface;
    }


    @Get("/getAllStudents")
    public CompletableFuture<QueryResult> getAllInfo(){
        return employeeInterface.getAllStudents();
    }

    @Get("/getStudent/{id}")
    public  CompletableFuture<QueryResult> getStudent(@PathVariable String id){
        return employeeInterface.getStudent(id);
    }
    @Post("/addStudent")
    public CompletableFuture<QueryResult> addEmployee(@Body Student student){
        return employeeInterface.addStudent(student);
    }
    @Put("/updateStudent")
    public CompletableFuture<QueryResult> updateEmployee(@Body Student student){
        return employeeInterface.updateStudent(student);
    }
}
