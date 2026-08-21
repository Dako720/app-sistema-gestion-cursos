package co.github.dako720.sistemagestionrecursos.domain.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;



@Entity
@Table(
        name = "students"
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "student_id",
            nullable = false
    )
    private Long studentId;

    @NotBlank
    @Column(
            name = "first_name",
            nullable = false,
            length = 100
    )
    private String firstName;

    @NotBlank
    @Column(
            name = "last_name",
            nullable = false,
            length = 100
    )
    private String lastName;

    @NotBlank
    @Email
    @Column(
            nullable = false,
            length = 150
    )
    private String email;

    @NotBlank
    @Pattern(regexp = "^[0-9+()\\-\\s]{7,20}$", message = "El número de teléfono no es válido")
    @Column(
            name = "phone_number",
            nullable = false,
            length = 20
    )
    private String phoneNumber;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String email, String phoneNumber) {
        this.studentId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return "Student{id=" + studentId + ", firstName='" + firstName + "', lastName='" + lastName +
                "', email='" + email + "', phoneNumber='" + phoneNumber + "'}";
    }
}