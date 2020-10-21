public class Card {
	private int number;
	private Kind kind;

	public Card(int number, Kind kind){
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
		int kindPriority = 0;
		switch(this.kind){
			case SPADE:
				kindPriority = 1;
				break;
			case DIAMOND:
				kindPriority = 2;
				break;
			case HEART:
				kindPriority = 3;
				break;
			case CLUB:
				kindPriority = 4;
				break;
		}
		return this.number * 4 + kindPriority;
	}

	public String toString(){
		return this.kind.toString() + this.number;  
	}

}