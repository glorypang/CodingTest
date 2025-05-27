import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		//문제에서 -10,000,000 ~ 10,000,000 , arr[index] = index - 100000000의 value를 가진 숫자가 몇 개인지 나타내주는 배열
		int[] arr = new int[20000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			//해당 인덱스 값에 +1해준다.
			arr[input + 10000000]++;
		}
		
		int M = Integer.parseInt(br.readLine()); //찾고 싶은 숫자 개수 M
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
			sb.append(arr[input + 10000000]).append(" ");
		}
		System.out.println(sb);
	}
}