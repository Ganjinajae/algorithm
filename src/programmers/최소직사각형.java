package programmers;

public class 최소직사각형 {
	public static void main(String[] args) {
		System.out.println(new 최소직사각형().solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
		System.out.println(new 최소직사각형().solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
		System.out.println(new 최소직사각형().solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
	}
	
	public int solution(int[][] sizes) {
        int w = Math.max(sizes[0][0], sizes[0][1]);
        int h = Math.min(sizes[0][0], sizes[0][1]);
        
        for (int i = 1; i < sizes.length; i++) {
			int a = sizes[i][0];
			int b = sizes[i][1];
			
			if (a > w || b > w) {
				w = Math.max(a, b);
			}
			if ((a <= w && b <= h) || (a <= h && b <= w)) {
				continue;
			}
			h = Math.min(a, b);
		}
        
        return w*h;
    }
}
