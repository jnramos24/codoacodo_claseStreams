import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {

        List<String> nombres = new ArrayList<>();

        nombres.add("Ana");
        nombres.add("Juan");
        nombres.add("Nicolas");
        nombres.add("Javi");
        nombres.add("Lorena");

        //devolver la lista toda en mayuscula de los nombres con un largo mayor a 4

        List<String> nombreModificado = nombres.stream()
                .map(nombre -> nombre.toUpperCase())
                .filter(nombre -> nombre.length() > 4)
                .collect(Collectors.toList());

        //nombreModificado.forEach(nombre -> System.out.println(nombre));

        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona(1, "Persona1", 20));
        personas.add(new Persona(2, "Persona2", 18));
        personas.add(new Persona(3, "Persona3", 17));
        personas.add(new Persona(4, "Persona4", 16));
        personas.add(new Persona(5, "Persona5", 25));

        // traer los nombres de todas las personas
        List<String> names = personas.stream()
                .map(persona -> persona.getNombre())
                .collect(Collectors.toList());

        // names.forEach(System.out :: println);

        // traer la edad de todas las personas mayores a 18 años
        List<Integer> edadesDeMayores = personas.stream()
                .filter(persona -> persona.getEdad() > 18)
                .map(persona -> persona.getEdad())
                .collect(Collectors.toList());

        //edadesDeMayores.forEach( edad -> System.out.println(edad));

        // Me traigo el nombre de la primer persona que sea mayor de edad

        String nombrePersona = personas.stream()
                .filter(persona -> persona.getEdad() >= 18)
                .findFirst()
                .map(persona -> persona.getNombre())
                .orElse("NombreGenerico");

        //System.out.println(nombrePersona);

        LocalDate startDate = LocalDate.of(2015, 2, 20);
        LocalDate endDate = LocalDate.now();

        System.out.println(calculoPeriodo(startDate, endDate));

    }
    public static Integer calculoPeriodo(LocalDate fechaInicial, LocalDate fechaFinal) {
        Period period = Period.between(fechaInicial, fechaFinal);
        return period.getYears();
    }
}
