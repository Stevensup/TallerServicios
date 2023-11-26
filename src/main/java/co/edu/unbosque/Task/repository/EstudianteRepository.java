package co.edu.unbosque.Task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.Task.model.EstudianteModel;

/**
 * This interface represents a repository for managing EstudianteModel objects.
 */
public interface EstudianteRepository extends JpaRepository<EstudianteModel, String> {

    /**
     * Finds an EstudianteModel by email.
     *
     * @param email the email to search for
     * @return an Optional containing the EstudianteModel if found, or an empty
     *         Optional if not found
     */
    Optional<EstudianteModel> findByEmail(String email);
}
