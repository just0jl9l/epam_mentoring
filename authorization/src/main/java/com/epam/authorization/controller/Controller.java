//package com.epam.authorization.controller;
//
//import java.util.List;
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.security.authentication.AuthenticationTrustResolver;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.epam.authorization.service.AccountService;
//
//@Controller
//@RequestMapping("/")
//@SessionAttributes("roles")
//public class Controller {
//	@Autowired
//	AccountService accountService;
//
//	@Autowired	
//	AccountRoleService accountRoleService;
//
//	
//	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
//	public String accessDeniedPage(ModelMap model) {
//		model.addAttribute("loggedinuser", getPrincipal());
//		return "accessDenied";
//	}
//
//	/**
//	 * This method handles login GET requests. If users is already logged-in and
//	 * tries to goto login page again, will be redirected to list page.
//	 */
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginPage() {
//		if (isCurrentAuthenticationAnonymous()) {
//			return "login";
//		} else {
//			return "redirect:/list";
//		}
//	}
//
//
//	private String getPrincipal() {
//		String userName = null;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails) {
//			userName = ((UserDetails) principal).getUsername();
//		} else {
//			userName = principal.toString();
//		}
//		return userName;
//	}
//}
