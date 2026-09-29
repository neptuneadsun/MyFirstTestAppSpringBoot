package ru.arkhipov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;




@RestController
public class HelloController {

    //0
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
        defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


    //1
    private ArrayList<String> list;
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s", defaultValue = "") String s) {

        if (list == null) {
            list = new ArrayList<>();
        }

        if (!s.isEmpty()) {
            list.add(s);
        }

        return "Текущий список: " + list.toString();
    }


    //2
    @GetMapping("/show-array")
    public String showArrayList() {
        if (list == null || list.isEmpty()) {
            return "Список пуст.";
        }

        return "Элементы списка: " + list.toString();
    }


    //3
    private HashMap<Integer, String> map;
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s", defaultValue = "") String s) {

        if (map == null) {
            map = new HashMap<>();
        }

        if (!s.isEmpty()) {
            map.put(map.size(), s);
        }

        return "Текущая Map: " + map.toString();
    }


    //4
    @GetMapping("/show-map")
    public String showHashMap() {
        if (map == null || map.isEmpty()) {
            return "Map пуста.";
        }

        return "Элементы Map: " + map.toString();
    }


    //5
    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int listSize = (list == null) ? 0 : list.size();

        int mapSize = (map == null) ? 0 : map.size();

        return String.format("Количество элементов в ArrayList: %d, в HashMap: %d", listSize, mapSize);
    }

}
