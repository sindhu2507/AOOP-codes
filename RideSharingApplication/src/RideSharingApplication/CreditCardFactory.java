package RideSharingApplication;

public class CreditCardFactory extends PaymentFactory{

	@Override
	public PaymentMethod createPayment() {
		// TODO Auto-generated method stub
		return new CreditCard();
	}

}
