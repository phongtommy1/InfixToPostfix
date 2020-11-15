package infixxToPostfix;

//
//   Name: Tommy Phong
//   Project: #2
//   Due: 3/9/202
//   Course: cs-2400-02
//
//   Description:
//               This class define Name, and allows name to store a string, that contain 
//               it's data. It also define getter and setter for this class.              
//
public class Name {
    private String name;
    private int value;
	
    public Name(String name, int value) {
    	this.name = name;
    	this.value = value;
    }
    
    public int getValue() {
    	return value;
    }
    
    public String getName() {
    	return name;
    }
}
