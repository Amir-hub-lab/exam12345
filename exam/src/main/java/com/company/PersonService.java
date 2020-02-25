package com.company;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/Persons")
public class PersonService {
    private PersonDao PersonDao = new PersonDao();
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Person> getAllPersons_Json() {
        return PersonDao.getPersons();
    }

    @GET
    @Path("/{PersonId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Person getPerson(@PathParam("PersonId") Integer id) {
        return PersonDao.getPersonById(1);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Person create(Person Person){
        return PersonDao.createPerson(Person);
    }

    @DELETE
    @Path("/{PersonId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("PersonId") int id){
        PersonDao.deleteById(id);
    }
}
