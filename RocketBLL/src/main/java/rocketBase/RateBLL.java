package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		for (RateDomainModel r: rates)
		{
			if (r.getiMinCreditScore() <= GivenCreditScore)
			{
				dInterestRate = r.getdInterestRate();
				
						
			}
		}
		
		if (dInterestRate == 0){
			RateDomainModel RDM = new RateDomainModel();
			RDM.setiMinCreditScore(GivenCreditScore);
			
			throw new RateException(RDM);
		}
		
		return dInterestRate;
		
		
	}
	
	public static boolean checkPITI(LoanRequest lq)
	{
		boolean checkPITI = false;
		if (lq.getdPayment() < lq.getdIncome()*0.28)
			checkPITI = true;
		if(lq.getdPayment() < (lq.getdIncome()-lq.getdExpenses())*0.36)
			checkPITI = true;
		
		return checkPITI;
		
	}
	
	
	
	
	
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
