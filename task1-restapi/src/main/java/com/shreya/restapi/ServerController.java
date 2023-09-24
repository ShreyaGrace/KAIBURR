package com.shreya.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    @GetMapping
    public ResponseEntity<List<Server>> getServers(@RequestParam(required = false) String id) {
        if (id == null) {
            return ResponseEntity.ok(serverRepository.findAll());
        } else {
            Server server = serverRepository.findById(id).orElse(null);
            if (server != null) {
                return ResponseEntity.ok(List.of(server));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }
    }

    @PutMapping
    public ResponseEntity<Server> putServer(@RequestBody Server server) {
        return ResponseEntity.ok(serverRepository.save(server));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable String id) {
        if (serverRepository.existsById(id)) {
            serverRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<Server>> findServers(@RequestParam String name) {
        List<Server> servers = serverRepository.findByNameContaining(name);
        if (!servers.isEmpty()) {
            return ResponseEntity.ok(servers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
