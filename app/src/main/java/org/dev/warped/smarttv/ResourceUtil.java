package org.dev.warped.smarttv;

/**
 * Created by Andreas Wiedmer on 25.07.2016.
 */
class ResourceUtil {

    private ResourceUtil() {
    }

    public static ReceiverClient.EReceiverType getReceiverType(String receiverTypeValue) {
        if (null != receiverTypeValue) {
            // TODO, anwi: make this safer, values defined in array.receiver_type_values
            switch (receiverTypeValue) {
                case "dm500hd":
                    return ReceiverClient.EReceiverType.eDM500HD;
                case "dm500hdv2":
                    return ReceiverClient.EReceiverType.eDM500HDV2;
                case "dm800":
                    return ReceiverClient.EReceiverType.eDM800;
                case "dm800se":
                    return ReceiverClient.EReceiverType.eDM800SE;
                case "dm800sev2":
                    return ReceiverClient.EReceiverType.eDM800SEV2;
                case "dm7020hd":
                    return ReceiverClient.EReceiverType.eDM7020HD;
                case "dm7020hdv2":
                    return ReceiverClient.EReceiverType.eDM7020HDV2;
                case "dm8000":
                    return ReceiverClient.EReceiverType.eDM8000;
            }
        }
        return ReceiverClient.EReceiverType.eUnknown;
    }

    public static String getReceiverTypeValue(ReceiverClient.EReceiverType receiverType) {
        switch (receiverType) {
            case eDM500HD:
                return "dm500hd";
            case eDM500HDV2:
                return "dm500hdv2";
            case eDM800:
                return "dm800";
            case eDM800SE:
                return "dm800se";
            case eDM800SEV2:
                return "dm800sev2";
            case eDM7020HD:
                return "dm7020hd";
            case eDM7020HDV2:
                return "dm7020hdv2";
            case eDM8000:
                return "dm8000";
            default:
                return "";
        }
    }
}
