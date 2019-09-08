package realRestAssured;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralTeacher {
    private int batch;
    private String birthDate;
    private String department;
    private String emailAddress;
    private String firstName;
    private String gender;
    private String joinDate;
    private String lastName;
    private String password;
    private String phone;
    private String premanentAddress;
    private int salary;
    private String section;
    private String subject;
    private int teacherId;


}
