package forfaitNieve;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidadorFechaLocalDate implements ValidadorFecha{

    private final DateTimeFormatter formateadorFecha;

    public ValidadorFechaLocalDate(DateTimeFormatter formateadorFecha) {
        this.formateadorFecha = formateadorFecha;
    }

    public boolean esValido(String fechaComoString) {
        try {
            LocalDate.parse(fechaComoString, this.formateadorFecha);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

}
