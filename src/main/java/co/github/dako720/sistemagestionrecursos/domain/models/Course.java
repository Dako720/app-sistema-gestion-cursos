package co.github.dako720.sistemagestionrecursos.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



@Entity
@Table(
        name = "courses"
)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "course_id",
            nullable = false
    )
    private Long id;

    @NotBlank
    @Column(
            name = "code",
            nullable = false,
            unique = true,
            length = 20
    )
    private String code;

    @NotBlank
    @Column(
            name = "name",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            name = "description",
            length = 255
    )
    private String description;

    @NotNull
    @Positive
    @Column(
            name = "max_capacity",
            nullable = false
    )
    private Integer maxCapacity;

    public Course() {
    }

    public Course(Long id, String code, String name, String description, Integer maxCapacity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(Integer maxCapacity) { this.maxCapacity = maxCapacity; }

    @Override
    public String toString() {
        return "Course{id=" + id + ", code='" + code + "', name='" + name +
                "', description='" + description + "', maxCapacity=" + maxCapacity + "}";
    }
}