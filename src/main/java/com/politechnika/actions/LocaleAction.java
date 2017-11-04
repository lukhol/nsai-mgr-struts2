package com.politechnika.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("/parentPackage")
@Namespace("/")
@Action("Locale")
@Result(name="success", type="tiles", location="firstView")
public class LocaleAction extends ActionSupport {
	
	private static final long serialVersionUID = -7666152935151050961L;
	
	public String execute() {
		return SUCCESS;
	}
}
