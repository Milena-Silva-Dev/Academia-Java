package Models;
import Models.Departamento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Projeto {
    @Id
    @Column(name ="id_proj", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 70)
    private String nome;
    @ManyToOne (fetch = FetchType.EAGER)
    private Funcionario funcionario;

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", funcionario=" + funcionario +
                '}';
    }
}