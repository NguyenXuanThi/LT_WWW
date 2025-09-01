package fit.se;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.persistence.*;
import java.util.List;
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Bai5 {
    private final EntityManager em = JPAUtils.getEntityManager();
    // Lấy tất cả user
    @GET
    public List<User2> getAllUsers() {
        return em.createQuery("SELECT u FROM User2 u", User2.class).getResultList();
    }

    // Lấy user theo id
    @GET
    @Path("{id}")
    public User2 getUser(@PathParam("id") int id) {
        return em.find(User2.class, id);
    }

    // Thêm user mới
    @POST
    public Response addUser(User2 user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    // Cập nhật user
    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id, User2 updatedUser) {
        User2 user = em.find(User2.class, id);
        if (user == null) return Response.status(Response.Status.NOT_FOUND).build();

        em.getTransaction().begin();
        user.setFirst_name(updatedUser.getFirst_name());
        user.setTuoi(updatedUser.getTuoi());
        user.setPhone(updatedUser.getPhone());
        em.getTransaction().commit();

        return Response.ok(user).build();
    }

    // Xoá user
    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        User2 user = em.find(User2.class, id);
        if (user == null) return Response.status(Response.Status.NOT_FOUND).build();

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();

        return Response.noContent().build();
    }
}

