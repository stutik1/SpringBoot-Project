package com.example.Guru;

import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GuruController {

    public static HashMap<Integer, String> map = new HashMap<>();

    public static int i = 1;

    @GetMapping("/")
    public static String sayHello() {
        return "Guru";
    }

    @PostMapping("/person")
    public static int create(@RequestBody String name) {
        map.put(i, name);
        i++;
        return i - 1;
    }
    @GetMapping("/person/{id}")
    public static String getPerson(@PathVariable int id) {
        return map.get(id);

    }
    @PutMapping("/person/{id}")
    public static String updatePerson(@PathVariable int id, @RequestBody String name) {
        map.put(id, map.get(id) + name);
        return map.get(id) + " id " + id;
    }

    @DeleteMapping("/person")
    public static String deletePersonName(@RequestBody String name) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            String s = " ";

            if (name.equals(entry.getValue())) {
                map.remove(entry.getKey());
            }
        }
        return "Success";
    }

//    @DeleteMapping("/person/{id}")
//    public static String deletePersonId(@PathVariable int id) {
//        return map.remove(id);
//    }
}
