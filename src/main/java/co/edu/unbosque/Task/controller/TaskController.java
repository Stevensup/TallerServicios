package co.edu.unbosque.Task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.unbosque.Task.model.EstudianteModel;
import co.edu.unbosque.Task.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Optional;

/**
 * This class represents the controller for managing tasks related to students.
 */
@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = { "http://localhost:8081", "http://localhost:8080", "*" })
public class TaskController {

    @Autowired
    private EstudianteService estudianteService;

    /**
     * Retrieves a list of all students.
     *
     * @return ResponseEntity<List<EstudianteModel>> The response entity containing
     *         the list of students.
     */
    @GetMapping("/all")
    @Operation(summary = "Consultar Estudiantes", description = "Retorna la lista de todos los estudiantes registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EstudianteModel.class))))
    })
    public ResponseEntity<List<EstudianteModel>> getAllEstudiantes() {
        List<EstudianteModel> estudiantes = estudianteService.findAll();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    /**
     * Retrieves a student by their ID.
     *
     * @param id The ID of the student.
     * @return ResponseEntity<EstudianteModel> The response entity containing the
     *         student.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Consultar Estudiante por ID", description = "Retorna un estudiante específico según su ID.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = EstudianteModel.class)))
    @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    public ResponseEntity<EstudianteModel> getEstudianteById(@PathVariable("id") String id) {
        // Cambié el tipo de id a String según el tipo definido en el modelo
        Optional<EstudianteModel> estudiante = estudianteService.findById(id);
        return estudiante.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Creates a new student.
     *
     * @param estudiante The student to be created.
     * @return ResponseEntity<EstudianteModel> The response entity containing the
     *         created student.
     */
    @PostMapping("/create")
    @Operation(summary = "Crear Estudiante", description = "Crea un nuevo estudiante.")
    @ApiResponse(responseCode = "201", description = "Estudiante creado exitosamente", content = @Content(schema = @Schema(implementation = EstudianteModel.class)))
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    public ResponseEntity<EstudianteModel> createEstudiante(@RequestBody EstudianteModel estudiante) {
        EstudianteModel createdEstudiante = estudianteService.insertar(estudiante);
        return new ResponseEntity<>(createdEstudiante, HttpStatus.CREATED);
    }

    /**
     * Updates an existing student.
     *
     * @param id         The ID of the student to be updated.
     * @param estudiante The updated student information.
     * @return ResponseEntity<EstudianteModel> The response entity containing the
     *         updated student.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Estudiante", description = "Actualiza los datos de un estudiante según su ID.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = EstudianteModel.class)))
    @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    public ResponseEntity<EstudianteModel> updateEstudiante(@PathVariable("id") String id,
            @RequestBody EstudianteModel estudiante) {
        Optional<EstudianteModel> estudianteOptional = estudianteService.findById(id);
        if (estudianteOptional.isPresent()) {
            EstudianteModel existingEstudiante = estudianteOptional.get();
            existingEstudiante.setNombre(estudiante.getNombre());
            existingEstudiante.setApellidos(estudiante.getApellidos());
            existingEstudiante.setEmail(estudiante.getEmail());
            existingEstudiante.setFacultad(estudiante.getFacultad());

            EstudianteModel updatedEstudiante = estudianteService.actualizar(existingEstudiante);
            return new ResponseEntity<>(updatedEstudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes a student by their ID.
     *
     * @param id The ID of the student to be deleted.
     * @return ResponseEntity<Void> The response entity indicating the success of
     *         the deletion.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Estudiante", description = "Elimina un estudiante según su ID.")
    @ApiResponse(responseCode = "204", description = "Estudiante eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable("id") String id) {
        Optional<EstudianteModel> estudianteOptional = estudianteService.findById(id);
        if (estudianteOptional.isPresent()) {
            estudianteService.borrar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @return ResponseEntity<String>
     */
    ////////////////// TAREA EN CLASE CALCULADORA CON DIEGO//////////////////
    ////////////////// /////////////////////////

    @GetMapping(path = "/saludar")
    public ResponseEntity<String> saludar() {
        return new ResponseEntity<String>("Buenas", HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/sumar")
    public ResponseEntity<String> sumar(@RequestParam Double num1, @RequestParam Double num2) {
        if (num1 < 0 || num2 < 0) {
            return new ResponseEntity<String>("No acepto numeros negativos", HttpStatus.PRECONDITION_FAILED);
        } else {
            return new ResponseEntity<String>("la suma es: " + (num1 + num2), HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/restar")
    public ResponseEntity<String> restar(@RequestParam Double num1, @RequestParam Double num2) {
        return new ResponseEntity<>("La resta es: " + (num1 - num2), HttpStatus.CREATED);
    }

    @GetMapping(path = "/multiplicar")
    public ResponseEntity<String> multiplicar(@RequestParam Double num1, @RequestParam Double num2) {
        return new ResponseEntity<>("La multiplicación es: " + (num1 * num2), HttpStatus.CREATED);
    }

    @GetMapping(path = "/dividir")
    public ResponseEntity<String> dividir(@RequestParam Double num1, @RequestParam Double num2) {
        if (num2 == 0) {
            return new ResponseEntity<>("No se puede dividir por cero", HttpStatus.PRECONDITION_FAILED);
        } else {
            return new ResponseEntity<>("La división es: " + (num1 / num2), HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/porcentaje")
    public ResponseEntity<String> calcularPorcentaje(@RequestParam Double numero, @RequestParam Double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            return new ResponseEntity<>("El porcentaje debe estar entre 0 y 100", HttpStatus.PRECONDITION_FAILED);
        } else {
            double resultado = (numero * porcentaje) / 100;
            return new ResponseEntity<>("El " + porcentaje + "% de " + numero + " es: " + resultado,
                    HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/logaritmo")
    public ResponseEntity<String> calcularLogaritmo(@RequestParam Double numero, @RequestParam Double base) {
        if (numero <= 0 || base <= 1) {
            return new ResponseEntity<>("El número debe ser positivo y la base del logaritmo debe ser mayor que 1",
                    HttpStatus.PRECONDITION_FAILED);
        } else {
            double resultado = Math.log(numero) / Math.log(base);
            return new ResponseEntity<>("El logaritmo base " + base + " de " + numero + " es: " + resultado,
                    HttpStatus.CREATED);
        }
    }
}
