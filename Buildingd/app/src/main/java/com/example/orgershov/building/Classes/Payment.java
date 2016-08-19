package com.example.orgershov.building.Classes;

import java.io.Serializable;

/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class Payment  implements Serializable {


        private int paymentId;
        private String from;
        private String to;
        private float sum;
        private String comment;

        public Payment() {
        }

        /**
         * constructor
         *
         * @param from
         * @param to
         * @param comment
         * @param sum
         */
        public Payment( int sum,String from, String to, String comment) {
            setFrom(from);
            setTo(to);
            setComment(comment);
            setSum(sum);

        }

        public Payment( int sNumber,float sum,String from, String to, String comment) {

            setFrom(from);
            setTo(to);
            setSum((int) sum);
            setComment(comment);
            paymentId = sNumber;
        }

        public int getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(int paymentId) {
            this.paymentId = paymentId;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String note) {
            this.comment = note;
        }

        public float getSum() {
            return sum;
        }

        public boolean setSum(int sum) {
            if (sum < 0)
                return false;
            this.sum = sum;
            return true;
        }
    }

