package org.dev.warped.smarttv;

/**
 * Created by Andreas Wiedmer on 25.07.2016.
 */
class ResourceUtil {

    public static ReceiverClient.EReceiverType getReceiverType(String receiverTypeValue) {
        if (null != receiverTypeValue) {
            // TODO, anwi: make this safer, values defined in array.receiver_type_values
            switch (receiverTypeValue) {
                case "Dreambox7025":
                case "Dreambox500HD":
                case "Dreambox800HDPVR":
                case "Dreambox800HDse":
                case "Dreambox820HD":
                case "Dreambox8000HDPVR":
                case "Dreambox7020HD":
                case "Dreambox7080HD":
                    return ReceiverClient.EReceiverType.eEnigma2;
            }
        }
        return ReceiverClient.EReceiverType.eUnknown;
    }

    private ResourceUtil() {
    }
}
