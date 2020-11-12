public enum Kind {
	SPADE(1),
	DIAMOND(2),
	HEART(3),
	CLUB(4);

    private int priority;
    Kind(int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }
}