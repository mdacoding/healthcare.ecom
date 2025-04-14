package com.mdacoding.healthcare.ecom.service;

public interface StripeService {

    PaymentIntent paymentIntent(StripePaymentDto stripePaymentDto) throws StripeException;

}
