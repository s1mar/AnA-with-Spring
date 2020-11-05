package s1.mar.controllers;

import org.springframework.security.core.GrantedAuthority;
import s1.mar.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import static s1.mar.Manifest.*;
@Controller
public class MainController {

    @Autowired
    private StockService stockService;

    @GetMapping(ROUTE_MAIN)
    public String main(Authentication auth, Model model) {
        GrantedAuthority grantedAuthority =  (GrantedAuthority) auth.getAuthorities().toArray()[0];
        String authorizationMessage = (grantedAuthority.getAuthority().equals(Authority.CAN_VIEW.getVal())?MessageStrings.permViewStock.getVal():MessageStrings.permBuySellStock.getVal());
        model.addAttribute(Attr.username.getVal(), auth.getName());
        model.addAttribute(Attr.stocks.getVal(), stockService.findAll());
        model.addAttribute(Attr.authority.getVal(),authorizationMessage);
        return FILE_MAIN_HTML;
    }
}
