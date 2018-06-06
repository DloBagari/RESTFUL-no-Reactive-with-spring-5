package org.springrest.simplerestAppnoReactive;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * dummy controller which returns simple map
 */
//set annotations to define this class is a rest controller, and the it handles request

@RestController
@RequestMapping("/test")
public class ControllerTest {
    //define this method as a response
    @ResponseBody
    @RequestMapping("")
    public Map<String, Object> test(){
        Map<String, Object> map = new HashMap<>();
        map.put("test", "ok");
        return map;
    }
}
