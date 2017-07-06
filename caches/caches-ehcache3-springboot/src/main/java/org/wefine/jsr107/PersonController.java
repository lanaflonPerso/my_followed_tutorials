package org.wefine.jsr107;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PersonController {

    @Resource
    private PersonService personService;

    @GetMapping("/person/{ssn}")
    @ResponseBody
    public String getPerson(@PathVariable("ssn") int ssn) {
        return personService.getPerson(ssn).toString();
    }
}
