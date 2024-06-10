package com.web_client.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.web_client.Entities.Vouchers;
import com.web_client.Exceptions.ClientErrorExceptions;
import com.web_client.Services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @GetMapping("/voucher")
    public String voucher(Model model) throws JsonProcessingException {
        try{
            Vouchers vouchers = voucherService.getDetailVoucher();

            model.addAttribute("voucher",vouchers);

            System.out.println(vouchers.getName());
            System.out.println(vouchers.getDateExpired());
            
            return "voucher";

        }catch (ClientErrorExceptions errorMessages){

            System.out.println(errorMessages.getErrorList().get(0));
            model.addAttribute("error",errorMessages.getErrorList());

            return "voucher";
        }
    }
}
