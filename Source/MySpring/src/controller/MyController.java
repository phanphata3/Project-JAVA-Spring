package controller;

import POJO.*;
import Services.*;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import data.*;


@Controller
public class MyController {
	
	@Autowired
	MyUserService myUserService;
	
	@Autowired
	MyProductService myProductService;
	
	@Autowired
	MyRoleService myRoleService;
	
	private MyUser myUser = new MyUser();
	private MyRole myRole = new MyRole();
	private String id = "";
	
// ------------------------------- PRODUCT ------------------------------//

	@RequestMapping(value = "/addProduct.html", method = RequestMethod.POST)
	public String addProduct(MyProduct product, ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				List<MyProduct> list = myProductService.getListProduct();

				if (!((product.getId().length() != 0) && (product.getName().length() != 0) 
						&& (product.getInfo().length() != 0)))
				{
					result.addAttribute("message", "Please input correct field, dont accept null");
					result.addAttribute("command", new MyProduct());
					return "AddProduct";
				}
				
				int flag = 0;
				for (MyProduct temp : list)
				{
					if (temp.getId().equals(product.getId()))
					{
						flag = 1;
						break;
					}
				}
				
				if (flag == 1)
				{
					result.addAttribute("message", "ID existed in database");
					result.addAttribute("command", new MyProduct());
					return "AddProduct";
				}
				else
				{
					
					myProductService.addProduct(product);
				}
			
				return "redirect:AdminList.html";
			}
			else
			{
				result.addAttribute("message", "Hi " + myUser.getUsername() + ", you don't have permission to access this page!");
				result.addAttribute("page", "UserLogin.html");
				return "403";
			}
		}
		else
		{
			result.addAttribute("message", "Please login with Administrator to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
	
		
	}
	
	@RequestMapping(value="/AddProduct", method = RequestMethod.GET)
	public String adminAddProduct(ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				result.addAttribute("message", "Add new product");
				result.addAttribute("command", new MyProduct());
				
				return "AddProduct";
			}
			else
			{
				result.addAttribute("message", "Hi " + myUser.getUsername() + ", you don't have permission to access this page!");
				result.addAttribute("page", "UserLogin.html");
				return "403";
			}
		}
		else
		{
			result.addAttribute("message", "Please login with Administrator to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
	}
	
	@RequestMapping("/deleteProduct_{id}")
	public String deleteProduct(@PathVariable (value="id") String id, ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				MyProduct temp = myProductService.getProduct(id);
				
				if (temp != null)
				{
					myProductService.removeProduct(temp);
					
				}
				
				return "redirect:AdminList.html";
			}
			else
			{
				result.addAttribute("message", "Hi " + myUser.getUsername() + ", you don't have permission to access this page!");
				result.addAttribute("page", "UserLogin.html");
				return "403";
			}
		
		}
		else
		{
			result.addAttribute("message", "Please login with Administrator to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
	}

	@RequestMapping("/editProduct_{id}")
	public String editProduct(@PathVariable (value="id") String id, ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				this.id = id;
				MyProduct temp = myProductService.getProduct(id);
				
				result.addAttribute("message", "Update product");
				result.addAttribute("id", temp.getId());
				result.addAttribute("name", temp.getName());
				result.addAttribute("info", temp.getInfo());
				result.addAttribute("price", temp.getPrice());
				result.addAttribute("command", new MyProduct());
				
				return "UpdateProduct";
			}
			else
			{
				result.addAttribute("message", "Hi " + myUser.getUsername() + ", you don't have permission to access this page!");
				result.addAttribute("page", "UserLogin.html");
				return "403";
			}
		}
		else
		{
			result.addAttribute("message", "Please login with Administrator to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
	}
	
	@RequestMapping(value="/changeProduct", method = RequestMethod.POST)
	public String updateProduct(MyProduct product, ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				product.setId(id);
				myProductService.updateProduct(product);
				
				
				return "redirect:AdminList.html";
			}
			else
			{
				result.addAttribute("message", "Hi " + myUser.getUsername() + ", you don't have permission to access this page!");
				result.addAttribute("page", "UserLogin.html");
				return "403";
			}
			
		}
		else
		{
			result.addAttribute("message", "Please login with Administrator to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
	}
	
	@RequestMapping(value="/multiDelete", method = RequestMethod.POST)
	public String multiDeleteCommand(MyDelete del, ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				String []spl = del.getDel().split(", ");
				
				for (int i = 0; i < spl.length; i++)
				{
					MyProduct temp = myProductService.getProduct(spl[i]);
					if (temp != null)
					{
						myProductService.removeProduct(temp);
					}
				}
				
				return "redirect:AdminList.html";
			}
			else
			{
				result.addAttribute("message", "Hi " + myUser.getUsername() + ", you don't have permission to access this page!");
				result.addAttribute("page", "UserLogin.html");
				return "403";
			}
			
		}
		else
		{
			result.addAttribute("message", "Please login with Administrator to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
		
	}
	
	@RequestMapping("/MultiDelete")
	public String multiDeleteProduct(ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				List<MyProduct> list = myProductService.getListProduct();
				result.addAttribute("listProduct", list);
				result.addAttribute("page", "AdminList.html");
				result.addAttribute("info", "Back to list");
				result.addAttribute("command", new MyDelete());
				return "MultiDelete";
			}
			else
			{
				result.addAttribute("message", "Hi " + myUser.getUsername() + ", you don't have permission to access this page!");
				result.addAttribute("page", "UserLogin.html");
				return "403";
			}
			
		}
		else
		{
			result.addAttribute("message", "Please login with Administrator to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
		
	}


// ------------------------------ LOGIN - LOGOUT ---------------------------------//	
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("Login") MyLogin user, ModelMap result)
	{
		List<MyUser> list = myUserService.getListUser();
		MyUser res = new MyUser();
		
		int flag = 0;
		
		for (MyUser temp : list)
		{
			if (temp.getUsername().equals(user.getUsername()))
			{
				flag = 1;
				res = temp;
				break;
			}
		}
		
		if (flag != 1)
		{
			result.addAttribute("error", "User not exist");
			result.addAttribute("command", new MyLogin());
			return "Login";
		}
		else
		{
			myUser = res;
			MyRole role = myRoleService.getRoleUsername(user.getUsername());
			myRole = role;
			
			if (res.getPass().equals(user.getPassword()))
			{
				result.addAttribute("error", "You must change password to continue");
				result.addAttribute("command", new MyLogin());
				return "ChangePassword";
			}
			else
			{
				if (res.getPass().equals("" + user.getPassword().hashCode()))
				{
					myUser.setPass(user.getPassword());
					if (role.getRole().equals("ADMIN"))
					{
						result.addAttribute("user", user.getUsername());
						result.addAttribute("page", "AdminList.html");
						return "UserLogin";
					}
						
					else
					{
						result.addAttribute("user", user.getUsername());
						result.addAttribute("page", "UserList.html");
						return "UserLogin";
					}
						
				}
				else
				{
					result.addAttribute("error", "Wrong password");
					result.addAttribute("command", new MyLogin());
					return "Login";
				}
			}
				
		}
	}
	
	@RequestMapping(value="/Login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(ModelMap result)
	{
		
		result.addAttribute("command", new MyLogin());
		result.addAttribute("error", "Login");

		return "Login";
	}
	
	@RequestMapping("/UserLogin")
	public String userLogin(ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			result.addAttribute("user",  myUser.getUsername());
			if (myRole.getRole() != null)
			{
				if (myRole.getRole().equals("ADMIN"))
				{
					result.addAttribute("page", "AdminList.html");
				}
				else
				{
					result.addAttribute("page", "UserList.html");
				}
			}
			
			return "UserLogin";
		}
		else
		{
			result.addAttribute("message", "Please login to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
	}
	
	@RequestMapping("/Logout")
	public String logout()
	{
		myUser.setUsername(null);
		myUser.setPass(null);
		myUser.setName(null);
		myUser.setAddress(null);
		myUser.setEmail(null);
		myUser.setPhone(null);
		
		myRole.setId(null);
		myRole.setRole(null);
		myRole.setUsername(null);
		
		return "redirect:index.html";
	}
	

	@RequestMapping(value="/ChangePassword", method = RequestMethod.GET)
	public String changePassword(ModelMap result)
	{

		if (myUser.getUsername() != null)
		{
			result.addAttribute("error", "Change password");
			result.addAttribute("command", new MyLogin());
			if (myUser.getUsername() == null)
			{
				result.addAttribute("page", "index.html");
				result.addAttribute("info", "Back to main page");
			}
			else
			{
				result.addAttribute("page", "UserInfo.html");
				result.addAttribute("info", "Back to Info page");
			}
			
			return "ChangePassword";
		}
		else
		{
			result.addAttribute("message", "Please login to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
	}
	
	@RequestMapping(value="/changePassword", method = RequestMethod.POST)
	public String changePasswordCommand(MyLogin log, ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (!((log.getPassword().length() != 0) && (log.getPassword1().length() != 0) && (log.getPassword2().length() != 0)))
			{
				result.addAttribute("error", "Please fill correct field, not accept null");
				result.addAttribute("command", new MyLogin());
				if (myUser.getUsername() == null)
				{
					result.addAttribute("page", "index.html");
					result.addAttribute("info", "Back to main page");
				}
				else
				{
					result.addAttribute("page", "UserInfo.html");
					result.addAttribute("info", "Back to Info page");
				}
				
				return "ChangePassword";
			}
			
			if (!log.getPassword().equals(myUser.getPass()))
			{
				result.addAttribute("error", "Please input correct old password");
				result.addAttribute("command", new MyLogin());
				
				if (myUser.getUsername() == null)
				{
					result.addAttribute("page", "index.html");
					result.addAttribute("info", "Back to main page");
				}
				else
				{
					result.addAttribute("page", "UserInfo.html");
					result.addAttribute("info", "Back to Info page");
				}
				
				return "ChangePassword";
			}
			
			if (!log.getPassword1().equals(log.getPassword2()))
			{
				result.addAttribute("error", "Please input same new password");
				result.addAttribute("command", new MyLogin());
				
				if (myUser.getUsername() == null)
				{
					result.addAttribute("page", "index.html");
					result.addAttribute("info", "Back to main page");
				}
				else
				{
					result.addAttribute("page", "UserInfo.html");
					result.addAttribute("info", "Back to Info page");
				}
				
				return "ChangePassword";
			}
			
			if (log.getPassword().equals(log.getPassword1()))
			{
				result.addAttribute("error", "New password must different with old password");
				result.addAttribute("command", new MyLogin());
				
				if (myUser.getUsername() == null)
				{
					result.addAttribute("page", "index.html");
					result.addAttribute("info", "Back to main page");
				}
				else
				{
					result.addAttribute("page", "UserInfo.html");
					result.addAttribute("info", "Back to Info page");
				}
				
				return "ChangePassword";
			}
			
			myUser.setPass("" + log.getPassword1().hashCode());
			myUserService.updateUser(myUser);
			
			if (myRole.getRole().equals("ADMIN"))
			{
				result.addAttribute("user", myUser.getUsername());
				result.addAttribute("page", "AdminList.html");
				return "UserLogin";
			}
				
			else
			{
				result.addAttribute("user", myUser.getUsername());
				result.addAttribute("page", "UserList.html");
				return "UserLogin";
			}
		}
		else
		{
			result.addAttribute("message", "Please login to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
		
		

	}
	
	@RequestMapping(value="/403", method = RequestMethod.GET)
	public String accessDenied(ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			return "redirect:UserLogin.html";
		}
		else
		{
			return "redirect:Login.html";
		}
		
	}
	
// ------------------------------- INFO -----------------------------//	

	@RequestMapping(value="/UserInfo", method = RequestMethod.GET)
	public String userInfoLogin(ModelMap result)
	{
		if (myUser.getName() != null)
		{
			result.addAttribute("username", myUser.getUsername());
			result.addAttribute("name", myUser.getName());
			result.addAttribute("address", myUser.getAddress());
			result.addAttribute("email", myUser.getEmail());
			result.addAttribute("phone", myUser.getPhone());
			
			result.addAttribute("page", "UserLogin.html");
			result.addAttribute("info", "Back to main page");
			result.addAttribute("change", "ChangePassword.html");
			result.addAttribute("changeinfo", "Change password");
			
			return "UserInfo";
		}
		else
		{
			result.addAttribute("message", "Please login to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
	}
	
	@RequestMapping(value={"/", "/index.html"}, method = RequestMethod.GET)
	public String indexPage(ModelMap result)
	{
		return "index";
	}
	
// -------------------------------- HELP PAGE  --------------------------   //	
	
	@RequestMapping(value="/Help", method = RequestMethod.GET)
	public String helpPage(ModelMap result)
	{
		String message1 = "Hi! This is help page to provide you some infomation to use this page. \n\n";
		String message2 = "1. You must login into page to use.";
		String message3 = "2. You can show list products or info of user after you login";
		String message4 = "3. If your session has expired, you must login again to use";
		
		result.addAttribute("message1", message1);
		result.addAttribute("message2", message2);
		result.addAttribute("message3", message3);
		result.addAttribute("message4", message4);
		
		if (myRole.getId() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				result.addAttribute("page", "UserLogin.html");
			}
			else
			{
				result.addAttribute("page", "UserLogin.html");
			}
		}
		else
			result.addAttribute("page", "index.html");
		
		
		return "Help";
	}
	
	
// ------------------------------ LIST ------------------------------//
	
	@RequestMapping(value="/AdminList", method = RequestMethod.GET)
	public String adminList(ModelMap result)
	{
		if (myUser.getUsername() != null)
		{
			if (myRole.getRole().equals("ADMIN"))
			{
				List<MyProduct> list = myProductService.getListProduct();
				result.addAttribute("listProduct", list);
				result.addAttribute("page", "UserLogin.html");
				result.addAttribute("info", "Back to main page");
				result.addAttribute("add", "AddProduct.html");
				result.addAttribute("addProduct", "Add new Product");
				result.addAttribute("deleteProduct", "Multi delete product");
				result.addAttribute("del", "MultiDelete.html");
				
				return "AdminList";
			}
			else
			{
				result.addAttribute("message", "Hi " + myUser.getUsername() + ", you don't have permission to access this page!");
				result.addAttribute("page", "UserLogin.html");
				return "403";
			}
		}
		else
		{
			result.addAttribute("message", "Please login to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}
			
	}

	@RequestMapping(value="/UserList", method = RequestMethod.GET)
	public String userList(ModelMap result)
	{
		if (myUser.getName() != null)
		{
			List<MyProduct> list = myProductService.getListProduct();
			result.addAttribute("listProduct", list);
			result.addAttribute("page", "UserLogin.html");
			result.addAttribute("info", "Back to main page");
			
			return "UserList";
		}
		else
		{
			result.addAttribute("message", "Please login to access this page!");
			result.addAttribute("page", "Login.html");
			return "403";
		}

	
	}

}
