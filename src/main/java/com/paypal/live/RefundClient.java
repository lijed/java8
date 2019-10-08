package com.paypal.live;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.DetailedRefund;
import com.paypal.api.payments.Invoice;
import com.paypal.api.payments.Refund;
import com.paypal.api.payments.RefundRequest;
import com.paypal.api.payments.Sale;
import com.paypal.base.Constants;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class RefundClient {
	
	public static void main(String[] args) throws PayPalRESTException {
		String clientId = "AR3dGJe8zToNs2fp2XT2NTQ9NVGuGeNzzMO8Z-uuncYM-wHJ0QTclojSh_dwl42G_hRm0_S3zKMgqC9E";
		String clientSecret = "EBVlJuT01YwWcdXn8UUap1WDazDM1kgCUpV0S6qQbZUB_jrPzd-NYlW_RrwJUd_WEAHwUO5Rju1VdF-a";
		
		APIContext apiContext = new APIContext(clientId, clientSecret, Constants.LIVE);
//		String accessToken = apiContext.getAccessToken();
//		System.out.println(accessToken);
		
		Refund refund = new Refund();

		Amount amount = new Amount();
		amount.setTotal("1.31");
		amount.setCurrency("USD");
		refund.setAmount(amount);
		
		Sale sale = new Sale();
		sale.setId("7DY409201T7922549");

//		RefundRequest refundRequest = new RefundRequest();
//		refundRequest.setAmount(new Amount("USD", "1.31"));
//		try {
//		  // Refund sale
//		  DetailedRefund refundresult = sale.refund( apiContext,  refundRequest);
//		  refundresult.getLastResponse();
//		  refundresult.getId();//Refund Trx ID
//		  refundresult.getState();// state
//		} catch (PayPalRESTException e) {
//		  System.err.println(e.getDetails());
//		}
		
		Invoice invoice = new Invoice();
		Sale saled =sale.get(apiContext, "2MA09869LY5281530");
		System.out.println(saled.toString());
	}
}
