package webservices;
//JAX-RS
import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/ue")
public class UniteEnsRestAPI {
    static UniteEnseignementBusiness helper=
            new UniteEnseignementBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUe(){
        return Response.status(200)
                .entity(helper.getListeUE())
                .build();
    }
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)//input
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUniteEnseignement(UniteEnseignement ue){
        if (helper.addUniteEnseignement(ue)){
            //201 created
            return Response.status(201).entity("Success").build();
        }
        else{
            //400 bad request
            return Response.status(400).entity("Erreur").build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")
    public Response getUEByCode(@PathParam("code") int code){
        return Response.status(200).entity(helper.getUEByCode(code)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getUEBySemestre(@QueryParam("semestre") int semestre){
        return Response.status(200).entity(helper.getUEBySemestre(semestre)).build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response updateUniteEnseignement(@QueryParam("code") int code , UniteEnseignement updateUE){
        return Response.status(200).entity(helper.updateUniteEnseignement(code, updateUE )).build();
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response deleteUniteEnseignement(@QueryParam("code") int code){
        return Response.status(200).entity(helper.deleteUniteEnseignement(code)).build();
    }


}
