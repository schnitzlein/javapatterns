package textkonverter;

//Concrete Builder
public class ASCIIConverter extends TextConverter{
	ASCIIText asciiTextObj;//resulting product

	/*converts a character to target representation and appends to the resulting*/
	public void convertCharacter(char c){
		char asciiChar = new Character(c).charValue();
			//gets the ascii character
		asciiTextObj.append(asciiChar);
	}
	public void convertParagraph(){}
	ASCIIText getResult(){
		return asciiTextObj;
	}
}