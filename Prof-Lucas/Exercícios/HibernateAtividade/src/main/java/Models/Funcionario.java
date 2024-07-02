package Models;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Funcionario {
    @Id
    @Column(name ="id_func", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", length = 70)
    private String nome;
    @Column(name = "salario")
    private BigDecimal salario;
    @Column(name = "cargo", length = 50)
    private String cargo;
    @ManyToOne (fetch = FetchType.EAGER)
    private Departamento departamento;

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", cargo='" + cargo + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}



