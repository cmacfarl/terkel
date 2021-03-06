package team25core;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import team25core.RingDetectionTask;
import team25core.Robot;

public class RingImageInfo {
    private double confidence;
    private double left;
    private String ringType;
    private RingDetectionTask.EventKind ringKind;
    private double type;
    private double imageMidpoint;
    private double ringMidpoint;
    private double delta;
    private double margin = 100;
    private double setColor;
    private double width;
    private int imageWidth;
    private boolean inCenter;
    private double realNumPixelsPerInch;
    private final int DISTANCE_FROM_WEBCAM_TO_GRABBER =1;
    private double distance;

    private int numObjectsSeen;
    private Telemetry.Item currLocationTlm;
    private Telemetry.Item ringPositionTlm;
    private Telemetry.Item ringTlm;
    private Telemetry.Item ringConfidTlm;
    private Telemetry.Item ringConfidTlm2;
    private Telemetry.Item ringTypeTlm;
    private Telemetry.Item ringTypeTlm2;
    private Telemetry.Item ringMidpointTlm;
    private Telemetry.Item imageMidpointTlm;
    private Telemetry.Item deltaTlm;
    private Telemetry.Item numObjectsSeenTlm;
    private Telemetry.Item pathTlm;
    private Telemetry.Item widthTlm;
    private Telemetry.Item marginTlm;
    private Telemetry.Item imageWidthTlm;
    private Telemetry.Item pixelsPerInchTlm;
    private Telemetry.Item distanceBtWWebcamAndGrabberTlm;

    //this is the default constructor
    public RingImageInfo() {}

    public double getConfidence(){
        return confidence;
    }

    public String getRingType(){
        return ringType;
    }

    public void getImageInfo(RingDetectionTask.RingDetectionEvent event) {
        //confidence is the likelihood that the object we detect is a ring in percentage
        //get(0) = gets the first item in the list of recognition objects pointed to by rings.
        // rings = a variable in the ring detection event
        confidence = event.rings.get(0).getConfidence();
        ringConfidTlm.setValue(confidence);
        //left is the left coordinate of the ring(s)
        left = event.rings.get(0).getLeft();

        ringType = event.rings.get(0).getLabel(); //LABEL_QUAD_RINGS LABEL_SINGLE_RING
        ringTypeTlm.setValue(ringType);

        ringKind = event.kind; //OBJECTS_DETECTED

        numObjectsSeen = event.rings.size();
        numObjectsSeenTlm.setValue(numObjectsSeen);
        currLocationTlm.setValue("in getImageInfo");
        if (numObjectsSeen > 1){
            confidence = event.rings.get(1).getConfidence();
            ringConfidTlm2.setValue(confidence);
            ringType = event.rings.get(1).getLabel(); //LABEL_QUAD_RINGS LABEL_SINGLE_RING
            ringTypeTlm2.setValue(ringType);
        }
    }

    public void displayTelemetry(Telemetry telemetry) {
        telemetry.setAutoClear(false);
        //caption: what appears on the phone
        ringPositionTlm = telemetry.addData("LeftOrigin", "unknown");
        ringConfidTlm = telemetry.addData("Confidence", "N/A");
        ringConfidTlm2 = telemetry.addData("Confidence2", "N/A");
        ringTypeTlm = telemetry.addData("RingType","unknown");
        ringTypeTlm2 = telemetry.addData("RingType2","unknown");
        imageMidpointTlm = telemetry.addData("Image_Mdpt", "unknown");
        ringMidpointTlm = telemetry.addData("Ring Mdpt", "unknown");
        ringTlm = telemetry.addData("kind", "unknown");
        deltaTlm = telemetry.addData("delta", "unknown");
        numObjectsSeenTlm = telemetry.addData("numRings",-1);
        pathTlm = telemetry.addData("AllianceClr", "unknown");
        widthTlm = telemetry.addData("ringWidth", "unknown");
        imageWidthTlm = telemetry.addData("imageWidth", -1);
        marginTlm = telemetry.addData("margin" , "unknown");
        pixelsPerInchTlm = telemetry.addData("pixelsPerInch", "unknown");
        distanceBtWWebcamAndGrabberTlm = telemetry.addData("distance BtW Webcam and Grabber","unknown");
        currLocationTlm = telemetry.addData("curr location", "in RingImageInfo constructor");
    }
    //CONTINUE HERE ********
    //ADD METHOD TO RETURN THE RING TYPE

}
