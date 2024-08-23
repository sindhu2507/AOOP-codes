package RideSharingApplication;

public class RideSharingApp {
	public static void main(String[] args) {
        UserAuth auth = UserAuth.getInstance();
        auth.login();

        Vehicle vehicle = new CarFactory().createVehicle();
        vehicle.ride();

        PaymentMethod payment = new CreditCardFactory().createPayment();
        payment.pay();

        auth.logout();
    }
}
