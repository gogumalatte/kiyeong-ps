import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int res = 0;
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[][] origin = new int[n][n];
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(origin, 0);
		System.out.println(res);
	}
	
	private static void solve(int[][] arr, int depth) {
		findLargeNum(arr);
		if(depth == 5) {
			return;
		}
		for(int i = 1; i <= 4; ++i) {
			solve(move(arr, i), depth+1);
		}
	}
	
	private static int[][] move(int[][] arr, int typeNum) {
		int[][] movedArr = new int[n][n];
		switch(typeNum) {
			case 1: // 위로 이동
				for(int i = 0; i < n; ++i) {
					int movedIndex = 0; // 새로 담아야 할 곳의 행 인덱스
					int frontPointer = 0;
					for(int rearPointer = 1; rearPointer < n; ++rearPointer) {
						if(arr[frontPointer][i] == 0 && arr[rearPointer][i] == 0) {
							frontPointer += 2;
							rearPointer++;
						} else if(arr[frontPointer][i] == 0 && arr[rearPointer][i] != 0) {
							frontPointer = rearPointer;
						} else if(arr[frontPointer][i] != 0 && arr[rearPointer][i] == 0) {
							continue;
						} else if(arr[frontPointer][i] == arr[rearPointer][i]) {
							movedArr[movedIndex++][i] = arr[frontPointer][i] * 2;
							frontPointer = rearPointer + 1;
							rearPointer++;
						} else if(arr[frontPointer][i] != arr[rearPointer][i]) {
							movedArr[movedIndex++][i] = arr[frontPointer][i];
							frontPointer = rearPointer;
						}
					}
					if(frontPointer <= n - 1) {
						movedArr[movedIndex][i] = arr[frontPointer][i];
					}
				}
				break;
			case 2: // 아래로 이동
				for(int i = 0; i < n; ++i) {
					int movedIndex = n - 1; // 새로 담아야 할 곳의 행 인덱스
					int frontPointer = n - 1;
					for(int rearPointer = n - 2; rearPointer >= 0; --rearPointer) {
						if(arr[frontPointer][i] == 0 && arr[rearPointer][i] == 0) {
							frontPointer -= 2;
							rearPointer--;
						} else if(arr[frontPointer][i] == 0 && arr[rearPointer][i] != 0) {
							frontPointer = rearPointer;
						} else if(arr[frontPointer][i] != 0 && arr[rearPointer][i] == 0) {
							continue;
						} else if(arr[frontPointer][i] == arr[rearPointer][i]) {
							movedArr[movedIndex--][i] = arr[frontPointer][i] * 2;
							frontPointer = rearPointer - 1;
							rearPointer--;
						} else if(arr[frontPointer][i] != arr[rearPointer][i]) {
							movedArr[movedIndex--][i] = arr[frontPointer][i];
							frontPointer = rearPointer;
						}
					}
					if(frontPointer >= 0) {
						movedArr[movedIndex][i] = arr[frontPointer][i];
					}
				}
				break;
			case 3: // 왼쪽으로 이동
				for(int i = 0; i < n; ++i) {
					int movedIndex = 0; // 새로 담아야 할 곳의 열 인덱스
					int frontPointer = 0;
					for(int rearPointer = 1; rearPointer < n; ++rearPointer) {
						if(arr[i][frontPointer] == 0 && arr[i][rearPointer] == 0) {
							frontPointer += 2;
							rearPointer++;
						} else if(arr[i][frontPointer] == 0 && arr[i][rearPointer] != 0) {
							frontPointer = rearPointer;
						} else if(arr[i][frontPointer] != 0 && arr[i][rearPointer] == 0) {
							continue;
						} else if(arr[i][frontPointer] == arr[i][rearPointer]) {
							movedArr[i][movedIndex++] = arr[i][frontPointer] * 2;
							frontPointer = rearPointer + 1;
							rearPointer++;
						} else if(arr[i][frontPointer] != arr[i][rearPointer]) {
							movedArr[i][movedIndex++] = arr[i][frontPointer];
							frontPointer = rearPointer;
						}
					}
					if(frontPointer <= n - 1) {
						movedArr[i][movedIndex] = arr[i][frontPointer];
					}
				}
				break;
			case 4: // 오른쪽으로 이동
				for(int i = 0; i < n; ++i) {
					int movedIndex = n - 1; // 새로 담아야 할 곳의 열 인덱스
					int frontPointer = n - 1;
					for(int rearPointer = n - 2; rearPointer >= 0; --rearPointer) {
						if(arr[i][frontPointer] == 0 && arr[i][rearPointer] == 0) {
							frontPointer -= 2;
							rearPointer--;
						} else if(arr[i][frontPointer] == 0 && arr[i][rearPointer] != 0) {
							frontPointer = rearPointer;
						} else if(arr[i][frontPointer] != 0 && arr[i][rearPointer] == 0) {
							continue;
						} else if(arr[i][frontPointer] == arr[i][rearPointer]) {
							movedArr[i][movedIndex--] = arr[i][frontPointer] * 2;
							frontPointer = rearPointer - 1;
							rearPointer--;
						} else if(arr[i][frontPointer] != arr[i][rearPointer]) {
							movedArr[i][movedIndex--] = arr[i][frontPointer];
							frontPointer = rearPointer;
						}
					}
					if(frontPointer >= 0) {
						movedArr[i][movedIndex] = arr[i][frontPointer];
					}
				}
				break;
		}
		return movedArr;
	}
	
	private static void findLargeNum(int[][] arr) {
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				res = Math.max(res, arr[i][j]);
			}
		}
	}
}
