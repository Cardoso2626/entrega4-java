package br.com.fiap.resource;


import br.com.fiap.dao.OficinaDao;

import br.com.fiap.model.Oficina;
import br.com.fiap.util.OficinaTo;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("oficinas")
public class OficinaResource {

    private OficinaDao oficinaDao;


    public OficinaResource() {
        this.oficinaDao = new OficinaDao();
    }

    //Método HTTP POST
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastra(OficinaTo o){
        OficinaDao banco = new OficinaDao();
        try{
            banco.insert(o.toOficina());
            return Response.status(201).entity(o).build();
        } catch (Exception e) {
            return Response.status(401).entity(e.getMessage()).build();
        }
    }


    //Método HTTP GET
    @GET
    @Path("{id}")
    public Oficina recuperaUsuario(@PathParam("id") Long id) throws Exception {
        return oficinaDao.recuperaOficinaPorId(id);
    }


    //Método HTTP DELETE
    @DELETE
    @Path("{id}")
    public void remover(@PathParam("id") Long id) throws Exception {
        oficinaDao.deleta(id);
    }

    //Método HTTP PUT
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@Valid OficinaTo o, @PathParam("id") Long id) {
        try {
            Oficina oficinaExistente = oficinaDao.recuperaOficinaPorId(id);

            if (oficinaExistente == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Oficina com ID " + id + " não encontrado.")
                        .build();
            }


            Oficina oficinaAtualizado = o.toOficina();
            oficinaAtualizado.setId(id);

            oficinaDao.altera(oficinaAtualizado);

            return Response.ok(o).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar a oficina: " + e.getMessage())
                    .build();
        }
    }


}
