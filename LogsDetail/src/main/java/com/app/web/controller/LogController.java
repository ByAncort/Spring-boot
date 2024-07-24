package com.app.web.controller;

import com.app.web.entity.Endpoint;
import com.app.web.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    public String showLogs(@RequestParam(value = "date", required = false) String date, Model model) {
        String sql = "SELECT * FROM logs ORDER BY fechahora DESC";
        String sql2 = "SELECT * FROM logs";
        List<Log> logs;

        try {
            if (date != null) {
                sql2 += " WHERE CONVERT(date, fechaHora) = ?";
                logs = jdbcTemplate.query(sql2, new Object[]{date}, new BeanPropertyRowMapper<>(Log.class));
            } else {
                logs = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Log.class));
            }
            model.addAttribute("logs", logs);
            model.addAttribute("date", date);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al recuperar los registros. Por favor, intenta de nuevo más tarde.");
        }

        return "logs";
    }

    @GetMapping("/endpoint")
    public String endpoint(Model model) {
        String sql = "SELECT * FROM allproject";
        try {
            List<Endpoint> endpoint = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Endpoint.class));
            model.addAttribute("endpoint", endpoint);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al recuperar los endpoints. Por favor, intenta de nuevo más tarde.");
        }
        return "endpoint";
    }
}
