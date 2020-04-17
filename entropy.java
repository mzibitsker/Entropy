/**
 * This is the class that I wrote to compute Shannon's Entropy
 * This includes four methods:
 * 	1) entro -- which takes in the probability distribution and computes the entropy
 *  2) log2 -- which computes the log base 2 of the double parameter input
 *  3) kolmogorov -- which computes the Kolmogorov distance between 2prob.dist.
 *  4) fidelity -- which computes the closeness of two quantum states
 * @author Maxim Zibitsker
 *
 * Output from console for Question 1 part e:
 * The entropy1 is 2.1804820237218405 
 * The entropy2 is 2.1804820237218405
 * The Kolmogorov distance is 0.07500000000000001
 * The Fidelity  is 0.85
 * 
 */
public class entropy {
	/**
	 * Sample Probability Distribution Used to Test
	 */
	static double[] p_ = {0.2, 0.25, 0.25, 0.25, 0.05};
	static double[] q_ = {0.05, 0.25, 0.25, 0.25, 0.2};
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Initialize variables
		 */
		// Entropy for probability distribution p
		double entro1 = entro(p_);
		// Entropy for probability distribution q
		double entro2 = entro(q_);
		// Kolmogorov computation
		double kolm1 = kolmogorov(p_, q_);
		// Fidelity computation
		double fid1 = fidelity(p_, q_);
		//Print output in Console
		System.out.println("The entropy1 is " + entro1);
		System.out.println("The entropy2 is " + entro2);
		System.out.println("The Kolmogorov distance is " + kolm1);
		System.out.println("The Fidelity  is " + fid1);
	} //end main
	/**
	 *
	 * This Method expects an array of doubles (i.e. probability distribution 
	 * as input), and computes the Shannon-Entropy of a system.
	 * @param num
	 * @return
	 */
	public static double entro (double[] num) {
		double counterSum_ = 0.0;
		double constK_ = -1.0;
		for( int i = 0; i < num.length; i++){
			counterSum_ = ( num[i] * log2(num[i]) )  + counterSum_; 
		}
		return counterSum_ * constK_;
	}
	/**
	 * This Method expects two arrays of doubles (i.e. probability
	 *  distribution as input),and computes the Kolmogorov distance
	 *  between P and Q
	 * @param P
	 * @param Q
	 * @return
	 */
	public static double kolmogorov( double[] P, double[] Q) {
		double counterSum_ = 0.0;
		double constH_ = 0.5;
		for(int i = 1; i < P.length; i++) {
			counterSum_ = Math.abs(P[i] - Q[i]) + counterSum_;
		}
		return counterSum_ *constH_;
	}
	/**
	 *  This Method expects two arrays of doubles (i.e. probability
	 *  distribution as input),and computes the Fidelity of P and Q
	 * @param P
	 * @param Q
	 * @return
	 */
	public static double fidelity( double[] P, double[] Q) {
		double counterSum_ = 0.0;
		for(int i = 1; i < P.length; i++) {
			counterSum_ = (Math.sqrt(P[i]) * Math.sqrt(Q[i])) +  counterSum_;
		}
		return counterSum_;
	}
	/**
	 * This method expects a number of type double as input, which
	 *  to log base 2
	 * @param num
	 * @return
	 */
	public static double log2 (double num) {
		double logreg = Math.log(num);
		double log2 = Math.log(2.0);
		double correct = logreg/log2;
		return correct;
	}
} //end entropy
