/*
 * Author: Carl Linton
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */
package program1;

public class MyString {

private char[] letters; //the char array
private int currLength; //the length

public MyString(){ //null constructor
	letters = null;
	currLength = 0;
	}

public MyString(String word){ //standard construcor
	letters = word.toCharArray[];
	currLength = word.length(); //length calculated with array method
	}

public static int length(){
	return currLength;
	}

private static void ensureCapacity(){
	}

public static String toString(){
	return letters.toString(); //string gotten with array method
	}

public static char[] getArray(){ //method for use in other methods
	return letters;
	}

public static void concat(MyString other){ //concatonation by array method
	letters = (char[])ArrayUtils.addAll(letters, other.getArray);	
	}

public static boolean equals(MyString other){
	char[] otherArray = other.getArray();
	boolean equal;
	
	equal = Arrays.equals(letters, otherArray); //equality determined by array method
	
	return equal;
	}

public static int compareTo(MyString other) {
	int length = 0; //base value for length to prevent error checking from whining
	int n = 0; //counter
	int relation = 0; //used to determine if letter is earlier or later
	char c1, c2;
	char[] otherArray = other.getArray();
	
	if(currLength < other.length()){ //sets length of loop to shortest array length
		length = currLength;
	} else{
		length = other.length;
	}
	while((n < length) && (relation == 0)){ //loop compares each letter and stops when they aren't equal
		c1 = letters[n];
		c2 = otherArray[n];
		relation = c1.compareTo(c2);
		n++;
	}
	return total;

	}

public static char get(int n){
	return letters[n];
	}

public static void toUpper(){
	int n = 0;
	char c;
	while(n < currLength){ //converts each letter to an upper case letter
		c = letters[n];
		letters[n] = c.toUpper;
		n++;
	} 
	}

public static void toLower(){
	int n = 0;
	char c;
	while(n < currLength){ //converts each letter to a lower case letter
		c = letters[n];
		letters[n] = c.toLower;
		n++;
	}
	}

public static int indexOf(MyString str){
	int n = 0; //counter
	int n2, n3; //secondary and tertiary counter
	int index = -1; //value for starting index, is -1 if no match
	char c1, c2;
	char[] strArr = str.getArray();
	int strLen = str.length(); //length of sub-string 
	while((n < currLength) && (index == -1)){ //loop checks each value of the MyString for a matching first letter
		c1 = letters[n];
		c2 = strArr[0];
		if(c1.equals(c2)){
			n2 = 0; //match resets secondary counter
			n3 = n; //tertiary counter set to starting index
			}
		while((c1.equals(c2) && (n2 < strLen)){ //loop compares each letter and stops early if any aren't equal
			c1 = letter[n3]; //tertiary counter tracks index on main string
			c2 = strArr[n2]; //secondary counter tracks index on secondary string
			n2++;
			n3++;
			}
		if((n2 == strLen) && c1.equals(c2)){ //if the loop checked all the letters in the substring and the last two letters are equal, then the value for the starting index is set to n
			index = n;
			}
		n++;
		}
	return index;
	}

public static int lastIndexOf(MyString str){
	char[] strArr = str.getArray();
	char c1, c2;
	int index = -1;
	int strLen = str.length();
	int n = currLength - strLen; //the counter starts at the highest number it could possibly be, preventing out of bounds errors and saving time
	int n2, n3;
	while((n >= 0 && (index == -1)){ //loop starts at last letter the first index could be and works backwards
		c1 = letters[n];
		c2 = strArr[0];
		if(c1.equals(c2)){
			n2 = 0;
			n3 = n;
			}
		while((c1.equals(c2)) && (n2 < strLen)){
			c1 = letters[n3];
			c2 = strArr[n2];
			n2++;
			n3++;
			}
		if((n2 == strLen) && c1.equals(c2)){
			index = n;
			}
		n--;
		}
	return index;
	}

public static MyString substring(int n){
	int num = n;
	int index = 0;
	char[] subArr = new char[](); //empty array made for storage
	while(num < currLength){ //loop copies every char starting at index n to subArr
		subArr[index] = letters[num];
		num++;
		index++;
		}
	String str = subArr.toString(); 
	MyString newStr = MyString(str); //subArr is converted to String then to MyString
	return newStr;
	}

public static MyString substring(int n, int m){
	int num = n;
	int max = m;
	int index = 0;
	char[] subArr = new char[]();
	while((num < max) && (num < currLength)){
		subArr[index] = letters[num];
		num++;
		index++;
		}
	String str = subArr.toString();
	MyString newStr = MyString(str);
	return newStr;
	}

}