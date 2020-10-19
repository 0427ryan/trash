public class Card {
	private Integar number;
	private Kind kind;

	public enum Kind{

	}

	public Card(int number, String kind){
		this.number = number;
		this.kind = new String(kind);
	}
	public int compareTo(Object o){
		if(this.toString().equals( o.toString() )) {
			return 0;
		}
	}
	public String toString(){
		return this.kind + this.number;  
	}

}