package Rest;

import DAO.OrdonnanceDAO;
import Model.Ordonnance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Path("/Ordonnance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdonnanceService {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ta_base", "root", "");
    }

    @GET
    public List<Ordonnance> getAll() throws SQLException {
    	OrdonnanceDAO dao = new OrdonnanceDAO(getConnection());
        return dao.getToutesOrdonnances();
    }

    @POST
    public void add(Ordonnance rdv) throws SQLException {
    	OrdonnanceDAO dao = new OrdonnanceDAO(getConnection());
        dao.ajouterOrdonnance(rdv);
    }

    

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) throws SQLException {
    	OrdonnanceDAO dao = new OrdonnanceDAO(getConnection());
        dao.supprimerOrdonnance(id);
    }
}
