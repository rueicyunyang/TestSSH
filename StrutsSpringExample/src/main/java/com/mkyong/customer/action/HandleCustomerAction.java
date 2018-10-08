package com.mkyong.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;

import com.mkyong.customer.bo.impl.CustomerBoImpl;
import com.mkyong.customer.form.CustomerForm;
import com.mkyong.customer.model.Customer;

public class HandleCustomerAction extends DispatchAction {

	CustomerBoImpl customerBo;
	
	public ActionForward saveAdd(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	        throws Exception {
			
//		將ActionForm的值取出	
		CustomerForm customerForm = (CustomerForm)form;
		Customer customer = new Customer();
		
		//copy customerform to model
		BeanUtils.copyProperties(customerForm, customer);
		
		//save it
		customerBo.addCustomer(customer);

		request.setAttribute("result", "新增成功");
		response.setCharacterEncoding("UTF-8");

		return mapping.findForward("list");
	  
	}

	public ActionForward saveEdit(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	        throws Exception {
		
		CustomerForm customerForm = (CustomerForm)form;
		Customer customer = new Customer();
		
		//copy customerform to model
		BeanUtils.copyProperties(customerForm,customer);
		
		//save it
		customerBo.editCustomer(customer);
//			設定要呈顯在頁面的資料
		request.setAttribute("name",customer.getName());
		request.setAttribute("address", customer.getAddress());
		request.setAttribute("result", "修改成功");
//			設定中文編碼			
		response.setCharacterEncoding("UTF-8");
		
		return mapping.findForward("list");
	  
	}

	public ActionForward delete(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	        throws Exception {
		
		CustomerForm customerForm = (CustomerForm)form;
		Customer customer = new Customer();
		
		//copy customerform to model
		BeanUtils.copyProperties(customerForm,customer);
		
		//save it
		customerBo.deleteCustomer(customer);
//			設定要呈顯在頁面的資料
		request.setAttribute("result", "刪除成功");
//			設定中文編碼			
		response.setCharacterEncoding("UTF-8");
		
		return mapping.findForward("list");
	  
	}
//	讓屬性可以被注入物件
	public void setCustomerBo(CustomerBoImpl customerBo) {
		this.customerBo = customerBo;
	}
}
