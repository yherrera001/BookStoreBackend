package BookExam.demo.pojo;

import com.fasterxml.jackson.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@CrossOrigin(origins = "http://localhost:4200")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    public Category(){

    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    @Column(name = "TYPE")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)

    private Set<Books> books;


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + name + '\'' +
                '}';
    }
}
