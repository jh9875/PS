import java.util.HashSet;

class Solution {
	HashSet<Integer> primeNumbers = new HashSet<>();

	public int solution(String numbers) {
		findPrimes(0, numbers, new boolean[numbers.length()]);
		return primeNumbers.size();
	}

	public void findPrimes(int number, String numbers, boolean[] used) {
		if (isPrime(number))
			primeNumbers.add(number);

		for (int i = 0; i < used.length; i++) {
			if (!used[i]) {
				used[i] = true;
				findPrimes(number * 10 + (numbers.charAt(i) - '0'), numbers, used);
				used[i] = false;
			}
		}
	}

	public boolean isPrime(int num) {
		if (num == 0 || num == 1)
			return false;
		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}