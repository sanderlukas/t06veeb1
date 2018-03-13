package springalgus;

import java.util.stream.IntStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {
    @RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
    
    @RequestMapping("/tervitus")
    String tervitus2(String eesnimi){
        return "Tere, "+ eesnimi;
    }
    
    @RequestMapping("/korrutus")
    int korrutamine(int arv1, int arv2) {
        return arv1 * arv2;
    } //localhost:8080/korrutus?arv1=3&arv2=6
    
    @RequestMapping("/ulesanne")
    int summa(String arvud) {
        String[] numbrid;
        numbrid = arvud.split(",");
        int[] intid = new int[numbrid.length];
        for (int i = 0; i < numbrid.length; i++) {
            intid[i] = Integer.parseInt(numbrid[i].trim());
        }
        int sum = 0;
        for (int arv: intid) {
            sum += arv;
        }
        return sum;
        
        //return java.util.Arrays.asStream(arvud.split(",")).map(s -> s.trim).mapToInt(Integer::parseInt).sum();
    }
    @RequestMapping("/bodyf")
    double bodyfat (double kehakaal, double pikkus, int age, int sugu) {
        pikkus = pikkus / 100;
        double bmi = kehakaal / (pikkus * pikkus);
        double fatPercentage = (1.20 * bmi) + (0.23 * age) - (10.8 * sugu) - 5.4;
        return fatPercentage;
    }
 
    public static void main(String[] args) {
		//System.getProperties().put("server.port", 40305);
        SpringApplication.run(Rakendus.class, args);
        // https://springbooti-bodyfat.herokuapp.com/bodyfat.html
    }
}
