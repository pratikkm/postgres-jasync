package jasync.model;

import io.micronaut.core.annotation.Introspected;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    private String id;

    private String name;

}
