import java.util.Scanner;


//Solution of the programming part of ArtLife Assignment 24
//Simple plan: Read from user how large the test should be, successively compute f_n+1 and f_n, print every ratio
public class Ass24 {
	public static void main(String[] args) {
		Scanner prompt = new Scanner(System.in);

		System.out.print("Check the fibonacci ratios until: ");
		int bound = prompt.nextInt();
		prompt.close();

		long fnew=2, fold=1, temp;
		for(int n=1; n<=bound; n++) {
			System.out.println("Ratio for n=" + n + ": " + (double)fnew/fold);

			//Calculate next sequence pair
			temp = fnew;
			fnew = fnew+fold;
			fold = temp;
		}

	}
}
