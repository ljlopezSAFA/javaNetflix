package modelos;

import lombok.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanSubscripcion {
    private Tipo tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precioMensual;
}
