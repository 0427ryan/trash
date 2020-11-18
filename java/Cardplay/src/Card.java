public class Card {
	private Num number;
	private Kind kind;

	public Card(Num number, Kind kind){
		this.number = number;
		this.kind = kind;
	}
	public int compareTo(Card o){
		if(this.getPriority() > o.getPriority() ) {
			return 1;
		}
		if(this.getPriority() == o.getPriority() ){
			return 0;
		}
		return -1;
	}
	
	public int getPriority(){
		return number.getPriority() * 4 + kind.getPriority();
	}

	public int getNumber(){
		return number.getPriority();
	}
	@Override
	public String toString(){
		return this.kind.toString() + " " + this.number.toString();  
	}
}