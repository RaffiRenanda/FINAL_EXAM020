/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FINAL_EXAM;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author R Raffi Renanda Zain Ais 20200140020
 */
@RestController
@CrossOrigin
@RequestMapping("/data")
public class MyController {
    Surat mysurat = new Surat();
    SuratJpaController ctrl = new SuratJpaController();
    
    @GetMapping("/{id}")
    public List<Surat> getNameById (@PathVariable("id") int id){
        List<Surat> dummy = new ArrayList<>();
        
        try{
            mysurat = ctrl.findSurat(id);
            dummy.add(mysurat);
            
        }
        catch (Exception e){
            dummy = List.of();
        }
        return dummy;
    }
    @GetMapping
    public List<Surat> getAll() {
        List<Surat> dummy = new ArrayList<>();
        try {
            dummy = ctrl.findSuratEntities();
        } catch (Exception e) {
            dummy = List.of();
        }
        return dummy;
    }
    
    @PostMapping()
    public String addData(HttpEntity<String> kurir)
    {
        String message = "";
        try{
            String json_receive = kurir.getBody();
            ObjectMapper opm = new ObjectMapper();
            Surat data = new Surat();
            data = opm.readValue(json_receive, Surat.class);
            
            ctrl.create(data);
            message = "Success";
        }
        catch (Exception e){
            message = "Coba Lagi";
    }
    return message;
    }
    @DeleteMapping()
    public String  deleteData(HttpEntity<String> kurir)
    {
        String message = "Surender";
        try{
            String json_receive = kurir.getBody();
            ObjectMapper opm = new ObjectMapper();
            Surat newsurat = new Surat();
            
            newsurat = opm.readValue(json_receive, Surat.class);
            ctrl.destroy(newsurat.getId());
            
            
            
                    
        }
        catch (Exception e){
            
        }
        return message;
    }
    
}

