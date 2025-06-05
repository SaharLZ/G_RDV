package Rest;

import DAO.PatientDAO;
import Model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Path("/patient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientService {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ta_base", "root", "");
    }

    @GET
    public List<Patient> getAll() throws SQLException {
        PatientDAO dao = new PatientDAO(getConnection());
        return dao.getTousLesPatients();
    }

    @POST
    public void add(Patient patient) throws SQLException {
        PatientDAO dao = new PatientDAO(getConnection());
        dao.ajouterPatient(patient);
    }

    @PUT
    public void update(Patient patient) throws SQLException {
        PatientDAO dao = new PatientDAO(getConnection());
        dao.modifierPatient(patient);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) throws SQLException {
        PatientDAO dao = new PatientDAO(getConnection());
        dao.supprimerPatient(id);
    }
}
