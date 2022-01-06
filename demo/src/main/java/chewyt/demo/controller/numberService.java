package chewyt.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class numberService {
    
    private String number;
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Integer> sendData(String number) {
        
        int num;
        List<Integer> result = new ArrayList<>();
        System.out.println("[service]number : " + number);
        try {
            num = Integer.parseInt(number);
            System.out.println("[service]num: " + num);
        } catch (NumberFormatException e) {
            
            System.out.println("[service]ERROR: Not a number");
            result.add(-1);
            return result;
        }
        
        if (num <= 30 && num >= 3) {
            // do something
            List<Integer> tempList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30));
            
            Random random = new Random();
            
            for (int i = 0; i < num; i++) {
                int rand = random.nextInt(tempList.size());
                result.add(tempList.get(rand));
                tempList.remove(rand);
            }
            
            System.out.println("[service]SUCCESS: within range");
            System.out.print("List of random numbers: ");
            for (Integer integer : result) {
                System.out.print(integer + " ");
            }
            System.out.println();
            
            return result;
        } else {
            System.out.println("[service]ERROR: Out of range");
            System.out.println();
            result.add(-2);
            return result;
        }
    }

    
    
}
