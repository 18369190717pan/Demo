package pojo;

public class Product {

private String name;
private String description;

private int categoryid ;
private String author;
private String publish;
private int pages;
private String images;
private float basePrice;


public float getbasePrice(){
	return basePrice;
}
public String getName(){
	return name;
}
public String getDescription(){
	return description;
}

public int getCategoryid(){
	return categoryid;
}

public String getAuthor(){
	return author;
}
public String getPublish(){
	return publish;
}

public int getPages(){
	return pages;
}
public String getImages(){
	return images;
}


public void setbasePrice(float f){
	basePrice=f;
}
public void setName(String s){
	name=s;
}
public void setDescription(String d){
	description=d;
}

public void setCategoryid(int d){
	categoryid=d;
}

public void setPages(String d){
	author=d;
}

public void setAuthor(String d){
	author=d;
}
public void setPublish(String d){
	publish=d;
}
public void setPages(int d){
	pages=d;
}

public void getImages(String d){
	images=d;
}
}
