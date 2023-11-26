package co.edu.unbosque.Task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.Task.model.EstudianteModel;
import co.edu.unbosque.Task.repository.EstudianteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    /**
     * Inserts a new EstudianteModel into the database.
     * 
     * @param estudiante The EstudianteModel to be inserted.
     * @return The inserted EstudianteModel.
     */
    public EstudianteModel insertar(EstudianteModel estudiante) {
        return estudianteRepository.save(estudiante);
    }

    /**
     * Retrieves all EstudianteModels from the database.
     * 
     * @return A list of EstudianteModels.
     */
    public List<EstudianteModel> findAll() {
        return estudianteRepository.findAll();
    }

    /**
     * Retrieves an EstudianteModel by its ID from the database.
     * 
     * @param id The ID of the EstudianteModel to be retrieved.
     * @return An Optional containing the EstudianteModel, or an empty Optional if
     *         not found.
     */
    public Optional<EstudianteModel> findById(String id) {
        return estudianteRepository.findById(id);
    }

    /**
     * Updates an existing EstudianteModel in the database.
     * 
     * @param estudiante The EstudianteModel to be updated.
     * @return The updated EstudianteModel.
     */
    public EstudianteModel actualizar(EstudianteModel estudiante) {
        return estudianteRepository.save(estudiante);
    }

    /**
     * Deletes an EstudianteModel from the database by its ID.
     * 
     * @param id The ID of the EstudianteModel to be deleted.
     */
    public void borrar(String id) {
        estudianteRepository.deleteById(id);
    }
}
