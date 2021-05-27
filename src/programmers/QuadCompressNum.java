package programmers;

import java.util.Arrays;

/**
 * 쿼드압축 후 개수 세기
 * @author wldud
 *
 */
public class QuadCompressNum {
    int one;
    int zero;
	
	public static void main(String[] args) {
		QuadCompressNum test = new QuadCompressNum();
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int[] answer = test.solution(arr);
		System.out.println(Arrays.toString(answer));
	}
	
	public int[] solution(int[][] arr) {
        int[] answer = new int[2];;
        
        dfs(arr, 0, 0, arr.length);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
	
	public void dfs(int[][] arr, int r, int c, int len) {
		if(len == 1) {
			if(arr[r][c] == 0) {
				zero++;
			}
			else {
				one++;
			}
			return;
		}
		
		int value = arr[r][c];
		boolean isSame = true;
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				if(value != arr[i][j]) {
					isSame = false;
					break;
				}
			}
		}
		
		if(isSame) {
			if(value == 0) {
				zero++;
			}
			else {
				one++;
			}
		}
		else {
			len = len/2;
			dfs(arr, r, c, len);
			dfs(arr, r, c+len, len);
			dfs(arr, r+len, c, len);
			dfs(arr, r+len, c+len, len);
		}
	}
}
