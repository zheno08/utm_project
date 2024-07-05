package net.codejava;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book") 
public class Book {
	
	    

	    public String title;
	    
	    public String author;
	    public Double price;
	    public Double Amount;
	

	
	    
	    public Book(String title,String author,Double price,Double Amount)
	    {   this.title=title;
	        this.author=author;
	        this.Amount=Amount;
	        this.price=price;
	        
	   
	    }
	    
	 
	    public String getTitle()
	    {
	        return title;
	    }
	    
	     public String getAuthor()
	    {
	        return author;
	    }

	     public Double getAmount()
		    {
		        return Amount;
		    }
		    
	     public Double getprice()
		    {
		        return price;
		    }
		    

	 
	    public void setTitle(String title)
	    {
	        this.title=title;
	    }
	    
	     public void setAuthor(String author)
	    {
	       this.author=author;
	    }

	  public void Totalprice(Double Amount, Double price){
		  
		  double a = getAmount();
		     // discount factor
		     double b = 1;
		     if (a > 10) {
		         b = 0.9;
		     }
		     // discounted price
		     double c = getprice() * b;
		     // order sum price
		     double d = a * c;
		  
		  
	  }
	     
	
	   
	    
	}

