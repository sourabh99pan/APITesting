package restassuredTest2;

public class Gorest {
	
	int id;
	String name;                                                          
	String email;                                                     
	String gender;    
	String status;
	                                                                     
	public Gorest(int id,String name, String email, String gender,String status)     
	{      
		this.id=id;
		this.name = name;                                                  
		this.email = email;                                        
		this.gender = gender; 
		this.status =status;
	}                                                                    
	                                                                     
	public int getId() {                                             
		return id;                                                      
	}                                                                    
	public void setName(String name) {                                     
		this.name = name;                                                 
	}   
	
	public String getname()
	{
		return name;
	}
	
	public void setEmail(String email) {                                     
		this.email = email;                                                  
	}   
	
	public String getEmail()
	{
		return email;
	}
	
	public void setGender(String gender) {                                     
		this.gender = gender;                                                  
	}  
	
	public String getGender() {                                        
		return gender;                                                 
	}   
	
	public void setStatus(String status) {                           
		this.status = status;                                        
	}    
	
	public String getStatus() {                                        
		return status;                                                 
	}   
	
                                                                   
}
