package com.politechnika.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("/parentPackage")
@Namespace("/")
@Result(name="input", type="tiles", location="firstView")
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 2047477076086738030L;

	@Action("login")
	public String input() {
		return "input";
	}
}
