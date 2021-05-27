import java.io.Serializable;
@Builder
@Data
@Entity
public class pessoa {
@Id
@GeneratedValue
private String nome;
    private String email;
    private int idade;

    

}