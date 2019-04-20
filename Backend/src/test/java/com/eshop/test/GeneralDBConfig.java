package com.eshop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralDBConfig 
{
		public static void main(String[] args)
		
		{
	    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.eshop");
	    context.refresh();
		}

	}



