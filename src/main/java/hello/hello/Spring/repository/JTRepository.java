package hello.hello.Spring.repository;

import hello.hello.Spring.domain.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JTRepository implements memberRepository{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JTRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public member save(member member1) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member1.getName());
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        member1.setId(key.longValue());
        return member1;
    }

    @Override
    public Optional<member> findById(Long id) {
        List<member> result = jdbcTemplate.query("select * from member where id =?",memberRowMapper(),id);
        return result.stream().findAny();
    }

    @Override
    public Optional<member> findByName(String name) {
        List<member> result = jdbcTemplate.query("select * from member where name =?", memberRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }
    private RowMapper<member> memberRowMapper(){
        return (rs, rowNum ) ->{
            member member= new member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            return member;
        };
    }
}
