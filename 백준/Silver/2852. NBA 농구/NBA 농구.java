import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader("bj2852.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int teamOneScore = 0;
		int teamTwoScore = 0;
		int teamOneTime = 0;
		int teamTwoTime = 0;
		int lastTime = 0;
		
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			String timeStr = st.nextToken();
			int curTime = Integer.parseInt(timeStr.substring(0, 2)) * 60 + Integer.parseInt(timeStr.substring(3));
			
			if(teamOneScore > teamTwoScore) {
				teamOneTime += (curTime - lastTime);
			} else if(teamOneScore < teamTwoScore) {
				teamTwoTime += (curTime - lastTime);
			}
			
			lastTime = curTime;
			
			if(team == 1) {
				teamOneScore++;
			} else {
				teamTwoScore++;
			}
		}
		
		int endTime = 48 * 60;
		if(teamOneScore > teamTwoScore) {
			teamOneTime += (endTime - lastTime);
		} else if(teamOneScore < teamTwoScore) {
			teamTwoTime += (endTime - lastTime);
		}
		
		System.out.printf("%02d:%02d\n", teamOneTime / 60, teamOneTime % 60);
		System.out.printf("%02d:%02d\n", teamTwoTime / 60, teamTwoTime % 60);
	}

}
