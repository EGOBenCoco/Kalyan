package org.example.Kalyan.controller;

import lombok.AllArgsConstructor;
import org.example.Kalyan.models.Tabak;
import org.example.Kalyan.repository.TabakRepository;
import org.example.Kalyan.service.TabakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TabakController
{
    private final TabakService tabakService;
    private final TabakRepository tabakRepository;

    @GetMapping("/tabak")
    public List<Tabak> showAll()
    {
        List<Tabak> tabakList = tabakService.showAll();
        return tabakList;
    }


    @GetMapping("/tabak/{id}")
    public Tabak showOne(@PathVariable int id)
    {
        Tabak tabak = tabakService.showOne(id);
        return tabak;
    }


/*    @GetMapping("/tabak/{name}")
    public List<Tabak> findAllByName(@PathVariable String name)
    {
        List<Tabak> tabakList = tabakRepository.findAllByName(name);
        return tabakList;
    }

    @GetMapping("/tabak/{brend}")
    public List<Tabak> findAllByBrend(@PathVariable String brend)
    {
        List<Tabak> tabakList = tabakRepository.findByBrend(brend);
        return tabakList;
    }*/




    @PostMapping("/tabak/{name}/{brend}/{strength}/{aboutTabak}")
    public ResponseEntity addTabak(@PathVariable String name,
                                 @PathVariable String brend,
                                 @PathVariable long strength ,
                                 @PathVariable String aboutTabak)
    {
        try {
            tabakService.addTabak(name,brend,strength,aboutTabak);
            return ResponseEntity.ok("Успішно змінено дані");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @PutMapping("/tabak")
    public void editTabak(@RequestBody Tabak tabak)
    {
        tabakService.editTabak(tabak);


    }

    @DeleteMapping("/tabak/{id}")
    public void deleteTabak(@PathVariable int id)
    {
        tabakService.delete(id);
    }





}
