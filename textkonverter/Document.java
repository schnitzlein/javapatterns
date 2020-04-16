package textkonverter;

import javax.print.attribute.HashDocAttributeSet;
import javax.swing.text.AttributeSet;
import javax.swing.text.EditorKit;
import javax.swing.text.PlainDocument;

//This class abstracts the document object
class Document{
	PlainDocument doc;
	AttributeSet as;
	HashDocAttributeSet a;
	
	static int value;
	char token;
	
	
	public char getNextToken(){
		//Get the next token
		return token;
	}
}