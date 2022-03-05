import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		int plusM = sc.nextInt();
		
		int plusH = plusM / 60;
		plusM = plusM % 60;
		
		int temp = (plusM + m) / 60;
		
		h = (plusH + h + temp) % 24;
		m = (plusM + m) % 60;
		
		System.out.println(h +" " + m);
	}

}
