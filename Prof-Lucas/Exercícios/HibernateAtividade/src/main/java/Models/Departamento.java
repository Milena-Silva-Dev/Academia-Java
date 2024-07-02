package Models;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Departamento {
        @Id
        @Column(name ="id_dep", nullable=false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(unique=true, name="nome", nullable=false)
        private String nome;
        @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
        private List<Funcionario> funcionarios;

        @Override
        public String toString() {
            return "Departamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}