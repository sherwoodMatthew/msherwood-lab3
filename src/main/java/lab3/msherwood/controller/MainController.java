package lab3.msherwood.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/orders")
    public String GetOrders(
        @RequestParam Map<String, String> params,
        Model model
    )
    {
        String item;
        item = params.get("item");

        if(item == null)
            item ="?";
        
           
        Integer quantity;
        if(params.get("quantity") == null)
            quantity =1;
        else
            quantity = Integer.parseInt(params.get("quantity"));
        
        model.addAttribute("item", item);
        model.addAttribute("quantity", quantity);
        return "orders";
    }
// this will be the controller for dynamic1 this will display the year you are born and how old you are
    @GetMapping("/dynamic1")
    public String GetDynamic1(
//      the validation happens within the parameters 
        @RequestParam(required = true, defaultValue = "0") String yearBorn,
        @RequestParam(required = true, defaultValue = "0") String age,
        Model model
    )
    {
        model.addAttribute("yearBorn", yearBorn);
        model.addAttribute("age", age);
        return "dynamic1";
    }
// this is the controller for dynamic 2 this will display how many callories are in food items
    @GetMapping("/dynamic2")
    public String GetDynamic2(
        @RequestParam(required = true) Optional<String> optFoodItm,
        @RequestParam(required = true) Optional<Integer> optCallorieAmt,
        Model model
    )
    {
//  validation for food type
        String foodItm;
        if(optFoodItm.isPresent())
            foodItm = optFoodItm.get();
        else
            foodItm = "?";
 // validation for callorie amount       
        Integer callorieAmt;
        if(optCallorieAmt.isPresent())
            callorieAmt = optCallorieAmt.get();
        else    
            callorieAmt = 0;
        
        model.addAttribute("foodItm", foodItm);
        model.addAttribute("callorieAmt", callorieAmt);

        return "dynamic2";
    }

//    @GetMapping("/orders")
//    public String GetOrders(
//        @RequestParam(required = true) Optional<String> optItem,
 //       @RequestParam(required = true) Optional<Integer> optQuantity,
 //       Model model
 //   )
 //   {
 //       String item;
 ///       if(optItem.isPresent())
//            item = optItem.get();
 //       else
 //           item = "?";

 //       Integer quantity;
 //       if(optQuantity.isPresent())
 //           quantity = optQuantity.get();
 //       else    
 //           quantity = 1;
//
 //       model.addAttribute("item", item);
 //       model.addAttribute("quantity", quantity);

//        return "orders";
 //   }

//    @GetMapping("/orders")
//    public String GetOrders(
//        @RequestParam(required = true, defaultValue = "?") String item,
//        @RequestParam(required = true, defaultValue = "1") String quantity,
//        Model model
//    )
//    {
//        model.addAttribute("item", item);
//        model.addAttribute("quantity", quantity);
//       return "orders";
//    }
//    
}
