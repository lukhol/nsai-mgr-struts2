package com.politechnika.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("/parentPackage")
@Namespace("/")
@Result(name="input", type="tiles", location="registerView")
public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 4872981664283281427L;
	
	@Action("register")
	public String register() throws Exception {
		
		return INPUT;
	}
	
}
