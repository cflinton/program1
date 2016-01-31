/*
 * Author: Carl Linton
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */
//package program1;

import java.lang.Character;
import java.util.Arrays;

public class MyString {

private char[] letters; //the char array
private int currLength; //the length

public MyString(){ //null constructor
	letters = null;
	currLength = 0;
	}

public MyString(String word){ //standard construcor
	letters = word.toCharArray();
	currLength = word.length(); //length calculated with array method
	}

public MyString(MyString other){
	letters = other.letters;
	currLength = other.currLength;
	}

public int length(){
	return currLength;
	}

private void ensureCapacity(){
	}

public String toString(){
	String str;
	if(letters == null) { //this exists to prevent a null pointer exception
		str = new String(""); 
	} else {
		str = new String(letters); //string gotten with array method
	}
	return str;
	}

public char[] getArray(){ //method for use in other methods
	return letters;
	}

public MyString concat(MyString other){ //concatonation by array method
	char[] otherArr;
	int aLen = currLength;
	int bLen;
	String str;
	MyString concated;
	if(other.letters == null){
		concated = new MyString(this);
	} else{
		otherArr = other.getArray();
		bLen = otherArr.length;
		char[] c = new char[aLen + bLen];
		System.arraycopy(letters, 0, c, 0, aLen);
		System.arraycopy(otherArr, 0, c, aLen, bLen);
		str = c.toString();
		concated = new MyString(str);
	}
	return concated;
	}

public MyString concat(String st){ //while the word document says to accept a MyString parameter for the concat method, this overloaded method is necessary to make the test program compile and run
	char[] otherArr = st.toCharArray();
 	int aLen = currLength;
	int bLen = otherArr.length;
	String str;
	if(letters == null){
		str = otherArr.toString();
	} else{
		str = (this.toString()) + st;
	}
	MyString concated = new MyString(str);
	return concated;
	}

public boolean equals(MyString other){
	char[] otherArray = other.getArray();
	boolean equal;
	
	equal = Arrays.equals(letters, otherArray); //equality determined by array method
	
	return equal;
	}

public int compareTo(MyString other) {
	int strlen = 0; //base value for length to prevent error checking from whining
	int n = 0; //counter
	int relation = 0; //used to determine if letter is earlier or later
	char c1, c2;
	char[] otherArray = other.getArray();
	
	if(currLength < other.length()){ //sets length of loop to shortest array length
		strlen = currLength;
	} else{
		strlen = other.length();
	}
	while((n < strlen) && (relation == 0)){ //loop compares each letter and stops when they aren't equal
		c1 = letters[n];
		c2 = otherArray[n];
		relation = Character.valueOf(c1).compareTo(Character.valueOf(c2));
		n++;
	}
	return relation;

	}

public char get(int n){
	char c;
	if(letters == null) {
		c = ' ';
	} else{
		c = letters[n-1];
	}
	return c;
	}

public MyString toUpper(){
	int n = 0;
	char c;
	String str = "";
	while(n < currLength){ //converts each letter to an upper case letter
		c = letters[n];
		str = str + Character.toUpperCase(c);
		n++;
		}
	MyString myStr = new MyString(str);
	return myStr;
}

public MyString toLower(){
	int n = 0;
	char c;
	String str = "";
	while(n < currLength){ //converts each letter to a lower case letter
		c = letters[n];
		str = str + Character.toLowerCase(c);
		n++;
	}
	MyString myStr = new MyString(str);
	return myStr;
}

public int indexOf(MyString str){
	int n = 0; //counter
	int n2 = 0;
	int n3 = 0; //secondary and tertiary counter
	int index = -1; //value for starting index, is -1 if no match
	char c1 = ' ';
	char c2 = ' ';
	char[] strArr = str.getArray();
	int strLen = str.length(); //length of sub-string 
	while((n < currLength) && (index == -1)){ //loop checks each value of the MyString for a matching first letter
		c1 = letters[n];
		c2 = strArr[0];
		if(c1 == c2){
			n2 = 0; //match resets secondary counter
			n3 = n; //tertiary counter set to starting index
			}
		while((c1 == c2) && (n2 < strLen)){ //loop compares each letter and stops early if any aren't equal
			c1 = letters[n3]; //tertiary counter tracks index on main string
			c2 = strArr[n2]; //secondary counter tracks index on secondary string
			n2++;
			n3++;
			}
		if((n2 == strLen) && (c1 == c2)){ //if the loop checked all the letters in the substring and the last two letters are equal, then the value for the starting index is set to n
			index = n;
			}
		n++;
		}
	return index;
	}

public int lastIndexOf(MyString str){
	char[] strArr = str.getArray();
	char c1 = ' ';
	char c2 = ' ';
	int index = -1;
	int strLen = str.length();
	int n = currLength - strLen; //the counter starts at the highest number it could possibly be, preventing out of bounds errors and saving time
	int n2 = 0;
	int n3 = 0;
	while((n >= 0) && (index == -1)){ //loop starts at last letter the first index could be and works backwards
		c1 = letters[n];
		c2 = strArr[0];
		if(c1 == c2){
			n2 = 0;
			n3 = n;
			}
		while((c1 == c2) && (n2 < strLen)){
			c1 = letters[n3];
			c2 = strArr[n2];
			n2++;
			n3++;
			}
		if((n2 == strLen) && (c1 == c2)){
			index = n;
			}
		n--;
		}
	return index;
	}

public MyString substring(int n){
	int num = n;
	int index = 0;
	char[] subArr = new char[currLength - num]; //empty array made for storage
	while(num < currLength){ //loop copies every char starting at index n to subArr
		subArr[index] = letters[num];
		num++;
		index++;
		}
	String str = subArr.toString(); 
	MyString newStr = new MyString(str); //subArr is converted to String then to MyString
	return newStr;
	}

public MyString substring(int n, int m){
	int num = n;
	int max = m;
	int index = 0; 
	char[] subArr = new char[max - num];
	while((num < max) && (num < currLength)){
		subArr[index] = letters[num];
		num++;
		index++;
		}
	String str = subArr.toString();
	MyString newStr = new MyString(str);
	return newStr;
	}

}
