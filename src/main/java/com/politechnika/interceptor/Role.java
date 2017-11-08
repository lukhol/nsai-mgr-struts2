package com.politechnika.interceptor;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.politechnika.models.RoleName;

@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface Role {

	RoleName[] roleNames();
}
