package com.Tests.JPALibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("LIB");
        EntityManager em=emf.createEntityManager();
        
        Scanner sc=new Scanner(System.in);
      
        
        
        
        do {
        	
        	System.out.println("1.Insert data");
        	System.out.println("2.Update data");
        	System.out.println("3.Delete data");
        	System.out.println("4.Show data");
        	System.out.println("5.Exit");
        	System.out.println("Enter Your Choice");
        	int choice=sc.nextInt();
        	
        	switch(choice) {
        	
        	case 1:{
        		
        		em.getTransaction().begin();
                Student st1=new Student(1,"Akash Dhamale","Pune","HRM");
                em.persist(st1);
                
                List<Student> list=new ArrayList<>();
                
                list.add(st1);
                
                
                Library lb=new Library(101,"Manse","UPSC",list);
                
                em.persist(lb);
                
                em.getTransaction().commit();
        		
        		
        		break;
        	}
        		
        	case 2:{
        		
        		em.getTransaction().begin();
        		
        		Student st=em.find(Student.class, 1);
        		
        		st.setAddress("Thane");
        		
        		em.persist(st);
        		
        		em.getTransaction().commit();
        		
        		break;
        	}
        	
        	case 3:{
        		
        		em.getTransaction().begin();
        		
        		Student st=em.find(Student.class, 1);
        		
        		em.remove(st);
        		
        		 System.out.println("Deleted successfully");
        		
        		em.getTransaction().commit();
        		
        		break;
        	}
        	
        	case 4:{
        		em.getTransaction().begin();
        		
        		Student st=em.find(Student.class, 1);
        		
        		System.out.println(st);
        		
        		em.persist(st);
        		
        		em.getTransaction().commit();
        		
        		
        		break;
        	}
        	
        	case 5:{
        		
        		System.out.println("Exit");
        		System.exit(0);
        		
        		break;
        	}
        	
  
        		
        		
        		default:
        			
        			System.out.println("Invalid choice");
        	
        	}
        	
        	
        	
        	
        }while(true);
        
        
        
        
        
    }
}
