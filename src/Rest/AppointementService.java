package Rest;

import DAO.RDVDAO;
import Model.RDV;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Path("/patient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointementService {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ta_base", "root", "");
    }

    @GET
    public List<RDV> getAll() throws SQLException {
        RDVDAO dao = new RDVDAO(getConnection());
        return dao.getTousLesRDV();
    }

    @POST
    public void add(RDV rdv) throws SQLException {
    	RDVDAO dao = new RDVDAO(getConnection());
        dao.ajouterRDV(rdv);
    }

    @PUT
    public void update(RDV rdv) throws SQLException {
        RDVDAO dao = new RDVDAO(getConnection());
        dao.modifierRDV(rdv);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) throws SQLException {
        RDVDAO dao = new RDVDAO(getConnection());
        dao.supprimerRDV(id);
    }
}
