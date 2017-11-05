package com.politechnika.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("/parentPackage")
@Namespace("/")
@Result(name="success", type="tiles", location="homeView")
@Action("home")
public class HomeAction extends ActionSupport {
	private static final long serialVersionUID = -5915939494810953918L;
	
	public String execute() throws Exception {
		return SUCCESS;
	}
}
