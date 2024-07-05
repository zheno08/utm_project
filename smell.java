package net.codejava;

public class smell {
	
	class BookDetalis {
	    String type;
	  
	    String bookType() {
	        switch (type) {
	            case "Novels":
	                return "Novels";
	            case "magazines":
	                return "magazines";
	                
	            case "literature":
	                return "literature";
	            default:
	                throw new IllegalStateException();
	        }
	    }
	}

	
}
