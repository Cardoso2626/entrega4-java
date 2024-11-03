package br.com.fiap.resource;



import br.com.fiap.dao.VeiculoDao;
import br.com.fiap.model.Veiculo;
import br.com.fiap.util.VeiculoTo;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("veiculos")
public class VeiculoResource {

    private VeiculoDao veiculoDao;


    public VeiculoResource() {
        this.veiculoDao = new VeiculoDao();
    }

    //Método HTTP POST
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastra(VeiculoTo v){
        VeiculoDao banco = new VeiculoDao();
        try{
            banco.insert(v.toVeiculo());
            return Response.status(201).entity(v).build();
        } catch (Exception e) {
            return Response.status(401).entity(e.getMessage()).build();
        }
    }

    //Método HTTP GET
    @GET
    @Path("{id}")
    public Veiculo recuperaVeiculo(@PathParam("id") Long id) throws Exception {
        return veiculoDao.recuperaVeiculoPorId(id);
    }


    //Método HTTP DELETE
    @DELETE
    @Path("{id}")
    public void remover(@PathParam("id") Long id) throws Exception {
        veiculoDao.deleta(id);
    }

    //Método HTTP PUT
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@Valid VeiculoTo v, @PathParam("id") Long id) {
        try {
            Veiculo veiculoExistente = veiculoDao.recuperaVeiculoPorId(id);

            if (veiculoExistente == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Veículo com ID " + id + " não encontrado.")
                        .build();
            }
            Veiculo veiculoAtualizado = v.toVeiculo();
            veiculoAtualizado.setId(id);

            veiculoDao.altera(veiculoAtualizado);

            return Response.ok(v).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar o veículo: " + e.getMessage())
                    .build();
        }
    }



}
