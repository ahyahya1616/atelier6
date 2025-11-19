package ma.fstt.atelier6.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String niveau;
    @OneToMany(mappedBy = "classe")
    private List<Eleve> eleve ;

    @ManyToMany(mappedBy = "classes")
    private List<Enseignant> enseignant;

}
