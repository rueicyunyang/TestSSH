package com.mkyong.customer.action;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 




import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.struts.ActionSupport;

import com.mkyong.customer.bo.CustomerBo;
import com.mkyong.customer.bo.impl.CustomerBoImpl;
import com.mkyong.customer.form.CustomerForm;
import com.mkyong.customer.model.Customer;
 
public class ForwardAction extends DispatchAction{

	CustomerBoImpl customerBo;
 
	public ActionForward add(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {
		
//		CustomerForm customerForm = (CustomerForm)form;
//		Customer customer = new Customer();
//		
//		//copy customerform to model
//		BeanUtils.copyProperties(customer, customerForm);
//		
//		//save it
//		customerBo.addCustomer(customer);
	        
		request.setAttribute("methodName", "Add");
		return mapping.findForward("add");
	  
	}

	public ActionForward list(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
	    throws Exception {
	
		List<Customer> list = customerBo.findAllCustomer();
		
		request.setAttribute("customerList", list);
	        
		return mapping.findForward("success");
  
	}

	public ActionForward edit(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception 
			{

		CustomerForm customerForm = (CustomerForm) form;
		String name = customerForm.getName();
//		要把既有資料帶到下一個頁面

		request.setAttribute("name", name);
		request.setAttribute("address",  customerForm.getAddress());
		request.setAttribute("customerId", customerForm.getCustomerId());
//		將該日期寫入表單會讓該日期變成字串，這樣該日期要再寫回ActionForm時就會出錯
//		request.setAttribute("createdDate", customerForm.getCreatedDate());

//		設定頁面要呈顯的字串，是新增還是修改	
		request.setAttribute("methodName", "Edit");

		return mapping.findForward("edit");
	}

	public void setCustomerBo(CustomerBoImpl customerBo) {
		this.customerBo = customerBo;
	}

//	public ActionForward execute(ActionMapping mapping,ActionForm form,
//			HttpServletRequest request,HttpServletResponse response) 
//	        throws Exception {
//			
////			DynaActionForm dynaCustomerListForm = (DynaActionForm)form;
////			
////			List<Customer> list = customerBo.findAllCustomer();
////			
////			request.setAttribute("customerList", list);
//		        
//			return mapping.findForward("add");
//		  
//		}
}