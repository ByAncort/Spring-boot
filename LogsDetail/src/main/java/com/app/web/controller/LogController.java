package com.app.web.controller;

import com.app.web.entity.Endpoint;
import com.app.web.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LogController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/logs")
    public String showLogs(
            @RequestParam(value = "date", required = false) String date,
            Model model) {

        String sql = "SELECT * FROM logs ORDER BY  fechahora DESC";

        if (date != null) {
            sql += " WHERE CONVERT(date, fechaHora) = ?";
            List<Log> logs = jdbcTemplate.query(sql, new Object[]{date}, BeanPropertyRowMapper.newInstance(Log.class));
            model.addAttribute("logs", logs);
        } else {
            List<Log> logs = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Log.class));
            model.addAttribute("logs", logs);
        }

        model.addAttribute("date", date);

        return "logs";
    }

    @GetMapping("/endpoint")
    public String endpoint(Model model) {
        String sql = "SELECT * FROM allproject";
        List<Endpoint> endpoint = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Endpoint.class));
        model.addAttribute("endpoint", endpoint);
        return "endpoint";
    }



}
