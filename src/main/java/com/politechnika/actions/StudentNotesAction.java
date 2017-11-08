package com.politechnika.actions;

import com.politechnika.interceptor.Role;
import com.politechnika.models.RoleName;

@Role(roleNames= {RoleName.STUDENT})
public class StudentNotesAction extends UserAwareAction {
	private static final long serialVersionUID = 3641852079848617733L;
}
