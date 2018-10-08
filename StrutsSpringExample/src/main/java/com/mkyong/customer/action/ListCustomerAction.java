package com.mkyong.customer.action;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.customer.bo.CustomerBo;
import com.mkyong.customer.bo.impl.CustomerBoImpl;
import com.mkyong.customer.model.Customer;
 
public class ListCustomerAction extends DispatchAction{

	CustomerBoImpl customerBo;

	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	        throws Exception {
			
			DynaActionForm dynaCustomerListForm = (DynaActionForm)form;
			
			List<Customer> list = customerBo.findAllCustomer();
			
			request.setAttribute("customerList", list);
		        
			return mapping.findForward("success");
		  
		}
	public void setCustomerBo(CustomerBoImpl customerBo) {
		this.customerBo = customerBo;
	} 
}