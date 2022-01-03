package chewyt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class numberController {

    @Autowired
    private numberService nserv;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @RequestMapping(value = "/test.html", method = RequestMethod.GET)
    public String getData(@RequestParam(value = "number") String number, Model model) {
        System.out.println("[Controller] query: " + number);
        List<Integer> num = nserv.sendData(number);

        if (num.contains(-1)) {
            model.addAttribute("errorMsg", "This is not a number. Please try again.");
            return "index";
        } else if (num.contains(-2)) {
            model.addAttribute("errorMsg", "Number is not within range of 3 - 30. Please try again.");
            return "index";
        } else {
            model.addAttribute("num", num.size());
            model.addAttribute("list", num);
            return "test";
        }

    }

    // @GetMapping(value = "/index.html")
    // public String getNumber(@RequestParam(value = "number") String number) {
    // return number;
    // }

    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    // public String printHello(@RequestParam String number) {
    // return "hello";
    // }

    // public String number(@RequestParam(required = true)String number, Model
    // model){
    // return null;
    // }

}
