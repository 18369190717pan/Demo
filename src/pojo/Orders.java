package pojo;

public class Orders {
     private int orderid;
     private String name;
     private float cost;
     private String  userid;
     private String statusid;
     private String paywayid;
     
     public int getOrderid(){
    	 return orderid;
     }
     
     
     public String getName(){
    	 return name;
     }
     
     public float getCost(){
    	 return cost;
     }
     
     public String getUserid(){
    	 return userid;
     }
     
     public String getStatusid(){
    	 return statusid;
     }
     
     public String getPaywayid(){
    	 return paywayid;
     }
     
     
     public void setOrderid(int i){
    	 orderid=i;
     }
     
     public void setName(String i){
    	name=i;
     }
     
     public void setCost(float i){
    	 cost=i;
     }
     
     public void setUserid(String i){
    	userid=i;
     }
     
     
     public void setStatusid(String i){
     	statusid=i;
      }
     public void setPaywayid(String i){
      	paywayid=i;
       }
     
     
     
}
