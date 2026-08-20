package kr.co.sist.test;

import kr.co.sist.user.address.AddressService;
import kr.co.sist.user.address.RangeDTO;
import kr.co.sist.user.address.UserDomain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class tController {
	
	@Autowired(required = false)
	private  AddressService as;

	@Autowired(required = false)
	private BCryptPasswordEncoder bc; 

	@GetMapping("test")
	public String a(Model model) {
		RangeDTO rDTO = new RangeDTO();
		List<UserDomain> uList = new ArrayList<UserDomain>();
		UserDomain temp = null;
		
		rDTO.setCompanyNo("CO000001");
		rDTO.setUserNo("U000001");
		
		
		for (UserDomain user : as.test(rDTO)) {
			temp = user;
			temp.setUserName(AESUtil.encrypt(user.getUserName()));
			temp.setEmail(AESUtil.encrypt(user.getEmail()));
			temp.setPhoneNumber(AESUtil.encrypt(user.getPhoneNumber()));
			
			uList.add(temp);
		}
		
		model.addAttribute("users", uList);
		
		return "test";
	}

}
