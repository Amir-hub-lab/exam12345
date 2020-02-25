package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        String SQL = "select * from persons";
        try (Connection connection = DB.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SQL)){
            while(rs.next()){
                persons.add(Person.builder()
                .name(rs.getString("NAME"))
                .year(rs.getInt("YEAR"))
                .age(rs.getInt("AGE"))
                .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public Person getPersonById(int id) {
        String SQL = "select * from persons where id = ?";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return Person.builder()
                            .name(rs.getString("NAME"))
                            .year(rs.getInt("YEAR"))
                            .age(rs.getInt("AGE"))
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person createPerson(Person person){
        String SQL = "insert into users (name, year, age) values (?,?,?)";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, person.getName());
            statement.setInt(2, person.getYear());
            statement.setInt(3, person.getAge());
            statement.executeUpdate();
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int id){

    }
}