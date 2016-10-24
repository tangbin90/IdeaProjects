package enumerated;

/**
 * Created by TangBin on 24/10/2016.
 */
import java.util.*;

import net.mindview.util.Enums;
import net.mindview.util.Print.*;
import net.mindview.*;

import static net.mindview.util.Print.print;

class Mail{
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
    enum Scanability {UNSCANNABLE, YES1, YES2, YES3, YES4}
    enum Readability{ILLEGIBLE, YES1, YES2, YES3, YES4}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5}
    enum ReturnAddress{MISSING, OK1, OK2, OK3,OK4, OK5}
    GeneralDelivery generalDelivery;
    Scanability scanability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;
    public String toString(){return "Mail "+id;}

    public String details() {
        return toString()+
                ", General Delivery: "+ generalDelivery +
                ", Address Scanability: " + scanability +
                ", Address Address: "+ address +
                ", Return address: "+ returnAddress;
    }

    public static Mail randommail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scanability = Enums.random(Scanability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>(){
            int n = count;
            public Iterator<Mail> iterator(){
                return new Iterator<Mail>() {
                    public boolean hasNext(){return n-->0;}
                    public Mail next(){return randommail();}
                    public void remove(){
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class PostOffice{
    enum MailHandler{
        GENERAL_DELIVERY{
            boolean handle(Mail mail) {
                switch (mail.generalDelivery){
                    case YES:
                        print("Using general delivery for "+ mail);
                        return true;
                    default:return false;
                }
            }
        },

        MACHINE_SCAN{
            boolean handle(Mail m){
                switch (m.scanability){
                    case UNSCANNABLE:return false;
                    default:
                        print("Delivering " + m + " automatically");
                        return true;
                }
            }
        },

        VISUAL_INSPECTION{
            boolean handle(Mail mail) {
                switch (mail.readability){
                    case ILLEGIBLE:return false;
                    default:
                        switch (mail.address){
                            case INCORRECT:return false;
                            default:
                                print("Delivering "+ mail +" normally");
                                return true;
                        }
                }
            }
        },

        RETURN_TOSENDER{
            boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case MISSING: return false;
                    default:
                        print("Returning "+ mail + " to sender");
                    return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    }

    static void handle(Mail mail) {
        for(MailHandler handler : MailHandler.values())
            if(handler.handle(mail))
                return;
        print(mail + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(30)) {
            print(mail.details());
            handle(mail);
            print("**********");
        }
    }



}
