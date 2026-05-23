package com.kangaroo.database.db_demo.jdbc;

import com.kangaroo.database.db_demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // cusom row mapper
    class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthday(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new BeanPropertyRowMapper<>(Person.class),
                id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", id);

        // older version - legacy code
        /*
         * Đây là signature gốc từ Spring 2.x, khi Java chưa có varargs.
         * Bạn phải tự tạo array và truyền vào.
         * Từ Spring 5.2 trở đi → method này đã được @Deprecated.
         */
        // return jdbcTemplate.update("delete from person where id=?", new Object[]
        // {id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) values (?, ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthday().getTime()));
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?",
                person.getName(), person.getLocation(), new Timestamp(person.getBirthday().getTime()), person.getId());
    }
}
