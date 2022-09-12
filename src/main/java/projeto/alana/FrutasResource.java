package projeto.alana;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/frutas")
public class FrutasResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list(){

        return Fruta.listAll();
    }

    @POST
    @Transactional
    public void novaFruta(Fruta fruta) {

        Fruta.persist(fruta);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Fruta update(@PathParam("id") Long id, Fruta fruta){
        Fruta frutaDatabase = Fruta.findById(id);
        frutaDatabase.nome = fruta.nome;
        return frutaDatabase;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        Fruta.deleteById(id);
    }


}