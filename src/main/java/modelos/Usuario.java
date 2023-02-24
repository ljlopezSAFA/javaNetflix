package modelos;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"valoraciones", "planSubscripcion"})
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"valoraciones", "planSubscripcion"})
public class Usuario {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String email;
    private String username;
    private String contrasenya;
    private List<Valoracion> valoraciones;
    private PlanSubscripcion planSubscripcion;
}
