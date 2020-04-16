package textkonverter;


//Director
public class TexReader {
	private static final char EOF='0'; //Delimitor for End of File
	final char CHAR='c';
	final char PARA='p';
	char t;
	TextConverter builder;
	TexReader(TextConverter obj){
		builder=obj;
	}
	void parseTex(Document doc){
		while ((t=doc.getNextToken())!= EOF){
			switch (t){
				case CHAR: builder.convertCharacter(t);
				case PARA: builder.convertParagraph();
			}
		}
	}
}