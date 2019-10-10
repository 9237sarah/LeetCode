// https://leetcode.com/problems/design-snake-game/

class SnakeGame {

    /** Initialize data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	
	private static final String UP = "U";
	private static final String DOWN = "D";
	private static final String LEFT = "L";
	private static final String RIGHT = "R";
	
	private LinkedList<int[]> snake = new LinkedList<>();
	private int foodIndex;
	private int w;
	private int h;
	private int[][] food;
	private int score;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        w = width;
        h = height;
        int[] start = new int[]{0, 0};
        snake.add(start);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) {
            return -1;
        }
        
        int[] head = snake.getFirst();
        int[] newHead = new int[] {head[0], head[1]};
        int[] tail = snake.removeLast();
        
        if (UP.equals(direction)) {
            newHead[0]--;
        } else if (DOWN.equals(direction)) {
            newHead[0]++;
        } else if (LEFT.equals(direction)) {
            newHead[1]--;
        } else if (RIGHT.equals(direction)) {
            newHead[1]++;
        } else {
        	throw new IllegalArgumentException("Direction " + direction + " is not allowed");
        }
        
        if (foodIndex < food.length && newHead[0] == food[foodIndex][0] && newHead[1] == food[foodIndex][1]) {
            snake.add(tail);
            foodIndex++;
        }
        
        if (newHead[0] < 0 || newHead[0] >= h || newHead[1] < 0 || newHead[1] >= w || hit(newHead)) {
            score = -1;
            return -1;
        }
        snake.addFirst(newHead);
        return foodIndex;
    }
    
    public boolean hit(int[] head) {
        for (int[] s : snake) {
            if (s[0] == head[0] && s[1] == head[1]) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */